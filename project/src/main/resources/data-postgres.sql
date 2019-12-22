--korisnici
insert into korisnik (grad,ime,password,email,prezime,broj_telefona,role,username, jedinstveni_broj, drzava, adresa, verifikovan) VALUES (NULL,'janko','$2a$10$PyUWKQye6ObdS417LOa08u.rmr.ms7lZ7y5JlQ52PfWE16.uraAHC','dejandoder96@gmail.com',NULL,0,'REGISTROVAN','janko',55,'srbija','njegoseva',true);
--klinike
insert into klinika (ime, adresa, opis, grad, ocjena) values ('Drzavna','Njegoseva','Drzavna klinika', 'Gacko',5);
insert into klinika (ime, adresa, opis, grad, ocjena) values ('Privatna','Tolstojeva','Privatna klinika', 'Novi Sad',4);
insert into klinika (ime, adresa, opis, grad, ocjena) values ('Vojna','Drenovik','Vojna klinika', 'Herceg Novi',5);
insert into klinika (ime, adresa, opis, grad, ocjena) values ('Nasa','Kotorska','Nasa', 'Kotor',4);
--ljekari
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Dejan', 'Doder', 5, 1, '2019-10-28', '2019-11-28', '08:00:00', '15:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Todor', 'Doder', 4, 1, '2019-10-28', '2019-10-28', '09:00:00', '16:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Dragan', 'Doder', 3, 1, '2019-10-28', '2019-10-28', '08:00:00', '15:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Ranka', 'Doder',2 , 2, '2019-10-28', '2019-10-28', '00:00:00', '00:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Ranko', 'Doder',1 , 2, '2019-10-28', '2019-10-28', '00:00:00', '00:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Lazar', 'Doder',2, 2, '2019-10-28', '2019-10-28', '00:00:00', '00:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Slavko', 'Doder',3, 3, '2019-10-28', '2019-10-28', '00:00:00', '00:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Nikola', 'Doder',4, 3, '2019-10-28', '2019-10-28', '00:00:00', '00:00:00');
insert into ljekar (ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values ('Miljan', 'Doder',5, 3, '2019-10-28', '2019-10-28', '00:00:00', '00:00:00');
--tipovi pregleda
insert into tip_pregleda(ime, cijena, trajanje, sala) values('oko',100, 10, 1);
insert into tip_pregleda(ime, cijena, trajanje, sala) values('glava',200, 15, 2);
insert into tip_pregleda(ime, cijena, trajanje, sala) values('nos',300, 20, 3);
insert into tip_pregleda(ime, cijena, trajanje, sala) values('ruka',400, 25, 4);
insert into tip_pregleda(ime, cijena, trajanje, sala) values('noga',500, 30, 5);

insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (1,1);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (1,2);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (1,3);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (2,1);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (2,2);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (2,3);

insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (1,1);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (1,2);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (1,3);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (2,1);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (2,2);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (2,3);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (3,1);
--pregledi
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id, tip_pregleda_id) values ('SLOBODAN', 10, 99, 0, 3, '2019-12-21 15:00:00', 'oko', 1,1);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id, tip_pregleda_id) values ('SLOBODAN',15,68,1,2, '2019-12-22 15:00:00','oko', 2,1);
insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id, tip_pregleda_id) values ('SLOBODAN',20,114,2,1, '2019-12-21 23:00:00','oko', 3,1);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',15,178,3,5, '2019-10-06 00:00:00','oko', 1);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',25,286,4,7, '2019-01-22 00:00:00','zub', 2);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',40,44,5,8, '2019-03-16 00:00:00','noga', 3);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',50,89,6,7, '2019-04-01 00:00:00','ruka', 4);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',25,255,7,2, '2019-12-30 00:00:00','oko', 5);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',55,122,7,4, '2019-12-11 00:00:00','prst', 6);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',5,123,6,4, '2019-10-08 00:00:00','stomak', 4);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',15,124,5,1, '2019-10-07 00:00:00','ledja', 5);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',45,127,4,2, '2019-11-02 00:00:00','rame', 6);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',40,192,3,3, '2019-11-26 00:00:00','koljeno', 7);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',35,212,2,2, '2019-11-28 00:00:00','stopalo', 8);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',10,312,3,9, '2019-01-24 00:00:00','dlan', 9);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',10,412,4,8, '2019-03-10 00:00:00','vrat', 7);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',15,112,5,2, '2019-04-11 00:00:00','zglob', 8);
--insert into pregled (stanje, trajanje, cijena, popust, sala, termin, tip, ljekar_id) values ('SLOBODAN',5,77,6,3, '2019-05-02 00:00:00','lakat',9);
