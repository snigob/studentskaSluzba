package example;
import java.util.Date;

public class Student extends Korisnik {
	
	//: ime jednog roditelja, broj indeksa, smer, datum rodjenja, JMBG
	//broj, adresa (mesto, ulica i broj), broj telefona, e-mail i tekuca godina studija
	private String imeRoditelja;
	private String brojIndeksa;
	private String smer;
	private Date datumRodjenja;
	private String jmbg;
	private Adresa adresa;
	private String brojTelefona;
	private String email;
	private GodinaStudija godina;
	private Racun racun;
	
	public Student(){}
	
	public String getImeRoditelja() {
		return imeRoditelja;
	}
	public void setImeRoditelja(String imeRoditelja) {
		this.imeRoditelja = imeRoditelja;
	}
	public String getBrojIndeksa() {
		return brojIndeksa;
	}
	public void setBrojIndeksa(String brojIndeksa) {
		this.brojIndeksa = brojIndeksa;
	}
	public String getSmer() {
		return smer;
	}
	public void setSmer(String smer) {
		this.smer = smer;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public String getJmbg() {
		return jmbg;
	}
	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}
	public Adresa getAdresa() {
		return adresa;
	}
	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}
	public String getBrojTelefona() {
		return brojTelefona;
	}
	public void setBrojTelefona(String brojTelefona) {
		this.brojTelefona = brojTelefona;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public GodinaStudija getGodina() {
		return godina;
	}
	public void setGodina(GodinaStudija godina) {
		this.godina = godina;
	}

	public Racun getRacun() {
		return racun;
	}
	public void setRacun(Racun racun) {
		this.racun = racun;
	}
	public Student(String ime, String prezime, String id, String username, String password, String imeRoditelja,
			String brojIndeksa, String smer, Date datumRodjenja, String jmbg, Adresa adresa, String brojTelefona,
			String email, GodinaStudija godina, Racun racun) {
		super(ime, prezime, id, username, password);
		this.imeRoditelja = imeRoditelja;
		this.brojIndeksa = brojIndeksa;
		this.smer = smer;
		this.datumRodjenja = datumRodjenja;
		this.jmbg = jmbg;
		this.adresa = adresa;
		this.brojTelefona = brojTelefona;
		this.email = email;
		this.godina = godina;
		this.racun = racun;
	}
	@Override
	public String toString() {
		return super.toString() + " Student imeRoditelja: " + imeRoditelja + ", brojIndeksa=" + brojIndeksa + ", smer=" + smer
				+ ", datumRodjenja=" + datumRodjenja + ", jmbg=" + jmbg + ", adresa=" + adresa + ", brojTelefona="
				+ brojTelefona + ", email=" + email + ", godina=" + godina + "]";
	}
	
	
	
}
