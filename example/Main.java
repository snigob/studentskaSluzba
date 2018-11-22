package example;

import java.io.IOException;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException, IOException {
		RadSaFajlovima.citajSve();

		Sistem.aktuelniRok = Rok.SEPTEMBARSKI;
		Korisnik marko =  Sistem.korisnici.get("3");
		Korisnik nidza =  Sistem.korisnici.get("4");
			// dodavanje dummy podataka u kolekcije ispit i prijaveIspita i predmeta
		Predmet p1 = new Predmet("SIMS", "SII", GodinaStudija.II, 10, (Profesor)marko);
		Predmet p2 = new Predmet("PP", "SII", GodinaStudija.II, 11, (Profesor)nidza);
		Predmet p3 = new Predmet("OOP1", "SII", GodinaStudija.I, 12, (Profesor)marko);
		Predmet p4 = new Predmet("ANALIZA", "SII", GodinaStudija.I, 13, (Profesor)nidza);

		Sistem.predmeti.add(p1);
		Sistem.predmeti.add(p2);
		Sistem.predmeti.add(p3);
		Sistem.predmeti.add(p4);
		Ispit i1 = new Ispit(p1, Rok.JANUARSKI, Sistem.sdf.parse("3.1.2018."));
		Ispit i2 = new Ispit(p2, Rok.JANUARSKI, Sistem.sdf.parse("5.1.2018."));
		Ispit i3 = new Ispit(p3, Rok.FEBRUARSKI, Sistem.sdf.parse("3.2.2018."));
		Ispit i4 = new Ispit(p4, Rok.OKTOBARSKI, Sistem.sdf.parse("3.10.2018."));

		Ispit i5 = new Ispit(p3, Rok.JANUARSKI, Sistem.sdf.parse("3.1.2018."));
		Ispit i6 = new Ispit(p4, Rok.JANUARSKI, Sistem.sdf.parse("5.1.2018."));
		Ispit i7 = new Ispit(p1, Rok.FEBRUARSKI, Sistem.sdf.parse("3.2.2018."));
		Ispit i8 = new Ispit(p2, Rok.OKTOBARSKI, Sistem.sdf.parse("5.10.2018."));

		Ispit i9 = new Ispit(p2, Rok.FEBRUARSKI, Sistem.sdf.parse("3.1.2018."));
		Ispit i10 = new Ispit(p1, Rok.OKTOBARSKI, Sistem.sdf.parse("19.10.2018."));
		Ispit i11 = new Ispit(p4, Rok.FEBRUARSKI, Sistem.sdf.parse("3.2.2018."));
		Ispit i12 = new Ispit(p3, Rok.OKTOBARSKI, Sistem.sdf.parse("13.10.2018."));

		Sistem.ispiti.add(i1);
		Sistem.ispiti.add(i2);
		Sistem.ispiti.add(i3);
		Sistem.ispiti.add(i4);
		Sistem.ispiti.add(i5);
		Sistem.ispiti.add(i6);
		Sistem.ispiti.add(i7);
		Sistem.ispiti.add(i8);
		Sistem.ispiti.add(i9);
		Sistem.ispiti.add(i10);
		Sistem.ispiti.add(i11);
		Sistem.ispiti.add(i12);

		while (true) {
			Util.idGenerator = Util.biggestId();

			Korisnik ulogovaniKorisnik = Sistem.login();
			System.out.println("Dobrodosli!");
			System.out.println("Ime: " + ulogovaniKorisnik.getIme());
			System.out.println("Prezime: " + ulogovaniKorisnik.getPrezime());
			System.out.println("Username: " + ulogovaniKorisnik.getUsername());
			if (ulogovaniKorisnik instanceof Profesor) {
				System.out.println("Uloga: Profesor");
				boolean uPetlji = true;
				while (uPetlji) {
					int opcija = Util.printMenuProfesor();
					switch (opcija) {
					case 1:
						AdministracijaIspita.pregledPrijavejnihIspitaProfesor((Profesor) ulogovaniKorisnik);
						break;
					case 2:
						AdministracijaIspita.unosRezultata((Profesor) ulogovaniKorisnik);
						break;

					case 0:
						uPetlji = false;
					}
				}

			} else if (ulogovaniKorisnik instanceof Student) {
				System.out.println("Uloga: Student");
				boolean uPetlji = true;
				while (uPetlji) {
					int opcija = Util.printMenuStudent();
					switch (opcija) {
					case 1:
						AdministracijaIspita.prijavaIspita((Student) ulogovaniKorisnik);
						break;
					case 2:
						AdministracijaIspita.prikazPolozenihPredmetaSaProsecnomOcenom((Student) ulogovaniKorisnik);
						break;
					case 3:
						AdministracijaIspita.prikazPrijavljenihIRezultataUaktuelnomRoku((Student) ulogovaniKorisnik);
						break;
					case 0:
						uPetlji = false;
					}
				}
			} else {
				System.out.println("Uloga: Sluzbenik");
				boolean uPetlji = true;
				while (uPetlji) {
					int opcija = Util.printMenuSluzbenik();
					switch (opcija) {

					case 1:
						AdministracijaStudenta.unos();
						RadSaFajlovima.sacuvajKorisnike();
						RadSaFajlovima.sacuvajRacune();
						AdministracijaStudenta.prikaz(Sistem.korisnici);
						break;
					case 2:
						while (true) {
							System.out.println("1. Unos profesora");
							System.out.println("2. Unos predmeta");
							System.out.println("0. Nazad");
							System.out.println("Unesite broj ispred opcije: ");
							int opcija2 = Util.nextInt();
							Util.sc.nextLine();
							if (opcija2 == 1) {
								AdministracijaProfesoraIPredmeta.unosProfesora();
								RadSaFajlovima.sacuvajKorisnike();
								AdministracijaProfesoraIPredmeta.prikazProfesora();
							}
							if (opcija2 == 2) {
								AdministracijaProfesoraIPredmeta.unosPredmeta();
								AdministracijaProfesoraIPredmeta.prikazPredmeta();
							}
							if (opcija2 == 0) {
								break;
							}
						}
						break;
					case 3:
						break;
					case 4:
						AdministracijaStudenta.prikaz(AdministracijaStudenta.pretragaPoIndeksu());
						break;
					case 5:
						AdministracijaStudenta.prikaz(AdministracijaStudenta.pretragaPoPrezime());
						break;
					case 6:
						System.out.println("1. Unapred");
						System.out.println("2. Unazad");
						System.out.println("Opcija: ");
						String komanda = Util.sc.nextLine();
						if (komanda.equals("1")) {
							AdministracijaStudenta
									.sortiranjePoPrezimenu(AdministracijaStudenta.mapaKorisnikaUListuStudenata(), 1);
						} else {
							AdministracijaStudenta
									.sortiranjePoPrezimenu(AdministracijaStudenta.mapaKorisnikaUListuStudenata(), -1);
						}
						break;
					case 0:
						uPetlji = false;

					}
				}
			}
		}
	}

}
