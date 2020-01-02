package Controller;


import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class DodajsprawyController {
	
	ObservableList<String> Rodzajszkod = FXCollections.observableArrayList("Ca³kowite","Maj¹tkowe","Cielesna","Czêœciowa");

	ObservableList<String> Status = FXCollections.observableArrayList("W trakcie","Zakoñczona","coœ jeszcze");
	
	 public Button btndodajsprawy;
	 @FXML
	 public TextField AddNrSprawy;
	 @FXML
	 public TextField AddPoszk;
	 @FXML
	 public TextField AddNrPolisy;
	 @FXML
	 public TextField AddNrKlienta;
	 @FXML
	 public TextField AddNrPracownika;
	 @FXML
	 public TextField AddSpr;
	 @FXML
	 public TextField AddUwag;
	 @FXML
	 public DatePicker AddRozp;
	 @FXML
	 public DatePicker AddZak;
	 
	 @FXML
		private ComboBox <String > Rodzajszkody;
		@FXML
		 private ComboBox<String> Stat;

		@FXML Button insertSprawy;

		@FXML Button insertsprawy;

		@FXML Label Lbspr;

		@FXML Label Lbposzk;

		@FXML Label LbSpra;

		@FXML Label Lbrodz;

		@FXML Label LbStat;

		@FXML Label Lbrozp;

		@FXML Label Lbprac;

		@FXML Label LbKlie;

		@FXML Label Lbpolis;

		@FXML Label LbUwag;
		@FXML
		private void initialize() {
		Rodzajszkody.setItems(Rodzajszkod);
		Stat.setItems(Status);
			
		}
			
		
		public void OnACdodajsprawy() {

	    	



			
    	   

            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddCasesScreen.fxml"));
            AnchorPane anchorPane = null;
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
		@FXML
public void insertSprawy() {
			if(AddPoszk.getText().trim().isEmpty()) {
				Lbposzk.setText("Podaj Dane Poszkodowanego ");
			}
			if(AddNrSprawy.getText().trim().isEmpty()) {
				Lbspr.setText("Podaj Nr.Sprawy ");
			}
			if(AddSpr.getText().trim().isEmpty()) {
				LbSpra.setText("Podaj Dane Sprawcy");
			}
			
			if(AddUwag.getText().trim().isEmpty()) {
				LbUwag.setText("Wype³nij Uwagi");
			}
			if(AddNrPracownika.getText().trim().isEmpty()) {
				Lbprac.setText("Podaj Nr. Pracownika");
			}
			if(AddNrKlienta.getText().trim().isEmpty()) {
				LbKlie.setText("Podaj Nr. Klienta");
			}
			if(AddNrPolisy.getText().trim().isEmpty()) {
				Lbpolis.setText("Podaj Nr. Polisy");
			}
			
			//Stage stage = (Stage) insertsprawy.getScene().getWindow();
	       // stage.close();
			String idSprawy = AddNrSprawy.getText(); 
	      	 String DanPoszk = AddPoszk.getText();
	        String DanSprawcy = AddSpr.getText();
	        String RodzSzkody = Rodzajszkody.getValue();
	        String StatSpraw = Stat.getValue();
	        LocalDate DatRozp = AddRozp.getValue();
	        LocalDate DatZak = AddZak.getValue();
	        String Uwagi = AddUwag.getText();
	        String Pracownik_idPracownik =AddNrPracownika.getText();
	        String Polisy_idPolisy =AddNrPolisy.getText();
	        String Polisy_Pracownik_idPracownik = AddNrPracownika.getText();
	       String Polisy_Klient_idKlient=AddNrKlienta.getText();
	       
		     Connection conn;
		     Statement stmt = null;
		     try {
		    	 Class.forName("com.mysql.cj.jdbc.Driver");
		    	 System.out.print("\n COnnecting to database ");
		    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
		    			 System.out.println(" SUCCESS!\n");
		         stmt = conn.createStatement(); 
		         System.out.print("elo");
		         
		         stmt.executeUpdate( "INSERT INTO `sprawy`(`idSprawy`, `DanPoszk`, `DanSprawcy`, `DatRozp`, `DatZak`, `StatSpraw`, `RodzSzkody`, `Uwagi`, `Pracownik_idPracownik`, `Polisy_idPolisy`, `Polisy_Pracownik_idPracownik`, `Polisy_Klient_idKlient`) VALUES ('"+idSprawy+"','"+DanPoszk+"','"+DanSprawcy+"','"+DatRozp+"','"+DatZak+"','"+StatSpraw+"','"+RodzSzkody+"','"+Uwagi+"','"+Pracownik_idPracownik+"','"+Polisy_idPolisy+"','"+Polisy_Pracownik_idPracownik+"','"+Polisy_Klient_idKlient+"')");
		         //conn.commit();
		         System.out.println(" SUCCESS!\n");
		         conn.close();
		         conn.close(); 
		         if(stmt!= null){
		        	 JOptionPane.showMessageDialog(null, "Dodano sprawê");
		          } 
		     } catch (ClassNotFoundException | SQLException e){
		          }
		    
}}
