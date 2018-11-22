package example;

public class Racun {
	private String broj;
	private double stanje;
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public double getStanje() {
		return stanje;
	}
	public void setStanje(double stanje) {
		this.stanje = stanje;
	}
	public Racun(String broj, double stanje) {
		super();
		this.broj = broj;
		this.stanje = stanje;
	}
	@Override
	public String toString() {
		return "Racun [broj=" + broj + ", stanje=" + stanje + "]";
	}
	
	
	
}
