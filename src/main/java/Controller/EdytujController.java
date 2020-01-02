package Controller;


import java.io.IOException;
import java.sql.SQLException;

import DAO.Polisa;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class EdytujController {

	ObservableList<String> RodzajUbezList = FXCollections.observableArrayList("Kominikacyjne","Komunikacyjne-Flota","OC","Maj¹tek");
	ObservableList<String> DodUbez = FXCollections.observableArrayList("AC","NWW","Szyb","Drzwi","Opon","Od Kradzie¿y");
	ObservableList<String> UbezpList = FXCollections.observableArrayList("PZU","Warta","Filar","Uniqa","Compensa","Generali","Samopomoc","Signal Iduna","Hestia","Bez Nas","Reso","mtu","pzm","InterRisk","Benefia","Proama","Tuw","Liberty Direct","Alianz","Axa","Gothaer");
	ObservableList<String> liczbarat = FXCollections.observableArrayList("Tak","Nie");
	@FXML
	public Button OnACEditPolisa;
	 

	 
	
	
	public ComboBox<String> EditUbezp;
	@FXML 
	public DatePicker EditDo;
	@FXML
	public DatePicker EditOd;
	@FXML
	public ComboBox<String> EditRodzajPolisy;
	@FXML
	public TextField EditNrPolisy;
	@FXML
	public ComboBox<String> EditDodUbez;
	@FXML 
	public TextField EditPrzedUbez;
	@FXML
	public TextField EditNip;
	@FXML
	public TextField EditUwagi;
	@FXML 
	public TextField EditKwota;
	@FXML  
	public ComboBox<String> EditRaty;
	@FXML 
	public TextField EditPesel;
	@FXML
	public TextField EditNrTel;

	@FXML TextField EditPrzedmiot;
	
	@FXML TextField EditNrKlienta;
	@FXML ComboBox<String> EditRodzajUbez;

	@FXML 
	private Label LbedPrzed;
	@FXML 
	private Label LbedPolis;
	@FXML 
	private Label LbedKlient;
	@FXML 
	private Label LbedUwagi ;
	@FXML 
	private Label LbedKwota;

	




	
    @FXML
	private void initialize() {
    	EditRodzajUbez.setItems(RodzajUbezList);
	EditUbezp.setItems(UbezpList);
	EditDodUbez.setItems(DodUbez);
	EditRaty.setItems(liczbarat);
	System.out.println("Controller initialized"); 
	}
    
	@FXML
		public void OnACedit() {

	    	



				
    	   

            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditPersonScreen.fxml"));
            AnchorPane anchorPane = null;
            try {
                anchorPane = loader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            Scene scene = new Scene(anchorPane);
            primaryStage.getIcons().add(new Image("/jgp/images.png"));
            primaryStage.setTitle("AgentUbez Edycja Polisy");
            primaryStage.setScene(scene);
            primaryStage.show();
        
    
	}
	@FXML 
	public void OnACEditPolisa(ActionEvent event) throws ClassNotFoundException, SQLException {
	
         if(EditUwagi.getText().trim().isEmpty()) {
		  LbedUwagi.setText("Wype³nij Uwagi");
		}
		
         if(EditKwota.getText().trim().isEmpty()) {
        	 LbedKwota.setText("Wype³nij Kwotê");
         }
         if(EditNrKlienta.getText().trim().isEmpty()) {
        	 LbedKlient.setText("Podaj Nr. Klienta");
         }
         if(EditNrPolisy.getText().trim().isEmpty()) {
        	 LbedPolis.setText("Podaj Nr. Polisy");
         }
         if(EditPrzedmiot.getText().trim().isEmpty()) {
        	 LbedPrzed.setText("Podaj Przedmiot ");
         }
	
		try{
			Polisa.EditPolisaById(EditOd.getValue(),EditDo.getValue(),
					EditUbezp.getValue(),EditRodzajUbez.getValue(),EditUwagi.getText(),EditDodUbez.getValue(),
					EditRaty.getValue(),EditKwota.getText(),EditPrzedmiot.getText(),EditNrKlienta.getText(),Integer.parseInt(EditNrPolisy.getText()));
			System.out.println(" SUCCESS!\n");
			
			
			
		}catch (ClassNotFoundException | SQLException e){
	        e.printStackTrace();
	        throw e;
	        }
		
 
    
  
	}
	

}
