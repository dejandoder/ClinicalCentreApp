import { Component, OnInit } from '@angular/core';
import { KlinikaService } from 'src/app/service/klinika.service';
import { PregledService } from 'src/app/service/pregled.service';
import { Pregled } from 'src/app/model/Pregled';
import { Klinika } from 'src/app/model/Klinika';
import { Ljekar } from 'src/app/model/Ljekar';
import { TipPregleda } from 'src/app/model/TipPregleda';
import { LjekarService } from 'src/app/service/ljekar.service';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-zakazivanje-pregleda',
  templateUrl: './zakazivanje-pregleda.component.html',
  styleUrls: ['./zakazivanje-pregleda.component.css']
})


export class ZakazivanjePregledaComponent implements OnInit {

  prikazTabeleKlinike: boolean = false;
  prikazTabeleLjekara: boolean = false;
  sviTipoviPregleda: TipPregleda[] = [];
  sviTipoviPregledaLjekari: TipPregleda[] = [];
  klinike: Klinika[] = [];
  ljekari: Ljekar[] = [];
  pregled: TipPregleda = new TipPregleda();
  tipLjekar: TipPregleda = new TipPregleda();
  cijena: number;
  imeLjekaraPretraga: string = "";
  prezimeLjekaraPretraga: string = "";
  ocjenaLjekara: number;
  ljekar: Ljekar = new Ljekar();
  zakazaniPregled: Pregled = new Pregled();
  status: string = "ZAKAZAN";
  klinikaZaPregled: Klinika = new Klinika();
  datumPregleda: Date;
  validacija: boolean = true;
  ocjenaKlinike: number;
  lokacijaKlinike: string="";


  constructor(private serviceKlinika: KlinikaService, private servicePregled: PregledService, private serviceLjekar: LjekarService, private toastr: ToastrService) { }

  ngOnInit() {
    this.servicePregled.preuzmiTipovePregleda().subscribe(
      data => {

        this.sviTipoviPregleda = data;
        this.sviTipoviPregledaLjekari = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  pretraziKlinike() {

    if (this.datumPregleda == null) {
      this.toastr.error("Morate izabrati datum pregleda");
      this.validacija = false;
    }

    if (this.pregled.ime == "") {
      this.toastr.error("Morate izabrati tip pregleda");
      this.validacija = false;
    }

    if (!this.validacija) {
      this.validacija = true;
    } else {
      console.log(this.pregled.ime);
      this.prikazTabeleKlinike = true;
      this.serviceKlinika.pretragaKlinika(this.pregled.ime, this.ocjenaKlinike, this.lokacijaKlinike).subscribe(
        data => {
          this.klinike = data.klinike;
          this.cijena = data.cijenaPregleda;
        }
      )
    }
  }
  prikaziLjekare(klinika: Klinika) {
    this.prikazTabeleLjekara = true;
    this.ljekari = klinika.ljekari;
    this.klinikaZaPregled = klinika;

  }

  pretraziLjekare() {

    this.serviceLjekar.pretragaLjekara(this.imeLjekaraPretraga, this.prezimeLjekaraPretraga, this.ocjenaLjekara, this.ljekari).subscribe(
      data => {
        this.ljekari = data;
      }
    )

  }

  zakaziPregled(ljekar: Ljekar) {

    this.zakazaniPregled.tipPregleda = this.pregled;
    this.zakazaniPregled.cijena = this.pregled.cijena;
    this.zakazaniPregled.stanje = this.status;
    this.zakazaniPregled.klinika = this.klinikaZaPregled;
    this.zakazaniPregled.ljekar = ljekar;
    this.zakazaniPregled.termin = this.datumPregleda;


    this.servicePregled.zakaziDostupniPregled(this.zakazaniPregled).subscribe(
      data => {
        this.toastr.success("Uspjesno ste zakazali pregled");

      },
      error => {
        console.log(error);
      }
    )

  }


}
