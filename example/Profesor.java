package example;

public class Profesor extends Korisnik {
	private String jmbg;
	private Zvanje zvanje;
	
	
	public Profesor() {
		// TODO Auto-generated constructor stub
	}
	
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Zvanje getZvanje() {
		return zvanje;
	}
	public void setZvanje(Zvanje zvanje) {
		this.zvanje = zvanje;
	}
	public Profesor(String ime, String prezime, String id, String username, String password, String jmbg,
			Zvanje zvanje) {
		super(ime, prezime, id, username, password);
		this.jmbg = jmbg;
		this.zvanje = zvanje;
	}
	@Override
	public String toString() {
		return "Profesor [jmbg=" + jmbg + ", zvanje=" + zvanje + "]";
	}
	
	
	
	
}
