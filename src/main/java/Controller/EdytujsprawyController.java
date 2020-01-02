package Controller;
import java.io.IOException;
import java.sql.SQLException;

import DAO.Cases;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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

public class EdytujsprawyController {
	
	ObservableList<String> Rodzajszkod = FXCollections.observableArrayList("Ca³kowite","Maj¹tkowe","Cielesna","Czêœciowa");

	ObservableList<String> Status = FXCollections.observableArrayList("W trakcie","Zakoñczona");
	
	 public Button btnedytujsprawy;
	 
		
	 @FXML
		public TextField EditNrSprawy;

		@FXML
		public TextField EditDaneSpr;

		@FXML
		public  TextField EditDanePoszk;

		@FXML
		public  ComboBox<String> EditStat;

		@FXML 
		public DatePicker EditZak;

		@FXML
		public  DatePicker EditRozp;

		@FXML
		public  ComboBox<String> EditRodzajszkody;

		@FXML 
		public TextField EditUwag;

		@FXML Label LbNrSpr;

		@FXML Label LbedPoszk;

		@FXML Label LbedSpr;

		@FXML Label LbedUwag;
		@FXML
		private void initialize() {
		EditRodzajszkody.setItems(Rodzajszkod);
		EditStat.setItems(Status);
			
		}
		public void OnACedytujsprawy() {

	    	



				
    	   

            Stage primaryStage = new Stage();
            FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditCasesScreen.fxml"));
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
		@FXML public void edytujsprawy(ActionEvent event) throws ClassNotFoundException, SQLException{
			if(EditNrSprawy.getText().trim().isEmpty()) {
				LbNrSpr.setText("Podaj Nr. Sprawy");
			}
			
			if(EditDanePoszk.getText().trim().isEmpty()) {
				LbedPoszk.setText("Podaj Dane Poszkodowango");
			}
			if(EditDaneSpr.getText().trim().isEmpty()) {
				LbedSpr.setText("Podaj Dane Sprawcy ");
			}
			if(EditUwag.getText().trim().isEmpty()) {
				LbedUwag.setText("Wype³nij Uwagê");
			}
			
		
			try{
				Cases.EditCasesById(Integer.parseInt(EditNrSprawy.getText()),EditDanePoszk.getText(),
						EditDaneSpr.getText(),EditRodzajszkody.getValue(),EditStat.getValue(),EditRozp.getValue(),
						EditZak.getValue(),EditUwag.getText());
				System.out.println(" SUCCESS!\n");
				Stage stage = (Stage) btnedytujsprawy.getScene().getWindow();
		         stage.close();
			}catch (ClassNotFoundException | SQLException e){
		        e.printStackTrace();
		        throw e;
		        }
			
	 
	    
	  
		
		}

}