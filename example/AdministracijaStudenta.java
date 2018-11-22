package example;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;

public class AdministracijaStudenta {
	public static void unos() {
		Student novi = new Student();
		AdministracijaKorisnika.popunjavanjeKorisnickogDela(novi);

		System.out.println("Broj indeksa: ");
		String index = Util.sc.nextLine();
		novi.setBrojIndeksa(index);

		System.out.println("Telefon: ");
		String telefon = Util.sc.nextLine();
		novi.setBrojTelefona(telefon);
		System.out.println("Email: ");
		String email = Util.sc.nextLine();
		novi.setEmail(email);
		System.out.println("Ime roditelja: ");
		String imeRoditelja = Util.sc.nextLine();
		novi.setImeRoditelja(imeRoditelja);
		System.out.println("Smer: ");
		String smer = Util.sc.nextLine();
		System.out.println("JMBG: ");
		String jmbg = Util.sc.nextLine();

		System.out.println("***ADRESA***");
		System.out.println("Mesto: ");
		String mesto = Util.sc.nextLine();
		System.out.println("Ulica: ");
		String ulica = Util.sc.nextLine();
		System.out.println("Broj: ");
		String broj = Util.sc.nextLine();
		Adresa adresa = new Adresa(mesto, ulica, broj);

		System.out.println("***RACUN***");
		System.out.println("Broj racuna: ");
		String brojRacuna = Util.sc.nextLine();
		Racun racun = new Racun(brojRacuna, 5000);
		System.out.println("Datum rodjenja (dan.mesec.godina.): ");
		Date datum = Util.nextDate();
		System.out.println("Godina studija (rimskim brojevima): ");
		GodinaStudija gs = Util.nextGodinaStudija();
		novi.setSmer(smer);
		novi.setJmbg(jmbg);
		novi.setAdresa(adresa);
		novi.setRacun(racun);
		novi.setGodina(gs);
		novi.setDatumRodjenja(datum);
		Sistem.korisnici.put(novi.getId(), novi);
		Sistem.racuni.put(racun.getBroj(), racun);
	}

	public static void izmena() {

	}

	public static void brisanje() {

	}

	public static HashMap<String, Korisnik> pretragaPoIndeksu() {
		System.out.println("Unesite indeks: ");
		String indeks = Util.sc.nextLine();
		HashMap<String, Korisnik> rezultatPretrage = new HashMap<String, Korisnik>();
		for (Korisnik k : Sistem.korisnici.values()) {
			if (k instanceof Student) {
				Student s = (Student) k;
				if (s.getBrojIndeksa().toUpperCase().contains(indeks.toUpperCase())) {
					rezultatPretrage.put(s.getUsername(), s);
				}

			}
		}
		return rezultatPretrage;
	}

	public static HashMap<String, Korisnik> pretragaPoPrezime() {
		System.out.println("Unesite prezime: ");
		String prezime = Util.sc.nextLine();
		HashMap<String, Korisnik> rezultatPretrage = new HashMap<String, Korisnik>();
		for (Korisnik k : Sistem.korisnici.values()) {
			if (k instanceof Student) {
				Student s = (Student) k;
				if (s.getPrezime().toUpperCase().contains(prezime.toUpperCase())) {
					rezultatPretrage.put(s.getUsername(), s);
				}

			}
		}
		return rezultatPretrage;
	}

	/////// SORTIRANJE POMOCU BUBBLE SORTA
	public static void sortPoPrezimenu(ArrayList<Student> lista) {
		for (int i = 0; i < lista.size(); i++) {
			for (int j = i; j < lista.size(); j++) {
				if (lista.get(i).getPrezime().compareTo(lista.get(j).getPrezime()) > 0) {
					Student pom = lista.get(i);
					lista.add(i, lista.get(j));
					lista.add(j, pom);
				}
			}
		}

		System.out.println("Sortirano po prezimenu: ");
		for (Student s : lista) {
			System.out.println(s);
		}
	}

	////////// SORTIRANJE POMOCU COMPARATORA I Collections.sort() metode
	public static class Poredjivac implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {

			return o1.getPrezime().compareTo(o2.getPrezime());
		}
	}

	public static class PoredjivacInvert implements Comparator<Student> {
		@Override
		public int compare(Student o1, Student o2) {

			return o2.getPrezime().compareTo(o1.getPrezime());
		}
	}

	public static void sortiranjePoPrezimenu(ArrayList<Student> lista, int znak) {
		if (znak > 0) {
			Collections.sort(lista, new Poredjivac());
		}
		else{
			Collections.sort(lista, new PoredjivacInvert());
		}
		System.out.println("Sortirano po prezimenu: ");
		for (Student s : lista) {
			System.out.println(s);
		}
	}

	public static void prikaz(HashMap<String, Korisnik> mapa) {
		System.out.println("STUDENTI");
		System.out.println("========");
		for (Korisnik k : mapa.values()) {
			if (k instanceof Student) {
				System.out.println(k);
			}
		}
		System.out.println("========\n");
	}

	public static ArrayList<Student> mapaKorisnikaUListuStudenata() {
		ArrayList<Student> studenti = new ArrayList<Student>();
		for (Korisnik k : Sistem.korisnici.values()) {
			if (k instanceof Student) {
				studenti.add((Student) k);
			}
		}
		return studenti;
	}

}
