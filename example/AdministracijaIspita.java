package example;

import java.util.ArrayList;
import java.util.Date;

public class AdministracijaIspita {

	public static void prijavaIspita(Student student) {

		System.out.println("U roku? Y/n");
		Boolean uRoku = !Util.sc.nextLine().equals("n");
		if (uRoku && student.getRacun().getStanje() < 200) {
			System.out.println("Nemate dovoljno sredstava na racunu. Vas racun iznosi: "
					+ student.getRacun().getStanje() + ", a cena prijave ispita je 200rsd");
			return;
		}
		if (!uRoku && student.getRacun().getStanje() < 400) {
			System.out.println("Nemate dovoljno sredstava na racunu. Vas racun iznosi: "
					+ student.getRacun().getStanje() + ", a cena prijave ispita je 400rsd");
			return;
		}

		System.out.println("Izaberite predmet koji zelite da polazete: ");
		ArrayList<Ispit> moguciIspiti = getMoguceIspite(student);
		if (moguciIspiti.isEmpty()) {
			System.out.println("Nema ispita koje mozete da prijavite");
			return;
		}

		ispisTabelarno(moguciIspiti);
		int rbr = -1;
		System.out.println();

		while (true) {
			System.out.println("Unesite broj ispred ispita koji zelite da prijavite: ");
			rbr = Util.nextInt();
			if (rbr > 0 && rbr <= moguciIspiti.size()) {
				break;
			}
		}

		Ispit odabrani = moguciIspiti.get(rbr - 1);
		PrijavaIspita novaPrijava = new PrijavaIspita(student, odabrani, uRoku, Sistem.aktuelniRok);
		System.out.println("Prijava ispita uspesno obavljena!1");
		Sistem.prijaveIspita.add(novaPrijava);
	}

	public static ArrayList<Ispit> getMoguceIspite(Student student) {
		ArrayList<Ispit> moguciIspiti = new ArrayList<Ispit>();
		for (Ispit i : Sistem.ispiti) {
			if (mogucePrijaviti(i, student)) {
				moguciIspiti.add(i);
			}
		}
		return moguciIspiti;
	}

	public static void ispisTabelarno(ArrayList<Ispit> lista) {
		System.out.println();
		System.out.println(String.format("%-3s|%-20s|%-20s", "RBR", "NAZIV PREDMETA", "DATUM POLAGANJA"));
		System.out.println("---+--------------------+--------------------+");
		int broj = 1;

		for (Ispit i : lista) {
			System.out.println(String.format("%-3s|%-20s|%-20s", broj + ". ", i.getPredmet().getNazivPredmeta(),
					Sistem.sdf.format(i.getDatum())));
			broj++;
		}
	}

	public static boolean mogucePrijaviti(Ispit i, Student s) {
		if (i.getDatum().before(new Date())) {
			return false;
		}

		if (i.getPredmet().getGodinaStudija().compareTo(s.getGodina()) > 0) {
			return false;
		}

		if (!i.getPredmet().getNazivSmera().equals(s.getSmer()))
			return false;
		for (PrijavaIspita pi : Sistem.prijaveIspita) {
			if (pi.getStudent() == s && pi.getIspit() == i && pi.getOcena() > 5) {
				return false;
			}
			if (pi.getStudent() == s && pi.getIspit() == i) {
				if (i.getDatum().after(new Date())) {
					return false;
				}
			}
		}
		return true;

	}

	public static double prosek(ArrayList<PrijavaIspita> prijave) {
		double suma = 0;
		if (prijave.isEmpty()) {
			return 0;
		}
		for (PrijavaIspita pi : prijave) {
			suma += pi.getOcena();
		}
		return suma / prijave.size();

	}

	public static ArrayList<PrijavaIspita> getUspesnePrijave(Student student) {
		ArrayList<PrijavaIspita> prijave = new ArrayList<>();
		for (PrijavaIspita pi : Sistem.prijaveIspita) {
			if (pi.getStudent() == student) {
				if (pi.getOcena() > 5) {
					prijave.add(pi);
				}
			}
		}
		return prijave;
	}

	public static void prikazPolozenihPredmetaSaProsecnomOcenom(Student student) {
		ArrayList<PrijavaIspita> prijave = getUspesnePrijave(student);
		double pros = prosek(prijave);
		System.out.println("Polozeni predmeti:");
		if (prijave.isEmpty()) {
			System.out.println("\n*Nemate polozen nijedan predmet*\n");
			return;
		}
		for (PrijavaIspita pi : prijave) {
			System.out.println("Predmet " + pi.getIspit().getPredmet().getNazivPredmeta());
		}
		System.out.println("********" + pros + "*******");
	}

	public static void promenaRoka() {
		Sistem.aktuelniRok = Sistem.aktuelniRok.next();
		System.out.println("Rok je promenjen u: " + Sistem.aktuelniRok);
	}

