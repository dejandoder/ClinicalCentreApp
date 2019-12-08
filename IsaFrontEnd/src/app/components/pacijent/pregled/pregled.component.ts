import { Component, OnInit } from '@angular/core';
import { Pregled } from 'src/app/model/Pregled';
import { PregledService } from 'src/app/service/pregled.service';

@Component({
  selector: 'app-pregled',
  templateUrl: './pregled.component.html',
  styleUrls: ['./pregled.component.css']
})
export class PregledComponent implements OnInit {

  pregledi: Pregled[]=[];

  constructor(private service: PregledService) { }

  ngOnInit() {
      this.service.preuzmiSvePreglede().subscribe(
      data =>{
        this.pregledi=data;

      },
      error => {
        console.log(error);
      }
    )
  }


}
