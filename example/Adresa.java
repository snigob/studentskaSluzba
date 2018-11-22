package example;

public class Adresa {
	private String mesto;
	private String ulica;
	private String broj;
	public String getMesto() {
		return mesto;
	}
	public void setMesto(String mesto) {
		this.mesto = mesto;
	}
	public String getUlica() {
		return ulica;
	}
	public void setUlica(String ulica) {
		this.ulica = ulica;
	}
	public String getBroj() {
		return broj;
	}
	public void setBroj(String broj) {
		this.broj = broj;
	}
	public Adresa(String mesto, String ulica, String broj) {
		super();
		this.mesto = mesto;
		this.ulica = ulica;
		this.broj = broj;
	}
	@Override
	public String toString() {
		return "Adresa [mesto=" + mesto + ", ulica=" + ulica + ", broj=" + broj + "]";
	}
	
	
	
}
