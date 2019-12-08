import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-pacijent',
  templateUrl: './pacijent.component.html',
  styleUrls: ['./pacijent.component.css']
})
export class PacijentComponent implements OnInit {

  constructor(private router : Router, private route : ActivatedRoute) { }

  ngOnInit() {
  }

  profilClick(){
   
      this.router.navigate(["profil"],{relativeTo: this.route});   
    
  }
  klinikaClick(){

    this.router.navigate(["klinika"],{relativeTo: this.route});

  }
  preglediClick(){

    this.router.navigate(["pregledi"],{relativeTo: this.route});

  }

}
