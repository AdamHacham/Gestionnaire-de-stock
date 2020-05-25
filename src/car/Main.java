package car;

import java.sql.Connection;
import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;
import java.util.Random;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.util.Callback;
import jdbcdemo.DbConnector;
import java.text.SimpleDateFormat;


public class Main extends Application {

	
    String SQL2 = "SELECT * FROM Coli WHERE date =";
	Stage window;
	Scene scenetest;
	Scene scene0,scene1,scene2,scene3,scene4,scene5,scene6,scene7;
	//private static Client tabs[];
	private static Client[] tab1s;
	
	private static Client cl;
	private static TableView<Client> table = new TableView<Client>();
	final ObservableList<Client> data = FXCollections.observableArrayList();
	private static Diver[] tab2s;
	@SuppressWarnings("rawtypes")
	private ObservableList<ObservableList> dataA ;
	@SuppressWarnings("rawtypes")
	public TableView tableA ;
	@SuppressWarnings("rawtypes")
	public TableView tableB ;
	String SQL1 = "SELECT Coli.nompe,Coli.prenompe,Coli.nompr,Coli.prenompr,Coli.dest,Coli.src,Coli.numcolis,Coli.prix,Client.tel FROM Coli INNER JOIN Client ON Coli.id_propriétaire=Client.id AND Coli.tel = Client.tel WHERE Client.tel =";
   
	DropShadow ds = new DropShadow();
	
	ComboBox<String> sexe = new ComboBox<String>();
	ComboBox<String> jour = new ComboBox<String>();
	ComboBox<String> mois = new ComboBox<String>();
	ComboBox<String> année = new ComboBox<String>();
	//TextField sexe = new TextField();
	//sexe.setPromptText(value);
	TextField nom = new TextField();
	TextField prenom = new TextField();
	TextField tel = new TextField();
	TextField mail = new TextField();
	TextField nm1 = new TextField();
	TextField pnom1 = new TextField();
	TextField dst = new TextField();
	TextField tl = new TextField();
	TextField type = new TextField();
	TextField prix = new TextField();
	TextField qté= new TextField();
	TextField etat = new TextField();
	TextField login = new TextField();
	TextField nom1 = new TextField();
	TextField prenom1 = new TextField();
	TextField tel1 = new TextField();
	TextField histo_client = new TextField();
	TextField histo_jour = new TextField();
	TextField histo_mois = new TextField();
	TextField histo_coli = new TextField();
	PasswordField password = new PasswordField();
	
	//Button historique_Client = new Button("Historique Client");
  	// Button historique_Jour = new Button("Historique du Jour");
  	// Button historique_Mois = new Button("Historique du Mois");
  	 Button historique_Coli  = new Button("Historique");
  	 
  	 VBox Sbox = new VBox(5); 
  	 HBox sbox = new HBox(2);
  	 HBox sbox1 = new HBox(2);
  	 HBox sbox2 = new HBox(2);
  	 HBox sbox3 = new HBox(2);
  	static SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
  	static SimpleDateFormat sm1 = new SimpleDateFormat("dd");
	static Date aujourdhui = new Date();
	static Random rd = new Random();
	
	public static void main(String[] args) {
		//lireEnBaseC("0609699888");
		//System.out.print(getClass().getResourceAsStream("home.png");
		
		//System.out.println();
		

		
System.out.println(Matricule());
		Application.launch(args);
		
			
		
	    

	  }
	public static String Matricule(){
	      int randomInt = rd.nextInt(10000);
	      String matricule = sm1.format(aujourdhui)+randomInt;
	      return matricule;
	 
	    }
	 

	//@SuppressWarnings({ "unchecked", "rawtypes" })
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		//FileInputStream input = new FileInputStream("hachamadam/Desktop/Projet_Java/Chaima/car/home.png");
	    
//________________________________________________________________________________________________
//_________________________________________________________________________________Scène For Login 
		
		ds.setOffsetY(3.0f);
		ds.setColor(Color.color(0.4f, 0.4f, 0.4f));
		
		VBox p1 = new VBox(2);
		VBox box0 = new VBox(3);
		p1.setAlignment(Pos.CENTER);
		
		
		password.setPrefWidth(100);
		box0.setAlignment(Pos.CENTER);
		box0.setSpacing(35);
		box0.setPadding(new Insets(50,50,50,50));
		
		box0.setStyle("-fx-background-color : #2A2E2D;");
		
		HBox login1 = new HBox(10);
		//login1.setStyle("-fx-border-color : Black;");
		login1.setAlignment(Pos.CENTER);
		login.prefWidthProperty().bind(login1.widthProperty());
		
		login.setMinWidth(150);
		login.setMaxWidth(300);
		HBox pass = new HBox(10);
		//pass.setStyle("-fx-border-color : Black;");
		pass.setAlignment(Pos.CENTER);
		password.prefWidthProperty().bind(login1.widthProperty());
		
		password.setMinWidth(150);
		password.setMaxWidth(300);
		HBox validation = new HBox(10);
		validation.setAlignment(Pos.CENTER);
		//validation.setStyle("-fx-border-color : Black;");
		
		
		
		 
		
		
		
		
		Label titre3 = new Label("Gestion Des Stocks");
		titre3.setFont(Font.font ("Avenir", 30));
		titre3.setTextFill(Color.BLACK);
		titre3.setEffect(ds);
		titre3.setCache(true);
		
		
		Label labelog = new Label("Login");
		labelog.setFont(Font.font ("Avenir", 18));
		labelog.setTextFill(Color.WHITE);
		labelog.setAlignment(Pos.CENTER_LEFT);
		//labelog.setStyle("-fx-border-color:Black;");
		labelog.setPrefWidth(100);
		labelog.prefWidthProperty().bind(login1.widthProperty());
		labelog.setMaxWidth(120);
		labelog.setEffect(ds);
		labelog.setCache(true);
		Label labelpass = new Label("Password");
		labelpass.setFont(Font.font ("Avenir", 18));
		labelpass.setTextFill(Color.WHITE);
		//labelpass.setStyle("-fx-border-color:Black;");
		labelpass.setAlignment(Pos.CENTER_LEFT);
		labelpass.setPrefWidth(120);
		
		labelpass.prefWidthProperty().bind(login1.widthProperty());
		labelpass.setMaxWidth(120);
		labelpass.setEffect(ds);
		labelpass.setCache(true);
		
        
		Button valid1 = new Button("Se Connecter");
	
		valid1.setFont(Font.font ("Avenir",15));
		valid1.setTextFill(Color.BLACK);
		valid1.setEffect(ds);
		valid1.setCache(true);
	//	valid1.setGraphics());
		valid1.prefWidthProperty().bind(login1.widthProperty());
		valid1.setMinWidth(150);
		valid1.setMaxWidth(300);
		valid1.setOnAction(e->{
			DbConnector dbc = new DbConnector(login.getText(),password.getText());
			if(dbc.getCn()!= null){
			window.setScene(scene1);
			window.setTitle("Menu");
			}
			else{
				System.out.println("Connection Not successful");
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Erreur Mot Passe");
				alert.setHeaderText(null);
				alert.setContentText("Connection Not successful");
				alert.showAndWait();
			}
		});
		
		login1.getChildren().addAll(labelog,login);
		pass.getChildren().addAll(labelpass,password);
		validation.getChildren().addAll(valid1);
		box0.getChildren().addAll(login1,pass);
		VBox.setMargin(box0,new Insets(20,20,20,20));
		p1.getChildren().addAll(titre3,box0,validation);
		scene0 = new Scene(p1,600,350);
		
		
//________________________________________________________________________________________________
//__________________________________________________________________________Scène Number 1 'Menu'

		
		Image image1 = new Image(getClass().getResourceAsStream("user.png"));
		Image image2 = new Image(getClass().getResourceAsStream("user-2.png"));
	ImageView imv = new ImageView(image1);
	 imv.setFitHeight(35);
	 imv.setFitWidth(35);
	imv.setEffect(ds);
	
