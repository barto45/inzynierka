package Controller;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class StageOneController {
	public void OnACdodajsprawy() {

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddCasesScreen.fxml"));
	    ScrollPane scrollPane = null;
	    try {
	        scrollPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(scrollPane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("AgentUbez");
	    primaryStage.show();

	
	}
	public void OnACedit() {

	    

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditPersonScreen.fxml"));
	    ScrollPane anchorPane = null;
	    try {
	        anchorPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(anchorPane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("AgentUbez");
	    primaryStage.show();

	}
	public void OnACusun() {

		

	    

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeletePersonScreen.fxml"));
	    Pane pane = null;
	    try {
	        pane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(pane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("AgentUbez");
	    primaryStage.show();

	}
	public void OnACdodaj() {

	

    

    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddPersonScreen.fxml"));
    ScrollPane scrollPane = null;
    try {
        scrollPane = loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene scene = new Scene(scrollPane);
    primaryStage.getIcons().add(new Image("/jgp/images.png"));
    primaryStage.setScene(scene);
    primaryStage.setTitle("AgentUbez");
    primaryStage.show();

}
	 public void OnACLogin() {

      
          Stage primaryStage = new Stage();
             FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/StageOneScreen.fxml"));
             AnchorPane anchorPane = null;
             try {
                 anchorPane = loader.load();
             } catch (IOException e) {
                 e.printStackTrace();
             }
             Scene scene = new Scene(anchorPane);
             primaryStage.getIcons().add(new Image("/jgp/images.png"));
             primaryStage.setScene(scene);
             primaryStage.setTitle("AgentUbez");
             primaryStage.show();
         

}
}
