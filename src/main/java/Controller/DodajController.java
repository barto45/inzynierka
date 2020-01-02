package Controller;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
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

import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;



public class DodajController {

	
	public   Button InsertPolisa;


	
	
	@FXML 
	public DatePicker AddDo;
	@FXML 
	public DatePicker AddOd;
	@FXML 
	public TextField AddNrPolisy;
	@FXML 
	public TextField AddPrzedmiot;
	@FXML 
	public TextField AddNrPracownika;
	@FXML 
	public TextField AddUwagi;
	@FXML 
	public TextField AddKwota;
	@FXML public ComboBox<String> AddRodzajUbez;
	@FXML public ComboBox<String> AddDodUbez;
	@FXML public  ComboBox<String> AddUbezp;
	@FXML public ComboBox<String> AddRaty;

	@FXML Button insertClient;


	@FXML TextField AddNrKlienta;




	@FXML Label LbPrzed;




	@FXML Label LbPolis;




	@FXML Label LbUwagi;




	@FXML Label LbPrac;




	@FXML Label LbKlient;




	@FXML Label LbKwota;
	
	
	
@FXML
	private void initialize() {
	ObservableList<String> RodzajUbezList = FXCollections.observableArrayList("Kominikacyjne","Komunikacyjne-Flota","OC","Maj¹tek");
	ObservableList<String> UbezpList = FXCollections.observableArrayList("PZU","Warta","Filar","Uniqa","Compensa","Generali","Samopomoc","Signal Iduna","Hestia","Bez Nas","Reso","mtu","pzm","InterRisk","Benefia","Proama","Tuw","Liberty Direct","Alianz","Axa","Gothaer");
	ObservableList<String> DodUbez = FXCollections.observableArrayList("AC","NWW","Szyb","Drzwi","Opon","Od Kradzie¿y");
	ObservableList<String> liczbarat = FXCollections.observableArrayList("Tak","Nie");
	
	AddRodzajUbez.setItems(RodzajUbezList);
	AddUbezp.setItems(UbezpList);
	AddRaty.setItems(liczbarat);
	AddDodUbez.setItems(DodUbez);
		
	
	}
    @FXML
		public void OnACdodaj() {

	    	



				
    	   

            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddPersonScreen.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            Scene scene = new Scene(anchorPane);
            
            primaryStage.getIcons().add(new Image("/jgp/images.png"));
            primaryStage.setTitle("AgentUbez  Dodawanie Polisy");
            primaryStage.setResizable(true);
            primaryStage.setScene(scene);
            primaryStage.show();
        
    
	}
    @FXML
	public void insertPolisa(){
    	 
    
		if(AddKwota.getText().trim().isEmpty()) {
			LbKwota.setText("Podaj Kwotê");
		}
		if(AddPrzedmiot.getText().trim().isEmpty()) {
			LbPrzed.setText("Podaj Przedmiot Ubezpieczenia");
		}
		
		if(AddUwagi.getText().trim().isEmpty()) {
			LbUwagi.setText("Wype³nij Uwagi ");
		}
		if(AddNrPracownika.getText().trim().isEmpty()) {
			LbPrac.setText("Podaj Nr. Pracownika");
		}
		if(AddNrKlienta.getText().trim().isEmpty()) {
			LbKlient.setText("Podaj Nr. Klienta");
		}
		if(AddNrPolisy.getText().trim().isEmpty()) {
			LbPolis.setText("Podaj Nr. Polisy");
		}
    	
        
        
       
        
    	Connection conn;
    	Statement stmt= null;
     int idPolisy = 0;
     LocalDate DataOd=AddOd.getValue();
     LocalDate DataDo =AddDo.getValue();
    String TowUbez = AddUbezp.getValue();
     String NazPolisy =AddRodzajUbez.getValue();
    String Uwagi =AddUwagi.getText();
     String DanUbez =AddDodUbez.getValue();
    String IleRat = AddRaty.getValue();
    String  Koszt =AddKwota.getText();
    String  NrRej =AddPrzedmiot.getText();
    String  NrPolisy =AddNrPolisy.getText();
 	String Pracownik_idPracownik = AddNrPracownika.getText();
     String Klient_idKlient = AddNrKlienta.getText();
     
    
     
     try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 System.out.print("\n COnnecting to database ");
    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
    	 
    			 System.out.println(" SUCCESS!\n");
         stmt = conn.createStatement(); 
         System.out.print("elo");
         
       stmt.executeUpdate( "INSERT INTO `polisy`(`idPolisy`, `DataOd`, `DataDo`, `TowUbez`, `NazPolisy`, `Uwagi`, `DanUbez`, `IleRat`, `Koszt`, `Pracownik_idPracownik`, `Klient_idKlient`,`NrRej`,`NrPolisy`) VALUES('"+idPolisy+"','"+DataOd+"','"+DataDo+"','"+TowUbez+"','"+NazPolisy+"', '"+Uwagi+"','"+DanUbez+"','"+IleRat+"','"+Koszt+"','"+Pracownik_idPracownik+"','"+Klient_idKlient+"','"+NrRej+"','"+NrPolisy+"')");
            //conn.commit();
         System.out.println(" SUCCESS!\n");
         Stage stage = (Stage) InsertPolisa.getScene().getWindow();
         stage.close();
         conn.close();
         conn.close(); 
         if(stmt!= null){
        	 JOptionPane.showMessageDialog(null, "Dodano polisê");
          } else  {
			JOptionPane.showMessageDialog(null, "Nie dodano polisy");
          }
     } catch (ClassNotFoundException | SQLException e){
          }
    
    }}




