import { Component, OnInit } from '@angular/core';
import { KlinikaService } from 'src/app/service/klinika.service';
import { PregledService } from 'src/app/service/pregled.service';
import { Pregled } from 'src/app/model/Pregled';
import { Klinika } from 'src/app/model/Klinika';

@Component({
  selector: 'app-zakazivanje-pregleda',
  templateUrl: './zakazivanje-pregleda.component.html',
  styleUrls: ['./zakazivanje-pregleda.component.css']
})
export class ZakazivanjePregledaComponent implements OnInit {

  prikazTabeleKlinike: boolean=false;
  sviTipoviPregleda: Pregled[]=[];
  klinike : Klinika[]=[];
  tipP: Pregled = new Pregled();
  nesto : any;
  pregled : Pregled = new Pregled();
 
  constructor(private serviceKlinika: KlinikaService, private servicePregled: PregledService) { }

  ngOnInit() {
    this.servicePregled.preuzmiSvePreglede().subscribe(
      data => {
        this.sviTipoviPregleda = data;
      },
      error => {
        console.log(error);
      }
    )
  }

  pretraziKlinike(){
    
    this.prikazTabeleKlinike=true;
    this.serviceKlinika.pretragaKlinika(this.pregled.tip).subscribe(
      data => {
        this.klinike = data;
        console.log(this.pregled.tip);
      }
    )
  }


}
