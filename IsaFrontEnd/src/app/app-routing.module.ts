import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PocetnaStranicaComponent } from './components/pocetna-stranica/pocetna-stranica.component';
import { PrijavaComponent } from './components/prijava/prijava.component';
import { RegistracijaComponent } from './components/registracija/registracija.component';
import { PacijentComponent } from './components/pacijent/pacijent.component';
import { ProfilComponent } from './components/pacijent/profil/profil.component';
import { IstorijaComponent } from './components/pacijent/istorija/istorija.component';
import { KlinikaComponent } from './components/pacijent/klinika/klinika.component';
import { ZdravstveniKartonComponent } from './components/pacijent/zdravstveni-karton/zdravstveni-karton.component';
import { PocetnaPacijentComponent } from './components/pacijent/pocetna-pacijent/pocetna-pacijent.component';


const routes: Routes = [
  { path: '', redirectTo: '/pocetna', pathMatch: 'full' },
  { path: 'pocetna', component: PocetnaStranicaComponent },
  { path: 'prijava', component: PrijavaComponent },
  { path: 'registracija', component: RegistracijaComponent },
  {
    path: 'pacijent', component: PacijentComponent,
    children: [
      { path: '', redirectTo: 'pocetnaPacijent',  pathMatch: 'full' },
      {path: 'pocetnaPacijent', component: PocetnaPacijentComponent},
      {path: 'profil', component: ProfilComponent},
      {path: 'istorija', component: IstorijaComponent},
      {path: 'klinika', component: KlinikaComponent},
      {path: 'karton', component: ZdravstveniKartonComponent},
      {path: '**', redirectTo: 'pocetnaPacijent'}
    ]
}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
