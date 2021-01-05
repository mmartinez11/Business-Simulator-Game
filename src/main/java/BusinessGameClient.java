import java.util.ArrayList;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.nimbus.State;

import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Worker;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Duration;
import netscape.javascript.JSObject;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

//Added For API Purposes
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
//----------------------

public class BusinessGameClient extends Application {
	
	//-------------------------------------
		dateSimulator sim = new dateSimulator();
		int storeCount = 0;
		int revenue = 0;
	//-------------------------------------
	

	// Map Variables
	String storeChosen;
	List<String> storeList;
	// -------------
	/* Location Variables */
	String country;
	String state;
	String city;
	String location;
	String industry;
	Button locationNext;
	Button locationHelp;
	int store1Cost = 25000;
	int store2Cost = 50000;
	int store3Cost = 75000;
	int inventoryTotal = 0; 
	
	int wages1 = 0;
	int utilities1 = 0;
	int propertyTaxes1=0;
	int value1 = 0;
	int inventory1 = 0; 
	
	int wages2 = 0;
	int utilities2 = 0;
	int propertyTaxes2=0;
	int value2 = 0;
	int inventory2 = 0; 
	
	int wages3 = 0;
	int utilities3 = 0;
	int propertyTaxes3=0;
	int value3 = 0;
	int inventory3 = 0; 
	
	boolean store1 = false;
	boolean store2 = false;
	boolean store3 = false;
	gameMap mapSettings = new gameMap();

	HashMap<String, Scene> sceneMap = new HashMap<String, Scene>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		/* Images */
		Image bigLogo = new Image("logo.png", 100, 100, true, true);
		Image smallLogo = new Image("logo.png", 60, 60, true, true);
		Image end = new Image("end.png", 25, 25, true, true);
		Image plus = new Image("plus.png", 25, 25, true, true);
		Image exit = new Image("exit.png", 25, 25, true, true);
		Image play = new Image("play.png", 25, 25, true, true);
		Image help = new Image("help.png", 25, 25, true, true);
		Image banner = new Image("Banner.png", 500, 400, true, true);
		primaryStage.setTitle("Business Startup Simulator");

		/* Text */
		Text WelcomeText = new Text("Welcome to Business Startup Simulator");
		WelcomeText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

		Text HowToPlayText = new Text("Instructions");
		HowToPlayText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

		/* Buttons */
		Button HelpButton = new Button("Help");
		HelpButton.setGraphic(new ImageView(help));
		HelpButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

		Button NextButton = new Button("Start Game");
		NextButton.setGraphic(new ImageView(play));
		NextButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

		Button End = new Button("");
		End.setGraphic(new ImageView(end));
		End.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

		Button Plus = new Button("");
		Plus.setGraphic(new ImageView(plus));
		Plus.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

		Button Exit = new Button("");
		Exit.setGraphic(new ImageView(exit));
		Exit.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
		Exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		Button Help = new Button("");
		Help.setGraphic(new ImageView(help));
		Help.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
				+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");

//		/* Pause Transition */ 
//		PauseTransition pause = new PauseTransition(Duration.seconds(3));
//		pause.setOnFinished(e -> primaryStage.setScene(sceneMap.get("scene")));
//		
//		primaryStage.setScene(sceneMap.get("scene"));
//		primaryStage.show();

		/* Header */
		HBox Header = new HBox();
		Header.setPadding(new Insets(5, 12, 5, 12));
		Header.setSpacing(10);
		Header.setStyle("-fx-background-color: #058ED9");
		Header.setAlignment(Pos.CENTER_RIGHT);
		Header.getChildren().addAll(Help, End, Plus, Exit, new ImageView(smallLogo));

		/* Start Game, Help Buttons */
		VBox Selection = new VBox();
		Selection.setPadding(new Insets(5, 12, 5, 12));
		Selection.setSpacing(10);
		Selection.setAlignment(Pos.CENTER);
		Selection.setStyle("-fx-background-color: #F4EBD9");
		Selection.getChildren().addAll(NextButton, HelpButton);

		/* Banner Image for Game */
		VBox Banner = new VBox(new ImageView(banner));
		Banner.setStyle("-fx-background-color: #F4EBD9");

		/* Set Start Pane */
		BorderPane StartPane = new BorderPane();
		StartPane.setTop(Header);
		StartPane.setBottom(Selection);
		StartPane.setCenter(Banner);

		Scene StartScene = new Scene(StartPane, 500, 400);

		primaryStage.setScene(StartScene);
		primaryStage.show();

		/* Help Button Pop Up */
		HelpButton.setOnAction(e -> {
			Stage popUpWindow = new Stage();
			popUpWindow.initModality(Modality.APPLICATION_MODAL);
			popUpWindow.setTitle("Full Game Instructions");
			Label fullGameInstructions = new Label(
					"Business simulator game will help you achieve the dream of becoming the greatest real estate investor there is.\n"
							+ "Before starting the game, you will be given a choice form a set of a locations of where you want to start the game and what industry you want to develop in. \n"
							+ "\n"
							+ "The locations are hand picked areas that were selected for maximum game experience. These area were picked because they have lots of value to learn from and invest into. \n"
							+ "Different areas have people from differing backgrounds, interests, education that all relate back to how well the return on investments will be.\n"
							+ "\n" + "Different industries include Technology, Business, and Fast Food.\n" + "\n"
							+ "The game will start out with an amount of money that is set for the location, and you will be given a background on the city like education, interests, demographics and "
							+ "you will have the ability to buy and sell properties. As you buy properties, missions will appear. Based on how well you respond to the tasks you gain or lose money and/or property.");
			fullGameInstructions.setWrapText(true);
			fullGameInstructions.setPadding(new Insets(15, 15, 15, 15));
			fullGameInstructions.setStyle("-fx-font-size: 16;");
			Button closePopUpWindow = new Button("Close Window");
			closePopUpWindow.setGraphic(new ImageView(exit));
			closePopUpWindow.setOnAction(f -> popUpWindow.close());

			VBox popUpWindowLayout = new VBox(20, fullGameInstructions, closePopUpWindow);
			popUpWindowLayout.setAlignment(Pos.CENTER);

			Scene fullGameInstructionsScene = new Scene(popUpWindowLayout, 800, 550);
			popUpWindow.setScene(fullGameInstructionsScene);
			popUpWindow.showAndWait();

		});

