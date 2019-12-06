import { Component, OnInit } from '@angular/core';
import { Korisnik } from 'src/app/model/Korisnik';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  korisnik : Korisnik=new Korisnik();

  constructor(private korisnikService: KorisnikService, private router : Router, private toastr: ToastrService) { }

  ngOnInit() {
  }

  registujSe(){
    this.korisnikService.registracija(this.korisnik).subscribe(
      data => {
        this.toastr.warning("Dobicete e-mail za verifikaciju!");
      },
      error => {
  
      }
    );

  }
  odustani(){
    this.router.navigate(['/pocetna']);
  }

 

}
