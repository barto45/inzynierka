package Controller;
import java.io.IOException;
import java.sql.SQLException;

import DAO.Polisa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class UsunController {
	 @FXML
	 public Button btnusun;
	 @FXML
	 public TextField IDPolisy;
	@FXML public Button btnDeleteP;
	@FXML public Button btnCancelP;
	@FXML  TextField IDpolisy;
	@FXML Label DelPerson;
		

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
		
		public void CancelPolisa() {
			Stage Stag = (Stage) btnCancelP.getScene().getWindow();
			Stag.hide();
		}
		@FXML 
		public void UsunPolise(MouseEvent event) throws ClassNotFoundException, SQLException{
			if(IDpolisy.getText().trim().isEmpty()) {
				DelPerson.setText("Podaj Nr. Klienta");
			}

			try{
				Polisa.deletePolisaById(Integer.parseInt(IDpolisy.getText()));
				System.out.println(" SUCCESS!\n");
			}catch (ClassNotFoundException | SQLException e){
		        e.printStackTrace();
		        throw e;
		        }
			Stage Stag = (Stage) btnDeleteP.getScene().getWindow();
			Stag.hide();
			}
		}