		/* Next Button Action */
		NextButton.setOnAction(e -> {

			/*
			 * // I think this will only run on windows!?? try {
			 * Desktop.getDesktop().browse(new URI("https://www.google.com/maps/"));
			 * System.out.println("Google maps should open in a browser"); } catch
			 * (IOException | URISyntaxException e1) { e1.printStackTrace();
			 * System.out.println("Fails in catch statement"); }
			 */

			// This would make the next button go into the map scene
			// primaryStage.setScene(previewSelections(primaryStage));

			// Will Go to the scene were the user will choose their location
			primaryStage.setScene(SelectLocation(primaryStage));
			primaryStage.show();

		});

	}

	/* Location Selection Screen */
	public Scene SelectLocation(Stage primaryStage) {

		// Location Drop Down
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

		// Location Label
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
		WelcomeText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

		Text HowToPlayText = new Text("Instructions");
		HowToPlayText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

		/* Buttons */
		Button HelpButton = new Button("Help");
		HelpButton.setGraphic(new ImageView(help));
		HelpButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

		Button NextButton = new Button("Start Game");
		NextButton.setGraphic(new ImageView(play));
		NextButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

		Button End = new Button("");
		End.setGraphic(new ImageView(end));
		End.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

		Button Plus = new Button("");
		Plus.setGraphic(new ImageView(plus));
		Plus.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

		Button Exit = new Button("");
		Exit.setGraphic(new ImageView(exit));
		Exit.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
		Exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		Button Help = new Button("");
		Help.setGraphic(new ImageView(help));
		Help.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
				+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");

		/* Next Button */
		locationNext = new Button("Confirm");
		locationNext.setGraphic(new ImageView(play));
		
		locationHelp = new Button("Info");
		locationHelp.setGraphic(new ImageView(help));
		
		// On Press Next Button
		locationNext.setOnAction(e -> {

			country = locationDropDown.getValue();
			
			if(country != null)
			{
				System.out.println(country);
				primaryStage.setScene(previewSelections(primaryStage));
			}

		});
		
		
		locationHelp.setOnAction(e -> {

			Stage popUpWindow = new Stage();
			popUpWindow.initModality(Modality.APPLICATION_MODAL);
			popUpWindow.setTitle("Full Game Instructions");
			
			Label fullGameInstructions = new Label(
					"Business simulator game will help you achieve the dream of becoming the greatest real estate investor there is.\n"
							+ "Before starting the game, you will be given a choice form a set of a locations of where you want to start the game and what industry you want to develop in. \n"
							+ "\n"
							+ "The locations are hand picked areas that were selected for maximum game experience. These area were picked because they have lots of value to learn from and invest into. \n"
							+ "Different areas have people from differing backgrounds, interests, education that all relate back to how well the return on investments will be.\n"
							+ "\n" + "Different industries include Technology, Business, and Fast Food.\n" + "\n"
							+ "The game will start out with an amount of money that is set for the location, and you will be given a background on the city like education, interests, demographics and "
							+ "you will have the ability to buy and sell properties. As you buy properties, missions will appear. Based on how well you respond to the tasks you gain or lose money and/or property.");
			fullGameInstructions.setWrapText(true);
			fullGameInstructions.setPadding(new Insets(15, 15, 15, 15));
			fullGameInstructions.setStyle("-fx-font-size: 16;");
			
			Button closePopUpWindow = new Button("Close Window");
			closePopUpWindow.setGraphic(new ImageView(exit));
			closePopUpWindow.setOnAction(f -> popUpWindow.close());

			VBox popUpWindowLayout = new VBox(20, fullGameInstructions, closePopUpWindow);
			popUpWindowLayout.setAlignment(Pos.CENTER);

			Scene fullGameInstructionsScene = new Scene(popUpWindowLayout, 800, 550);
			popUpWindow.setScene(fullGameInstructionsScene);
			popUpWindow.showAndWait();

		});

		HBox locationButtons = new HBox(5, locationNext, locationHelp);
		locationButtons.setAlignment(Pos.CENTER);
		
		/* Create Layout for Location Selection Screen */
		VBox Location = new VBox(5, locationLabel, locationDropDown, locationButtons);
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

	// This is the scene that displays the map
	public Scene previewSelections(Stage primaryStage) {
		
		
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
		// --------------------------------------------------------
		// List<String> storeList;

		ComboBox<String> storeDropdown = new ComboBox<String>();
		storeDropdown.setDisable(true);
		storeDropdown.setStyle("-fx-pref-width: 300;" + "-fx-font-size: 18;");
		// --------------------------------------------------------
		BorderPane testA = new BorderPane();

		testA.setStyle("-fx-background-color: #F4EBD9");

		WebView webView = new WebView();

		WebEngine webEngine = webView.getEngine();
		webEngine.load(getClass().getResource("/googlemap.html").toString());

		// Testing Button to switch to a new map//
		Button loadButton = new Button("Load Map");
		loadButton.setGraphic(new ImageView(play));
		loadButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
		Button addBuisiness = new Button("Buy Property"); //<-------------------------------------------------------------------------------
		addBuisiness.setDisable(true);
		addBuisiness.setGraphic(new ImageView(play));
		addBuisiness.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
		
		
		//---------------------------------
			Button simButton = new Button("Simulate");
			simButton.setDisable(true);
			simButton.setGraphic(new ImageView(play));
			simButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
			
			TextField simDate = new TextField();
			simDate.setDisable(true);
			simDate.setStyle("-fx-text-fill: #000000; -fx-font-size: 16px; -fx-font-weight: bold;");
			
			TextField totalRevenue = new TextField("Revenue: $" + revenue);
			totalRevenue.setDisable(true);
			totalRevenue.setStyle("-fx-text-fill: #000000; -fx-font-size: 16px; -fx-font-weight: bold;");
		//---------------------------------
		
		Button manageBusiness = new Button("ManageBusiness");
		manageBusiness.setGraphic(new ImageView(play));
		manageBusiness.setStyle("-fx-background-radius: 100em;");
		manageBusiness.setDisable(true);
		Button saveBusiness = new Button("Save");
		Text initialBudget = new Text("Available Cash: ");
		Text budget = new Text("0.00");
		Text employee = new Text("Employee Amount");
		Text employeeCount = new Text("0");
		Text lastStorePurchased = new Text("");
		Text storeCost = new Text("");

		Text infoScreen = new Text("");
		
		saveBusiness.setGraphic(new ImageView(play));
		saveBusiness.setStyle("-fx-background-radius: 100em;");
		Button info = new Button("Retrieve Info");
		info.setGraphic(new ImageView(play));
		info.setStyle("-fx-background-radius: 100em;");
		Button choose = new Button("Choose Business");
		choose.setGraphic(new ImageView(play));
		choose.setStyle("-fx-background-radius: 100em;");
		// Load the Map for the User
		loadButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				mapSettings.getCountry(country, webEngine);

				loadButton.setDisable(true);
				addBuisiness.setDisable(false);

				storeList = getListofStores();
				storeDropdown.getItems().addAll(storeList.get(0), storeList.get(1), storeList.get(2));
				budget.setText("300000");

				storeDropdown.setDisable(false);
				
				simDate.setText("Date: " + sim.getDate());
			}

		}

		);

		addBuisiness.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				storeChosen = storeDropdown.getValue();
				System.out.println(storeChosen);

				if (storeChosen == null) {
					infoScreen.setText("Pick a store from the list");
				}	 
			
				
				else if (storeChosen.contains("1")) {
					if (store1 == true) {
						lastStorePurchased.setText(storeChosen);
						infoScreen.setText("you have already bought store 1, buy something else");
						return;
					}
					
					infoScreen.setText("You just bought store 1");
					storeCost.setText(Integer.toString(store1Cost));
					int updatedBudget = Integer.parseInt(budget.getText()) - store1Cost;
					budget.setText(Integer.toString(updatedBudget));
					int employ = Integer.parseInt(employeeCount.getText()) + 2;
					employeeCount.setText(Integer.toString(employ));
					manageBusiness.setDisable(false);
					store1 = true;
					
					lastStorePurchased.setText(storeChosen);

					mapSettings.putBusiness(storeChosen, webEngine);
					storeCount++;
					simButton.setDisable(false);

				} else if (storeChosen.contains("2")) {
					if (store2 == true) {
						lastStorePurchased.setText(storeChosen);
						infoScreen.setText("you have already bought store 2, buy something else");
						return;
					}
					infoScreen.setText("You just bought store 2");
					storeCost.setText(Integer.toString(store2Cost));
					int updatedBudget = Integer.parseInt(budget.getText()) - store2Cost;
					budget.setText(Integer.toString(updatedBudget));
					int employ = Integer.parseInt(employeeCount.getText()) + 2;
					employeeCount.setText(Integer.toString(employ));
					manageBusiness.setDisable(false);
					store2 = true;
					
					lastStorePurchased.setText(storeChosen);

					mapSettings.putBusiness(storeChosen, webEngine);
					storeCount++;
					simButton.setDisable(false);

				} else if (storeChosen.contains("3")) {
					if (store3 == true) {
						lastStorePurchased.setText(storeChosen);
						infoScreen.setText("you have already bought store 3, buy something else");
						return;
					}
					infoScreen.setText("You just bought store 3");
					storeCost.setText(Integer.toString(store3Cost));
					int updatedBudget = Integer.parseInt(budget.getText()) - store3Cost;
					budget.setText(Integer.toString(updatedBudget));
					int employ = Integer.parseInt(employeeCount.getText()) + 2;
					employeeCount.setText(Integer.toString(employ));
					manageBusiness.setDisable(false);
					store3 = true;
					
					lastStorePurchased.setText(storeChosen);

					mapSettings.putBusiness(storeChosen, webEngine);
					storeCount++;
					simButton.setDisable(false);
				}
							
			}

		}

		);
		
		//--------------------------------------------------------------------------
		simButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				if(storeCount == 0){
					
					simButton.setDisable(true);
				}
				else
				{
					
					sim.nextDay();
					simDate.setText("Date: " + sim.getDate());
				
					System.out.println("The Counter is: " + storeCount);
				
					int dailyRevenue = (1350 * storeCount);
					revenue = revenue + (1350 * storeCount);
				
				
					int totalR = Integer.parseInt(budget.getText()) + dailyRevenue;
					budget.setText(Integer.toString(totalR));
				
					totalRevenue.setText("Revenue: $" + revenue);
				
				}
			}
		
		});
		//--------------------------------------------------------------------------
		
		

		manageBusiness.setOnAction(d -> {

			Button End = new Button("");
			End.setGraphic(new ImageView(end));
			End.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
					+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

			Button Plus = new Button("");
			Plus.setGraphic(new ImageView(plus));
			Plus.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
					+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

			Button Exit = new Button("");
			Exit.setGraphic(new ImageView(exit));
			Exit.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
					+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
			Exit.setOnAction(new EventHandler<ActionEvent>() {
				public void handle(ActionEvent event) {
					Platform.exit();
				}
			});
			Button Help = new Button("");
			Help.setGraphic(new ImageView(help));
			Help.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
					+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");
			/* Header */
			HBox HeaderBox = new HBox();
			HeaderBox.setPadding(new Insets(5, 12, 5, 12));
			HeaderBox.setSpacing(10);
			HeaderBox.setStyle("-fx-background-color: #058ED9");
			HeaderBox.setAlignment(Pos.CENTER_RIGHT);
			HeaderBox.getChildren().addAll(Help, End, Plus, Exit, new ImageView(smallLogo));
			

			Image employees = new Image("employee.png", 25, 25, true, true);
			Image pay = new Image("pay.png", 25, 25, true, true);
			Image sellImg = new Image("sell.png", 25, 25, true, true);
			Image inventoryImg = new Image("inventory.png", 25, 25, true, true);
			
			Stage popUpWindow = new Stage();
			popUpWindow.initModality(Modality.APPLICATION_MODAL);
			popUpWindow.setTitle("Manage Business");
			Button employeeManagement = new Button("Employee Management");
			employeeManagement.setGraphic(new ImageView(employees));
			employeeManagement.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
			
			Button payBills = new Button("Pay Bills");
			payBills.setGraphic(new ImageView(pay));
			payBills.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
			
			Button inventory = new Button("Inventory");
			inventory.setGraphic(new ImageView(inventoryImg));
			inventory.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
			
			Button sell = new Button("Sell");
			sell.setGraphic(new ImageView(sellImg));
			sell.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
			
			Button closePopUpWindow = new Button("Close Window");
			closePopUpWindow.setGraphic(new ImageView(exit));
			closePopUpWindow.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
			closePopUpWindow.setOnAction(f -> popUpWindow.close());
			
			

			// NEED TO ADD FUNCTIONALITY TO THESE BUTTONS

			employeeManagement.setOnAction(f -> {
/* Text */
				
				Text WelcomeText = new Text("Welcome to Business Startup Simulator");
				WelcomeText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Text HowToPlayText = new Text("Instructions");
				HowToPlayText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Button EndIn = new Button("");
				EndIn.setGraphic(new ImageView(end));
				EndIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button PlusIn = new Button("");
				PlusIn.setGraphic(new ImageView(plus));
				PlusIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button ExitIn = new Button("");
				ExitIn.setGraphic(new ImageView(exit));
				ExitIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
				ExitIn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Platform.exit();
					}
				});
				Button HelpIn = new Button("");
				HelpIn.setGraphic(new ImageView(help));
				HelpIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
						+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");

				/* Header */
				HBox Header = new HBox();
				Header.setPadding(new Insets(5, 12, 5, 12));
				Header.setSpacing(10);
				Header.setStyle("-fx-background-color: #058ED9");
				Header.setAlignment(Pos.CENTER_RIGHT);
				Header.getChildren().addAll(HelpIn, EndIn, PlusIn, ExitIn, new ImageView(smallLogo));
				

				Stage management = new Stage();
				management.initModality(Modality.APPLICATION_MODAL);
				management.setTitle("Employee Management");
				
				Text priceB = new Text("($600)");
				
				Button buyB = new Button("Hire Employees");
				Button sellB = new Button("Fire Employees");
				Image add = new Image("add.png", 25, 25, true, true);
				Image angry = new Image("angry.png", 25, 25, true, true);
				Button exitM = new Button("Exit Management");
				exitM.setGraphic(new ImageView(exit));
				exitM.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
				
				buyB.setGraphic(new ImageView(add));
				buyB.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

				sellB.setGraphic(new ImageView(angry));
				sellB.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

				TextField sellT = new TextField ();
				TextField buyT = new TextField ();
				
				HBox tb1 = new HBox(10, buyB, buyT, priceB);
				HBox tb2 = new HBox(10, sellB, sellT);
				
				VBox tb3 = new VBox(10, tb1, tb2, exitM);
				tb3.setAlignment(Pos.CENTER);
				tb3.setPadding(new Insets(150, 150, 150, 150));
				tb3.setStyle("-fx-background-color: #F4EBD9");
				exitM.setOnAction(p -> management.close());
				
				
				buyB.setOnAction(new EventHandler<ActionEvent>() {
					
					@Override
					public void handle(ActionEvent event) {
						if (buyT.getText().isEmpty()) {
							infoScreen.setText("put a number to hire");
						}
						else {
							int buyV = Integer.parseInt(buyT.getText());
							
							int addV = Integer.parseInt(employeeCount.getText()) + buyV;
							employeeCount.setText(Integer.toString(addV));
							
							buyT.clear();
							infoScreen.setText("you just Hired " + buyV + " employees");
						}
						
					}
					
				});
				
				sellB.setOnAction(new EventHandler<ActionEvent>() {

					@Override
					public void handle(ActionEvent event) {
						if (sellT.getText().isEmpty()) {
							infoScreen.setText("put a number to fire");
						}
						else {
							int sellV = Integer.parseInt(sellT.getText());
							int removeV = Integer.parseInt(employeeCount.getText()) - sellV;
							if (removeV < 0) {
								infoScreen.setText("you cant have less than 0 employees, sell a more resonable amount");							
								
							}
							else {
								
								employeeCount.setText(Integer.toString(removeV));
								infoScreen.setText("you just fired " + sellV + " employees");
							}
						
						}		
						
						
						sellT.clear();
						
					}
					
				});
				BorderPane SellEmployee = new BorderPane(); 
				SellEmployee.setCenter(tb3);
				SellEmployee.setTop(Header);
				
				Scene popUpWindowScene = new Scene(SellEmployee, 800, 550);
				management.setScene(popUpWindowScene);
				management.showAndWait();
				
			});
			
			
						
			payBills.setOnAction(p -> {


				Text WelcomeText = new Text("Welcome to Business Startup Simulator");
				WelcomeText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Text HowToPlayText = new Text("Instructions");
				HowToPlayText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Button EndIn = new Button("");
				EndIn.setGraphic(new ImageView(end));
				EndIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button PlusIn = new Button("");
				PlusIn.setGraphic(new ImageView(plus));
				PlusIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button ExitIn = new Button("");
				ExitIn.setGraphic(new ImageView(exit));
				ExitIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
				ExitIn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Platform.exit();
					}
				});
				Button HelpIn = new Button("");
				HelpIn.setGraphic(new ImageView(help));
				HelpIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
						+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");

				/* Header */
				HBox Header = new HBox();
				Header.setPadding(new Insets(5, 12, 5, 12));
				Header.setSpacing(10);
				Header.setStyle("-fx-background-color: #058ED9");
				Header.setAlignment(Pos.CENTER_RIGHT);
				Header.getChildren().addAll(HelpIn, EndIn, PlusIn, ExitIn, new ImageView(smallLogo));
				
				/***** Images for the Screen */ 
				Image payment = new Image("payment-method.png", 25, 25, true, true);
				Image utilities = new Image("utilities.png", 25, 25, true, true);
				Image installment = new Image("installment.png", 25, 25, true, true);
				
				Stage payBillsPopUp = new Stage();
				payBillsPopUp.initModality(Modality.APPLICATION_MODAL);
				payBillsPopUp.setTitle("Pay Bills");
				Button payEmployeeWages = new Button("Pay Employee Wages");
				Button payUtilities = new Button("Pay Utilities");
				Button payPropertTaxes = new Button("Pay Property Taxes");
				Text paidEmployee = new Text("");
				payEmployeeWages.setGraphic(new ImageView(payment));
				payEmployeeWages.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
				Text paidUtilities = new Text("");
				payUtilities.setGraphic(new ImageView(installment));
				payUtilities.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
				payPropertTaxes.setGraphic(new ImageView(payment));
				payPropertTaxes.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
				
				Text paidTaxes = new Text("");
				Button closePayBillsPopUp = new Button("Close Window");
				closePayBillsPopUp.setGraphic(new ImageView(exit));
				closePayBillsPopUp.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
				payUtilities.setDisable(false);
				paidEmployee.setDisable(false);
				paidTaxes.setDisable(false);
				closePayBillsPopUp.setOnAction(f -> payBillsPopUp.close());
				
				
				
				
				payEmployeeWages.setOnAction(f -> {
					
					storeChosen = storeDropdown.getValue();
					System.out.println(storeChosen);
					
					if (storeChosen.contains("1")) {

						if (store1 == true) {
							int budgetAfterWorkersPaid = Integer.parseInt(budget.getText())
									- (Integer.parseInt(employeeCount.getText()) * 600);
							budget.setText(Integer.toString(budgetAfterWorkersPaid));
							wages1 += (Integer.parseInt(employeeCount.getText()) * 600);
							paidEmployee.setText(
							"Paid: " + (Integer.parseInt(employeeCount.getText()) * 600) + " for employee costs!");
							payEmployeeWages.setDisable(true);
						}
						else {
							paidEmployee.setText("You have to own store 1 to pay Wages.");
						}
					}
					
					if (storeChosen.contains("2")) {

						if (store2 == true) {
							int budgetAfterWorkersPaid = Integer.parseInt(budget.getText())
									- (Integer.parseInt(employeeCount.getText()) * 600);
							budget.setText(Integer.toString(budgetAfterWorkersPaid));
							wages2 += (Integer.parseInt(employeeCount.getText()) * 600);
							paidEmployee.setText(
							"Paid: " + (Integer.parseInt(employeeCount.getText()) * 600) + " for employee costs!");
							payEmployeeWages.setDisable(true);
						}
						else {
							paidEmployee.setText("You have to own store 2 to pay Wages.");
						}
					}
					
					if (storeChosen.contains("3")) {

						if (store3 == true) {
							int budgetAfterWorkersPaid = Integer.parseInt(budget.getText())
									- (Integer.parseInt(employeeCount.getText()) * 600);
							budget.setText(Integer.toString(budgetAfterWorkersPaid));
							wages3 += (Integer.parseInt(employeeCount.getText()) * 600);
							paidEmployee.setText(
							"Paid: " + (Integer.parseInt(employeeCount.getText()) * 600) + " for employee costs!");
							payEmployeeWages.setDisable(true);
						}
						else {
							paidEmployee.setText("You have to own store 3 to pay Wages.");
						}
					}

					


				});

				payUtilities.setOnAction(f -> {
					
					storeChosen = storeDropdown.getValue();
					System.out.println(storeChosen);

					if (storeChosen.contains("1")) {

						if (store1 == true) {
							inventory1+= inventoryTotal;
							
							utilities1 +=1000;
							int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) - utilities1;
							budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
							paidUtilities.setText("Paid: "+ utilities1 + " for Store1 Utilities and "  + inventory1 + " for inventory.");							
							payUtilities.setDisable(true);
							
							
							inventoryTotal=0;
						}
						else {
							paidUtilities.setText("You have to own store 1 to pay Utilities.");
						}


					} else if (storeChosen.contains("2")) {
						if (store2 == true) {
							inventory2+= inventoryTotal;
							
							utilities2 +=2000;
							int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) - utilities2;
							budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
							paidUtilities.setText("Paid: "+ utilities2 + " for Store2 Utilities and "  + inventory2 + " for inventory.");							
							payUtilities.setDisable(true);
							
							
							inventoryTotal=0;
							
						}
					
					else {
						paidUtilities.setText("You have to own store 2 to pay Utilities.");
					}

						

					} else if (storeChosen.contains("3")) {
						if (store3 == true) {
							inventory3+= inventoryTotal;
							
							utilities3 +=3000;
							int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) - utilities3;
							budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
							paidUtilities.setText("Paid: "+ utilities3 + " for Store3 Utilities and "  + inventory3 + " for inventory.");							
							payUtilities.setDisable(true);
							
							
							inventoryTotal=0;
						}
					
					else {
						paidUtilities.setText("You have to own store 3 to pay Utilities.");
					}

					}

				});

				payPropertTaxes.setOnAction(f -> {
					
					storeChosen = storeDropdown.getValue();
					System.out.println(storeChosen);

					if (storeChosen.contains("1")) {

						if (store1 == true) {
							int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) - 10000;
							budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
							paidTaxes.setText("Paid: 10000 for Store1 taxes.");
							propertyTaxes1 +=10000;
							payPropertTaxes.setDisable(true);
						}
						else {
							paidTaxes.setText("You have to own store 1 to pay Taxes.");
						}

					} else if (storeChosen.contains("2")) {
						if (store2 == true) {
							int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) - 15000;
							budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
							paidTaxes.setText("Paid: 15000 for Store2 taxes.");
							propertyTaxes2 +=15000;
							payPropertTaxes.setDisable(true);

						}
						else {
							paidTaxes.setText("You have to own store 2 to pay Taxes.");
						}

					} else if (storeChosen.contains("3")) {
						if (store3 == true) {
							int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) - 20000;
							budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
							paidTaxes.setText("Paid: 20000 for Store3 taxes.");
							propertyTaxes3 +=20000;
							payPropertTaxes.setDisable(true);
						}
						else {
							paidTaxes.setText("You have to own store 3 to pay Taxes.");
						}
					}
					

				});

				VBox payBillsPopUpWindow = new VBox(20, payEmployeeWages, payUtilities, payPropertTaxes,
						closePayBillsPopUp, paidEmployee, paidUtilities, paidTaxes);
				payBillsPopUpWindow.setAlignment(Pos.CENTER);
				payBillsPopUpWindow.setStyle("-fx-background-color: #F4EBD9");
				BorderPane findThisEasterEgg = new BorderPane(); 
				findThisEasterEgg.setCenter(payBillsPopUpWindow);
				findThisEasterEgg.setTop(Header);
				Scene popUpWindowScene = new Scene(findThisEasterEgg, 800, 550);
				payBillsPopUp.setScene(popUpWindowScene);
				payBillsPopUp.showAndWait();

			});

			inventory.setOnAction(h -> {

				Text inventoryTotalText = new Text("Inventory Total: $" + inventoryTotal); 
				Image done = new Image("check.png", 25, 25, true, true);
				Stage inventoryStage= new Stage();
				inventoryStage.initModality(Modality.APPLICATION_MODAL);
				/* Text */
				Text WelcomeText = new Text("Welcome to Business Startup Simulator");
				WelcomeText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Text HowToPlayText = new Text("Instructions");
				HowToPlayText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				/* Buttons */
				Button Done = new Button("Done");
				Done.setGraphic(new ImageView(done));
				Done.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

				Button EndIn = new Button("");
				EndIn.setGraphic(new ImageView(end));
				EndIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button PlusIn = new Button("");
				PlusIn.setGraphic(new ImageView(plus));
				PlusIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button ExitIn = new Button("");
				ExitIn.setGraphic(new ImageView(exit));
				ExitIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
				ExitIn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Platform.exit();
					}
				});
				Button HelpIn = new Button("");
				HelpIn.setGraphic(new ImageView(help));
				HelpIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
						+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");

				/* Header */
				HBox Header = new HBox();
				Header.setPadding(new Insets(5, 12, 5, 12));
				Header.setSpacing(10);
				Header.setStyle("-fx-background-color: #058ED9");
				Header.setAlignment(Pos.CENTER_RIGHT);
				Header.getChildren().addAll(HelpIn, EndIn, PlusIn, ExitIn, new ImageView(smallLogo));
				
				/* Start Game, Help Buttons */
				VBox Selection = new VBox();
				Selection.setPadding(new Insets(5, 12, 5, 12));
				Selection.setSpacing(10);
				Selection.setAlignment(Pos.CENTER);
				Selection.setStyle("-fx-background-color: #F4EBD9");
				Selection.getChildren().addAll(inventoryTotalText, Done);
				
				ListView ItemList = new ListView(); 
				VBox InventoryList = new VBox(ItemList);
				InventoryList.setPadding(new Insets(5, 12, 5, 12));
				InventoryList.setSpacing(10);
				InventoryList.setAlignment(Pos.CENTER);
				InventoryList.setStyle("-fx-background-color: #F4EBD9");
				
				/* Images */ 
				Image cheddar = new Image("cheddar.png", 25, 25, true, true);
				Image lettuce = new Image("lettuce.png", 25, 25, true, true);
				Image tomatoes = new Image("tomatoes.png", 25, 25, true, true);
				Image avacadoes = new Image("avacadoes.png", 25, 25, true, true);
				Image onions = new Image("onions.png", 25, 25, true, true);
				Image mushrooms = new Image("mushrooms.png", 25, 25, true, true);
				Image bacon = new Image("bacon.png", 25, 25, true, true);
				Image pickle = new Image("pickle.png", 25, 25, true, true);
				Image peppers = new Image("peppers.png", 25, 25, true, true);
				Image buns = new Image("buns.png", 25, 25, true, true);
				Image veganmeat = new Image("veganmeat.png", 25, 25, true, true);
				Image beef = new Image("beef.png", 25, 25, true, true);
				Image chicken = new Image("chicken.png", 25, 25, true, true);
				Image potatoes = new Image("potatoes.png", 25, 25, true, true);
				Image soda = new Image("soda.png", 25, 25, true, true);
				Image bags = new Image("bags.png", 25, 25, true, true);
				Image utensils = new Image("utensils.png", 25, 25, true, true);
				
			    /* Add buttons for the items added to the grocery list */ 
				/* Cheese */ 
				Button Cheddar = new Button("Cheddar"); 
				Cheddar.setGraphic(new ImageView(cheddar));
				Cheddar.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Cheddar.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Cheddar........................................................................+ $10.00");
					inventoryTotal += 10; 
					}
				});
				/* Toppings */ 
				Button Lettuce = new Button("Lettuce"); 
				Lettuce.setGraphic(new ImageView(lettuce));
				Lettuce.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Lettuce.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Lettuce........................................................................+ $5.00");
					inventoryTotal += 5; 
					}
				});
				Button Tomatoes = new Button("Tomatoes"); 
				Tomatoes.setGraphic(new ImageView(tomatoes));
				Tomatoes.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Tomatoes.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Tomatoes........................................................................+ $10.00");
					inventoryTotal += 10; 
					}
				});
				Button Avocadoes = new Button("Avocadoes"); 
				Avocadoes.setGraphic(new ImageView(avacadoes));
				Avocadoes.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Avocadoes.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Avocadoes........................................................................+ $20.00");
					inventoryTotal += 20; 
					}
				});
				Button RedOnions = new Button("Red Onions"); 
				RedOnions.setGraphic(new ImageView(onions));
				RedOnions.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				RedOnions.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Onions........................................................................+ $10.00");
					inventoryTotal += 10; 
					}
				});
				Button Mushrooms = new Button("Mushrooms"); 
				Mushrooms.setGraphic(new ImageView(mushrooms));
				Mushrooms.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Mushrooms.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Mushrooms........................................................................+ $15.00");
					inventoryTotal += 15; 
					}
				});
				Button Bacon = new Button("Bacon"); 
				Bacon.setGraphic(new ImageView(bacon));
				Bacon.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Bacon.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Bacon........................................................................+ $30.00");
					inventoryTotal += 30; 
					}
				});
				Button Pickles = new Button("Pickles"); 
				Pickles.setGraphic(new ImageView(pickle));
				Pickles.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Pickles.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Pickles........................................................................+ $8.00");
					inventoryTotal += 8; 
					}
				});
				Button Peppers = new Button("Peppers"); 
				Peppers.setGraphic(new ImageView(peppers));
				Peppers.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Peppers.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Peppers........................................................................+ $8.00");
					inventoryTotal += 8; 
					}
				});
				
				
				/*Bread*/ 
				Button Buns = new Button("Buns"); 
				Buns.setGraphic(new ImageView(buns));
				Buns.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Buns.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Buns........................................................................+ $15.00");
					inventoryTotal += 15; 
					}
				});
				
				
				/*Meat*/
				Button VeganMeat = new Button("Vegan Meat"); 
				VeganMeat.setGraphic(new ImageView(veganmeat));
				VeganMeat.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				VeganMeat.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Vegan Meat........................................................................+ $30.00");
					inventoryTotal += 30; 
					}
				});
				Button Beef = new Button("Beef"); 
				Beef.setGraphic(new ImageView(beef));
				Beef.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Beef.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Beef........................................................................+ $40.00");
					inventoryTotal += 40; 
					}
				});
				Button Chicken = new Button("Chicken"); 
				Chicken.setGraphic(new ImageView(chicken));
				Chicken.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Chicken.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Mushrooms........................................................................+ $20.00");
					inventoryTotal += 20; 
					}
				});
				/* Sides */ 
				Button Potatoes = new Button("Potatoes"); 
				Potatoes.setGraphic(new ImageView(potatoes));
				Potatoes.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Potatoes.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Potatoes........................................................................+ $10.00");
					inventoryTotal += 10; 
					}
				});
				Button Soda = new Button("Soda"); 
				Soda.setGraphic(new ImageView(soda));
				Soda.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Soda.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Soda........................................................................+ $15.00");
					inventoryTotal += 15; 
					}
				});
				Button Bags = new Button("Bags"); 
				Bags.setGraphic(new ImageView(bags));
				Bags.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Bags.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Mushrooms........................................................................+ $10.00");
					inventoryTotal += 10; 
					}
				});
				Button Utensils = new Button("Utensils");
				Utensils.setGraphic(new ImageView(utensils));
				Utensils.setStyle("-fx-background-radius: 100em;" + "-fx-max-width: 300px; ");
				Utensils.setOnAction( new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
					ItemList.getItems().add("Utensils........................................................................+ $15.00");
					inventoryTotal += 15; 
					}
				});
				Done.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						inventoryTotalText.setText("Inventory Total: $" + inventoryTotal); 
						//int budgetAfterInventory = (int) (Integer.parseInt(budget.getText()) - inventoryTotal);
						//budget.setText(Integer.toString(budgetAfterInventory));
						ItemList.getItems().clear();
					}
					
				});
				VBox buttonList = new VBox(Cheddar, Lettuce, Tomatoes, Avocadoes, 
						RedOnions, Mushrooms, Bacon, Pickles, Peppers, Buns, VeganMeat, Beef, Chicken, 
						Potatoes, Soda, Bags, Utensils);
				buttonList.setAlignment(Pos.CENTER);
				buttonList.setStyle("-fx-background-color: #F4EBD9");
				
				/* Set Start Pane */
				BorderPane StartPane = new BorderPane();
				StartPane.setTop(Header);
				StartPane.setRight(Selection);
				StartPane.setCenter(InventoryList);
				StartPane.setLeft(buttonList);
				Scene popUpInventory = new Scene(StartPane, 800, 750);
				inventoryStage.setScene(popUpInventory);
				inventoryStage.showAndWait();
			});

			sell.setOnAction(p -> {
				/* Text */
				
				Text WelcomeText = new Text("Welcome to Business Startup Simulator");
				WelcomeText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Text HowToPlayText = new Text("Instructions");
				HowToPlayText.setStyle("-fx-font-size: 18;" + "-fx-border-size: 20;" + "-fx-border-color: red;");

				Button EndIn = new Button("");
				EndIn.setGraphic(new ImageView(end));
				EndIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button PlusIn = new Button("");
				PlusIn.setGraphic(new ImageView(plus));
				PlusIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

				Button ExitIn = new Button("");
				ExitIn.setGraphic(new ImageView(exit));
				ExitIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
						+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
				ExitIn.setOnAction(new EventHandler<ActionEvent>() {
					public void handle(ActionEvent event) {
						Platform.exit();
					}
				});
				Button HelpIn = new Button("");
				HelpIn.setGraphic(new ImageView(help));
				HelpIn.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
						+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");

				/* Header */
				HBox Header = new HBox();
				Header.setPadding(new Insets(5, 12, 5, 12));
				Header.setSpacing(10);
				Header.setStyle("-fx-background-color: #058ED9");
				Header.setAlignment(Pos.CENTER_RIGHT);
				Header.getChildren().addAll(HelpIn, EndIn, PlusIn, ExitIn, new ImageView(smallLogo));
				
				Stage sellPropertiesPopUp = new Stage();
				sellPropertiesPopUp.initModality(Modality.APPLICATION_MODAL);
				
				sellPropertiesPopUp.setTitle("Pay Bills");
				Button Sell = new Button("Sell Property");
				Text soldPropertyValue = new Text("");
				Text soldPropertyName = new Text("");
				Text paidTaxesText = new Text("");
				Image deal = new Image("deal.png", 25, 25, true, true);
				Button closeSellPropertiesPopUp = new Button("Close Window");
				closeSellPropertiesPopUp.setGraphic(new ImageView(exit));
				closeSellPropertiesPopUp.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");
				closeSellPropertiesPopUp.setOnAction(f -> popUpWindow.close());
				Sell.setGraphic(new ImageView(deal));
				Sell.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

				Sell.setDisable(false);
				closeSellPropertiesPopUp.setDisable(false);
				closeSellPropertiesPopUp.setOnAction(f -> sellPropertiesPopUp.close());
				
				
				//System.out.println("the wages is " + wages + "the taxes is " + propertyTaxes + "the utilties is " + utilities);
				
				
				
				
				//System.out.println("the value of what we invested in the company is " + value);

				
				
				storeChosen = storeDropdown.getValue();
				System.out.println(storeChosen);

				if (storeChosen.contains("1")) {
					if(store1 == false) {
						paidTaxesText.setText("You dont own property 1");		
						Sell.setDisable(true);
					}
					else {
					
					value1 = store1Cost + wages1 + propertyTaxes1 + utilities1 + inventory1;
					paidTaxesText.setText("The Value of the property1 is "+ value1 + " because you invested " + wages1 +" in wages " + propertyTaxes1 + " in taxes " +  utilities1 +" in utilties " + inventory1 +" in inventory");				

					Sell.setOnAction(g-> {	
						int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) + value1;
						budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
						wages1 = 0;
						propertyTaxes1 = 0;
						utilities1 = 0;
						store1 = false;
						inventory1 = 0;
						Sell.setDisable(true);
						
						int employ = 0;
						
						if (Integer.parseInt(employeeCount.getText()) > 2 ) {
							employ = Integer.parseInt(employeeCount.getText()) - 2;
							employeeCount.setText(Integer.toString(employ));							
						}
						
						else if (Integer.parseInt(employeeCount.getText()) == 2 || Integer.parseInt(employeeCount.getText()) == 1 || Integer.parseInt(employeeCount.getText()) == 0 ) {
							employ = 0;
							employeeCount.setText(Integer.toString(employ));							
						}
						
						
						employeeCount.setText(Integer.toString(employ));	
						
						mapSettings.deleteMarker(storeChosen, webEngine);
						storeCount--;
						
						infoScreen.setText("you just sold store 1 for " + value1);
					});
					}
				} else if (storeChosen.contains("2")) {
					if(store2 == false) {
						paidTaxesText.setText("You dont own property 2");		
						Sell.setDisable(true);
					}
					else {
					int tempUtilties = utilities2 + inventoryTotal;
					value2 = store2Cost + wages2 + propertyTaxes2 + tempUtilties;
					paidTaxesText.setText("The Value of the property2 is "+ value2 + " because you invested " + wages2 +" in wages " + propertyTaxes2 + " in taxes " +  inventory2 +" in inventory");		


					Sell.setOnAction(g-> {

						
						int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) + value2;
						budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
						wages2 = 0;
						propertyTaxes2 = 0;
						utilities2 = 0;
						inventory2 = 0;
						store2 = false;
						Sell.setDisable(true);
						
					
						int employes=0;
						
						if (Integer.parseInt(employeeCount.getText()) > 2 ) {
							employes = Integer.parseInt(employeeCount.getText()) - 2;
							employeeCount.setText(Integer.toString(employes));							
						}
						
						else if (Integer.parseInt(employeeCount.getText()) == 2 || Integer.parseInt(employeeCount.getText()) == 1 || Integer.parseInt(employeeCount.getText()) == 0 ) {
							employes = 0;
							employeeCount.setText(Integer.toString(employes));							
						}
						
						employeeCount.setText(Integer.toString(employes));
						mapSettings.deleteMarker(storeChosen, webEngine);
						storeCount--;
						
						infoScreen.setText("you just sold store 2 for " + value2);
					});
					}

				} else if (storeChosen.contains("3")) {
					if(store3 == false) {
						paidTaxesText.setText("You dont own property 3");				

						Sell.setDisable(true);
					}
					else {
					int tempUtilties = utilities3 + inventoryTotal;
					value3 = store3Cost + wages3 + propertyTaxes3 + tempUtilties;
					paidTaxesText.setText("The Value of the property3 is "+ value3 + " because you invested " + wages3 +" in wages " + propertyTaxes3 + " in taxes " +  inventory3 +" in inventory");				
					

					
					Sell.setOnAction(g-> {

	
						int budgetAfterUtilitiesPaid = Integer.parseInt(budget.getText()) + value3;
						budget.setText(Integer.toString(budgetAfterUtilitiesPaid));
						wages3 = 0;
						propertyTaxes3 = 0;
						utilities3 = 0;
						store3 = false;
						inventory3 = 0;
						Sell.setDisable(true);

						int employ=0;
						
						
						if (Integer.parseInt(employeeCount.getText()) > 2 ) {
							employ = Integer.parseInt(employeeCount.getText()) - 2;
							employeeCount.setText(Integer.toString(employ));							
						}
						
						else if (Integer.parseInt(employeeCount.getText()) == 2 || Integer.parseInt(employeeCount.getText()) == 1 || Integer.parseInt(employeeCount.getText()) == 0 ) {
							employ = 0;
							employeeCount.setText(Integer.toString(employ));							
						}
						
						employeeCount.setText(Integer.toString(employ));
						mapSettings.deleteMarker(storeChosen, webEngine);
						storeCount--;
						
						infoScreen.setText("you just sold store 3 for " + value3);
					});
					}
				}

				
				VBox sellPropertiesPopUpWindow = new VBox(20, soldPropertyName, soldPropertyValue,paidTaxesText, Sell, closeSellPropertiesPopUp);
				sellPropertiesPopUpWindow.setAlignment(Pos.CENTER);
				sellPropertiesPopUpWindow.setStyle("-fx-background-color: #F4EBD9");
				BorderPane sellBP = new BorderPane(); 
				sellBP.setCenter(sellPropertiesPopUpWindow);
				sellBP.setTop(Header);
				Scene sellPropertiesPopUpWindowScene = new Scene(sellBP, 800, 550);
				sellPropertiesPopUp.setScene(sellPropertiesPopUpWindowScene);
				sellPropertiesPopUp.showAndWait();
				
			});

			VBox popUpWindowLayout = new VBox(20, employeeManagement, payBills, inventory, sell, closePopUpWindow);
			popUpWindowLayout.setAlignment(Pos.CENTER);

			popUpWindowLayout.setStyle("-fx-background-color: #F4EBD9");
			BorderPane popUpWindowLayoutBorderPane = new BorderPane(); 
			popUpWindowLayoutBorderPane.setTop(HeaderBox);
			popUpWindowLayoutBorderPane.setCenter(popUpWindowLayout);
			Scene fullGameInstructionsScene = new Scene(popUpWindowLayoutBorderPane, 800, 550);
			popUpWindow.setScene(fullGameInstructionsScene);
			popUpWindow.showAndWait();

		});

		/* Buttons */
		Button HelpButton = new Button("Help");
		HelpButton.setGraphic(new ImageView(help));
		HelpButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

		Button NextButton = new Button("Start Game");
		NextButton.setGraphic(new ImageView(play));
		NextButton.setStyle("-fx-background-radius: 100em;" + "-fx-font-size: 18;" + "-fx-max-width: 300px; ");

		Button End = new Button("");
		End.setGraphic(new ImageView(end));
		End.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
		End.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {

				Stage popUpWindow = new Stage();
				popUpWindow.initModality(Modality.APPLICATION_MODAL);
				popUpWindow.setTitle("Full Game Instructions");
				Label fullGameInstructions = new Label(
						"Conclusion\n" + "Total Revenue: $" + revenue + "\n" + "Last Store Bought: " + storeChosen
								+ "\n" + "Country Chosen: " + country + '\n' + "Thank you for playing!");
				fullGameInstructions.setWrapText(true);
				fullGameInstructions.setPadding(new Insets(15, 15, 15, 15));
				fullGameInstructions.setStyle("-fx-font-size: 16;");
				Button closePopUpWindow = new Button("Close Window");
				closePopUpWindow.setGraphic(new ImageView(exit));
				closePopUpWindow.setOnAction(f -> popUpWindow.close());

				VBox popUpWindowLayout = new VBox(20, fullGameInstructions, closePopUpWindow);
				popUpWindowLayout.setAlignment(Pos.CENTER);
				popUpWindowLayout.setStyle("-fx-background-color: #F4EBD9");

				Scene fullGameInstructionsScene = new Scene(popUpWindowLayout, 800, 550);
				popUpWindow.setScene(fullGameInstructionsScene);
				popUpWindow.showAndWait();

				Platform.exit();
			}

		}

		);
		Button Plus = new Button("");
		Plus.setGraphic(new ImageView(plus));
		Plus.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");

		Button Exit = new Button("");
		Exit.setGraphic(new ImageView(exit));
		Exit.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 35px; " + "-fx-min-height: 35px; "
				+ "-fx-max-width: 35px; " + "-fx-max-height: 35px;");
		Exit.setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				Platform.exit();
			}
		});
		Button Help = new Button("");
		Help.setGraphic(new ImageView(help));
		Help.setStyle("-fx-background-radius: 100em;" + "-fx-min-width: 40px; " + "-fx-min-height: 40px; "
				+ "-fx-max-width: 40px; " + "-fx-max-height: 40px;");
		/* Header */
		HBox Header = new HBox();
		Header.setPadding(new Insets(5, 12, 5, 12));
		Header.setSpacing(10);
		Header.setStyle("-fx-background-color: #058ED9");
		Header.setAlignment(Pos.CENTER_RIGHT);
		Header.getChildren().addAll(Help, End, Plus, Exit, new ImageView(smallLogo));

		HBox hBox = new HBox(50, loadButton, addBuisiness, storeDropdown, simButton, simDate); //<-----------------------------
		hBox.setPadding(new Insets(50, 50, 50, 50));
		VBox vBox = new VBox(50, webView);
		vBox.setPadding(new Insets(50, 50, 50, 50));
		HBox budgetBox = new HBox(50, initialBudget, budget);
		HBox lastTransaction = new HBox(50, lastStorePurchased, storeCost);
		HBox employeeS = new HBox(50, employee, employeeCount);
		VBox vBox1 = new VBox(20, manageBusiness, saveBusiness, info, choose, budgetBox, lastTransaction, employeeS, infoScreen, totalRevenue);
		vBox1.setPadding(new Insets(50, 50, 50, 50));
		testA.setCenter(vBox);
		testA.setTop(Header);
		testA.setBottom(hBox);
		testA.setLeft(vBox1);
		return new Scene(testA, 1600, 750);
	}

	public List<String> getListofStores() {
		List<String> stores = new ArrayList<String>();

		switch (country) {
		case "Seoul/South Korea":
			stores.add("Seoul Store1");
			stores.add("Seoul Store2");
			stores.add("Seoul Store3");
			break;
		case "Beijing/China":
			stores.add("China Store1");
			stores.add("China Store2");
			stores.add("China Store3");
			break;
		case "Taipei/Taiwan":
			stores.add("Taiwan Store1");
			stores.add("Taiwan Store2");
			stores.add("Taiwan Store3");
			break;
		case "Mexico City/Mexico":
			stores.add("Mexico Store1");
			stores.add("Mexico Store2");
			stores.add("Mexico Store3");
			break;
		case "Vancouver/Canada":
			stores.add("Canada Store1");
			stores.add("Canada Store2");
			stores.add("Canada Store3");
			break;
		case "Palo Alto/USA":
			stores.add("USA Store1");
			stores.add("USA Store2");
			stores.add("USA Store3");
			break;
		case "Paris/France":
			stores.add("France Store1");
			stores.add("France Store2");
			stores.add("France Store3");
			break;
		case "Berlin/Germany":
			stores.add("Germany Store1");
			stores.add("Germany Store2");
			stores.add("Germany Store3");
			break;
		case "Madrid/Spain":
			stores.add("Spain Store1");
			stores.add("Spain Store2");
			stores.add("Spain Store3");
			break;
		default:
			System.out.println("ERROR IN GET LIST OF STORES");
		}

		return stores;
	}

}
