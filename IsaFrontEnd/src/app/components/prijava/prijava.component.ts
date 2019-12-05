import { Component, OnInit } from '@angular/core';
import { Router, ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-prijava',
  templateUrl: './prijava.component.html',
  styleUrls: ['./prijava.component.css']
})
export class PrijavaComponent implements OnInit {

  constructor(private router : Router, private route : ActivatedRoute) { }

  ngOnInit() {
  }

  clickLogIn(){
    this.router.navigate(['/pacijent']);
  }

}
