package example;

import java.net.URL;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class MainViewController {

    @FXML private static int counter = 0;
    @FXML private TextField tfLoginUsername;
    @FXML private TextField tfLoginPassword;
    @FXML private Label labLoginKontrolna;
    @FXML private Button butLoginOk;
    @FXML private TabPane tabPane;
    @FXML private TextArea taOutput;
    @FXML private TextField tfStudentBrindeksa;
    @FXML private TextField tfStudentIme;
    @FXML private TextField tfStudentPrezime;
    @FXML private TextField tfStudentSmer;
    @FXML private TextField tfStudentGodstudija;
    // private Student s;

    @FXML
    public Korisnik btnLoginOk() throws ParseException {
        System.out.println("Provera 001");
        labLoginKontrolna.setText("Provera 001");
        Korisnik ulogovani = null;
        RadSaFajlovima.ucitajKorisnike();
        
           String username = tfLoginUsername.getText();
           String password = tfLoginPassword.getText();
           ulogovani = Sistem.checkLogIn(username, password);
           if (ulogovani == null) {
	      labLoginKontrolna.setText("Username and/or password incorrect");
              return ulogovani;
           }
        
        labLoginKontrolna.setText("Username and password correct");
        
        listanjeStudenata(AdministracijaStudenta.mapaKorisnikaUListuStudenata(), ulogovani);
        
        return ulogovani;
        
    }

    /*
    @FXML
    public void btnStudentOk() throws ParseException {
        System.out.println("Provera 002");   
        RadSaFajlovima.ucitajKorisnike();
        listanjeStudenata(AdministracijaStudenta.mapaKorisnikaUListuStudenata());
 
    }
    */
    
    @FXML
    public void listanjeStudenata(ArrayList<Student> lista, Korisnik ulogovani) {
        System.out.println("Spisak studenata ");
        // Student s = lista.get(0);
        int i = 0;    
        for (Student s : lista){
            System.out.println(lista.get(i).toString());
           
            System.out.println("ulogovani = " + ulogovani.getUsername());
            System.out.println(lista.get(i).getUsername());
            if (ulogovani.getUsername().equals(lista.get(i).getUsername())) {
                System.out.println("usao u if");
                    tfStudentBrindeksa.setText(lista.get(i).getBrojIndeksa());
                    tfStudentIme.setText(lista.get(i).getIme());
                    tfStudentPrezime.setText(lista.get(i).getPrezime());
                    tfStudentSmer.setText(lista.get(i).getSmer());
                    tfStudentGodstudija.setText(lista.get(i).getGodina().toString());
            }
             i++;
        }
            
    }
    
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}