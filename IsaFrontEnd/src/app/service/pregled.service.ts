import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class PregledService {

  constructor(private http: HttpClient) { }

  preuzmiSvePreglede(){
    return this.http.get<any>('api/pregledi/all');
  }
}
