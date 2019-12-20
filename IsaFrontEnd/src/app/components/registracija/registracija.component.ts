import { Component, OnInit, ElementRef } from '@angular/core';
import { Korisnik } from 'src/app/model/Korisnik';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-registracija',
  templateUrl: './registracija.component.html',
  styleUrls: ['./registracija.component.css']
})
export class RegistracijaComponent implements OnInit {

  korisnik: Korisnik = new Korisnik();
  haha: boolean = false;
  validacijaIme: boolean = false;
  validacijaPrezime: boolean = false;
  validacijaMail: boolean = false;
  validacijaAdresa: boolean = false;
  validacijaGrad: boolean = false;
  validacijaDrzava: boolean = false;
  validacijaBroj: boolean = false;
  validacijaJedinstveni: boolean = false;
  validacijaLozinka: boolean = false;

  constructor(private korisnikService: KorisnikService, private router: Router, private toastr: ToastrService, private formBuilder: FormBuilder) {

  }

  ngOnInit() {
  }

  registujSe() {
    this.haha = true;
    this.validacijaIme = true;
    this.validacijaPrezime = true;
    this.validacijaMail = true;
    this.validacijaAdresa = true;
    this.validacijaGrad = true;
    this.validacijaDrzava = true;
    this.validacijaBroj = true;
    this.validacijaJedinstveni = true;
    this.validacijaLozinka = true;
    this.korisnik.username = this.korisnik.email;
    this.korisnikService.registracija(this.korisnik).subscribe(
      data => {
        this.toastr.warning("Dobicete e-mail za verifikaciju!");
      },
      error => {

      }
    );

  }
  odustani() {
    this.router.navigate(['/pocetna']);
  }



}
