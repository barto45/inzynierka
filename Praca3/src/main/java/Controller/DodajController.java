package Controller;

import java.awt.Button;
import java.awt.TextField;
import java.io.IOException;
import java.util.Collection;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DodajController {

	ObservableList<String> RodzajUbezList = FXCollections.observableArrayList("Kominikacyjne","Komunikacyjne-Flota","OC","Maj¹tek");

	ObservableList<String> UbezpList = FXCollections.observableArrayList("PZU","Warta","Filar","Uniqa","Compensa","Generali","Samopomoc","Signal Iduna","Hestia","Bez Nas","Reso","mtu","pzm","InterRisk","Benefia","Proama","Tuw","Liberty Direct","Alianz","Axa","Gothaer");
	public Button btndodaj;
	 @FXML
	private ComboBox <String > RodzajUbez;
	@FXML
	 private ComboBox<String> Ubezp;
	 
	 public TextField id_name;
    @FXML
	private void initialize() {
	RodzajUbez.setItems(RodzajUbezList);
	Ubezp.setItems(UbezpList);
		
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
            primaryStage.setTitle("AgentUbez");
            primaryStage.setScene(scene);
            primaryStage.show();
        
    
	}

}