	 ImageView imv1 = new ImageView(image2);
	 imv1.setFitHeight(35);
	 imv1.setFitWidth(35);
	 imv1.setEffect(ds);
	 ToggleButton nClient = new ToggleButton("  Nouveau Client ?");
	 nClient.setPrefSize(100,50);
	 nClient.setGraphic(imv1);
	 nClient.setFont(Font.font ("Avenir", 15));
	nClient.setTextFill(Color.BLACK);
	// VBox lay = new VBox(10);
    // lay.setAlignment(Pos.CENTER);
    // lay.getChildren().setAll(nClient);
	 ToggleButton aClient = new ToggleButton("    Déjà Client ?",imv);
	 aClient.setFont(Font.font ("Avenir", 15));
	 aClient.setTextFill(Color.BLACK);
	 Button aFermer = new Button("Fermer");
	 aClient.setFont(Font.font ("Avenir", 15));
	 aClient.setTextFill(Color.BLACK);
	 Button aHistorique = new Button("Historique");
	 
	 GridPane grid = new GridPane();
	 GridPane grid2 = new GridPane();
	 
	 GridPane grid3 = new GridPane();
	 VBox box = new VBox(3);
	
		grid.setPadding(new Insets(5,5,5,5));
	    grid.setStyle("-fx-border-color : Black ;");
	    grid.setStyle("-fx-background-color :#F3EDE0 ;");
	    grid2.setPadding(new Insets(15,15,15,15));
	    grid2.setHgap(20);
	    
	    grid2.setStyle("-fx-background-radius: 10px;-fx-background-color : #2A2E2D;");
	    grid3.setPadding(new Insets(15,15,15,15));
	    grid3.setHgap(20);
	    grid3.setStyle("-fx-background-radius: 10px;-fx-background-color : #2A2E2D;");
	    grid3.setEffect(ds);
		grid3.setCache(true);
		grid2.setEffect(ds);
		grid2.setCache(true);
		//grid2.setMargin(grid,new Insets(25,25,25,25));
	    nClient.prefWidthProperty().bind(grid2.widthProperty());
	    aClient.prefWidthProperty().bind(grid2.widthProperty());
	    nClient.prefHeightProperty().bind(grid2.heightProperty());
	    aClient.prefHeightProperty().bind(grid2.heightProperty());
	    nClient.setPadding(new Insets(15,5,5,5));
	    
	    aClient.setPadding(new Insets(15,5,5,5));
	    aFermer.prefWidthProperty().bind(grid2.widthProperty());
	    aHistorique.prefWidthProperty().bind(grid2.widthProperty());
	    aFermer.prefHeightProperty().bind(grid2.heightProperty());
	    aHistorique.prefHeightProperty().bind(grid2.heightProperty());
	    aFermer.setPadding(new Insets(15,5,5,5));
	    aHistorique.setPadding(new Insets(15,5,5,5));
//	    nClient.setMaxHeight(90);
	//    aClient.setMaxHeight(90);
	    nClient.setMinHeight(30);
	    aClient.setMinHeight(30); 
	    nClient.setMaxWidth(300);
	    aClient.setMaxWidth(300);
	    grid2.prefWidthProperty().bind(grid.widthProperty());
	    grid2.prefHeightProperty().bind(grid.heightProperty());
	    //grid2.setMinHeight(50);
	    grid2.setMaxHeight(100);
	    grid2.setMinWidth(400);
	    grid2.add(aClient,0,0);
	    grid2.add(nClient,1,0);
	    grid2.setAlignment(Pos.CENTER);
	    box.setAlignment(Pos.CENTER);
	    box.setSpacing(35);
	    Label titre = new Label("Menu Principal");
	    
	    titre.setStyle("-fx-background-radius: 10px;-fx-background-color : #F2F2F2;"); 
	   //  -fx-font : Avenir; -fx-size:20px; -fx-background-radius: 10px;-fx-background-color : White;-fx-font-size: 16pt;");
	    titre.setEffect(ds);
	    titre.setFont(Font.font ("Avenir", 25));
		titre.setTextFill(Color.LIGHTCORAL);
	    titre.setPadding(new Insets(5,5,5,5));
	    titre.prefWidthProperty().bind(grid.widthProperty());
	    titre.prefHeightProperty().bind(grid.heightProperty());
	    titre.setMaxHeight(80);
	    titre.setAlignment(Pos.CENTER);
	    
	    aFermer.setMinHeight(40);
	    aHistorique.setMinHeight(40); 
	    aFermer.setMaxWidth(300);
	    aHistorique.setMaxWidth(300);
	    aFermer.setFont(Font.font ("Avenir", 15));
		 aFermer.setTextFill(Color.BLACK);
		 aHistorique.setFont(Font.font ("Avenir", 15));
		 aHistorique.setTextFill(Color.BLACK);
	    grid3.prefWidthProperty().bind(grid.widthProperty());
	    grid3.prefHeightProperty().bind(grid.heightProperty());
	    grid3.setMinHeight(50);
	    grid3.setMaxHeight(100);
	    grid3.setMinWidth(500);
	    grid3.add(aFermer,0,0);
	    grid3.add(aHistorique,1,0);
	    grid3.setAlignment(Pos.CENTER);
	    grid3.setEffect(ds);
		grid3.setCache(true);
	    
	    
	    box.getChildren().addAll(titre,grid2,grid3);
	    
	    grid.addRow(0,box);
	    grid.setAlignment(Pos.CENTER);
	    aFermer.setOnAction(e->window.close());
		nClient.setOnAction(e->{
			
			
			window.setScene(scene2);
			
			window.setTitle("Nouveau Client");
		});
		aClient.setOnAction(e->{
			
			window.setScene(scene3);
			window.setTitle("Ancien Client");
			});
		aHistorique.setOnAction(e->{
			
			window.setScene(scene6);
			window.setTitle("Historique");
			});
		scene1 = new Scene(grid,600,600);
		
//________________________________________________________________________________________________
//____________________________________________________________________ Scène Number 2 'New Client'
		
		
		Image image11 = new Image(getClass().getResourceAsStream("checked-2.png"));
		Image image22 = new Image(getClass().getResourceAsStream("unchecked.png"));
	ImageView imv11 = new ImageView(image11);
	 imv11.setFitHeight(10);
	 imv11.setFitWidth(10);
	imv11.setEffect(ds);
	
	 ImageView imv12 = new ImageView(image22);
	 imv12.setFitHeight(10);
	 imv12.setFitWidth(10);
	 imv12.setEffect(ds);
	 ToggleButton valid = new ToggleButton("Validez");
	 //valid.setPrefSize(100,50);
	 valid.setGraphic(imv11);
	 valid.setFont(Font.font ("Avenir", 15));
	 valid.setTextFill(Color.BLACK);
	 //VBox lay1 = new VBox(10);
     //lay1.setAlignment(Pos.CENTER);
     //lay1.getChildren().setAll(nClient);
	 ToggleButton annule = new ToggleButton("Annulez",imv12);
	 annule.setFont(Font.font ("Avenir", 11));
	 annule.setTextFill(Color.BLACK);
	 valid.setFont(Font.font ("Avenir", 11));
	 valid.setTextFill(Color.BLACK);
		
	
		Image image = new Image(getClass().getResourceAsStream("home.png"));
		ImageView imv2 = new ImageView(image);
		 imv2.setFitHeight(20);
		 imv2.setFitWidth(20);
		 imv2.setEffect(ds);
		ToggleButton home = new ToggleButton();
	      home.setPrefSize(20,20);
	     home.setGraphic(imv2);
	      VBox layout = new VBox(10);
	      layout.setAlignment(Pos.CENTER);
	      layout.getChildren().setAll(home);

	    layout.getStylesheets().add(getClass().getResource("New.css").toExternalForm());
	     //home.setOnAction(e->window.setScene(scene1));
	   home.setOnAction(e->window.setScene(scene1));
		 
		
	//ColoredToggle 	
		
		StackPane layout2 = new StackPane();
		
		
		VBox box1 = new VBox(10);
		HBox hbox5 = new HBox(10);
		hbox5.setEffect(ds);
		box1.setStyle("-fx-background-color : White;-fx-background-radius: 10px;");
		HBox hbox = new HBox(10);
		hbox.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox.setEffect(ds);
		//hbox.setPrefHeight(50);
		HBox hbox1 = new HBox(10);
		hbox1.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox1.setEffect(ds);
		HBox hbox2 = new HBox(10);
		hbox2.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox2.setEffect(ds);
		HBox hbox3 = new HBox(10);
		hbox3.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hbox3.setEffect(ds);
		HBox hbox4 = new HBox(10);
		hbox4.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hbox4.setEffect(ds);
		
