import { Component, OnInit } from '@angular/core';
import { KlinikaService } from 'src/app/service/klinika.service';
import { PregledService } from 'src/app/service/pregled.service';
import { Pregled } from 'src/app/model/Pregled';
import { Klinika } from 'src/app/model/Klinika';
import { Ljekar } from 'src/app/model/Ljekar';
import { TipPregleda } from 'src/app/model/TipPregleda';

@Component({
  selector: 'app-zakazivanje-pregleda',
  templateUrl: './zakazivanje-pregleda.component.html',
  styleUrls: ['./zakazivanje-pregleda.component.css']
})


export class ZakazivanjePregledaComponent implements OnInit {

  prikazTabeleKlinike: boolean = false;
  prikazTabeleLjekara: boolean = false;
  sviTipoviPregleda: TipPregleda[]=[];
  sviTipoviPregledaLjekari: TipPregleda[]=[];
  klinike: Klinika[] = [];
  ljekari: Ljekar[] = [];
  pregled: TipPregleda = new TipPregleda();
  tipLjekar: TipPregleda = new TipPregleda();
  cijena: number;

  constructor(private serviceKlinika: KlinikaService, private servicePregled: PregledService) { }

  ngOnInit() {
    this.servicePregled.preuzmiTipovePregleda().subscribe(
      data => {

        this.sviTipoviPregleda = data;
        this.sviTipoviPregledaLjekari=data;
      },
      error => {
        console.log(error);
      }
    )
  }

  pretraziKlinike() {
    console.log(this.pregled.ime);
    this.prikazTabeleKlinike = true;
    this.serviceKlinika.pretragaKlinika(this.pregled.ime).subscribe(
      data => {
        this.klinike = data.klinike;
        this.cijena = data.cijenaPregleda;
        /* for(let a of this.klinike){
             for(let b of a.ljekari){
               for(let c of b.pregledi){
                 this.cijena=c.cijena;
               }
             }
         }*/


      }
    )
  }
  prikaziLjekare(klinika: Klinika) {
    this.prikazTabeleLjekara = true;
    this.ljekari = klinika.ljekari;
    console.log(this.ljekari);
  }


}
