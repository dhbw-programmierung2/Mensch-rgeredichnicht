package launcher;

import javafx.scene.Scene;

import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import sixplayersgame.GameBoardSixPlayersController;

import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

import fourplayersgame.GameBoardFourPlayersController;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;


/**
 * Das ist die Klasse Launcher.
 * @author Isabelle Scheffler
 * @version 1.0
 *
 */
public class LauncherController {
	@FXML
	public GridPane gridPane;
	public ComboBox<String> cbNumberOfPlayers;
	
	public TextField txtName1;
	public TextField txtName2;
	public TextField txtName3;
	public TextField txtName4;
	public TextField txtName5;
	public TextField txtName6;
	
	public ComboBox<String> cbColor1;
	public ComboBox<String> cbColor2;
	public ComboBox<String> cbColor3;
	public ComboBox<String> cbColor4;
	public ComboBox<String> cbColor5;
	public ComboBox<String> cbColor6;
	
	public ComboBox<String> cbRival1;
	public ComboBox<String> cbRival2;
	public ComboBox<String> cbRival3;
	public ComboBox<String> cbRival4;
	public ComboBox<String> cbRival5;
	public ComboBox<String> cbRival6;
	
	public Button btnStartGame;
	public Button btnExitGame;
	public Button btnCheckSelection;
	
	// Variable wichtig bei späterem prüfen der Eingaben
	private int numberOfPlayers;
	
	// zum Befüllen des Launchers
	public ArrayList <TextField> txtName = new ArrayList<TextField>();
	public ArrayList <ComboBox> cbColor = new ArrayList<ComboBox>();
	public ArrayList <ComboBox> cbRival = new ArrayList<ComboBox>();
	
	// zur Übergabe an die Logik
	private ArrayList <String> playerName = new ArrayList<String>();
	private ArrayList <String> color = new ArrayList<String>();
	private ArrayList <String> rival = new ArrayList<String>();
	
