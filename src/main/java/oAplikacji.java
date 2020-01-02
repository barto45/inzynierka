import javafx.scene.control.Alert;

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
}
