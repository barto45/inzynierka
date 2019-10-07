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
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class EdytujsprawyController {
	 @FXML
	 public Button btnusun;
		private void initialize() {
		
		}

		public void OnACusun() {

	    	



				
    	   

            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeletePersonScreen.fxml"));
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
