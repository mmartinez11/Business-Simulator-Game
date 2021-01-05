import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

//Added For API Purposes
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
//----------------------

public class Screens {
	
		//Map Variables
		static String storeChosen;
		static List<String> storeList;
		//-------------

	/* Location Variables */ 
	static String country;
	static String state;
	static String city; 
	static String location;
	
	static Button locationNext;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

	/* Location Selection Screen */ 
	public static Scene SelectLocation(Stage primaryStage) {	
		
		/* List of Countries */ 
		List<String> countries = new ArrayList<String>();
		String token = ""; 
		try {
			Scanner inFile = new Scanner(new File("countries.txt")).useDelimiter("\r\n");
			while (inFile.hasNext()) {
				token = inFile.next(); 
				countries.add(token); 
			}
			inFile.close(); 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* List of States */ 
		List<String> us_states = new ArrayList<String>();
		String string = ""; 
		try {
			Scanner in = new Scanner(new File("us_states.txt")).useDelimiter("\r\n");
			while (in.hasNext()) {
				string = in.next(); 
				us_states.add(string); 
			}
			in.close(); 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		/* List of Cities */ 
		List<String> california_cities = new ArrayList<String>();
		String tokens = ""; 
		try {
			Scanner fin = new Scanner(new File("california_cities.txt")).useDelimiter("\r\n");
			while (fin.hasNext()) {
				tokens = fin.next(); 
				california_cities.add(tokens); 
			}
			fin.close(); 
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		

		/* Countries Dropdown Menu */ 
		ComboBox<String> countriesDropDown = new ComboBox<String>();
		for(int i = 0; i < countries.size(); i++) {
			countriesDropDown.getItems().add(countries.get(i));
		}
		countriesDropDown.setStyle("-fx-pref-width: 200;"); 
		/* States Dropdown Menu */ 
		ComboBox<String> statesDropDown = new ComboBox<String>();
		for(int i = 0; i < us_states.size(); i++) {
			statesDropDown.getItems().add(us_states.get(i));
		}
		statesDropDown.setStyle("-fx-pref-width: 200;"); 
		/* Cities Dropdown Menu */ 
		ComboBox<String> citiesDropDown = new ComboBox<String>();
		for(int i = 0; i < california_cities.size(); i++) {
			citiesDropDown.getItems().add(california_cities.get(i));
		}
		citiesDropDown.setStyle("-fx-pref-width: 200;"); 
		
		//Location Drop Down
		List<String> locationList = new ArrayList<String>();
		
		locationList.add("Seoul/South Korea");
		locationList.add("Beijing/China");
		locationList.add("Taipei/Taiwan");
		
		locationList.add("Mexico City/Mexico");
		locationList.add("Vancouver/Canada");
		locationList.add("Palo Alto/USA");
		
		locationList.add("Paris/France");
		locationList.add("Berlin/Germany");
		locationList.add("Madrid/Spain");

		// Drop Down Menu
		ComboBox<String> locationDropDown = new ComboBox<String>();
		locationDropDown.getItems().add(locationList.get(0));
		locationDropDown.getItems().add(locationList.get(1));
		locationDropDown.getItems().add(locationList.get(2));
		
		locationDropDown.getItems().add(locationList.get(3));
		locationDropDown.getItems().add(locationList.get(4));
		locationDropDown.getItems().add(locationList.get(5));
		
		locationDropDown.getItems().add(locationList.get(6));
		locationDropDown.getItems().add(locationList.get(7));
		locationDropDown.getItems().add(locationList.get(8));
		
		//-------------------------
		
		/* Labels for Input Fields*/ 
		Label countryLabel = new Label("Select Country");
		Label stateLabel = new Label("Select State or Region");
		Label cityLabel = new Label("Select City");
		
		//Location Label
		Label locationLabel = new Label("Select Location");
		
		/* Text Field */ 
		TextField addressTextField = new TextField("Enter City or Address");
		addressTextField.setMaxWidth(200.0);

		
		/* Location Screen UI */ 				
		/* Images */ 
		Image bigLogo = new Image("logo.png", 100, 100, true, true); 
		Image smallLogo = new Image("logo.png", 60, 60, true, true); 
		Image end = new Image("end.png", 25, 25, true, true); 
		Image plus = new Image("plus.png", 25, 25, true, true);
		Image exit = new Image("exit.png", 25, 25, true, true);
		Image play = new Image("play.png", 25, 25, true, true);
		Image help = new Image("help.png", 25, 25, true, true);
		Image banner = new Image("Banner.png", 500, 300, true, true);
		Image location_banner = new Image("LocationBanner.png", 500, 100, true, true);
		primaryStage.setTitle("Business Startup Simulator");
		
		/* Text */ 
		Text WelcomeText = new Text("Welcome to Business Startup Simulator");
		WelcomeText.setStyle(
				"-fx-font-size: 18;" + 
				"-fx-border-size: 20;" + 
				"-fx-border-color: red;"
		);
		
		Text HowToPlayText = new Text("Instructions");
		HowToPlayText.setStyle(
				"-fx-font-size: 18;" + 
				"-fx-border-size: 20;" + 
				"-fx-border-color: red;"
		);
		
		/* Buttons */ 
		Button HelpButton = new Button("Help");
		HelpButton.setGraphic(new ImageView(help));
		HelpButton.setStyle(
				"-fx-background-radius: 100em;" +
				"-fx-font-size: 18;" + 
                "-fx-max-width: 300px; " 
		);
		
		Button NextButton = new Button("Start Game");
		NextButton.setGraphic(new ImageView(play));
		NextButton.setStyle(
				"-fx-background-radius: 100em;" +
				"-fx-font-size: 18;" + 
                "-fx-max-width: 300px; "
		);
		
		Button End = new Button("");
		End.setGraphic(new ImageView(end));
		End.setStyle(
				"-fx-background-radius: 100em;" +
				"-fx-min-width: 35px; " +
                "-fx-min-height: 35px; " +
                "-fx-max-width: 35px; " +
                "-fx-max-height: 35px;"
        );
		
		Button Plus = new Button("");
		Plus.setGraphic(new ImageView(plus));
		Plus.setStyle(
				"-fx-background-radius: 100em;" +
				"-fx-min-width: 35px; " +
                "-fx-min-height: 35px; " +
                "-fx-max-width: 35px; " +
                "-fx-max-height: 35px;"
        );
		
		Button Exit = new Button("");
		Exit.setGraphic(new ImageView(exit));
		Exit.setStyle(
				"-fx-background-radius: 100em;" +
				"-fx-min-width: 35px; " +
                "-fx-min-height: 35px; " +
                "-fx-max-width: 35px; " +
                "-fx-max-height: 35px;"
        );
		
		Button Help = new Button("");
		Help.setGraphic(new ImageView(help));
		Help.setStyle(
				"-fx-background-radius: 100em;" +
				"-fx-min-width: 40px; " +
                "-fx-min-height: 40px; " +
                "-fx-max-width: 40px; " +
                "-fx-max-height: 40px;" 
        );
		
		/* Next Button */ 
		locationNext = new Button("Next");
		// On Press Next Button
		locationNext.setOnAction(e -> {
			country = countriesDropDown.getValue();
			System.out.println(country);

			state = statesDropDown.getValue(); 
			System.out.println(state);
			
			location = locationDropDown.getValue();
			System.out.println(location);

			//primaryStage.setScene(previewSelections(primaryStage));
			
		});
				
		/* Create Layout for Location Selection Screen */ 
		VBox Location= new VBox(5, countryLabel, countriesDropDown, stateLabel, statesDropDown, cityLabel, citiesDropDown, locationLabel, locationDropDown,locationNext);
		Location.setAlignment(Pos.CENTER);
		Location.setStyle("-fx-background-color: #F4EBD9");

		/* Header */
		HBox Header = new HBox(); 
		Header.setPadding(new Insets(5, 12, 5, 12));
		Header.setSpacing(10);
		Header.setStyle("-fx-background-color: #058ED9");
		Header.setAlignment(Pos.CENTER_RIGHT);
		Header.getChildren().addAll(Help, End, Plus, Exit, new ImageView(smallLogo));
	
		/* Banner Image for Location Selection */ 
		VBox Banner = new VBox(10, new ImageView(location_banner), Location); 
		Banner.setStyle("-fx-background-color: #F4EBD9");
		
		BorderPane LocationPane = new BorderPane();
		LocationPane.setTop(Header);
		LocationPane.setCenter(Banner);

		// Return Scene
		return new Scene(LocationPane, 500, 500);
	}
	
}
