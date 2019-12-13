import { Component, OnInit, ViewChild, Directive, Input, Output, EventEmitter, ViewChildren, QueryList, HostListener } from '@angular/core';
import { AllCommunityModules } from '@ag-grid-community/all-modules';
import { Korisnik } from 'src/app/model/Korisnik';
import { StudentService } from 'src/app/service/student.service';
import { Student } from 'src/app/model/Student';
import { Klinika } from 'src/app/model/Klinika';
import { MatTableDataSource } from '@angular/material';
import { MatSortModule, MatSort } from '@angular/material/sort';
import { KlinikaService } from 'src/app/service/klinika.service';
import { Subscription } from 'rxjs';
import { SortService } from 'src/app/service/sort.service';

@Component({
  selector: 'app-klinika',
  templateUrl: './klinika.component.html',
  styleUrls: ['./klinika.component.css']
})

export class KlinikaComponent implements OnInit {

  korisnik: Korisnik = new Korisnik();
  studenti: Student[] = [];
  student: Student = new Student();
  klinike: Klinika[] = [];


  constructor(private service: StudentService, private serviceKlinika: KlinikaService, private sortService: SortService) { }

  //displayedColumns: string[] = ['ime'];
  //dataSource = new MatTableDataSource(this.klinike);

  ngOnInit() {

    this.serviceKlinika.preuzmiSveKlinike().subscribe(
      data => {

        this.klinike = data;
      },
      error => {
        console.log(error);
      }
    )


  }

}
