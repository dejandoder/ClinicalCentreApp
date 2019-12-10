import { Component, OnInit } from '@angular/core';
import { Pregled } from 'src/app/model/Pregled';
import { PregledService } from 'src/app/service/pregled.service';
import { DatePipe } from '@angular/common';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-zakazani-pregledi',
  templateUrl: './zakazani-pregledi.component.html',
  styleUrls: ['./zakazani-pregledi.component.css']
})
export class ZakazaniPreglediComponent implements OnInit {

  pregledi: Pregled[] = [];

  constructor(private service: PregledService, private datePipe: DatePipe, private toastr: ToastrService) { }

  ngOnInit() {
    this.service.preuzmiZakazanePreglede().subscribe(
      data => {
        this.pregledi = data;
        for (let date of this.pregledi) {
          date.medium = this.datePipe.transform(date.termin, "MMM d, y, h:mm a");
        }
      },
      error => {
        console.log(error);
      }
    )
  }

  otkaziPregled(pregled: Pregled){
    this.service.otkaziPregled(pregled).subscribe(
      data => {
        this.toastr.success("Uspjesno ste otkazali pregled!");
        this.service.preuzmiZakazanePreglede().subscribe(
          data => {
            this.pregledi = data;
            for (let date of this.pregledi) {
              date.medium = this.datePipe.transform(date.termin, "MMM d, y, h:mm a");
            }
          },
          error => {
            console.log(error);
          }
        )

      },
      error => {
        console.log(error);
      }
    )

  }

}
