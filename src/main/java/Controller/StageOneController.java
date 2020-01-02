package Controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;

import com.sun.javafx.css.StyleManager;

import Util.DBConnect;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.Tab;


public class StageOneController extends Application {
	

	
		//Prypomnienie
		@FXML  private TableView<Przypomnienie> Przypomnienie;
		@FXML  private TableColumn<Przypomnienie, String> DatZakPrzyp;
		@FXML  private TableColumn<Przypomnienie, String> UwagiPrzyp;
		@FXML  private TableColumn<Przypomnienie, Integer> NrKlientaPrzyp;
		@FXML  private TableColumn<Przypomnienie, String> NazUbePrzyp;
		@FXML  private TableColumn<Przypomnienie, Integer> NrPolisyPrzyp;
		
	
	
	
		ObservableList<Controller.Przypomnienie> Polislist=FXCollections.observableArrayList();
		
	//Klienci
	@FXML private TableView<ModelTable> Osoby;
	@FXML private TableColumn <ModelTable,Integer >NrKlienta;
	@FXML private TableColumn<ModelTable,String > NazwaKlienta;
	@FXML private TableColumn<ModelTable,String > UlKlienta;
	@FXML private TableColumn<ModelTable,String > KodKlienta;
	@FXML private TableColumn<ModelTable,String > GminaKlienta;
	@FXML private TableColumn <ModelTable,String >TelKlienta;
	@FXML private TableColumn<ModelTable,String > NipKlienta;
	@FXML private TableColumn<ModelTable,String > PeselKlienta;
	@FXML private TableColumn<ModelTable,String > MiejscKlienta;
	@FXML private TableColumn<ModelTable,String > NrDomKlienta;
	
	ObservableList<ModelTable> oblist=FXCollections.observableArrayList();
	
	//Polisy
	@FXML private TableView<Polisy> Polisy;
	
	@FXML  private TableColumn<Polisy, Integer> NrPolisy;
	@FXML  private TableColumn<Polisy, String> OdPolisy;
	@FXML  private TableColumn<Polisy, String> DoPolisy;
	@FXML  private TableColumn<Polisy, String> TowPolisy;
	@FXML  private TableColumn<Polisy, String> NazwaPolisy;
	@FXML  private TableColumn<Polisy, String> NrRej;
	@FXML  private TableColumn<Polisy, String> DanePolisy;
	@FXML  private TableColumn<Polisy, String> RatyPolis;
	@FXML  private TableColumn<Polisy, String> KwotaPolisy;
	@FXML  private TableColumn<Polisy, String> AgentPolisy;
	@FXML  private TableColumn<Polisy, String> UwagiPolisy;
	@FXML  private TableColumn<Polisy, Integer> KlientPolisy;
	ObservableList<Controller.Polisy> polisylist=FXCollections.observableArrayList();
	//Sprawy
	@FXML  private TableView<Sprawy> Sprawy;
	@FXML  private TableColumn<Sprawy, Integer> NrSprawy;
	@FXML  private TableColumn<Sprawy, String> DanePoszk;
	@FXML  private TableColumn<Sprawy, String> DaneSprawcy;
	@FXML  private TableColumn<Sprawy, String> RozpSprawy;
	@FXML  private TableColumn<Sprawy, String> ZakSprawy;
	@FXML  private TableColumn<Sprawy, String> StatSprawy;
	@FXML  private TableColumn<Sprawy, String> RodzajSprawy;
	@FXML  private TableColumn<Sprawy, String> UwagiSprawy;
	ObservableList<Controller.Sprawy> Caseslist=FXCollections.observableArrayList();
	
	
	@FXML Button DeleteClient;
	@FXML Button EditClient;
	@FXML Button btnAddClient;
	@FXML Button OnACdodaj;
	@FXML Button OnACusun;
	@FXML Button OnACedit;
	@FXML Button refresh;
	private String klient_idKlient;

	
	
