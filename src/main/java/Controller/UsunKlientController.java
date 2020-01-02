package Controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.Client;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class UsunKlientController {

	@FXML public Button btnDelClient;
	@FXML public Button btnCancClient;
	@FXML public TextField ClientID;
	@FXML Label DelClient;
	public void DeleteClient() {          
		 Stage primaryStage = new Stage();
		   
		    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeleteClientScreen.fxml"));
		    Pane pane = null;
		    try {
		        pane = loader.load();
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
		    Scene scene = new Scene(pane);
		    primaryStage.getIcons().add(new Image("/jgp/images.png"));
		    primaryStage.setScene(scene);
		    primaryStage.setTitle("Usuwanie Sprawy");
		    primaryStage.show();

		
}
	@FXML 
	public  void CancelCLient() {
		Stage dialogStage = (Stage) btnCancClient.getScene().getWindow();
    	dialogStage.hide();
	}
	@FXML
	public  void OnACDeleteClient(MouseEvent event) throws ClassNotFoundException, SQLException{
		if(ClientID.getText().trim().isEmpty()) {
			DelClient.setText("Podaj Nr. Klienta");
		}

		
		try{
			Client.deleteKlienciById(Integer.parseInt(ClientID.getText()));
			System.out.println(" SUCCESS!\n");
		}catch (ClassNotFoundException | SQLException e){
	        e.printStackTrace();
	        throw e;
	        }
Stage Stage = (Stage) btnDelClient.getScene().getWindow();
      	
		Stage.hide();
	}

}
