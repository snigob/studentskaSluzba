package example;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class Sistem {

	public static SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy.");
	public static HashMap<String, Korisnik> korisnici = new HashMap<String, Korisnik>();
	public static HashMap<String, Racun> racuni = new HashMap<String, Racun>();
	public static ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
	public static ArrayList<Ispit> ispiti = new ArrayList<Ispit>();
	public static ArrayList<PrijavaIspita> prijaveIspita = new ArrayList<PrijavaIspita>();
	
	public static Rok aktuelniRok;
	
	
	public static Korisnik checkLogIn(String username, String password) {
	     System.out.println(username);
             System.out.println(password);	
            for (Korisnik k : korisnici.values()) {
                        
			if (k.getUsername().equals(username) && k.getPassword().equals(password)) {
                            System.out.println(k.toString());
				return k;
			}
		}
		return null;

	}

	public static Korisnik login() {

		Korisnik ulogovani = null;
		do {
			System.out.println("Username: ");
			String username = Util.sc.nextLine();
			System.out.println("Password: ");
			String password = Util.sc.nextLine();
			ulogovani = checkLogIn(username, password);
			if (ulogovani == null) {
				System.out.println("Username and/or password incorrect. Please try again: ");
			}

		} while (ulogovani == null);
		
		
		System.out.println("Login successfull! :)");
		return ulogovani;
	}

}
