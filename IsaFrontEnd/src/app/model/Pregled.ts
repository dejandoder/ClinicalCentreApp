import { Ljekar } from './Ljekar';
import { Klinika } from './Klinika';

export class Pregled{
    id : number;
    cijena : number;
    popust : number;
    tip : string= "";
    sala : number;
    trajanje : number;
    termin : Date;
    ljekar : Ljekar = new Ljekar();
    medium : string="";
    stanje : string="";
    klinika : Klinika = new Klinika();
    novo : number;
}