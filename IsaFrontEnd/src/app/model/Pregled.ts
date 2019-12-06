import { Ljekar } from './Ljekar';

export class Pregled{
    id : number;
    opis : string = "";
    cijena : number;
    popust : number;
    tip : string= "";
    termin : Date;
    ljekar : Ljekar = new Ljekar();
}