	public static void prikazPrijavljenihIRezultataUaktuelnomRoku(Student s) {
		String rok = Sistem.aktuelniRok.toString();
		System.out.println("Aktuelni rok: " + rok);
		String naslov = String.format("%-10s|%-20s|%-20s|%-5s|%-10s", "Index", "Datum", "Predmet", "Ocena", "Cena");
		System.out.println(naslov);
		System.out.println("----------+--------------------+--------------------+-----+----------");
		for (PrijavaIspita pi : Sistem.prijaveIspita) {
			String ocena = pi.getIspit().getDatum().after(new Date()) ? "/" : pi.getOcena() + "";
			if (pi.getStudent() == s && pi.getRok().equals(Sistem.aktuelniRok)) {
				System.out.println(String.format("%-10s|%-20s|%-20s|%-5s|%-10d", s.getBrojIndeksa(),
						Sistem.sdf.format(pi.getIspit().getDatum()), pi.getIspit().getPredmet().getNazivPredmeta(),
						ocena, pi.getuRoku() ? 200 : 400));
			}
		}
	}

	public static void pregledPrijavejnihIspitaProfesor(Profesor p) {
		String rok = Sistem.aktuelniRok.toString();
		System.out.println("Aktuelni rok: " + rok);
		String naslov = String.format("%-10s|%-20s|%-20s|%-5s|%-10s", "Index", "Datum", "Predmet", "Ocena", "Cena");
		System.out.println(naslov);
		System.out.println("----------+--------------------+--------------------+-----+----------");
		for (PrijavaIspita pi : Sistem.prijaveIspita) {
			String ocena = pi.getIspit().getDatum().after(new Date()) ? "/" : pi.getOcena() + "";
			if (pi.getIspit().getPredmet().getProfesor().getUsername() == p.getUsername() && pi.getRok().equals(Sistem.aktuelniRok)) {
				System.out.println(String.format("%-10s|%-20s|%-20s|%-5s|%-10d", pi.getStudent().getBrojIndeksa(),
						Sistem.sdf.format(pi.getIspit().getDatum()), pi.getIspit().getPredmet().getNazivPredmeta(),
						ocena, pi.getuRoku() ? 200 : 400));
			}
		}
		System.out.println();
	}

	public static ArrayList<Predmet> getProfesoroviPredmeti(Profesor prof) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		for (Predmet p : Sistem.predmeti) {
			if (p.getProfesor() == prof) {
				predmeti.add(p);
			}
		}
		return predmeti;
	}

	public static void unosRezultata(Profesor p) {
		while (true) {
			int br = 1;
			ArrayList<Predmet> predmetiProfe = getProfesoroviPredmeti(p);
			if(predmetiProfe.isEmpty()){
				System.out.println("Nemate predmeta");
				return;
			}

			for (Predmet pre : predmetiProfe) {
				System.out.println(br + ". " + pre.getNazivPredmeta());
				br++;
			}
			System.out.println("0. Nazad");
			System.out.println("Unesite broj ispred predmeta cije rezultate zelite da unesete: ");
			int brojPredmeta = Util.nextInt();
			if(brojPredmeta == 0){
				return;
			}
			if (brojPredmeta < 1 || brojPredmeta > predmetiProfe.size()) {
				System.out.println("Greska pri odabiru, pokusajte ponovo");
				continue;
			}

			Predmet odabrani = predmetiProfe.get(brojPredmeta - 1);
			unosOcena(odabrani);
		}

	}

	public static void unosOcena(Predmet p) {
		ArrayList<PrijavaIspita> lista = prijavljeniIspitiPredmeta(p);
		if(lista.isEmpty()){
			System.out.println("Nemate prijava za ovaj predmet.");
			return;
		}
		for (PrijavaIspita pi : lista) {
			System.out.println(String.format("%-10s|%-20s|%-20s|%-10d", pi.getStudent().getBrojIndeksa(),
			Sistem.sdf.format(pi.getIspit().getDatum()), pi.getIspit().getPredmet().getNazivPredmeta(),
			pi.getuRoku() ? 200 : 400));
			Integer ocena = -1;
			while (ocena < 5 || ocena > 10) {
				System.out.println("Unesite ocenu: ");
				ocena = Util.nextInt();
			}
			pi.setOcena(ocena);
		}
	}

	public static ArrayList<PrijavaIspita> prijavljeniIspitiPredmeta(Predmet p){
		ArrayList<PrijavaIspita> lista = new ArrayList<PrijavaIspita>();
		for(PrijavaIspita pi : Sistem.prijaveIspita){
			if(pi.getIspit().getPredmet() == p)
				lista.add(pi);
		}
		return lista;
	}
	
}
