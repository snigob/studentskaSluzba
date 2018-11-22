package example;

public class AdministracijaKorisnika {
	
	
	public static void popunjavanjeKorisnickogDela(Korisnik k){
		System.out.println("Ime: ");
		String ime = Util.sc.nextLine();
		System.out.println("Prezime: ");
		String prezime = Util.sc.nextLine();
		String username;
		do{
			System.out.println("Username: ");
			username = Util.sc.nextLine();
			if(Sistem.korisnici.get(username) != null){
				System.out.println("Username zauzet, izaberite neki drugi");
			}
		}while(Sistem.korisnici.get(username) != null);
		System.out.println("Password: ");
		String password = Util.sc.nextLine();
		String id = Util.generateId() + "";
		k.setId(id);
		k.setUsername(username);
		k.setPassword(password);
		k.setIme(ime);
		k.setPrezime(prezime);
	}
	
}
