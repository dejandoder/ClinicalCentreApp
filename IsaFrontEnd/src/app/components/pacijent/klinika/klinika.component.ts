import { Component, OnInit } from '@angular/core';
import { AllCommunityModules } from '@ag-grid-community/all-modules';
import { Korisnik } from 'src/app/model/Korisnik';
import { StudentService } from 'src/app/service/student.service';
import { Student } from 'src/app/model/Student';

@Component({
  selector: 'app-klinika',
  templateUrl: './klinika.component.html',
  styleUrls: ['./klinika.component.css']
})
export class KlinikaComponent implements OnInit {

  korisnik: Korisnik = new Korisnik();
  studenti: Student[]=[];
  student: Student=new Student();

  constructor(private service: StudentService) { }

  ngOnInit() {
    this.service.preuzmiSveStudente().subscribe(
      data =>{
        this.studenti=data;
        data.forEach(function (value) {
          console.log(value);
          this.student=value;
      });
        
      },
      error => {
        console.log(error);
      }
    )
  }
  

  columnDefs = [
    { headerName: 'Make', field: 'make' },
    { headerName: 'Model', field: 'model' },
    { headerName: 'Price', field: 'price' }
  ];

  /*rowData = [
    { make: 'kkk' , model: 'Celica', price: 35000 },
    { make: 'Ford', model: 'Mondeo', price: 32000 },
    { make: 'Porsche', model: 'Boxter', price: 72000 }
  ]*/

  modules = AllCommunityModules;

}
