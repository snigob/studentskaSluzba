package example;
import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Util{
	
	public static int idGenerator;
	public static Scanner sc = new Scanner(System.in);

	public static int nextInt() {
		int a;
		do {
			try {
				a = sc.nextInt();
				return a;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Greska u unosu! Pokusajte ponovo");
			}
		} while (true);
	}

	public static Date nextDate() {
		Date datum;
		while (true) {
			String datumS = sc.nextLine();
			try {
				datum = Sistem.sdf.parse(datumS);
				return datum;
			} catch (ParseException ps) {
				System.out.println("Greska pri unosu!");
			}
		}
	}

	public static GodinaStudija nextGodinaStudija(){
		GodinaStudija gs;
		while (true) {
			String gsS = sc.nextLine();
			try {
				gs = GodinaStudija.valueOf(gsS);
				return gs;
			} catch (Exception ps) {
				System.out.println("Greska pri unosu!");
			}
		}	
	}
	
	public static Zvanje nextZvanje(){
		Zvanje gs;
		while (true) {
			String gsS = sc.nextLine();
			try {
				gs = Zvanje.valueOf(gsS);
				return gs;
			} catch (Exception ps) {
				System.out.println("Greska pri unosu!");
			}
		}
	}

	public static double nextDouble() {
		double a;
		do {
			try {
				a = sc.nextDouble();

				return a;
			} catch (Exception e) {
				sc.nextLine();
				System.out.println("Greska u unosu! Pokusajte ponovo");
			}
		} while (true);
	}

	public static Integer printMenuSluzbenik() {

		int opcija;
		do {
			System.out.println("1. Upis studenata");
			System.out.println("2. Upis nastavnika i predmeta");
			System.out.println("3. Evidencija uplata studenata");
			System.out.println("4. Pretraga studenta po indeksu");
			System.out.println("5. Pretraga studenta po prezimenu");
			System.out.println("6. Prikaz studenata sortiranih po prezimenu");
			System.out.println("0. Logout");
			System.out.println("Unesite broj ispred zeljene opcije:");
			opcija = nextInt();
			sc.nextLine();
			if (opcija < 0 || opcija > 6)
				System.out.println("Greska u unosu! Pokusajte ponovo");
		} while (opcija < 0 || opcija > 6);
		return opcija;
	}
	
	public static Integer printMenuProfesor(){
		int opcija;
		do {
			System.out.println("1. Pregled prijavljenih ispita");
			System.out.println("2. Unos rezultata ispita");
			
			System.out.println("0. Logout");
			System.out.println("Unesite broj ispred zeljene opcije:");
			opcija = nextInt();
			sc.nextLine();
			if (opcija < 0 || opcija > 2)
				System.out.println("Greska u unosu! Pokusajte ponovo");
		} while (opcija < 0 || opcija > 2);
		return opcija;
		
	}

	public static Integer printMenuStudent() {

		int opcija;
		do {
			System.out.println("1. Prijava ispita");
			System.out.println("2. Prikaz polozenih predmeta i prosek");
			System.out.println("3. Prikaz prijavljenih ispita i rezultata po aktuelnom ispitnom roku");
			
			System.out.println("0. Logout");
			System.out.println("Unesite broj ispred zeljene opcije:");
			opcija = nextInt();
			sc.nextLine();
			if (opcija < 0 || opcija > 3)
				System.out.println("Greska u unosu! Pokusajte ponovo");
		} while (opcija < 0 || opcija > 3);
		return opcija;
	}

	public static int generateId(){
		return ++idGenerator;
	}
	
	public static int biggestId(){
		int  max = -1;
		for(String id : Sistem.korisnici.keySet()){
			if(Integer.parseInt(id) > max){
				max = Integer.parseInt(id);
			}
		}
		return max;
	}
	
	
	
}