		Label titre1 = new Label("Nouveau Client");
		titre1.setFont(Font.font ("Avenir", 30));
		titre1.setTextFill(Color.BLACK);
		titre1.setEffect(ds);
		
		Label label1 = new Label("M/MME     ");
		label1.setAlignment(Pos.CENTER_LEFT);
		//label1.setStyle("-fx-border-color:;");
		label1.setPrefWidth(150);
		label1.setFont(Font.font ("Avenir", 15));
		label1.setTextFill(Color.WHITE);
		label1.setEffect(ds);
		
		Label label2 = new Label("Nom");
		//label2.setStyle("-fx-border-color:Black;");
		label2.setAlignment(Pos.CENTER_LEFT);
		label2.setPrefWidth(150);
		label2.setFont(Font.font ("Avenir", 15));
		label2.setTextFill(Color.WHITE);
		label2.setEffect(ds);
		
		Label label3 = new Label("Prénom     ");
		label3.setAlignment(Pos.CENTER_LEFT);
		label3.setPrefWidth(150);
		//label3.setStyle("-fx-border-color:Black;");
		label3.setFont(Font.font ("Avenir", 15));
		label3.setTextFill(Color.WHITE);
		label3.setEffect(ds);
		
		Label label4 = new Label("Téléphone");
		label4.setPrefWidth(150);
		label4.setAlignment(Pos.CENTER_LEFT);
		//label4.setStyle("-fx-border-color:Black;");
		label4.setFont(Font.font ("Avenir", 15));
		label4.setTextFill(Color.WHITE);
		label4.setEffect(ds);
		Label label5 = new Label("E-mail       ");
		label5.setPrefWidth(150);
		label5.setAlignment(Pos.CENTER_LEFT);
		//label5.setStyle("-fx-border-color:Black;");
		label5.setFont(Font.font ("Avenir", 15));
		label5.setTextFill(Color.WHITE);
		label5.setEffect(ds);
		
		
		
	    
	    sexe.getItems().addAll("M", "F");
	    sexe.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
	          @Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(100);
	              }

	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("M")) {
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("F")) {
	                    setTextFill(Color.PINK);
	                  } 
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
	        });
		
	    
		sexe.setPrefWidth(175);
		sexe.setPadding(new Insets(0,10,10,10));
		nom.setPadding(new Insets(10,10,10,10));
		prenom.setPadding(new Insets(10,10,10,10));
		tel.setPadding(new Insets(10,10,10,10));
		mail.setPadding(new Insets(10,10,10,10));
		
		hbox.getChildren().addAll(label1,sexe);
		hbox1.getChildren().addAll(label2,nom);
		hbox2.getChildren().addAll(label3,prenom);
		hbox3.getChildren().addAll(label4,tel);
		hbox4.getChildren().addAll(label5,mail);
		hbox5.getChildren().addAll(annule,home,valid);
		
		annule.setOnAction(e->{
			window.setScene(scene1);
		});
		
		valid.setOnAction(e->{
			//System.out.println(""+nom.getText()+"");
			
			if(EmailValide(mail) && NomValide(nom) && TelValide(tel) && PrenomValide(prenom)){
				sauverEnBase(nom.getText(),sexe.getValue(),prenom.getText(),tel.getText(),mail.getText()); 
				
				scenetest = window.getScene();
				window.setScene(scene5);
				window.setTitle("Première Envoi de Coli");
			}
			
		});
		HBox.setMargin(sexe, new Insets(10,5,10,5));
		HBox.setMargin(nom, new Insets(10,5,10,5));
		HBox.setMargin(prenom, new Insets(10,5,10,5));
		HBox.setMargin(tel, new Insets(10,5,10,5));
		HBox.setMargin(mail, new Insets(10,5,10,5));
		box1.setSpacing(20);
		box1.setAlignment(Pos.CENTER);
		hbox.setSpacing(10);
		hbox.setAlignment(Pos.CENTER);
		hbox1.setSpacing(10);
		hbox1.setAlignment(Pos.CENTER);
		hbox2.setSpacing(10);
		hbox2.setAlignment(Pos.CENTER);
		hbox3.setSpacing(10);
		hbox3.setAlignment(Pos.CENTER);
		hbox4.setSpacing(10);
		hbox4.setAlignment(Pos.CENTER);
		hbox5.setSpacing(10);
		hbox5.setAlignment(Pos.CENTER);
		VBox.setMargin(hbox,new Insets(0,20,0,20));
		VBox.setMargin(hbox1,new Insets(0,20,0,20));
		VBox.setMargin(hbox2,new Insets(0,20,0,20));
		VBox.setMargin(hbox3,new Insets(0,20,0,20));
		VBox.setMargin(hbox4,new Insets(0,20,0,20));
		VBox.setMargin(hbox5,new Insets(0,20,0,20));
		box1.getChildren().addAll(titre1,hbox,hbox1,hbox2,hbox3,hbox4,hbox5);
		StackPane.setMargin(box1,new Insets(5,50,5,50));
		layout2.getChildren().add(box1);
		
		scene2 = new Scene(layout2,600,600);
		
		
