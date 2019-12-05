import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-profil',
  templateUrl: './profil.component.html',
  styleUrls: ['./profil.component.css']
})
export class ProfilComponent implements OnInit {

  constructor(private router : Router, private route : ActivatedRoute) { }

  ngOnInit() {
  }

  odustani(){
    this.router.navigate(["pocetnaPacijent"],{relativeTo: this.route}); 
  }

}
