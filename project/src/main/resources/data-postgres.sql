insert into student (index_number, first_name, last_name) values ('ra1-2014', 'Marko', 'Marković');
insert into student (index_number, first_name, last_name) values ('ra2-2014', 'Milan', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra3-2014', 'Ivana', 'Ivanović');
insert into student (index_number, first_name, last_name) values ('ra4-2014', 'Bojan', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra5-2014', 'Pera', 'Perić');
insert into student (index_number, first_name, last_name) values ('ra6-2014', 'Zoran', 'Zoranović');
insert into student (index_number, first_name, last_name) values ('ra7-2014', 'Bojana', 'Bojanović');
insert into student (index_number, first_name, last_name) values ('ra8-2014', 'Milana', 'Milanović');
insert into student (index_number, first_name, last_name) values ('ra9-2014', 'Jovana', 'Jovanić');

insert into korisnik (ime,prezime) values ('dejan','doder');
insert into korisnik (grad,ime,password,email,prezime,broj_telefona,role,username, jedinstveni_broj, drzava, adresa, verifikovan) VALUES (NULL,'janko','$2a$10$PyUWKQye6ObdS417LOa08u.rmr.ms7lZ7y5JlQ52PfWE16.uraAHC','dejandoder96@gmail.com',NULL,0,'REGISTROVAN','janko',55,'srbija','njegoseva',true);

insert into klinika (ime, adresa, opis, grad) values ('Drzavna','Njegoseva','Drzavna klinika', 'Gacko');
insert into klinika (ime, adresa, opis, grad) values ('Privatna','Tolstojeva','Privatna klinika', 'Novi Sad');
insert into klinika (ime, adresa, opis, grad) values ('Vojna','Drenovik','Vojna klinika', 'Herceg Novi');
insert into klinika (ime, adresa, opis, grad) values ('Nasa','Kotorska','Nasa', 'Kotor');

insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Dejan','Doder',5,1);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Todor','Doder',4,1);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Dragan','Doder',3,1);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Ranka','Doder',2,2);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Ranko','Doder',1,2);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Lazar','Doder',2,2);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Slavko','Doder',3,3);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Nikola','Doder',4,3);
insert into ljekar (ime, prezime, ocjena, klinika_id) values ('Miljan','Doder',5,3);

insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN', 10, 99, 0, 3, '2019-11-13 00:00:00', 'oko', 1, 1);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',15,68,1,2, '2019-10-28 00:00:00','grlo', 1, 2);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',20,114,2,1, '2019-09-05 00:00:00','uho', 1, 3);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',15,178,3,5, '2019-10-06 00:00:00','nos', 1, 1);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',25,286,4,7, '2019-01-22 00:00:00','zub', 1, 2);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',40,44,5,8, '2019-03-16 00:00:00','noga', 1, 3);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',50,89,6,7, '2019-04-01 00:00:00','ruka', 2, 4);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',25,255,7,2, '2019-12-30 00:00:00','glava', 2, 5);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',55,122,7,4, '2019-12-11 00:00:00','prst', 2, 6);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',5,123,6,4, '2019-10-08 00:00:00','stomak', 2, 4);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',15,124,5,1, '2019-10-07 00:00:00','ledja', 2 , 5);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',45,127,4,2, '2019-11-02 00:00:00','rame', 2, 6);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',40,192,3,3, '2019-11-26 00:00:00','koljeno', 3, 7);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',35,212,2,2, '2019-11-28 00:00:00','stopalo', 3, 8);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',10,312,3,9, '2019-01-24 00:00:00','dlan', 3, 9);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',10,412,4,8, '2019-03-10 00:00:00','vrat', 3, 7);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',15,112,5,2, '2019-04-11 00:00:00','zglob', 3, 8);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip,klinika_id, ljekar_id) values ('SLOBODAN',5,77,6,3, '2019-05-02 00:00:00','lakat',3,9);