//________________________________________________________________________________________________
//____________________________________________________________________Scène Number 3 'old Client'		
		
		StackPane layout3 = new StackPane();
		
		
		Image image111 = new Image(getClass().getResourceAsStream("checked-2.png"));
		Image image222 = new Image(getClass().getResourceAsStream("unchecked.png"));
	ImageView imv111 = new ImageView(image111);
	 imv111.setFitHeight(10);
	 imv111.setFitWidth(10);
	imv111.setEffect(ds);
	
	 ImageView imv122 = new ImageView(image222);
	 imv122.setFitHeight(10);
	 imv122.setFitWidth(10);
	 imv122.setEffect(ds);
	 ToggleButton nEnvoi = new ToggleButton("Validez");
	 //valid.setPrefSize(100,50);
	 nEnvoi.setGraphic(imv111);
	 nEnvoi.setFont(Font.font ("Avenir", 15));
	 nEnvoi.setTextFill(Color.BLACK);
	 //VBox lay1 = new VBox(10);
     //lay1.setAlignment(Pos.CENTER);
     //lay1.getChildren().setAll(nClient);
	 ToggleButton historique = new ToggleButton("Annulez",imv122);
	 historique.setFont(Font.font ("Avenir", 11));
	 historique.setTextFill(Color.BLACK);
	 nEnvoi.setFont(Font.font ("Avenir", 11));
	 nEnvoi.setTextFill(Color.BLACK);
		
	
		Image image13 = new Image(getClass().getResourceAsStream("home.png"));
		ImageView imv23 = new ImageView(image13);
		 imv23.setFitHeight(20);
		 imv23.setFitWidth(20);
		 imv23.setEffect(ds);
		ToggleButton retour1 = new ToggleButton();
	      retour1.setPrefSize(20,20);
	     retour1.setGraphic(imv23);
	      VBox layout33 = new VBox(10);
	      layout33.setAlignment(Pos.CENTER);
	      layout33.getChildren().setAll(retour1);

	    layout33.getStylesheets().add(getClass().getResource("New.css").toExternalForm());
	     //home.setOnAction(e->window.setScene(scene1));
	   retour1.setOnAction(e->window.setScene(scene1));
		
		
		
		
		VBox box2 = new VBox(10);
		box2.setStyle("-fx-background-color : White;-fx-background-radius: 10px;");
		HBox hbox6 = new HBox(10);
		hbox6.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox6.setEffect(ds);
		//hbox.setPrefHeight(50);
		HBox hbox7 = new HBox(10);
		hbox7.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox7.setEffect(ds);
		HBox hbox8 = new HBox(10);
		hbox8.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox8.setEffect(ds);
		HBox hbox10 = new HBox(10);
		hbox10.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hbox10.setEffect(ds);
		
		HBox.setMargin(retour1, new Insets(10,5,10,5));
		HBox.setMargin(nom1, new Insets(10,5,10,5));
		HBox.setMargin(prenom1, new Insets(10,5,10,5));
		HBox.setMargin(tel1, new Insets(10,5,10,5));
		
		Label titre2 = new Label("Ancien Client");
		titre2.setFont(Font.font ("Avenir", 30));
		titre2.setTextFill(Color.BLACK);
		titre2.setEffect(ds);
		
		Label label6 = new Label("Nom");
		label6.setAlignment(Pos.CENTER_LEFT);
		//label1.setStyle("-fx-border-color:;");
		label6.setPrefWidth(150);
		label6.setFont(Font.font ("Avenir", 15));
		label6.setTextFill(Color.WHITE);
		label6.setEffect(ds);
		
		Label label7 = new Label("Prenom");
		//label2.setStyle("-fx-border-color:Black;");
		label7.setAlignment(Pos.CENTER_LEFT);
		label7.setPrefWidth(150);
		label7.setFont(Font.font ("Avenir", 15));
		label7.setTextFill(Color.WHITE);
		label7.setEffect(ds);
		
		Label label8 = new Label("tel");
		label8.setAlignment(Pos.CENTER_LEFT);
		label8.setPrefWidth(150);
		//label3.setStyle("-fx-border-color:Black;");
		label8.setFont(Font.font ("Avenir", 15));
		label8.setTextFill(Color.WHITE);
		label8.setEffect(ds);
		
		
		
		tel1.setPadding(new Insets(10,10,10,10));
		nom1.setPadding(new Insets(10,10,10,10));
		prenom1.setPadding(new Insets(10,10,10,10));
		
		hbox6.getChildren().addAll(label6,nom1);
		hbox7.getChildren().addAll(label7,prenom1);
		hbox8.getChildren().addAll(label8,tel1);
		VBox.setMargin(hbox6,new Insets(0,20,0,20));
		VBox.setMargin(hbox7,new Insets(0,20,0,20));
		VBox.setMargin(hbox8,new Insets(0,20,0,20));
		VBox.setMargin(hbox10,new Insets(0,20,0,20));
		
		
		/*
		Button  nEnvoi = new Button("Nouvelle Envoi");
		Image imag4 = new Image(getClass().getResourceAsStream("home.png"));
        ImageView imv4 = new ImageView(imag4);
        imv4.setFitHeight(20);
		imv4.setFitWidth(20);
		imv4.setEffect(ds);
        ToggleButton retour1 = new ToggleButton();
	    retour1.setPrefSize(20,20);;
	    retour1.setGraphic(imv4);
	    VBox hom2 = new VBox(10);
	    hom2.setAlignment(Pos.CENTER);
	    hom2.getChildren().setAll(retour1);
		Button  historique = new Button("Historique");
		*/
		nEnvoi.setOnAction(e->{
			
			
			//if(NomValide() && TelValide() && PrenomValide()){
				
				scenetest = window.getScene();
				window.setScene(scene5);
				window.setTitle("Envoi de Coli");
			
			
			

//			window.setScene(scene4);
			 //tab1s[i].toString();
		});
	
		historique.setOnAction(e->{
			window.setScene(scene1);
		
		});
		
		/*
		historique.setOnAction(e->{
				lireEnBase();
				for(int i = 0 ; i<tab1s.length;i++) {
					data.add(tab1s[i]);
				}
				window.setScene(scene4);
				 //tab1s[i].toString();
			});
		*/
		retour1.setOnAction(e->window.setScene(scene1));
		hbox10.getChildren().addAll(historique,retour1,nEnvoi);
		box2.setSpacing(20);
		box2.setAlignment(Pos.CENTER);
		hbox6.setSpacing(10);
		hbox6.setAlignment(Pos.CENTER);
		hbox7.setSpacing(10);
		hbox7.setAlignment(Pos.CENTER);
		hbox8.setSpacing(10);
		hbox8.setAlignment(Pos.CENTER);
		
		hbox10.setSpacing(10);
		hbox10.setAlignment(Pos.CENTER);
		//hbox5.setSpacing(10);
		//hbox5.setAlignment(Pos.CENTER);
		box2.getChildren().addAll(titre2,hbox6,hbox7,hbox8,hbox10);
		layout3.getChildren().add(box2);
		
		scene3 = new Scene(layout3,600,500);
	   
//________________________________________________________________________________________________
//____________________________________________________________________ Scène Number 4 'Historique'		
		
		
		table.setEditable(true);

		TableColumn<Client,String> NomCol = new TableColumn<Client, String>("Nom");
        NomCol.setMinWidth(100);
        NomCol.setCellValueFactory(new PropertyValueFactory<>("Nom"));
 
        TableColumn<Client,String> PrenomCol = new TableColumn<Client,String>("Prenom");
        PrenomCol.setMinWidth(100);
        PrenomCol.setCellValueFactory(new PropertyValueFactory<>("Prenom"));
        
        TableColumn<Client,String> TelCol = new TableColumn<Client, String>("Tel");
        TelCol.setMinWidth(100);
        TelCol.setCellValueFactory(new PropertyValueFactory<>("Tel"));
 
        TableColumn<Client,String> MailCol = new TableColumn<Client,String>("Mail");
        MailCol.setMinWidth(200);
        MailCol.setCellValueFactory(new PropertyValueFactory<>("Mail"));
 
        table.setItems(data);
        table.setPrefWidth(500);
        table.setPrefHeight(300);
        table.getColumns().addAll(NomCol,PrenomCol,TelCol,MailCol);
       
        Image imag = new Image(getClass().getResourceAsStream("home.png"));
        ImageView imv3 = new ImageView(imag);
        imv3.setFitHeight(20);
		 imv3.setFitWidth(20);
		 imv3.setEffect(ds);
        ToggleButton home0 = new ToggleButton();
	      home0.setPrefSize(20,20);;
	      home0.setGraphic(imv3);
	      VBox hom1 = new VBox(10);
	      hom1.setAlignment(Pos.CENTER);
	      hom1.getChildren().setAll(home0);

	    layout.getStylesheets().add(getClass().getResource("New.css").toExternalForm());
	     //home.setOnAction(e->window.setScene(scene1));
	    home0.setOnAction(e->window.setScene(scene1));
        

        VBox vbox = new VBox();
        vbox.setSpacing(5);
        vbox.setPadding(new Insets(10, 0, 0, 10));
        vbox.getChildren().addAll(table,hom1);
 
        
        scene4 = new Scene(vbox,600,600);
      
        
