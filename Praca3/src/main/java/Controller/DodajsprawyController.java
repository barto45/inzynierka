package Controller;

import java.awt.Button;
import java.io.IOException;
import java.util.List;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class DodajsprawyController {
	
	ObservableList<String> Rodzajszkod = FXCollections.observableArrayList("Ca³kowite","Maj¹tkowe","Cielesna","Czêœciowa");

	ObservableList<String> Status = FXCollections.observableArrayList("W trakcie","Zakoñczona","coœ jeszcze");
	
	 public Button btndodajsprawy;
	 @FXML
		private ComboBox <String > Rodzajszkody;
		@FXML
		 private ComboBox<String> Stat;
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

}
