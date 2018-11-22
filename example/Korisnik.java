package example;

public abstract class Korisnik {
	private String ime;
	private String prezime;
	private String id;
	private String username;
	private String password;
	
	
	public Korisnik() {
		// TODO Auto-generated constructor stub
	}
	
	
	public String getIme() {
		return ime;
	}
	public void setIme(String ime) {
		this.ime = ime;
	}
	public String getPrezime() {
		return prezime;
	}
	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public Korisnik(String ime, String prezime, String id, String username, String password) {
		this.ime = ime;
		this.prezime = prezime;
		this.id = id;
		this.username = username;
		this.password = password;
	}
	@Override
	public String toString() {
		return "Korisnik ime: " + ime + ", prezime: " + prezime + ", id: " + id + ", username: " + username + ", password: "
				+ password;
	}
	
	
	

}