	public void initialize() {
		 Connection conn;
	     
	     try {
	    	 Class.forName("com.mysql.cj.jdbc.Driver");
	    	 System.out.print("\n COnnecting to database ");
	    	 conn =  DriverManager.getConnection("jdbc:mysql://remotemysql.com:3306/2BleZUlB9V", "2BleZUlB9V", "1YtMnjtkSO");
	    			 System.out.println(" SUCCESS!\n");
	         
	         System.out.print("elo");
	        ResultSet rs3= conn.createStatement().executeQuery("SELECT * FROM `polisy` WHERE `DataDo`< ADDDATE(CURDATE(), INTERVAL 31 DAY)");
        	 while (rs3.next()) {
        		 Polislist.add(new Przypomnienie(
        				 rs3.getInt("idPolisy"),
	        			 rs3.getString("DataOd"),
	        			 rs3.getString("DataDo"),
	        			 rs3.getString("TowUbez"),
	        			 rs3.getString("NazPolisy"),
	        			 rs3.getString("NrRej"),
	        			 rs3.getString("DanUbez"),
	        			 rs3.getInt("Klient_idKlient"),
	        			 rs3.getString("IleRat"),
	        			 rs3.getString("Koszt"),
	        			 rs3.getString("Uwagi")));
        	 System.out.print("elo");}
	         
        	 
	         ResultSet rs= conn.createStatement().executeQuery("SELECT * FROM klient");
	         System.out.print("elo");
	         while (rs.next()) {
	        	 oblist.add(new ModelTable(
	        			 rs.getInt("idKlient"),
	        			 rs.getString("Nazwa"),
	        			 rs.getString("Ulica"),
	        			 rs.getString("Kod_Poczt"),
	        			 rs.getString("Nr_tel"),
	        			 rs.getString("Nip"),
	        			 rs.getString("Pesel"),
	        			 rs.getString("Miejscowosc"),
	        			 rs.getString("NrDomu")));}
	         
	         ResultSet rs1= conn.createStatement().executeQuery("SELECT * FROM `polisy`");
	        	 while (rs1.next()) {
	        		 polisylist.add(new Polisy(
	        			 rs1.getInt("idPolisy"),
	        			 rs1.getString("DataOd"),
	        			 rs1.getString("DataDo"),
	        			 rs1.getString("TowUbez"),
	        			 rs1.getString("NazPolisy"),
	        			 rs1.getString("NrRej"),
	        			 rs1.getString("DanUbez"),
	        			 rs1.getString("IleRat"),
	        			 rs1.getString("Koszt"),
	        			 rs1.getString("Uwagi"),
	        			 rs1.getInt("Klient_idKlient")));
	        	 }
	        	 ResultSet rs2= conn.createStatement().executeQuery("SELECT * FROM `sprawy`");
	        	 while (rs2.next()) {
	        		 Caseslist.add(new Sprawy(
	        			 rs2.getInt("idSprawy"),
	        			 rs2.getString("DanPoszk"),
	        			 rs2.getString("DanSprawcy"),
	        			 rs2.getString("DatRozp"),
	        			 rs2.getString("DatZak"),
	        			 rs2.getString("StatSpraw"),
	        			 rs2.getString("RodzSzkody"),
	        			 rs2.getString("Uwagi")));
	        	}
	        	 
	        	
	         
	         
	         System.out.println(" SUCCESS!\n");
	       //Przypomnienie
	         
	         
	    
	     	
	     	NrPolisyPrzyp.setCellValueFactory(new PropertyValueFactory<>("idPolisy"));
	     	DatZakPrzyp.setCellValueFactory(new PropertyValueFactory<>("DataDo"));
	        NrKlientaPrzyp.setCellValueFactory(new PropertyValueFactory<>("Klient_idKlient"));	    	
	        NazUbePrzyp.setCellValueFactory(new PropertyValueFactory<>("NrRej"));
	    	UwagiPrzyp.setCellValueFactory(new PropertyValueFactory<>("Uwagi"));
	     
	     	
	     	
	     	Przypomnienie.setItems(Polislist);

		NrKlienta.setCellValueFactory(new PropertyValueFactory<>("idKlient"));
		NazwaKlienta.setCellValueFactory(new PropertyValueFactory<>("Nazwa"));
		UlKlienta.setCellValueFactory(new PropertyValueFactory<>("Ulica"));
		KodKlienta.setCellValueFactory(new PropertyValueFactory<>("Kod_Poczt"));
		TelKlienta.setCellValueFactory(new PropertyValueFactory<>("Nr_tel"));
		NipKlienta.setCellValueFactory(new PropertyValueFactory<>("Nip"));
		PeselKlienta.setCellValueFactory(new PropertyValueFactory<>("Pesel"));
		MiejscKlienta.setCellValueFactory(new PropertyValueFactory<>("Miejscowosc"));
		NrDomKlienta.setCellValueFactory(new PropertyValueFactory<>("NrDomu"));

	Osoby.setItems(oblist);
	//Polisy
	NrPolisy.setCellValueFactory(new PropertyValueFactory<>("idPolisy"));
	OdPolisy.setCellValueFactory(new PropertyValueFactory<>("DataOd"));
	DoPolisy.setCellValueFactory(new PropertyValueFactory<>("DataDo"));
	TowPolisy.setCellValueFactory(new PropertyValueFactory<>("TowUbez"));
	NazwaPolisy.setCellValueFactory(new PropertyValueFactory<>("NazPolisy"));
	NrRej.setCellValueFactory(new PropertyValueFactory<>("NrRej"));
	DanePolisy.setCellValueFactory(new PropertyValueFactory<>("DanUbez"));
	RatyPolis.setCellValueFactory(new PropertyValueFactory<>("IleRat"));
	KwotaPolisy.setCellValueFactory(new PropertyValueFactory<>("Koszt"));
	UwagiPolisy.setCellValueFactory(new PropertyValueFactory<>("Uwagi"));
	KlientPolisy.setCellValueFactory(new PropertyValueFactory<>("klient_idKlient"));
	

Polisy.setItems(polisylist);

//Sprawy

	NrSprawy.setCellValueFactory(new PropertyValueFactory<>("idSprawy"));
	DanePoszk.setCellValueFactory(new PropertyValueFactory<>("DanPoszk"));
	DaneSprawcy.setCellValueFactory(new PropertyValueFactory<>("DanSprawcy"));
	RozpSprawy.setCellValueFactory(new PropertyValueFactory<>("DatRozp"));
	ZakSprawy.setCellValueFactory(new PropertyValueFactory<>("DatZak"));
	StatSprawy.setCellValueFactory(new PropertyValueFactory<>("StatSpraw"));
	RodzajSprawy.setCellValueFactory(new PropertyValueFactory<>("RodzSzkody"));
	UwagiSprawy.setCellValueFactory(new PropertyValueFactory<>("Uwagi"));
	
Sprawy.setItems(Caseslist);



	 conn.close();
	     } catch (ClassNotFoundException | SQLException e){
	          }
	}
	
