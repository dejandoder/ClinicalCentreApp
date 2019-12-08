import { Ljekar } from './Ljekar';

export class Pregled{
    id : number;
    cijena : number;
    popust : number;
    tip : string= "";
    sala : number;
    trajanje : number;
    termin : Date;
    ljekar : Ljekar = new Ljekar();
}