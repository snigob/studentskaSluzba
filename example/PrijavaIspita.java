package example;

public class PrijavaIspita {
	private Student student;
	private Ispit ispit;
	private Boolean uRoku;
	private int ocena;
	private Rok rok;
	
	public Rok getRok() {
		return rok;
	}
	public void setRok(Rok rok) {
		this.rok = rok;
	}
	public int getOcena() {
		return ocena;
	}
	public void setOcena(int ocena) {
		this.ocena = ocena;
	}
	
	
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Ispit getIspit() {
		return ispit;
	}
	public void setIspit(Ispit ispit) {
		this.ispit = ispit;
	}
	public Boolean getuRoku() {
		return uRoku;
	}
	public void setuRoku(Boolean uRoku) {
		this.uRoku = uRoku;
	}
	
	public PrijavaIspita(Student student, Ispit ispit, Boolean uRoku, Rok rok) {
		this.student = student;
		this.ispit = ispit;
		this.uRoku = uRoku;
		this.ocena = 0;
		this.rok = rok;
	}
	@Override
	public String toString() {
		return "PrijavaIspita [student=" + student + ", ispit=" + ispit + ", uRoku=" + uRoku + "]";
	}
	
	
	
	
}