	// Fügt die einzelnen Textfelder und Comboboxen den jeweiligen ArrayList hinzu
	public void initialize() {
		txtName.add(txtName1);
		txtName.add(txtName2);
		txtName.add(txtName3);
		txtName.add(txtName4);
		txtName.add(txtName5);
		txtName.add(txtName6);
		
		cbColor.add(cbColor1);
		cbColor.add(cbColor2);
		cbColor.add(cbColor3);
		cbColor.add(cbColor4);
		cbColor.add(cbColor5);
		cbColor.add(cbColor6);
		
		cbRival.add(cbRival1);
		cbRival.add(cbRival2);
		cbRival.add(cbRival3);
		cbRival.add(cbRival4);
		cbRival.add(cbRival5);
		cbRival.add(cbRival6);
		
		cbNumberOfPlayers.getItems().add("2");
		cbNumberOfPlayers.getItems().add("3");
		cbNumberOfPlayers.getItems().add("4");
		cbNumberOfPlayers.getItems().add("5");
		cbNumberOfPlayers.getItems().add("6");
		cbNumberOfPlayers.setValue("2");
		
		// wird die Combobox color mit 4 Farben gefüllt und gelb als Vorauswahl getroffen damit es nie leer sein kann
		int i = 0,j = 0;
		while (i < cbColor.size()) {
			cbColor.get(i).getItems().add("Gelb");
			cbColor.get(i).getItems().add("Rot");
			cbColor.get(i).getItems().add("Grün");
			cbColor.get(i).getItems().add("Schwarz");
			cbColor.get(i).setValue("Gelb");
			i++;
		}
		// dann wird die Combobox rival mit den 2 Möglichkeiten an Gegnern gefüllt und Mensch als Vorauswahl getroffen damit es nie leer sein kann
		while (j < cbRival.size()) {
			cbRival.get(j).getItems().add("Mensch");
			cbRival.get(j).getItems().add("Computer");
			cbRival.get(j).setValue("Mensch");
			j++;
		}
				
	}
	@FXML
	// Event Listener on CheckBox[#chbSpieler1].onAction 
	public void cbOnActionPlayers(ActionEvent event) {
		// Wenn entweder 2 oder 4 Spieler ausgewählt wurden dann
		if((cbNumberOfPlayers.getValue().equals("2"))) {
			numberOfPlayers = 2;
		}
		// wenn 4 Spieler ausgewählt wurden dann werden die Nodes für Spieler 3 und 4 sichtbar gemacht
		else if(cbNumberOfPlayers.getValue().equals("4")) {
			numberOfPlayers = 4;
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
		}				
		// wenn eine andere Auswahl an Spielern getroffen wurde also 3, 5 oder 6
		else {
			// die Combobox colors mit 6 Farben gefüllt und Gelb als Vorauswahl getroffen damit es nie leer sein kann
			int i = 0,j = 0;
			while (i < cbColor.size()) {
				cbColor.get(i).getItems().add("Blau");
				cbColor.get(i).getItems().add("Lila");
				cbColor.get(i).setValue("Gelb");
				i++;
			}
			
			numberOfPlayers = 3;
			// wenn 3 Spieler ausgewählt wurden dann werden die Nodes für Spieler 3 sichtbar gemacht
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			// wenn 5 Spieler ausgewählt wurden dann werden die Nodes für Spieler 4 und 5 sichtbar gemacht
			if(cbNumberOfPlayers.getValue().equals("5")) {
				numberOfPlayers = 5;
				txtName4.setDisable(false);
				cbColor4.setDisable(false);
				cbRival4.setDisable(false);
				
				txtName5.setDisable(false);
				cbColor5.setDisable(false);
				cbRival5.setDisable(false);
			} 
			// wenn 6 Spieler ausgewählt wurden dann werden die Nodes für Spieler 4, 5 und 6 sichtbar gemacht
			else if(cbNumberOfPlayers.getValue().equals("6")) {
				numberOfPlayers = 6;
				txtName4.setDisable(false);
				cbColor4.setDisable(false);
				cbRival4.setDisable(false);
				
				txtName5.setDisable(false);
				cbColor5.setDisable(false);
				cbRival5.setDisable(false);
				
				txtName6.setDisable(false);
				cbColor6.setDisable(false);
				cbRival6.setDisable(false);
			}
		}
		cbNumberOfPlayers.setDisable(true);
	}
	