	public void OnACedytujsprawy() {

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditCasesScreen.fxml"));
	    AnchorPane scrollPane = null;
	    try {
	        scrollPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(scrollPane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Edytuj Sprawê");
	    primaryStage.setResizable(false);
	    primaryStage.show();

	
	}
	@FXML
	public void OnACusunsprawy()
	{

    Stage primaryStage = new Stage();
   
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeleteCasesScreen.fxml"));
    Pane pane = null;
    try {
        pane = loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene scene = new Scene(pane);
    primaryStage.getIcons().add(new Image("/jgp/images.png"));
    primaryStage.setScene(scene);
    primaryStage.setTitle("Usuwanie Sprawy");
    primaryStage.setResizable(false);
    primaryStage.show();}
	
	public void OnACusunSprawe(MouseEvent action) {
		
		
	    
	
	}
	public void OnACdodajsprawy() {

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddCasesScreen.fxml"));
	    AnchorPane scrollPane = null;
	    try {
	        scrollPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(scrollPane);
	   
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Dodawanie Sprawy");
	    primaryStage.setResizable(false);
	   
	    primaryStage.show();

	
	}
	public void OnACedit() {

	    

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditPersonScreen.fxml"));
	    AnchorPane anchorPane = null;
	    try {
	        anchorPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(anchorPane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Edycja Polisy ");
	    primaryStage.setResizable(false);
	    primaryStage.show();

	}
	@FXML
	public void OnACusun() {

		
		 Sprawy.getItems().removeAll(Sprawy.getSelectionModel().getSelectedItems());
	    

	    Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeletePersonScreen.fxml"));
	    Pane pane = null;
	    try {
	        pane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(pane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Usuniêcie Polisy");
	    primaryStage.setResizable(false);
	    primaryStage.show();

	}
	@FXML
    public void ACRefresh() {
		Stage stage = (Stage) refresh.getScene().getWindow();
        stage.close();
        
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
	public void OnACdodaj() {

        
    Stage primaryStage = new Stage();
    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddPersonScreen.fxml"));
    AnchorPane scrollPane = null;
    try {
        scrollPane = loader.load();
    } catch (IOException e) {
        e.printStackTrace();
    }
    Scene scene = new Scene(scrollPane);
    primaryStage.getIcons().add(new Image("/jgp/images.png"));
    primaryStage.setScene(scene);
    primaryStage.setTitle("Dodawanie Polisy");
    primaryStage.setResizable(false);
    primaryStage.show();



}
	 public void OnACLogin() {
		
      
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
             Stage.setScene(scene);
            Stage.setTitle("Logowanie");
            Stage.setResizable(true);
             Stage.close();
         

}
		@FXML
		public void EditClient() {         
		Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/EditClientScreen.fxml"));
	    AnchorPane scrPane = null;
	    try {
	    	scrPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(scrPane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Edycja Klienta");
	    primaryStage.setResizable(false);
	    primaryStage.show();
	}
	@FXML
		public void DeleteClient() {   
		Osoby.getItems().removeAll(Osoby.getSelectionModel().getSelectedItems());
		Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/DeleteClientScreen.fxml"));
	    Pane Pan = null;
	    try {
	       Pan = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(Pan);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Usuwanie Klienta");
	    primaryStage.setResizable(false);
	    primaryStage.show();
	}
		
	 public void closeApp(ActionEvent event) {
		 Optional<ButtonType> result = oAplikacji.confirmationDialog();
		 if(result.get()==ButtonType.OK) {
		Platform.exit();
		System.exit(0);
		 }
	}
	 public void setModena( ) {
		setUserAgentStylesheet(STYLESHEET_MODENA);
	}
	 public void setCaspian( ) {
		setUserAgentStylesheet(STYLESHEET_CASPIAN);
	}
	 public void setAbout ( ) {
		 oAplikacji.dialogoAplikacji();
	 }

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		
	}

	
@FXML 
	 public void AddClient() {
		Stage primaryStage = new Stage();
	    FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/fxml/AddClientScreen.fxml"));
	    AnchorPane scrolPane = null;
	    try {
	        scrolPane = loader.load();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    Scene scene = new Scene(scrolPane);
	    primaryStage.getIcons().add(new Image("/jgp/images.png"));
	    primaryStage.setScene(scene);
	    primaryStage.setTitle("Dodawanie Klienta");
	    primaryStage.setResizable(false);
	    primaryStage.show();
    
	}


      

}
