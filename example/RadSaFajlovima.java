package example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

public class RadSaFajlovima {

	public static Racun vratiRacunPoBroju(String brojRacuna) {
		for (String broj : Sistem.racuni.keySet()) {
			if (broj.equals(brojRacuna)) {
				return Sistem.racuni.get(broj);
			}
		}
		return null;
	}

	public static boolean ucitajKorisnike() throws ParseException {
		try {
			BufferedReader bf = new BufferedReader(new FileReader("./src/example/baza/korisnici.txt"));
			String linija;
			while ((linija = bf.readLine()) != null) {
				String[] podaci = linija.split("\\|");
				Korisnik novi = null;
				if (podaci.length == 5) { // sluzbenik
					novi = new Sluzbenik(podaci[0], podaci[1], podaci[2], podaci[3], podaci[4]);
				} else if (podaci.length == 7) { // profesor
					String zvanje = podaci[6];
					Zvanje zv = Zvanje.valueOf(zvanje);
					novi = new Profesor(podaci[0], podaci[1], podaci[2], podaci[3], podaci[4], podaci[5], zv);
				} else { // student
					String ime = podaci[0];
					String prezime = podaci[1];
					String id = podaci[2];
					String username = podaci[3];
					String password = podaci[4];
					String imeRoditelja = podaci[5];
					String brojIndeksa = podaci[6];
					String smer = podaci[7];
					Date datumRodjenja = Sistem.sdf.parse(podaci[8]);
					String jmbg = podaci[9];
					String[] adresa = podaci[10].split(";");
					Adresa adr = new Adresa(adresa[0], adresa[1], adresa[2]);
					String brojTelefona = podaci[11];
					String email = podaci[12];
					GodinaStudija godina = GodinaStudija.valueOf(podaci[13]);
					Racun racun = Sistem.racuni.get(podaci[14]);
					System.out.println("Racun: " + racun);
					novi = new Student(ime, prezime, id, username, password, imeRoditelja, brojIndeksa, smer,
						           datumRodjenja, jmbg, adr, brojTelefona, email, godina, racun);
				}
				Sistem.korisnici.put(novi.getId(), novi);

			}
			bf.close();
			return true;
		} catch (FileNotFoundException e) {
			System.out.println("Neuspelo ucitavanje 1");
			return false;

		} catch (IOException e) {
			System.out.println("Neuspelo ucitavanje 2");
			return false;
		}
	}

	public static boolean ucitajRacune() throws IOException{
		BufferedReader bf = new BufferedReader(new FileReader("./src/baza/racuni.txt"));
		String linija;
		while((linija = bf.readLine()) != null ){
			String[] elementi = linija.split("\\|");
			String brojR = elementi[0];
			Double stanje = Double.parseDouble(elementi[1]);
			Racun novi = new Racun(brojR, stanje);
			Sistem.racuni.put(brojR, novi);
		}
		bf.close();
		return true;
	}
	
	
	
	public static boolean sacuvajKorisnike() throws IOException {
		PrintWriter pw = new PrintWriter(new FileWriter("./src/baza/korisnici.txt"));
		for (Korisnik k : Sistem.korisnici.values()) {
			String linija = k.getIme() + "|" + k.getPrezime() + "|" + k.getId() + "|" + k.getUsername() + "|"
					+ k.getPassword();

			if (k instanceof Profesor) {
				Profesor p = (Profesor) k;
				linija = linija + "|" + p.getJmbg() + "|" + p.getZvanje().toString();
			}
			if (k instanceof Student) {
				Student s = (Student) k;
				System.out.println(s.getUsername());
				linija = linija + "|" + s.getImeRoditelja() + "|" + s.getBrojIndeksa() + "|" + s.getSmer() + "|"
						+ Sistem.sdf.format(s.getDatumRodjenja()) + "|" + s.getJmbg() + "|" + s.getAdresa().getMesto()
						+ ";" + s.getAdresa().getUlica() + ";" + s.getAdresa().getBroj() + "|" + s.getBrojTelefona()
						+ "|" + s.getEmail() 
						+ "|" + s.getGodina() 
						+ "|" + s.getRacun().getBroj();
			}
			
			pw.write(linija + "\n");

		}
		
		pw.close();
		return true;
	}
	
	public static void sacuvajRacune() throws IOException{
		PrintWriter pw = new PrintWriter(new FileWriter("./src/baza/racuni.txt"));
		
		for (Racun r : Sistem.racuni.values()) {
			String linija = r.getBroj() + "|" + r.getStanje();
			pw.write(linija + "\n"); 
		}
			
		pw.close();
		

		
		
	}
	
	
	public static void citajSve() throws IOException, ParseException{
		ucitajRacune();
		ucitajKorisnike();
	}
	
	

}
