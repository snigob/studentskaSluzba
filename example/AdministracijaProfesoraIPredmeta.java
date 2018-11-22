package example;

public class AdministracijaProfesoraIPredmeta {

	public static void unosProfesora() {
		Profesor novi = new Profesor();
		AdministracijaKorisnika.popunjavanjeKorisnickogDela(novi);
		System.out.println("JMBG: ");
		String jmbg = Util.sc.nextLine();
		System.out.println("Zvanje: ");
		Zvanje zvanje = Util.nextZvanje();
		novi.setJmbg(jmbg);
		novi.setZvanje(zvanje);
		Sistem.korisnici.put(novi.getId(), novi);
		// int opcija = 0;
		// do{
		// System.out.println("1. Kreirati novi predmet za ovog profesora");
		// System.out.println("2. Izabrati postojeci predmet predmet za ovog
		// profesora");
		// System.out.println("Unesite broj ispred zeljene opcije: ");
		// opcija = Util.nextInt();
		// }while(opcija!=1 && opcija!=2);
		// if(opcija == 1){
		// unosNovogPredmeta(novi);
		// }
	}

	public static void unosPredmeta() {
		// private String nazivPredmeta;
		// private String nazivSmera;
		// private GodinaStudija godinaStudija;
		// private int fondCasova;

		String username = "";
		Profesor odabrani = null;
		while (true) {
			for (Korisnik k : Sistem.korisnici.values()) {
				if (k instanceof Profesor) {
					System.out.println(k.getUsername());
				}
			}
			System.err.println("Unesite username profesora kojeg zelite da predaje ovaj predmet: ");
			username = Util.sc.nextLine();
			Korisnik k = Sistem.korisnici.get(username);
			if (k == null || !(k instanceof Profesor)) {
				System.out.println("Greska pri unosu, ponovite");
			} else {
				odabrani = (Profesor)k;
				break;
			}
		}

		
		
		System.out.println("Naziv predmeta: ");
		String naziv = Util.sc.nextLine();
		System.out.println("Naziv smera: ");
		String smer = Util.sc.nextLine();
		System.out.println("Godina studija: ");
		GodinaStudija g = Util.nextGodinaStudija();
		int fond = -1;
		while (true) {
			System.out.println("Fond casova");
			fond = Util.sc.nextInt();
			if (fond > 1)
				break;
		}
		Predmet p = new Predmet(naziv, smer, g, fond, odabrani);
		Sistem.predmeti.add(p);
	}

	public static void prikazPredmeta() {
		for (Predmet p : Sistem.predmeti) {
			System.out.println(p);
		}
	}

	public static void prikazProfesora() {
		for (Korisnik k : Sistem.korisnici.values()) {
			System.out.println(k);
		}
	}

}
