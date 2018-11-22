package example;

public class Predmet {
	//. Podaci za predmet su: naziv predmeta, naziv smera, godina studija i nedeljni fond casova.
	private String nazivPredmeta;
	private String nazivSmera;
	private GodinaStudija godinaStudija;
	private int fondCasova;
	private Profesor profesor; // dodat atribut profesor da bismo znali ko predaje ovaj predmet
	
	
	public Profesor getProfesor() {
		return profesor;
	}
	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
	public String getNazivPredmeta() {
		return nazivPredmeta;
	}
	
	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}
	
	public String getNazivSmera() {
		return nazivSmera;
	}
	
	public void setNazivSmera(String nazivSmera) {
		this.nazivSmera = nazivSmera;
	}
	
	public GodinaStudija getGodinaStudija() {
		return godinaStudija;
	}
	
	public void setGodinaStudija(GodinaStudija godinaStudija) {
		this.godinaStudija = godinaStudija;
	}
	
	public int getFondCasova() {
		return fondCasova;
	}
	
	public void setFondCasova(int fondCasova) {
		this.fondCasova = fondCasova;
	}
	
	public Predmet(String nazivPredmeta, String nazivSmera, GodinaStudija godinaStudija, int fondCasova, Profesor p) {
		super();
		this.profesor = p;
		this.nazivPredmeta = nazivPredmeta;
		this.nazivSmera = nazivSmera;
		this.godinaStudija = godinaStudija;
		this.fondCasova = fondCasova;
	}
	@Override
	public String toString() {
		return "Predmet [nazivPredmeta=" + nazivPredmeta + ", nazivSmera=" + nazivSmera + ", godinaStudija="
				+ godinaStudija + ", fondCasova=" + fondCasova +", profesor: " + profesor.getPrezime() +  "]";
	}

	
	
}
