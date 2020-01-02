package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class DodajKlientController {

	@FXML 
	public TextField AddNrTel;
	@FXML
	public TextField AddPesel;
	@FXML 
	public TextField AddNrDomu;
	@FXML 
	public TextField AddMiejscowosc;
	@FXML 
	public TextField AddKod;
	@FXML 
	public TextField AddUlica;
	@FXML 
	public TextField AddNazwa;
	@FXML 
	public TextField AddNrKlienta;
	@FXML 
	public TextField AddUwagi;
	@FXML 
	public Button insertPolisa;
	@FXML 
	public TextField AddNip;
	@FXML Button insertClient;
	@FXML Label LbKlient;
	@FXML Label LbNazw;
	@FXML Label LbNrDom;
	@FXML Label LbMiejsc;
	@FXML Label LbKod;
	@FXML Label LbUlic;
	@FXML Label lbNrTel;
	@FXML Label LbPesel;
	@FXML Label LbNip;
	@FXML Label LbUwagi;
	 public void AddClient() {


         Stage primaryStage = new Stage();
         FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddClientScreen.fxml"));
         ScrollPane anchorPane = null;
         try {
             anchorPane = loader.load();
         } catch (IOException e) {
             e.printStackTrace();
         }
         
         Scene scene = new Scene(anchorPane);
         primaryStage.getIcons().add(new Image("/jgp/images.png"));
         primaryStage.setTitle("AgentUbez");
         primaryStage.setScene(scene);
         primaryStage.show();
     
	    
		}
	
	@SuppressWarnings("unused")
	@FXML public void insertClient() {
		
		if(AddNrKlienta.getText().trim().isEmpty()) {
			LbKlient.setText("Podaj Nr. Klienta");
		}
		if(AddNazwa.getText().trim().isEmpty()) {
			LbNazw.setText("Wpisz Imiê Nazwisko ");
		}
		if(AddUlica.getText().trim().isEmpty()) {
			LbUlic.setText("Podaj Ulicê ");
		}
		
		if(AddKod.getText().trim().isEmpty()) {
			LbKod.setText("Podaj Kod Pocztowy ");
		}
		if(AddNrTel.getText().trim().isEmpty()) {
			lbNrTel.setText("Podaj Numer Telefonu ");
		}
		if(AddNrKlienta.getText().trim().isEmpty()) {
			LbKlient.setText("Podaj Nr. Klienta");
		}
		if(AddNip.getText().trim().isEmpty()) {
			LbNip.setText("Podaj Nip");
		}
		if(AddPesel.getText().trim().isEmpty()) {
			LbPesel.setText("Podaj Pesel");
		}
		if(AddMiejscowosc.getText().trim().isEmpty()) {
			LbMiejsc.setText("Podaj Miejscowoœæ");
		}
		if(AddNrDomu.getText().trim().isEmpty()) {
			LbNrDom.setText("Podaj Nr. Domu/Mieszkania");
		}
		
		if(AddUwagi.getText().trim().isEmpty()) {
			LbUwagi.setText("Wype³nij Uwagi ");
		}
		
		
		int idKlient = 0; 
     	 String Nazwa = AddNazwa.getText();
       String Ulica = AddUlica.getText();
       String Kod_Poczt = AddKod.getText();
       String Nr_tel = AddNrTel.getText();
       String Nip = AddNip.getText();
       String Pesel = AddPesel.getText();
       String Miejscowosc = AddMiejscowosc.getText();
       String NrDomu = AddNrDomu.getText();
       String Uwagi = AddUwagi.getText();
      
    Connection conn;
    Statement stmt = null;
    try {
   	 Class.forName("com.mysql.cj.jdbc.Driver");
   	 System.out.print("\n COnnecting to database ");
   	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
   			 System.out.println(" SUCCESS!\n");
        stmt = conn.createStatement(); 
        System.out.print("elo");
        
        stmt.executeUpdate( "INSERT INTO `klient`(`idKlient`, `Nazwa`, `Ulica`, `Kod_Poczt`, `NrDomu`, `Nr_tel`, `Nip`, `Pesel`, `Miejscowosc`,  `Uwagi`)Values"
        		+ "('"+idKlient+"','"+Nazwa+"','"+Ulica+"','"+Kod_Poczt+"','"+NrDomu+"','"+Nr_tel+"', '"+Nip+"','"+Pesel+"','"+Miejscowosc+"','"+Uwagi+"')");
        //conn.commit();
        System.out.println(" SUCCESS!\n");
        if(stmt!= null){
          	 JOptionPane.showMessageDialog(null, "Dodano klienta");
            } else
   			JOptionPane.showMessageDialog(null, "Nie dodano klienta");
        Stage stage = (Stage) insertClient.getScene().getWindow();
	    stage.close();
        conn.close();
        conn.close(); 
       
    } catch (ClassNotFoundException | SQLException e){
         }
	}

}
