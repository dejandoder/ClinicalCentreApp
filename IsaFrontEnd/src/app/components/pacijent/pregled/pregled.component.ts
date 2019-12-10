import { Component, OnInit } from '@angular/core';
import { Pregled } from 'src/app/model/Pregled';
import { PregledService } from 'src/app/service/pregled.service';
import {DatePipe} from '@angular/common';
@Component({
  selector: 'app-pregled',
  templateUrl: './pregled.component.html',
  styleUrls: ['./pregled.component.css']
})
export class PregledComponent implements OnInit {

  pregledi: Pregled[]=[];
  
  constructor(private service: PregledService,private datePipe: DatePipe) { }

  ngOnInit() {
      this.service.preuzmiSvePreglede().subscribe(
      data =>{
        this.pregledi=data;
        for(let date of this.pregledi){
          date.medium = this.datePipe.transform(date.termin,"MMM d, y, h:mm a");
        }
      },
      error => {
        console.log(error);
      }
    )
  }
  transformDate(date) {
    this.datePipe.transform(date, 'yyyy-MM-dd'); //whatever format you need. 
  }


}
