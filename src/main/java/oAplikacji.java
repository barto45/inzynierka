import javafx.scene.control.Alert;

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
}
