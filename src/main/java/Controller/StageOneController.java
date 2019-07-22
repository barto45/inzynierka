package Controller;

import java.io.IOException;


import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class StageOneController {
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
             primaryStage.setScene(scene);
             primaryStage.setTitle("AgentUbez");
             primaryStage.show();
         

}
}