//________________________________________________________________________________________________
//__________________________________________________________________Scène Number 5 'Nouveau Coli'        
 
        
        
        
        
        
        
        
        Image image1111 = new Image(getClass().getResourceAsStream("checked-2.png"));
		Image image2222 = new Image(getClass().getResourceAsStream("unchecked.png"));
	ImageView imv1111 = new ImageView(image1111);
	 imv1111.setFitHeight(10);
	 imv1111.setFitWidth(10);
	imv1111.setEffect(ds);
	
	 ImageView imv1211 = new ImageView(image2222);
	 imv1211.setFitHeight(10);
	 imv1211.setFitWidth(10);
	 imv1211.setEffect(ds);
	 ToggleButton envoyer = new ToggleButton("Validez");
	 //valid.setPrefSize(100,50);
	 envoyer.setGraphic(imv1111);
	 envoyer.setFont(Font.font ("Avenir", 15));
	 envoyer.setTextFill(Color.BLACK);
	 //VBox lay1 = new VBox(10);
     //lay1.setAlignment(Pos.CENTER);
     //lay1.getChildren().setAll(nClient);
	 ToggleButton retourner = new ToggleButton("Annulez",imv1211);
	 retourner.setFont(Font.font ("Avenir", 11));
	 retourner.setTextFill(Color.BLACK);
	 envoyer.setFont(Font.font ("Avenir", 11));
	 envoyer.setTextFill(Color.BLACK);
		
	
		Image image8 = new Image(getClass().getResourceAsStream("home.png"));
		ImageView imv24 = new ImageView(image8);
		 imv24.setFitHeight(20);
		 imv24.setFitWidth(20);
		 imv24.setEffect(ds);
		ToggleButton home4 = new ToggleButton();
	      home4.setPrefSize(20,20);
	     home4.setGraphic(imv24);
	      VBox layout4 = new VBox(10);
	      layout4.setAlignment(Pos.CENTER);
	      layout4.getChildren().setAll(home4);

	    layout4.getStylesheets().add(getClass().getResource("New.css").toExternalForm());
	     //home.setOnAction(e->window.setScene(scene1));
	   home4.setOnAction(e->window.setScene(scene1));
		 
		
	//ColoredToggle 	
		
		//StackPane layout222 = new StackPane();
		
		
		VBox nc = new VBox(10);
		//HBox hox = new HBox(10);
		//hox.setEffect(ds);
		//hox.setStyle("-fx-background-color : White;-fx-background-radius: 10px;");
		HBox hox1 = new HBox(10);
		hox1.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hox1.setEffect(ds);
		//hbox.setPrefHeight(50);
		HBox hox2 = new HBox(10);
		hox2.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hox2.setEffect(ds);
		HBox hox3 = new HBox(10);
		hox3.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hox3.setEffect(ds);
		//HBox hox4 = new HBox(10);
		//hox4.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		//hox4.setEffect(ds);
		HBox hox5 = new HBox(10);
		hox5.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hox5.setEffect(ds);
		HBox hox6 = new HBox(10);
		hox6.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hox6.setEffect(ds);
		HBox hox7 = new HBox(10);
		hox7.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hox7.setEffect(ds);
		HBox hox8 = new HBox(10);
		hox8.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hox8.setEffect(ds);
		HBox hox9 = new HBox(10);
		hox9.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hox9.setEffect(ds);
		
		Label titr2 = new Label("Nouveau Coli");
		titr2.setFont(Font.font ("Avenir", 30));
		titr2.setTextFill(Color.BLACK);
		titr2.setEffect(ds);
		
		Label labe6 = new Label("Nom Receveur");
		labe6.setAlignment(Pos.CENTER_LEFT);
		//label1.setStyle("-fx-border-color:;");
		labe6.setPrefWidth(150);
		labe6.setFont(Font.font ("Avenir", 15));
		labe6.setTextFill(Color.WHITE);
		labe6.setEffect(ds);
		Label labe7 = new Label("Prénom Receveur");
		Label labe8 = new Label("Destination");
		Label labe10 = new Label("Type");
		Label labe11 = new Label("Prix");
		Label labe12 = new Label("Quantité");
		Label labe13 = new Label("Etat");
		
		
		//label2.setStyle("-fx-border-color:Black;");
		labe7.setAlignment(Pos.CENTER_LEFT);
		labe7.setPrefWidth(150);
		labe7.setFont(Font.font ("Avenir", 15));
		labe7.setTextFill(Color.WHITE);
		labe7.setEffect(ds);
		
		
		labe8.setAlignment(Pos.CENTER_LEFT);
		labe8.setPrefWidth(150);
		//label3.setStyle("-fx-border-color:Black;");
		labe8.setFont(Font.font ("Avenir", 15));
		labe8.setTextFill(Color.WHITE);
		labe8.setEffect(ds);
		
		
		labe10.setPrefWidth(150);
		labe10.setAlignment(Pos.CENTER_LEFT);
		//label4.setStyle("-fx-border-color:Black;");
		labe10.setFont(Font.font ("Avenir", 15));
		labe10.setTextFill(Color.WHITE);
		labe10.setEffect(ds);
		
		labe11.setPrefWidth(150);
		labe11.setAlignment(Pos.CENTER_LEFT);
		//label5.setStyle("-fx-border-color:Black;");
		labe11.setFont(Font.font ("Avenir", 15));
		labe11.setTextFill(Color.WHITE);
		labe11.setEffect(ds);
		
		labe12.setPrefWidth(150);
		labe12.setAlignment(Pos.CENTER_LEFT);
		//label5.setStyle("-fx-border-color:Black;");
		labe12.setFont(Font.font ("Avenir", 15));
		labe12.setTextFill(Color.WHITE);
		labe12.setEffect(ds);
		
		labe13.setPrefWidth(150);
		labe13.setAlignment(Pos.CENTER_LEFT);
		//label5.setStyle("-fx-border-color:Black;");
		labe13.setFont(Font.font ("Avenir", 15));
		labe13.setTextFill(Color.WHITE);
		labe13.setEffect(ds);
		
		nm1.setPadding(new Insets(5,5,5,5));
		pnom1.setPadding(new Insets(5,5,5,5));
		dst.setPadding(new Insets(5,5,5,5));
		type.setPadding(new Insets(5,5,5,5));
		prix.setPadding(new Insets(5,5,5,5));
		qté.setPadding(new Insets(5,5,5,5));
		etat.setPadding(new Insets(5,5,5,5));
		
		
		//hox.getChildren().addAll(titr2);
		hox1.getChildren().addAll(labe6,nm1);
		hox2.getChildren().addAll(labe7,pnom1);
		hox3.getChildren().addAll(labe8,dst);
		//hox4.getChildren().addAll(labe9,tl);
		hox5.getChildren().addAll(labe10,type);
		hox6.getChildren().addAll(labe11,prix);
		hox7.getChildren().addAll(labe12,qté);
		hox8.getChildren().addAll(labe13,etat);
		hox9.getChildren().addAll(retourner,home4,envoyer);
		/*
		annule.setOnAction(e->{
			window.setScene(scene1);
		});
		
		valid.setOnAction(e->{
			//System.out.println(""+nom.getText()+"");
			
			if(EmailValide(mail) && NomValide(nom) && TelValide(tel) && PrenomValide(prenom)){
				sauverEnBase(nom.getText(),sexe.getText(),prenom.getText(),tel.getText(),mail.getText()); 
				scenetest = window.getScene();
				window.setScene(scene5);
				window.setTitle("Première Envoi de Coli");
			}
			
		});
		*/
		HBox.setMargin(nm1, new Insets(10,5,10,5));
		HBox.setMargin(pnom1, new Insets(10,5,10,5));
		HBox.setMargin(dst, new Insets(10,5,10,5));
		HBox.setMargin(type, new Insets(10,5,10,5));
		HBox.setMargin(prix, new Insets(10,5,10,5));
		HBox.setMargin(qté, new Insets(10,5,10,5));
		HBox.setMargin(etat, new Insets(10,5,10,5));
		nc.setSpacing(20);
		nc.setAlignment(Pos.CENTER);
		//hox.setSpacing(10);
		//hox.setAlignment(Pos.CENTER);
		hox1.setSpacing(10);
		hox1.setAlignment(Pos.CENTER);
		hox2.setSpacing(10);
		hox2.setAlignment(Pos.CENTER);
		hox3.setSpacing(10);
		hox3.setAlignment(Pos.CENTER);
		//hox4.setSpacing(10);
		//hox4.setAlignment(Pos.CENTER);
		hox5.setSpacing(10);
		hox5.setAlignment(Pos.CENTER);
		hox6.setSpacing(10);
		hox6.setAlignment(Pos.CENTER);
		hox7.setSpacing(10);
		hox7.setAlignment(Pos.CENTER);
		hox8.setSpacing(10);
		hox8.setAlignment(Pos.CENTER);
		hox9.setSpacing(10);
		hox9.setAlignment(Pos.CENTER);
		
		
		//VBox.setMargin(hox,new Insets(0,20,0,20));
		VBox.setMargin(hox1,new Insets(0,20,0,20));
		VBox.setMargin(hox2,new Insets(0,20,0,20));
		VBox.setMargin(hox3,new Insets(0,20,0,20));
		//VBox.setMargin(hox4,new Insets(0,20,0,20));
		VBox.setMargin(hox5,new Insets(0,20,0,20));
		VBox.setMargin(hox6,new Insets(0,20,0,20));
		VBox.setMargin(hox7,new Insets(0,20,0,20));
		VBox.setMargin(hox8,new Insets(0,20,0,20));
		VBox.setMargin(hox9,new Insets(0,20,0,20));
		nc.getChildren().addAll(titr2,hox1,hox2,hox3,hox5,hox6,hox7,hox8,hox9);
		//StackPane.setMargin(nc,new Insets(5,50,5,50));
		//layout222.getChildren().add(nc);
        
   
        scene5=new Scene(nc,600,600);
		
        envoyer.setOnAction(e->{
        	if(scene2==scenetest){
        	
        	System.out.println(tel.getText());
        	lireEnBaseC(tel.getText());
        	
        	sauverEnBaseC(cl.getTel(),cl.getNom(),cl.getPrenom(),nm1.getText(),pnom1.getText(),dst.getText(),"Paris","AZER345RT",prix.getText(),qté.getText(),type.getText(),etat.getText(),cl.getId(),sm.format(aujourdhui));
        	}
        	else if(scene3==scenetest){
            	
            	System.out.println(tel1.getText());
            	lireEnBaseC(tel1.getText()); 	
            	sauverEnBaseC(cl.getTel(),cl.getNom(),cl.getPrenom(),nm1.getText(),pnom1.getText(),dst.getText(),"Paris",Matricule(),prix.getText(),qté.getText(),type.getText(),etat.getText(),cl.getId(),sm.format(aujourdhui));
            	}
        	
        	
        });
        retourner.setOnAction(e->{
        	if(scene2==scenetest){
        		window.setScene(scene2);
        	}
        	else if(scene3==scenetest){
        		window.setScene(scene3);
        	}
        });
		
