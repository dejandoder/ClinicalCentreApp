import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { PacijentComponent } from './components/pacijent/pacijent.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';
import { PrijavaComponent } from './components/prijava/prijava.component';
import { PocetnaStranicaComponent } from './components/pocetna-stranica/pocetna-stranica.component';
import { ProfilComponent } from './components/pacijent/profil/profil.component';
import { KlinikaComponent } from './components/pacijent/klinika/klinika.component';
import { ZdravstveniKartonComponent } from './components/pacijent/zdravstveni-karton/zdravstveni-karton.component';
import { IstorijaComponent } from './components/pacijent/istorija/istorija.component';
import { PocetnaPacijentComponent } from './components/pacijent/pocetna-pacijent/pocetna-pacijent.component';

@NgModule({
  declarations: [
    AppComponent,
    PacijentComponent,
    RegistracijaComponent,
    PrijavaComponent,
    PocetnaStranicaComponent,
    ProfilComponent,
    KlinikaComponent,
    ZdravstveniKartonComponent,
    IstorijaComponent,
    PocetnaPacijentComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
