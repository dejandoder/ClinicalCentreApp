import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class KlinikaService {

  constructor(private http: HttpClient) { }

  preuzmiSveKlinike(){
    return this.http.get<any>('api/klinike/all');
  }
}
