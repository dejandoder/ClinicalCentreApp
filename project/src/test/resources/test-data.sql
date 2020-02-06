insert into klinika (id, ime, adresa, opis, grad, ocjena) values (20, 'Drzavna','Njegoseva','Drzavna klinika', 'Gacko',5);
insert into klinika (id, ime, adresa, opis, grad, ocjena) values (21, 'Privatna','Tolstojeva','Privatna klinika', 'Novi Sad',4);

insert into tip_pregleda(id, ime, cijena, trajanje, sala) values(55,'oko',100, 10, 1);
insert into tip_pregleda(id, ime, cijena, trajanje, sala) values(56,'glava',200, 15, 2);

insert into ljekar (id, ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values (11, 'Dejan', 'Doder', 5, 20, '2019-10-28', '2019-11-28', '08:00:00', '15:00:00');
insert into ljekar (id, ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values (12, 'Dejan', 'Doder', 5, 20, '2019-10-28', '2019-10-28', '09:00:00', '16:00:00');
insert into ljekar (id, ime, prezime, ocjena, klinika_id, godisnji_od, godisnji_do, radno_vrijeme_od, radno_vrijeme_do) values (13, 'Dragan', 'Doder', 3, 20, '2019-10-28', '2019-10-28', '08:00:00', '15:00:00');

insert into termin  (termin, zauzet, ljekar_id) values ('08:00:00', false, 11);
insert into termin  (termin, zauzet, ljekar_id) values ('09:00:00', false, 11);

insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (20,55);
insert into klinika_tip_pregleda (klinika_id, tip_pregleda_id) values (20,56);

insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (11,55);
insert into ljekar_tip_pregleda (ljekar_id, tip_pregleda_id) values (11,56);

insert into pregled (id, stanje, trajanje, cijena, popust, sala, termin, vrijeme, tip, ljekar_id, tip_pregleda_id, klinika_id) values (28, 'SLOBODAN', 10, 99, 0, 3, '2019-12-21', '15:00:00', 'oko', 11, 55, 20);
insert into pregled (id, stanje, trajanje, cijena, popust, sala, termin, vrijeme, tip, ljekar_id, tip_pregleda_id, klinika_id) values (29, 'SLOBODAN', 10, 99, 0, 3, '2019-12-21', '15:00:00', 'oko', 11, 55, 20);