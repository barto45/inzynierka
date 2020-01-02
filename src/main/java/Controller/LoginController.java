package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import Util.DBConnect;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class LoginController {

    @FXML
    private Button Loginb;
    @FXML
    public Button btnCreate ;
    @FXML
    public PasswordField id_haslo;

    @FXML
    public TextField id_login;
    @FXML
    public AnchorPane IDanchore;
	@FXML Button DodajPracow;
	@FXML TextField Imie;
	@FXML TextField Nazwisk;
	@FXML TextField Logi;
	@FXML PasswordField Haslo;
	@FXML Label Login;

	@FXML Label Cash;
	@FXML Label Name;
	@FXML Label Pass;
	@FXML public TextField IdPrac;
	@FXML Label Id;

@FXML
    private void Login(MouseEvent ev) {

    	 String Login = id_login.getText().toString();
         String Has³o = id_haslo.getText().toString();
         DBConnect con = new DBConnect();
         con.getConnection(Login , Has³o);
         if(con.getConect() == true) {
        	 Stage stage = (Stage) Loginb.getScene().getWindow();
             stage.close();
                 Stage Stage = new Stage();
                    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/StageOneScreen.fxml"));
                    AnchorPane anchorPane = null;
                    try {
                        anchorPane = loader.load();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    Scene scene = new Scene(anchorPane);
                    Stage.getIcons().add(new Image("/jgp/images.png"));
                    Stage.setTitle("AgentUbez");
                    Stage.setResizable(true);
                    Stage.setScene(scene);
                    Stage.show();
                  
            	    }
         
    
    }
    @FXML
    public void OnACCreate() {

    	System.out.println(" SUCCESS!\n");
    	Stage primaryStage = new Stage();
        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddWorkerScreen.fxml"));
       ScrollPane anchorPane = null;
        try {
            anchorPane = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Scene scene = new Scene(anchorPane);
        primaryStage.getIcons().add(new Image("/jgp/images.png"));
        primaryStage.setTitle("AgentUbez Dodawanie Pracownika");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println(" SUCCESS!\n");
	    }
   

      
    

	@FXML 
	public void DodajPracow() {
		if(IdPrac.getText().trim().isEmpty()) {
			Id.setText("Podaj nr.Prac.");
		}
		if(Nazwisk.getText().trim().isEmpty()) {
			Name.setText("Podaj Nazwisko");
		}
		if(Imie.getText().trim().isEmpty()) {
			Cash.setText("Podaj Imiê");
		}
		if(Logi.getText().trim().isEmpty()) {
			Login.setText("Podaj Login");
		}
		if(Haslo.getText().trim().isEmpty()) {
			Pass.setText("Podaj Has³o");
		}
	  	Connection conn;
    	Statement stmt= null;
     String idPracownika = IdPrac.getText();
    String Nazwisko = Nazwisk.getText();
     String Imiê =Imie.getText();
    String Login =Logi.getText();
     String Has³o =Haslo.getText();
    
     
    
     
     try {
    	 Class.forName("com.mysql.cj.jdbc.Driver");
    	 System.out.print("\n COnnecting to database ");
    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
    	 
    			 System.out.println(" SUCCESS!\n");
         stmt = conn.createStatement(); 
         System.out.print("elo");
         
       stmt.executeUpdate( "INSERT INTO `pracownik`(`idPracownik`, `Nazwisko`, `Imiê`, `Login`, `Has³o`) VALUES ('"+idPracownika+"','"+Nazwisko+"','"+Imiê+"','"+Login+"','"+Has³o+"')");
            //conn.commit();
         System.out.println(" SUCCESS!\n");
         if(stmt!= null){
        	 JOptionPane.showMessageDialog(null, "Dodano u¿ytkownika");
          } else
			JOptionPane.showMessageDialog(null, "Nie dodano u¿ytkownika");
         Stage stage = (Stage) DodajPracow.getScene().getWindow();
         stage.close();
         conn.close(); 
        
			
     } catch (ClassNotFoundException | SQLException e){
          }

	}



}


