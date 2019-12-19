import { Ljekar } from './Ljekar';
import { Klinika } from './Klinika';
import { TipPregleda } from './TipPregleda';

export class Pregled{
    id : number;
    cijena : number;
    popust : number;
    tipPregleda : TipPregleda=new TipPregleda();
    sala : number;
    trajanje : number;
    termin : Date;
    ljekar : Ljekar = new Ljekar();
    medium : string="";
    stanje : string="";
    klinika : Klinika = new Klinika();
    novo : number;
}