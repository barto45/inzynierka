package Controller;
import java.io.IOException;
import java.sql.SQLException;

import DAO.Cases;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class UsunsprawyController {
	 @FXML
	public Button btnCancel;
	public Button btnUsunsprawe;
	@FXML 
	public TextArea id;
	@FXML 
	private TextField  CasesID;
	@FXML public Button btnDelete;
	
	public void OnACusunsprawy() {
	      Stage primaryStage = new Stage();
          FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeleteCasesScreen.fxml"));
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

		public void CancelCases() {

	    	
			Stage dialogStage = (Stage) btnCancel.getScene().getWindow();
        	dialogStage.hide();
        	    
        
				
	}
		
		

		@FXML public void OnACusunSprawe(MouseEvent event) throws ClassNotFoundException, SQLException{
			
			try{
				Cases.deleteCasesById(Integer.parseInt(CasesID.getText()));
				System.out.println(" SUCCESS!\n");
			}catch (ClassNotFoundException | SQLException e){
		        e.printStackTrace();
		        throw e;
		        }
			
        	    
			
		}

	


		

}
