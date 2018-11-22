package example;

import java.util.Date;

public class Ispit {
	private Predmet predmet;
	private Rok ispitniRok;
	private Date datum;
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public Rok getIspitniRok() {
		return ispitniRok;
	}
	public void setIspitniRok(Rok ispitniRok) {
		this.ispitniRok = ispitniRok;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public Ispit(Predmet predmet, Rok ispitniRok, Date datum) {
		super();
		this.predmet = predmet;
		this.ispitniRok = ispitniRok;
		this.datum = datum;
	}
	@Override
	public String toString() {
		return "Ispit [predmet=" + predmet + ", ispitniRok=" + ispitniRok + ", datum=" + datum + "]";
	}
	
	
}