	@FXML		
	// Event Listener on Button[#btnSpielstarten].onAction
	public void buttonOnActionStart(ActionEvent event) {
		// Spiel starten und das ausgewählte Spielfeld öffnen
		
		if((numberOfPlayers == 3) || (numberOfPlayers == 5) || (numberOfPlayers == 6)) {
			// Spielbrett für 6 Spieler öffnen
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sixplayersgame/GameBoardSixPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardSixPlayersController gbsp = fxmlloader.getController(); 
				gbsp.initialize(playerName, color, rival, numberOfPlayers);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Game Board");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.show();
				
			} catch (IOException e) {
			// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			// Spielbrett für 4 Spieler öffnen
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fourplayersgame/GameBoardFourPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardFourPlayersController gbfp = fxmlloader.getController(); 
				gbfp.initialize(playerName, color, rival, numberOfPlayers);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Game Board");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.show();
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 
	}
	@FXML
	// Event Listener on Button[#btnSpielbeenden].onAction
	public void buttonOnActionExit(ActionEvent event) {
		// Spiel beenden und schließen
		System.exit(0);
	}
	@FXML
	// Event Listener on Button[#btnSpielstarten].onAction
	public void buttonOnActionCheckSelection(ActionEvent event) {
		checkSelection();
	}
	
	// hier werden die Eingaben auf Vollständigkeit und Richtigkeit überprüft
	public void checkSelection () {
		// Wenn das TextFeld zum Name 1 leer ist dann gibt es eine Fehlermeldung
		if(txtName1.getText().isEmpty()){
			JOptionPane.showMessageDialog(null, "Bitte Überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
		}
		// ansonsten wird der Name, Farbe und Gegner in die ArrayList übernommen
		else {	
				playerName.add(txtName1.getText());
				color.add(cbColor1.getValue());
				rival.add(cbRival1.getValue());	
		
				// wenn der Name2 gleich ist wie ein Name in der ArrayList der Namen oder leer ist 
				if((playerName.contains(txtName2.getText())) || (txtName2.getText().isEmpty())){
					// oder die Farbe2 gleich ist wie Farbe1 dann gibt es einen Fehler und die bisherigen ArrayList werden geleert
					if(cbColor2.getValue().equals(cbColor1.getValue())) {
						playerName.clear();
						color.clear();
						rival.clear();
						JOptionPane.showMessageDialog(null, "Bitte überprüfen Sie Ihre Eingaben","Achtung", JOptionPane.ERROR_MESSAGE);
					}
				} else { // ansonsten wird der Name2, die Farbe 2 und der Gegner zur jeweiligen ArrayList hinzugefügt
					playerName.add(txtName2.getText());
					color.add(cbColor2.getValue());
					rival.add(cbRival2.getValue());	
					if(cbNumberOfPlayers.getValue().equals("2")) {
						btnStartGame.setDisable(false);
					}
					
				}
				
			if(numberOfPlayers == 3) {
				// wenn der Name3 gleich ist wie ein Name in der ArrayList oder leer ist 
				if((playerName.contains(txtName3.getText())) || (txtName3.getText().isEmpty())){
					// oder die Farbe3 bereits vergeben ist gibt es einen Fehler und die bisherigen Arraylist werden geleert
					if((cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue()))){
					playerName.clear();
					color.clear();
					rival.clear();
					JOptionPane.showMessageDialog(null,  "Bitte überprüfen Sie Ihre Eingaben","Achtung", JOptionPane.ERROR_MESSAGE);
					}
				} else { // ansonsten wird der Name3, die Farbe3 und der Gegner zur jeweiligen ArrayList hinzugefügt
					playerName.add(txtName3.getText());
					color.add(cbColor3.getValue());
					rival.add(cbRival3.getValue());	
					btnStartGame.setDisable(false);
				} 		
			} else if(numberOfPlayers == 4) {
				// wenn der Name4 oder Name3 gleich ist wie ein Name in der ArrayList oder leer ist 
				if((playerName.contains(txtName3.getText()) || (playerName.contains(txtName4.getText()))) || (txtName3.getText().isEmpty()) || (txtName4.getText().isEmpty())) {
					// oder die Farbe3 oder Farbe4 bereits vergeben ist gibt es einen Fehler und die bisherigen Arraylist werden geleert
					if((cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor1.getValue())) || 
					(cbColor4.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor3.getValue()))){
						playerName.clear();
						color.clear();
						rival.clear();
						JOptionPane.showMessageDialog(null,  "Bitte überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
					}
									
				} else { // ansonsten wird der Name3, Name4, die Farbe3, Farbe4 und der Gegner3, Gegner4 zur jeweiligen ArrayList hinzugefügt
					playerName.add(txtName3.getText());	
					playerName.add(txtName4.getText());
					color.add(cbColor3.getValue());	
					color.add(cbColor4.getValue());	
					rival.add(cbRival3.getValue());	
					rival.add(cbRival4.getValue());	
					btnStartGame.setDisable(false);
				}
			} else if(numberOfPlayers == 5) {
				// wenn der Name3, Name4 oder Name5 gleich ist wie ein Name in der ArrayList oder leer ist 
				if((playerName.contains(txtName3.getText())) || (playerName.contains(txtName4.getText())) || (playerName.contains(txtName5.getText())) || (txtName3.getText().isEmpty()) || (txtName4.getText().isEmpty()) || (txtName5.getText().isEmpty())) {
					// oder die Farbe3, Farbe4 oder Farbe5 schon vergeben ist gibt es einen Fehler und die bisherigen Arraylist werden geleert
					if((cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor1.getValue())) || (cbColor4.getValue().equals(cbColor2.getValue())) || 
					(cbColor4.getValue().equals(cbColor3.getValue())) || (cbColor5.getValue().equals(cbColor1.getValue())) || (cbColor5.getValue().equals(cbColor2.getValue())) || (cbColor5.getValue().equals(cbColor3.getValue())) || (cbColor5.getValue().equals(cbColor4.getValue()))){
							playerName.clear();
							color.clear();
							rival.clear();
							JOptionPane.showMessageDialog(null,  "Bitte überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
					}
										
				} else { // ansonsten wird der Name3, Name4, Name5, die Farbe3, Farbe4, Farbe5 und der Gegner3, Gegner4, Gegner5 zur jeweiligen ArrayList hinzugefügt
					playerName.add(txtName3.getText());	
					playerName.add(txtName4.getText());
					playerName.add(txtName5.getText());
					color.add(cbColor3.getValue());	
					color.add(cbColor4.getValue());		
					color.add(cbColor5.getValue());	
					rival.add(cbRival3.getValue());	
					rival.add(cbRival4.getValue());	
					rival.add(cbRival5.getValue());
					btnStartGame.setDisable(false);
				} 				
				// wenn der Name3, Name4, Name5 oder Name6 gleich ist wie ein Name in der ArrayList oder leer ist 
			} else if(numberOfPlayers == 6) {
				if((playerName.contains(txtName3.getText())) || (playerName.contains(txtName4.getText())) || (playerName.contains(txtName5.getText()))|| (playerName.contains(txtName6.getText())  
				|| (txtName3.getText().isEmpty()) || (txtName4.getText().isEmpty()) || (txtName5.getText().isEmpty()) || (txtName6.getText().isEmpty()))) {
				// oder die Farbe3, Farbe4, Farbe5 oder Farbe6 schon vergeben ist gibt es einen Fehler und die bisherigen Arraylist werden geleert
				if((cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor1.getValue())) || (cbColor4.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor3.getValue())) || 
				(cbColor5.getValue().equals(cbColor1.getValue())) || (cbColor5.getValue().equals(cbColor2.getValue())) || (cbColor5.getValue().equals(cbColor3.getValue())) || (cbColor5.getValue().equals(cbColor4.getValue())) || 
				(cbColor6.getValue().equals(cbColor1.getValue())) || (cbColor6.getValue().equals(cbColor2.getValue())) || (cbColor6.getValue().equals(cbColor3.getValue())) || (cbColor6.getValue().equals(cbColor4.getValue())) || (cbColor6.getValue().equals(cbColor5.getValue()))){
					playerName.clear();
					color.clear();
					rival.clear();
					JOptionPane.showMessageDialog(null,  "Bitte überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
					
				}
				} else { // ansonsten wird der Name3, Name4, Name5, Name6, die Farbe3, Farbe4, Farbe5, Farbe6 und der Gegner3, Gegner4, Gegner5, Gegner6 zur jeweiligen ArrayList hinzugefügt
					playerName.add(txtName3.getText());	
					playerName.add(txtName4.getText());
					playerName.add(txtName5.getText());
					playerName.add(txtName6.getText());
					color.add(cbColor3.getValue());	
					color.add(cbColor4.getValue());		
					color.add(cbColor5.getValue());	
					color.add(cbColor6.getValue());
					rival.add(cbRival3.getValue());	
					rival.add(cbRival4.getValue());	
					rival.add(cbRival5.getValue());	
					rival.add(cbRival6.getValue());	
					btnStartGame.setDisable(false);
				} 
		}	
	}
}
}
