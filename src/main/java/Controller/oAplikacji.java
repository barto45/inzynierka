package Controller;
import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

public class oAplikacji extends Alert {

	
	public oAplikacji(AlertType alertType) {
		super(alertType);
		// TODO Auto-generated constructor stub
	}

	public static void dialogoAplikacji() {
		Alert informationAlert = new Alert(Alert.AlertType.INFORMATION);
		informationAlert.setTitle("O Aplikacji");
		informationAlert.setHeaderText("Aplikacja zosta³a stworzon¹ przez Bart³omieja Mitrusa oraz Rafa³a Karwana ");
		informationAlert.setContentText("W razie b³êdów aplikacji pytania proszê kierowaæ na e-mail:mitbartek@gmail.com");
		informationAlert.showAndWait();
	}
	public static Optional<ButtonType> confirmationDialog(){
		Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationDialog.setTitle("Zamykanie");
		confirmationDialog.setHeaderText("Czy na pewno chcesz zamkn¹æ program ?!");
		Optional<ButtonType> result = confirmationDialog.showAndWait();
		return result;
	}
}