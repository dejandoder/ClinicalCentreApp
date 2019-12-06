import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Korisnik } from '../model/Korisnik';

@Injectable({
  providedIn: 'root'
})
export class KorisnikService {

  constructor(private http: HttpClient) { }

  registracija(korisnik: Korisnik) {
    return this.http.post<Korisnik>('api/korisnici/registracija', korisnik);
  }
 
}