//________________________________________________________________________________________________
//__________________________________________________________________Scène Number 6 'Historique'
     

        
        
     
   	Image imagea = new Image(getClass().getResourceAsStream("search.png"));
	ImageView imva = new ImageView(imagea);
	imva.setFitHeight(20);
	 imva.setFitWidth(20);
	 imva.setEffect(ds);
	Image imageb = new Image(getClass().getResourceAsStream("search.png"));
    ImageView imvb = new ImageView(imageb);
	imvb.setFitHeight(20);
	imvb.setFitWidth(20);
	imvb.setEffect(ds);
    Image imagec = new Image(getClass().getResourceAsStream("search-user.png"));
	ImageView imvc = new ImageView(imagec);
	imvc.setFitHeight(25);
	imvc.setFitWidth(25);
	imvc.setEffect(ds);
	ToggleButton historique_Client = new ToggleButton();
	historique_Client.setGraphic(imva);
	historique_Client.setPrefSize(20,20);
	ToggleButton historique_Jour = new ToggleButton();
	historique_Jour.setGraphic(imvb);
	historique_Jour.setPrefSize(20,20);
	ToggleButton historique_Mois = new ToggleButton();
	historique_Mois.setGraphic(imvc);
	historique_Mois.setPrefSize(20,20);
	
	Image imageaa = new Image(getClass().getResourceAsStream("home.png"));
	ImageView imvaa = new ImageView(imageaa);
	imvaa.setFitHeight(20);
	 imvaa.setFitWidth(20);
	 imvaa.setEffect(ds);
	Image imagebb = new Image(getClass().getResourceAsStream("back.png"));
    ImageView imvbb = new ImageView(imagebb);
	imvbb.setFitHeight(20);
	imvbb.setFitWidth(20);
	imvbb.setEffect(ds);
	ToggleButton homea = new ToggleButton();
	homea.setGraphic(imvaa);
	homea.setPrefSize(20,20);
	ToggleButton retoura = new ToggleButton();
	retoura.setGraphic(imvbb);
	retoura.setPrefSize(20,20);
	ToggleButton retourb = new ToggleButton();
	retourb.setGraphic(imvbb);
	retourb.setPrefSize(20,20);
	ToggleButton homeb = new ToggleButton();
	homeb.setGraphic(imvaa);
	homeb.setPrefSize(20,20);
	homea.setOnAction(e->window.setScene(scene1));
	homeb.setOnAction(e->window.setScene(scene1));
	retoura.setOnAction(e->{
    	
    	
    		window.setScene(scene6);
   
    });
	retourb.setOnAction(e->{
    	
    	
		window.setScene(scene6);

});
	
   	historique_Client.setOnAction(e->{
   		//ViewTable tb = new ViewTable();
   		tableA = new TableView();
	    tableA.setPrefWidth(500);
        tableA.setPrefHeight(300);
        VBox bb = new VBox(3);
        HBox hh = new HBox(3);
        hh.getChildren().addAll(retoura,homea);
        hh.setAlignment(Pos.CENTER);
   		TableauDeRecherche(tableA,SQL1+histo_client.getText(),dataA);
   		bb.getChildren().addAll(tableA,hh);
   		VBox.setMargin(tableA, new Insets(20,20,20,20));
   		bb.setSpacing(50);
   		
	     scene7 = new Scene(bb,900,600);
		
	     System.out.println(histo_client.getText());
		window.setScene(scene7);
		 //tab1s[i].toString();
	});
   	historique_Jour.setOnAction(e->{
   		//ViewTable tb = new ViewTable();
   		TableView tableB = new TableView();
   		ObservableList<ObservableList> dataB = null;
		
		VBox bb1 = new VBox(3);
		HBox hh1 = new HBox(3);
		hh1.setAlignment(Pos.CENTER);
		hh1.getChildren().addAll(retourb,homeb);
        TableauDeRecherche(tableB,SQL2+"'"+année.getValue()+"-"+mois.getValue()+"-"+jour.getValue()+"'",dataB);
		bb1.getChildren().addAll(tableB,hh1);
   		VBox.setMargin(tableB, new Insets(20,20,20,20));
   		
   		bb1.setSpacing(50); 
		scene7 = new Scene(bb1,600,600);
		//System.out.println(histo_client.getText());
		window.setScene(scene7);
		 //tab1s[i].toString();
	});
   	
   	historique_Mois.setOnAction(e->{
        //Group g = new Group();
        //Plateau p = new Plateau(g);
   		lireEnBase();
		for(int i = 0 ; i<tab1s.length;i++) {
			data.add(tab1s[i]);
		}
     window.setScene(scene4);
        
   	}); 
     
     
     
     
     
     
     
     
		StackPane layoutx = new StackPane();
		
		
		Image imagex = new Image(getClass().getResourceAsStream("back.png"));
		Image imagez = new Image(getClass().getResourceAsStream("unchecked.png"));
	ImageView imvx = new ImageView(imagex);
	 imvx.setFitHeight(20);
	 imvx.setFitWidth(20);
	imvx.setEffect(ds);
	
	 ImageView imvz = new ImageView(imagez);
	 imvz.setFitHeight(10);
	 imvz.setFitWidth(10);
	 imvz.setEffect(ds);
	 ToggleButton nEnvoix = new ToggleButton("Validez");
	 //valid.setPrefSize(100,50);
	 nEnvoix.setGraphic(imvx);
	 nEnvoix.setFont(Font.font ("Avenir", 15));
	 nEnvoix.setTextFill(Color.BLACK);
	 //VBox lay1 = new VBox(10);
  //lay1.setAlignment(Pos.CENTER);
  //lay1.getChildren().setAll(nClient);
	 ToggleButton annulx = new ToggleButton();
	 annulx.setGraphic(imvx);
	 annulx.setFont(Font.font ("Avenir", 11));
	 annulx.setTextFill(Color.BLACK);
	 nEnvoix.setFont(Font.font ("Avenir", 11));
	 nEnvoix.setTextFill(Color.BLACK);
		
	
		Image imagey = new Image(getClass().getResourceAsStream("home.png"));
		ImageView imvy = new ImageView(imagey);
		 imvy.setFitHeight(20);
		 imvy.setFitWidth(20);
		 imvy.setEffect(ds);
		ToggleButton retoury = new ToggleButton();
	      retoury.setPrefSize(20,20);
	     retoury.setGraphic(imvy);
	      VBox layouty = new VBox(10);
	      layouty.setAlignment(Pos.CENTER);
	      layouty.getChildren().setAll(retoury);

	    layouty.getStylesheets().add(getClass().getResource("New.css").toExternalForm());
	     //home.setOnAction(e->window.setScene(scene1));
	   retoury.setOnAction(e->window.setScene(scene1));
		
		
		
		
		VBox box2y = new VBox(10);
		box2.setStyle("-fx-background-color : White;-fx-background-radius: 10px;");
		HBox hbox6y = new HBox(10);
		hbox6y.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox6y.setEffect(ds);
		//hbox.setPrefHeight(50);
		HBox hbox7y = new HBox(10);
		hbox7y.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox7y.setEffect(ds);
		HBox hbox8y = new HBox(10);
		hbox8y.setStyle("-fx-background-color : #2A2E2D;-fx-background-radius: 10px;");
		hbox8y.setEffect(ds);
		HBox hbox10y = new HBox(10);
		hbox10y.setStyle("-fx-background-color :#2A2E2D;-fx-background-radius: 10px;");
		hbox10y.setEffect(ds);
		
		
		jour.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31");
	    jour.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
	          @Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(35);
	              }
	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("1")) {
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("2")) {
	                    setTextFill(Color.BLACK);
	                  } 
	                  else if (item.contains("3")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("4")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("5")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("6")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("7")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("8")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("9")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("10")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("11")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("12")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("13")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("14")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("15")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("16")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("17")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("18")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("19")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("20")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("21")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("22")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("23")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("24")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("25")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("26")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("27")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("28")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("29")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("30")) {
		                    setTextFill(Color.BLACK);
		                  }
	                  else if (item.contains("31")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
	        });
	    
	    
	    
	    jour.setPrefWidth(70);
	    mois.setPrefWidth(80);
	    année.setPrefWidth(90);
	    mois.getItems().addAll("1","2","3","4","5","6","7","8","9","10","11","12");
	    mois.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
	          @Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(40);
	              }
	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  if (item.contains("Janvier")) {
	                    setTextFill(Color.BLACK);
	                  } else if (item.contains("02")) {
	                    setTextFill(Color.BLACK);
	                    setText("Février");
	                  } 
	                  else if (item.contains("Mars")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Avril")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Mais")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Juin")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Juillet")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Août")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Septembre")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Octobre")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Novembre")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("Décembre")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  
	                } else {
	                  setText(null);
	                }
	              }
	              
	            };
	            return cell;
	          }
	        });
	    année.getItems().addAll("2017","2018","2019","2020","2021","2022","2023","2024","2025","2026","2027","2028","2029","2030");
	    année.setCellFactory(new Callback<ListView<String>, ListCell<String>>() {
	          @Override
	          public ListCell<String> call(ListView<String> param) {
	            final ListCell<String> cell = new ListCell<String>() {
	              {
	                super.setPrefWidth(100);
	              }
	              @Override
	              public void updateItem(String item, boolean empty) {
	                super.updateItem(item, empty);
	                if (item != null) {
	                  setText(item);
	                  
	                  if (item.contains("2017")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2018")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2019")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2020")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2021")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2022")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2023")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2024")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2025")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2026")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2027")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2028")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2029")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  else if (item.contains("2030")) {
		                    setTextFill(Color.BLACK);
		                  }
	                  else if (item.contains("2031")) {
		                    setTextFill(Color.BLACK);
		                  } 
	                  
	                } else {
	                  setText(null);
	                }
	              }
	            };
	            return cell;
	          }
	        });
	    
		HBox.setMargin(retoury, new Insets(10,5,10,5));
		HBox.setMargin(histo_client, new Insets(10,5,10,5));
		HBox.setMargin(jour, new Insets(10,5,10,5));
		HBox.setMargin(historique_Mois, new Insets(10,5,10,5));
		
		Label titre2y = new Label("Rechercher");
		titre2y.setFont(Font.font ("Avenir", 30));
		titre2y.setTextFill(Color.BLACK);
		titre2y.setEffect(ds);
		
		Label label6y = new Label("Entrez un Tel");
		label6y.setAlignment(Pos.CENTER_LEFT);
		//label1.setStyle("-fx-border-color:;");
		label6y.setPrefWidth(150);
		label6y.setFont(Font.font ("Avenir", 15));
		label6y.setTextFill(Color.WHITE);
		label6y.setEffect(ds);
		
		Label label7y = new Label("Historique du jour");
		//label2.setStyle("-fx-border-color:Black;");
		label7y.setAlignment(Pos.CENTER_LEFT);
		label7y.setPrefWidth(150);
		label7y.setFont(Font.font ("Avenir", 15));
		label7y.setTextFill(Color.WHITE);
		label7y.setEffect(ds);
		
		Label label8y = new Label("Client");
		label8y.setAlignment(Pos.CENTER_LEFT);
		label8y.setPrefWidth(150);
		//label3.setStyle("-fx-border-color:Black;");
		label8y.setFont(Font.font ("Avenir", 15));
		label8y.setTextFill(Color.WHITE);
		label8y.setEffect(ds);
		
		
		
		histo_client.setPadding(new Insets(10,10,10,10));
		histo_jour.setPadding(new Insets(10,10,10,10));
		histo_mois.setPadding(new Insets(10,10,10,10));
		
		hbox6y.getChildren().addAll(label6y,histo_client,historique_Client);
		hbox7y.getChildren().addAll(label7y,jour,mois,année,historique_Jour);
		hbox8y.getChildren().addAll(label8y,historique_Mois);
		hbox10y.getChildren().addAll(annulx,retoury);
		VBox.setMargin(hbox6y,new Insets(0,20,0,20));
		VBox.setMargin(hbox7y,new Insets(0,20,0,20));
		VBox.setMargin(hbox8y,new Insets(0,20,0,20));
		VBox.setMargin(hbox10y,new Insets(0,20,0,20));
		jour.setPadding(new Insets(5,3,5,3));
		mois.setPadding(new Insets(5,3,5,3));
		année.setPadding(new Insets(5,3,5,3));
		
		/*
		Button  nEnvoi = new Button("Nouvelle Envoi");
		Image imag4 = new Image(getClass().getResourceAsStream("home.png"));
     ImageView imv4 = new ImageView(imag4);
     imv4.setFitHeight(20);
		imv4.setFitWidth(20);
		imv4.setEffect(ds);
     ToggleButton retour1 = new ToggleButton();
	    retour1.setPrefSize(20,20);;
	    retour1.setGraphic(imv4);
	    VBox hom2 = new VBox(10);
	    hom2.setAlignment(Pos.CENTER);
	    hom2.getChildren().setAll(retour1);
		Button  historique = new Button("Historique");
		*/
		nEnvoix.setOnAction(e->{
			
			
			//if(NomValide() && TelValide() && PrenomValide()){
				
				scenetest = window.getScene();
				window.setScene(scene5);
				window.setTitle("Première Envoi de Coli");
			
			
			

//			window.setScene(scene4);
			 //tab1s[i].toString();
		});
	
		annulx.setOnAction(e->{
			window.setScene(scene1);
		
		});
		
		/*
		historique.setOnAction(e->{
				lireEnBase();
				for(int i = 0 ; i<tab1s.length;i++) {
					data.add(tab1s[i]);
				}
				window.setScene(scene4);
				 //tab1s[i].toString();
			});
		*/
		retoury.setOnAction(e->window.setScene(scene1));
		
		box2y.setSpacing(20);
		box2y.setAlignment(Pos.CENTER);
		hbox6y.setSpacing(10);
		hbox6y.setAlignment(Pos.CENTER);
		hbox7y.setSpacing(10);
		hbox7y.setAlignment(Pos.CENTER);
		hbox8y.setSpacing(10);
		hbox8y.setAlignment(Pos.CENTER);
		hbox10y.setSpacing(10);
		hbox10y.setAlignment(Pos.CENTER);
		
		//hbox5.setSpacing(10);
		//hbox5.setAlignment(Pos.CENTER);
		box2y.getChildren().addAll(titre2y,hbox6y,hbox7y,hbox8y,hbox10y);
		layoutx.getChildren().add(box2y);
		
		scene6 = new Scene(layoutx,600,500);
     
     
     
     
     
     
     
     
     
     
     
