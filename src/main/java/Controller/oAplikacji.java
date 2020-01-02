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
		informationAlert.setHeaderText("Aplikacja zosta�a stworzon� przez Bart�omieja Mitrusa oraz Rafa�a Karwana ");
		informationAlert.setContentText("W razie b��d�w aplikacji pytania prosz� kierowa� na e-mail:mitbartek@gmail.com");
		informationAlert.showAndWait();
	}
	public static Optional<ButtonType> confirmationDialog(){
		Alert confirmationDialog = new Alert(Alert.AlertType.CONFIRMATION);
		confirmationDialog.setTitle("Zamykanie");
		confirmationDialog.setHeaderText("Czy na pewno chcesz zamkn�� program ?!");
		Optional<ButtonType> result = confirmationDialog.showAndWait();
		return result;
	}
}