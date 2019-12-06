import { Pregled } from './Pregled';

export class Ljekar{
    id : number;
    ime : string = "";
    prezime : string = "";
    ocjena : number;
    pregledi : Pregled[]=[];
}