package Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


import java.io.IOException;

public class LoginController {

    @FXML
    public Button btnLogin;
    @FXML
    public PasswordField id_haslo;

    @FXML
    public TextField id_login;
    @FXML
    public AnchorPane IDanchore;


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
                    primaryStage.setTitle("AgentUbez");
                    primaryStage.setScene(scene);
                    primaryStage.show();
                
    	    }
    




}