//________________________________________________________________________________________________
//__________________________________________________________Scène Number 7 'Historique Du Client'        
		
    
     
     	window.setScene(scene0);
		window.setTitle("Login");
		window.show();
	
	}
	//public Scene4(){
		
//	}
    public static void lireEnBase() {

        // Information d'accès à la base de données                                                                                                                          
        String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;
        int i = 1;
        setTab1s(new Client[50]);
        try {

                // Etape 1 : Chargement du driver                                                                                                                            
                Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                cn = DriverManager.getConnection(url, login, passwd);

                // Etape 3 : Création d'un statement                                                                                                                         
                st = cn.createStatement();

                String sql = "SELECT * FROM Client ";

                // Etape 4 : exécution requête                                                                                                                               
                rs = st.executeQuery(sql);

                // Si récup données alors étapes 5 (parcours Resultset)                                                                                                      

                while (rs.next()) {
                	tab1s[i] = new Client(rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("mail"));	
                	//	tab1s.length = rs.getString("mail");
                	System.out.println(tab1s[i].toString());
                    i++;    

                }
                
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } finally {
                try {
                // Etape 6 : libérer ressources de la mémoire.                                                                                                               
                        cn.close();
                        st.close();
                        rs.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
    public static void lireEnBaseC(String tele1) {

        // Information d'accès à la base de données                                                                                                                          
        String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;
       
        
        try {

                // Etape 1 : Chargement du driver                                                                                                                            
                Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                cn = DriverManager.getConnection(url, login, passwd);

                // Etape 3 : Création d'un statement                                                                                                                         
                st = cn.createStatement();

                String sql = "SELECT * FROM Client WHERE tel ="+tele1;

                // Etape 4 : exécution requête                                                                                                                               
                rs = st.executeQuery(sql);

                // Si récup données alors étapes 5 (parcours Resultset) 
                while(rs.next()){
//                System.out.println(cl.toString());
               
                	cl = new Client(rs.getString("id"),rs.getString("nom"),rs.getString("prenom"),rs.getString("tel"),rs.getString("mail"));	
                	//	tab1s.length = rs.getString("mail");
           	System.out.println(cl.getId());
                     
                }
                
                
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } finally {
                try {
                // Etape 6 : libérer ressources de la mémoire.                                                                                                               
                        cn.close();
                        st.close();
                        rs.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
    public static void lireEnBaseColiClient(String tele2) {

        // Information d'accès à la base de données                                                                                                                          
        String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
        Connection cn =null;
        Statement st =null;
        ResultSet rs =null;
        setTab2s(new Diver[50]);
        int i =1;
        try {

                // Etape 1 : Chargement du driver                                                                                                                            
                Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                cn = DriverManager.getConnection(url, login, passwd);

                // Etape 3 : Création d'un statement                                                                                                                         
                

                String sql = "SELECT Coli.nompe,Coli.prenompe,Coli.nompr,Coli.prenompr,Coli.dest,Coli.src,Coli.numcolis,Coli.prix,Client.tel FROM Coli INNER JOIN Client ON Coli.id_propriétaire=Client.id AND Coli.tel = Client.tel WHERE Client.tel = "+tele2+";";
                
                st = cn.createStatement();
                // Etape 4 : exécution requête                                                                                                                               
                rs = st.executeQuery(sql);

                // Si récup données alors étapes 5 (parcours Resultset) 
                while(rs.next()){
//                System.out.println(cl.toString());
               
                	tab2s[i] = new Diver(rs.getString("nompe"),rs.getString("prenompe"),rs.getString("nompr"),rs.getString("prenompr"),rs.getString("dest"),rs.getString("src"),rs.getString("numcolis"),rs.getString("prix"));	
                	//	tab1s.length = rs.getString("mail");
                	System.out.println(tab2s[i].toString());
                    i++;    
                     
                }
                
                
        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } finally {
                try {
                // Etape 6 : libérer ressources de la mémoire.                                                                                                               
                        cn.close();
                        st.close();
                        rs.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
    public static void sauverEnBase(String nom,String sexe,String prenom,String tel,String mail) {

        // Information d'accès à la base de données                                                                                                                          
        String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
        Connection cn =null;
        Statement st =null;

        try {

                // Etape 1 : Chargement du driver                                                                                                                            
                Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                cn = DriverManager.getConnection(url, login, passwd);

                // Etape 3 : Création d'un statement                                                                                                                         
                st = cn.createStatement();

                String sql = "INSERT INTO `Client` VALUES (NULL,'"+nom+"','"+sexe+"','"+prenom+"','"+tel+"','"+mail+"')";

                // Etape 4 : exécution requête                                                                                                                               
                st.executeUpdate(sql);

                // Si récup données alors étapes 5 (parcours Resultset)                                                                                                      

        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {
                                                                                                                                                  
                e.printStackTrace();
        } finally {
                try {
                // Etape 6 : libérer ressources de la mémoire.                                                                                                               
                        cn.close();
                        st.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}
    public static void sauverEnBaseC(String tel,String nom,String prenom,String nom1,String prenom1,String dest,String src ,String numcoli,String prix ,String quantité,String type,String etat,String id,String date ) {

        // Information d'accès à la base de données                                                                                                                          
        String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
        Connection cn =null;
        Statement st =null;

        try {

                // Etape 1 : Chargement du driver                                                                                                                            
                Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                cn = DriverManager.getConnection(url, login, passwd);

                // Etape 3 : Création d'un statement                                                                                                                         
                st = cn.createStatement();

                String sql = "INSERT INTO `Coli` VALUES (NULL,'"+tel+"','"+nom+"','"+prenom+"','"+nom1+"','"+prenom1+"','"+dest+"','"+src+"','"+numcoli+"','"+prix+"','"+quantité+"','"+type+"','"+etat+"','"+id+"','"+sm.format(aujourdhui)+"')";

                // Etape 4 : exécution requête                                                                                                                               
                st.executeUpdate(sql);

                // Si récup données alors étapes 5 (parcours Resultset)                                                                                                      

        } catch (SQLException e) {
                e.printStackTrace();
        } catch (ClassNotFoundException e) {                                                                                                                               
                e.printStackTrace();
        } finally {
                try {
                // Etape 6 : libérer ressources de la mémoire.                                                                                                               
                        cn.close();
                        st.close();
                } catch (SQLException e) {
                        e.printStackTrace();
                }
        }
}

	public static Client[] getTab1s() {
		return tab1s;
	}

	public static void setTab1s(Client[] tab1s) {
		Main.tab1s = tab1s;
	}
	private boolean EmailValide(TextField mailv){
	Pattern p = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+");
	Matcher m = p.matcher(mailv.getText());
		if(m.find() && m.group().equals(mailv.getText())){
			return true;
		}else{
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Validate Mail");
			alert.setHeaderText(null);
			alert.setContentText("Please Enter Valid Email");
			alert.showAndWait();
			return false;
		}
	}
	private boolean TelValide(TextField telv){
		Pattern p = Pattern.compile("[0-9]+");
		Matcher m = p.matcher(telv.getText());
			if(m.find() && m.group().equals(telv.getText())){
				return true;
			}else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Validation de Téléphone");
				alert.setHeaderText(null);
				alert.setContentText("Entrez un Numéro de Téléphone Valide");
				alert.showAndWait();
				return false;
			}
		}
	private boolean NomValide(TextField nomv){
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(nomv.getText());
			if(m.find() && m.group().equals(nomv.getText())){
				return true;
			}else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Validate Name");
				alert.setHeaderText(null);
				alert.setContentText("Entrez Un Nom Valide !");
				alert.showAndWait();
				return false;
			}
		}
	private boolean PrenomValide(TextField prenomv){
		Pattern p = Pattern.compile("[a-zA-Z]+");
		Matcher m = p.matcher(prenomv.getText());
			if(m.find() && m.group().equals(prenomv.getText())){
				return true;
			}else{
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Validate prenom");
				alert.setHeaderText(null);
				alert.setContentText("Entrez Un Prénom Valide !");
				alert.showAndWait();
				return false;
			}
		}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void TableauDeRecherche(TableView table2e,String SQL,ObservableList<ObservableList> data2e){
	String url = "jdbc:mysql://localhost:3306/Users";
        String login = "root";
        String passwd = "doliprane";
          Connection c ;
          data2e = FXCollections.observableArrayList();
          try{
           Class.forName("com.mysql.jdbc.Driver");

                // Etape 2 : récupération de la connexion                                                                                                                    
                c = DriverManager.getConnection(url, login, passwd);
            //SQL FOR SELECTING ALL OF CUSTOMER
            
            //ResultSet
            ResultSet rs = c.createStatement().executeQuery(SQL);

            /**********************************
             * TABLE COLUMN ADDED DYNAMICALLY *
             **********************************/
            for(int i=0 ; i<rs.getMetaData().getColumnCount(); i++){
                //We are using non property style for making dynamic table
                final int j = i;                
                TableColumn col = new TableColumn(rs.getMetaData().getColumnName(i+1));
                col.setCellValueFactory(new Callback<CellDataFeatures<ObservableList,String>,ObservableValue<String>>(){                    
                    public ObservableValue<String> call(CellDataFeatures<ObservableList, String> param) {                                                                                              
                        return new SimpleStringProperty(param.getValue().get(j).toString());                        
                    }                    
                });

                table2e.getColumns().addAll(col); 
                System.out.println("Column ["+i+"] ");
            }

            /********************************
             * Data added to ObservableList *
             ********************************/
            while(rs.next()){
                //Iterate Row
                ObservableList<String> row = FXCollections.observableArrayList();
                for(int i=1 ; i<=rs.getMetaData().getColumnCount(); i++){
                    //Iterate Column
                    row.add(rs.getString(i));
                }
                System.out.println("Row [1] added "+row );
                data2e.add(row);

            }

            //FINALLY ADDED TO TableView
            table2e.setItems(data2e);
          }catch(Exception e){
              e.printStackTrace();
              System.out.println("Error on Building Data");             
          }
      }

	public static Diver[] getTab2s() {
		return tab2s;
	}

	public static void setTab2s(Diver[] tab2s) {
		Main.tab2s = tab2s;
	}
}
