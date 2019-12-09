import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';
import { KorisnikService } from 'src/app/service/korisnik.service';
import { Korisnik } from 'src/app/model/Korisnik';
import { ToastrModule, ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  trenutniKorisnik: Korisnik=new Korisnik();
  ime : string = ""; 
  prezime : string = "";
  email : string = "";
  grad : string = "";

  constructor(private router : Router, private route : ActivatedRoute, private service: KorisnikService, private toastr: ToastrService) { }

  ngOnInit() {
    this.service.vratiTrenutnogKorisnika().subscribe(
      data =>{
        this.trenutniKorisnik=data;
      },
      error => {
        console.log(error);
      }
    )
  }

  odustani(){
    this.router.navigate(["pocetnaPacijent"],{relativeTo: this.route}); 
  }

  izmijeniPodatke(){
    this.service.izmjenaPodataka(this.trenutniKorisnik).subscribe(
      data => {
        this.toastr.success("Uspjesno ste promijenili podatke!", this.trenutniKorisnik.ime);
      },
      error => {
  
      }
    );
  }

}
