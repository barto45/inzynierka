package Controller;

import java.io.IOException;
import java.sql.SQLException;

import DAO.Client;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class EdytujKlientController {

	@FXML
	public Button btnedytujsprawy;
	@FXML
	public TextField EditNrTel;
	@FXML 
	public TextField EditPesel;
	@FXML 
	public  TextField EditNrDomu;
	@FXML 
	public TextField EditMiejscowosc;
	@FXML 
	public TextField EditKod;
	@FXML 
	public TextField EditUlica;
	@FXML 
	public TextField EditUwagi;
	@FXML 
	public TextField EditNazwa;
	@FXML 
	public Button insertClient;
	@FXML 
	public TextField EditNip;
	@FXML 
	public TextField EditNrKlienta;
	@FXML Label LbedNazw;
	@FXML Label LbedNrDomu;
	@FXML Label LbedMiejsc;
	@FXML Label LbedKod;
	@FXML Label LbedUlica;
	@FXML Label LbedNrTel;
	@FXML Label lbedPesel;
	@FXML Label LbedNip;
	@FXML Label LbedKlient;
	@FXML Label LbedUwagi;
	@FXML
	public void EditClient() {          Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditClientScreen.fxml"));
    ScrollPane scPane = null;
    try {
    	scPane = loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene scene = new Scene(scPane);
    primaryStage.getIcons().add(new Image("/jgp/images.png"));
    primaryStage.setScene(scene);
    primaryStage.setTitle("Edycja Klienta");
    primaryStage.show();
}
	@FXML public void edytujsprawy(ActionEvent event) throws ClassNotFoundException, SQLException {
		if(EditNrKlienta.getText().trim().isEmpty()) {
			LbedKlient.setText("Podaj Nr. Klienta ");
		}
		if(EditNazwa.getText().trim().isEmpty()) {
			LbedNazw.setText("Podaj Imiê Nazwisko ");
		}
		if(EditUlica.getText().trim().isEmpty()) {
			LbedUlica.setText("Podaj Ulicê");
		}
		
		if(EditKod.getText().trim().isEmpty()) {
			LbedKod.setText("Podaj Kod Pocztowy");
		}
		if(EditNrTel.getText().trim().isEmpty()) {
			LbedNrTel.setText("Podaj Nr. Tel");
		}
		if(EditNip.getText().trim().isEmpty()) {
			LbedNip.setText("Podaj Nip");
		}
		if(EditPesel.getText().trim().isEmpty()) {
			lbedPesel.setText("Podaj Pesel");
		}
		if(EditMiejscowosc.getText().trim().isEmpty()) {
			LbedMiejsc.setText("Podaj Miejscowoœæ");
		}
		if(EditNrDomu.getText().trim().isEmpty()) {
			LbedNrDomu.setText("Podaj Nr. Domu/Mieszkania");
		}
		
		if(EditUwagi.getText().trim().isEmpty()) {
			LbedUwagi.setText("Uzupe³nij Uwagi");
		}
		
		try{
			Client.UpdateKlienciById(Integer.parseInt(EditNrKlienta.getText()),EditNazwa.getText(), EditUlica.getText(),
					EditKod.getText(),EditNrTel.getText(),EditNip.getText(),EditPesel.getText(),EditMiejscowosc.getText(),
					EditNrDomu.getText(),
					EditUwagi.getText());
			System.out.println(" SUCCESS!\n");
			 Stage stage = (Stage) btnedytujsprawy.getScene().getWindow();
	         stage.close();
		}catch (ClassNotFoundException | SQLException e){
	        e.printStackTrace();
	        throw e;
	        }
		
	}

}
