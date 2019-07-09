package launcher;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import sixplayersgame.GameBoardSixPlayersController;
import fourplayersgame.GameBoardFourPlayersController;



/**
 * Diese Klasse repräsentiert den Einstieg in das Spiel.
 * Hier werden die Voreinstellungen getätigt.
 * 
 * @author Lukas, Kim, Isabelle, Jonas
 * @version 1.0
 *
 */
public class LauncherController {
	
	/*
	 * FXML Komponenten
	 */
	
	@FXML
	public GridPane gridPane;
	public RadioButton rbPlayer2;
	public RadioButton rbPlayer3;
	public RadioButton rbPlayer4;
	public RadioButton rbPlayer5;
	public RadioButton rbPlayer6;
		
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
	
	/*
	 * Variable enthält die Anzahl der Spieler
	 */
	private int numberOfPlayers;
	
	/*
	 * ArrayLists die die Farbe und Eigenschaften der Spieler enthält, diese sind zum leichteren Befüllen der ComboBoxen.
	 */
	public ArrayList <ComboBox> cbColor = new ArrayList<ComboBox>();
	public ArrayList <ComboBox> cbRival = new ArrayList<ComboBox>();
	
	/*
	 * ArrayLists zur Übergabe der vom Spieler ausgewählten Eigenschaften an die Spiellogik 
	 */
	private ArrayList <String> playerName = new ArrayList<String>();
	private ArrayList <String> color = new ArrayList<String>();
	private ArrayList <String> rival = new ArrayList<String>();
	
	/*
	 * Methode zum Hinzufügen der einzelnen ComboBoxen zu den ArrayLists sowie das Befüllen der ComboBoxen.
	 */
	public void initialize() {
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
		
		/*
		 * Die ComboBoxen Farbe wird zunächst mit den 4 Farben des 4er Spielbrettes gefüllt und die Farbe Gelb als Vorauswahl getroffen
		 */
		int i = 0,j = 0;
		while (i < cbColor.size()) {
			cbColor.get(i).getItems().add("Gelb");
			cbColor.get(i).getItems().add("Rot");
			cbColor.get(i).getItems().add("Grün");
			cbColor.get(i).getItems().add("Schwarz");
			cbColor.get(i).setValue("Gelb");
			i++;
		}
		/*
		 * Die ComboBoxen für die Auswahl der Eigenschaften der Gegner wird befüllt und die Eigenschaft Mensch als Vorauswahl getroffen
		 */
		while (j < cbRival.size()) {
			cbRival.get(j).getItems().add("Mensch");
			cbRival.get(j).getItems().add("Computer");
			cbRival.get(j).setValue("Mensch");
			j++;
		}
				
	}
	
	@FXML
	/*
	 * Event Listener für den RadioButton, wenn für die Anzahl der Spieler 2 ausgewählt wird.
	 */
	public void rbOnActionPlayer2(ActionEvent event) {
		if(rbPlayer2.isSelected()) {
			
			numberOfPlayers = 2;
		}
		
		/*
		 * Die Textfelder und ComboBoxen für den Spieler 1 und Spieler 2 werden aktiviert, außer die ComboBox Farben für Spieler 2 da der Spieler 2 immer gegenüber der Farbe des Spielers 1 sein muss
		 */
		txtName1.setDisable(false);
		cbColor1.setDisable(false);
		cbRival1.setDisable(false);
		
		txtName2.setDisable(false);
		cbRival2.setDisable(false);
		
		/*
		 * Die Auswahl für die Anzahl an Spielern die nicht ausgewählt wurde, wird deaktiviert
		 */
		rbPlayer3.setDisable(true);
		rbPlayer4.setDisable(true);
		rbPlayer5.setDisable(true);
		rbPlayer6.setDisable(true);
		
		/*
		 * Da die Vorauswahl der ComboBox Farben des Spieler 1 auf Gelb gesetzt wird, wird die Farbe Rot für den Spieler 2 ausgewählt
		 */
		cbColor2.setValue("Rot");
	}
	
	@FXML
	/*
	 * Event Listener für den RadioButton, wenn für die Anzahl der Spieler 3 ausgewählt wird.
	 */
	public void rbOnActionPlayer3(ActionEvent event) {
		if(rbPlayer3.isSelected()) {
			numberOfPlayers = 3;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben des Spielers 1 hinzugefügt, da hier auf dem 6er Spielfeld gespielt wird.
			 * Da die Auswahl für Spieler 1 anfangs auf Gelb gesetzt wird und die direkte Nachbarfarbe bei 3 Spieler nicht ausgewählt werden darf, wird die Auswahl Farbe bei Spieler 2 auf Blau und Grün beschränkt
			 * Die Farbauswahl bei Spieler 3 wird erweitert mit Blau und Lila und die Vorauswahl auf Grün gesetzt
			 */
			cbColor1.getItems().add("Blau");
			cbColor1.getItems().add("Lila");
			cbColor1.setValue("Gelb");
			
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Grün");
			cbColor2.setValue("Blau");
			
			cbColor3.getItems().add("Blau");
			cbColor3.getItems().add("Lila");
			cbColor3.setValue("Grün");
			
			
			
			/*
			 * Das Textfeld für den Namen und die ComboBox für die Gegnerauswahl wird für Spieler 1, Spieler 2 und Spieler 3 aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbRival3.setDisable(false);
			
			/*
			 * Die Auswahl für die Anzahl an Spielern die nicht ausgewählt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/*
	 * Event Listener für den RadioButton, wenn für die Anzahl der Spieler 4 ausgewählt wird.
	 */
	public void rbOnActionPlayer4(ActionEvent event) {
		if(rbPlayer4.isSelected()) {
			numberOfPlayers = 4;
			
			/*
			 * Das Textfeld für den Namen und die ComboBox für die Gegnerauswahl wird für Spieler 1, Spieler 2, Spieler 3 und Spieler 4 aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false); 
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
			
			/*
			 * Die Auswahl für die Anzahl an Spielern die nicht ausgewählt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer5.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/*
	 * Event Listener für den RadioButton, wenn für die Anzahl der Spieler 5 ausgewählt wird.
	 */
	public void rbOnActionPlayer5(ActionEvent event) {
		if(rbPlayer5.isSelected()) {
			numberOfPlayers = 5;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben aller Spieler hinzugefügt, da hier auf dem 6er Spielfeld gespielt wird
			 * Und jeweils eine Vorauswahl der Farben getroffen
			 */
			int i = 0,j = 0;
			while (i < cbColor.size()) {
				cbColor.get(i).getItems().add("Blau");
				cbColor.get(i).getItems().add("Lila");
				cbColor.get(i).setValue("Gelb");
				i++;
			}
			
			/*
			 * Das Textfeld für den Namen und die ComboBox für die Gegnerauswahl wird für Spieler 1, Spieler 2, Spieler 3, Spieler 4 und Spieler 5 aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
			
			txtName5.setDisable(false);
			cbColor5.setDisable(false);
			cbRival5.setDisable(false);
			
			/*
			 * Die Auswahl für die Anzahl an Spielern die nicht ausgewählt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer6.setDisable(true);
		}
	}
	
	@FXML
	/*
	 * Event Listener für den RadioButton, wenn für die Anzahl der Spieler 6 ausgewählt wird.
	 */
	public void rbOnActionPlayer6(ActionEvent event) {
		if(rbPlayer6.isSelected()) {
			numberOfPlayers = 6;
			
			/*
			 * Hier werden die Farben Blau und Lila zur ComboBox Farben aller Spieler hinzugefügt, da hier auf dem 6er Spielfeld gespielt wird
			 * Und jeweils eine Vorauswahl der Farben getroffen
			 */
			int i = 0,j = 0;
			while (i < cbColor.size()) {
				cbColor.get(i).getItems().add("Blau");
				cbColor.get(i).getItems().add("Lila");
				cbColor.get(i).setValue("Gelb");
				i++;
			}
			
			/*
			 * Das Textfeld für den Namen und die ComboBox für die Gegnerauswahl wird für alle Spieler aktiviert
			 */
			txtName1.setDisable(false);
			cbColor1.setDisable(false);
			cbRival1.setDisable(false);
			
			txtName2.setDisable(false);
			cbColor2.setDisable(false);
			cbRival2.setDisable(false);
			
			txtName3.setDisable(false);
			cbColor3.setDisable(false);
			cbRival3.setDisable(false);
			
			txtName4.setDisable(false);
			cbColor4.setDisable(false);
			cbRival4.setDisable(false);
				
			txtName5.setDisable(false);
			cbColor5.setDisable(false);
			cbRival5.setDisable(false);
			
			txtName6.setDisable(false);
			cbColor6.setDisable(false);
			cbRival6.setDisable(false);
			
			/*
			 * Die Auswahl für die Anzahl an Spielern die nicht ausgewählt wurde, wird deaktiviert
			 */
			rbPlayer2.setDisable(true);
			rbPlayer3.setDisable(true);
			rbPlayer4.setDisable(true);
			rbPlayer5.setDisable(true);
		}
	}
	
	@FXML
	/*
	 *  Event Listener für die ComboBox Farben1.
	 */
	public void cbOnActionColor1(ActionEvent event) {
		/*
		 * Da man nur Werte die Items der jeweiligen ComboBox sind als Value setzen kann werden hier nochmal alle zur ComboBox der Farben des Spielers 2 hinzugefügt,
		 * da es ansonsten zu Fehler bei der Farbauswahl von 3 Spielern kommen würde
		 */
		cbColor2.getItems().clear();
		cbColor2.getItems().add("Gelb");
		cbColor2.getItems().add("Rot");
		cbColor2.getItems().add("Grün");
		cbColor2.getItems().add("Schwarz");
		cbColor2.getItems().add("Blau");
		cbColor2.getItems().add("Lila");
		/*
		 * Wenn die Anzahl der Spieler = 2 ist, wird die Methode setcbColor2Player2() ausgeführt.
		 */
		if(rbPlayer2.isSelected()){
			setcbColor2Player2();
		}
		/*
		 * Wenn die Anzahl der Spieler = 3 ist, wird die Methode setcbColor2Player3() ausgeführt.
		 */
		else if(rbPlayer3.isSelected()) {
			setcbColor2Player3();
			
		}
		
		
	}
	
	/*
	 * Wenn die Anzahl der Spieler = 2 ist, dürfen nur die gegenüberliegenden Farben verwendet werden. 
	 * Es wird zunächst die Auswahl für die erste Farbe überprüft und die Farbe für die zweite Farbe, also den Spieler 2 automatisch ausgewählt.
	 * Die zweite Farbe kann nicht verändert werden.
	 */
	private void setcbColor2Player2() {		
		if(cbColor1.getValue().equals("Gelb")) {
			cbColor2.setValue("Rot");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Grün")) {
			cbColor2.setValue("Schwarz");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Rot")) {
			cbColor2.setValue("Gelb");
			cbColor2.setDisable(true);
		} else if(cbColor1.getValue().equals("Schwarz")) {
			cbColor2.setValue("Grün");
			cbColor2.setDisable(true);
		}
		
	}
	
	/*
	 * Wenn die Anzahl der Spieler = 3 ist, dürfen nur die Farben verwendet werden, die nicht direkte Nachbarn sind. 
	 * Es wird zunächst die Auswahl für die erste Farbe überprüft und die Farbauswahl für die zweite Farbe neu festgelegt, also die ComboBox der Farbe des Spielers 2 jeweils neue Items gesetzt.
	 */
	private void setcbColor2Player3() {
		if(cbColor1.getValue().equals("Gelb")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Blau");
			cbColor2.getItems().add("Grün");
			cbColor2.setValue("Blau");
			cbColor3.setValue("Grün");
				
		} else if(cbColor1.getValue().equals("Grün")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Blau");
			cbColor2.setValue("Gelb");
			cbColor3.setValue("Blau");
				
		} else if(cbColor1.getValue().equals("Blau")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Gelb");
			cbColor2.getItems().add("Grün");
			cbColor2.setValue("Gelb");
			cbColor3.setValue("Grün");
		
		} else if(cbColor1.getValue().equals("Lila")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Schwarz");
			cbColor2.setValue("Rot");
			cbColor3.setValue("Schwarz");
				
		} else if(cbColor1.getValue().equals("Rot")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Lila");
			cbColor2.getItems().add("Schwarz");
			cbColor2.setValue("Lila");
			cbColor3.setValue("Schwarz");
				
		} else if(cbColor1.getValue().equals("Schwarz")) {
			cbColor2.getItems().clear();
			cbColor2.getItems().add("Rot");
			cbColor2.getItems().add("Lila");
			cbColor2.setValue("Rot");
			cbColor3.setValue("Lila");
		}
	}

	@FXML
	/*
	 *  Event Listener für die ComboBox Farben2.
	 */
	public void cbOnActionColor2(ActionEvent event) {
		
		/*
		 * Wenn die Anzahl der Spieler = 3 ist, wird die Methode setcbColor3() ausgeführt.
		 */
		if(rbPlayer3.isSelected()){
			setcbColor3();
		}
	}

	/*
	 * Es wird anschließend die Auswahl für die erste und zweite Farbe überprüft und die Farbe für die dritte Farbe, also für den Spieler 3 automatisch ausgewählt.
	 * Die dritte Farbe kann nicht verändert werden.
	 */
	public void setcbColor3() {
		if(cbColor1.getValue().equals("Gelb")) {
			if(cbColor2.getValue().equals("Grün")) {
				cbColor3.setValue("Blau");
			} else if (cbColor2.getValue().equals("Blau")){
				cbColor3.setValue("Grün");
			}	
		} else if(cbColor1.getValue().equals("Grün")) {
			if(cbColor2.getValue().equals("Blau")) {
				cbColor3.setValue("Gelb");
			} else if(cbColor2.getValue().equals("Gelb")){
				cbColor3.setValue("Blau");
			}	
		} else if(cbColor1.getValue().equals("Blau")) {
			if(cbColor2.getValue().equals("Grün")) {
				cbColor3.setValue("Gelb");
			} else if(cbColor2.getValue().equals("Gelb")){
				cbColor3.setValue("Grün");
			}		
		} else if(cbColor1.getValue().equals("Lila")) {
			if(cbColor2.getValue().equals("Rot")) {
				cbColor3.setValue("Schwarz");
			} else if (cbColor2.getValue().equals("Schwarz")){
				cbColor3.setValue("Rot");
			}				
		} else if(cbColor1.getValue().equals("Rot")) {
			if(cbColor2.getValue().equals("Lila")) {
				cbColor3.setValue("Schwarz");
			} else if (cbColor2.getValue().equals("Schwarz")){
				cbColor3.setValue("Lila");
			}	
				
		} else if(cbColor1.getValue().equals("Schwarz")) {
			if(cbColor2.getValue().equals("Rot")) {
				cbColor3.setValue("Lila");
			} else if (cbColor2.getValue().equals("Lila")){
				cbColor3.setValue("Rot");
			}	
		}
	}

	
	@FXML
	/*
	 *  Event Listener für den Button Auswahl überprüfen.
	 */
	public void buttonOnActionCheckSelection(ActionEvent event) {
		/*
		 * Zunächst muss ein RadioButton für die Anzahl an Spielern ausgewählt sein, damit es keinen Fehler bei der Überprüfung gibt
		 */
		if((!rbPlayer2.isSelected()) && (!rbPlayer3.isSelected()) && (!rbPlayer4.isSelected()) && (!rbPlayer5.isSelected()) && (!rbPlayer6.isSelected())) {
			JOptionPane.showMessageDialog(null, "Bitte wählen Sie eine Anzahl an Spielern aus.","Achtung", JOptionPane.ERROR_MESSAGE);
		}
		else {
			/*
			 * Wenn die Anzahl der Spieler = 2 ausgewählt wurde
			 */
			if(numberOfPlayers == 2) {
				/*
				 * Es wird die Methode checkSelection1and2() ausgeführt, wenn diese false zurückggibt wird eine Fehlermeldung gesendet
				 */
				if(checkSelection1and2() == true) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
				
			/*
			 * Wenn die Anzahl der Spieler = 3 ausgewählt wurde
			 */
			}else if(numberOfPlayers == 3) {
				/*
				 * Es werden die Methoden checkSelection1and2() und checkSelection3() ausgeführt, wenn diese false zurückggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true)) {
						btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Wenn die Anzahl der Spieler = 4 ausgewählt wurde
			 */
			} else if (numberOfPlayers == 4) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3() und checkSelection4() ausgeführt, wenn diese false zurückggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true)) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Wenn die Anzahl der Spieler = 5 ausgewählt wurde
			 */
			} else if (numberOfPlayers == 5) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3(), checkSelection4() und checkSelection5() ausgeführt, wenn diese false zurückggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true) && (checkSelection5()) == true) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			
			/*
			 * Wenn die Anzahl der Spieler = 6 ausgewählt wurde
			 */
			} else if (numberOfPlayers == 6) {
				/*
				 * Es werden die Methoden checkSelection1and2(), checkSelection3(), checkSelection4(), checkSelection5() und checkSelection6() ausgeführt, wenn diese false zurückggeben wird eine Fehlermeldung gesendet.
				 */
				if((checkSelection1and2() == true) && (checkSelection3() == true) && (checkSelection4() == true) && (checkSelection5() == true) && (checkSelection6() == true)) {
					btnStartGame.setDisable(false);
				} else {
					JOptionPane.showMessageDialog(null, "Bitte Überprüfen Sie Ihre Eingaben.","Achtung", JOptionPane.ERROR_MESSAGE);
				}
			}
		}
		
		//nur für Testzwecke
		System.out.println(playerName);
		System.out.println(color);
		System.out.println(rival);
		
	}
	
	
	/*
	 * Die Eingaben beim Spieler 1 und Spieler 2 werden auf Vollständigkeit und Richtigkeit überprüft.
	 * @return Es wird false zurückgegeben, wenn nicht alles richtig und vollständig ist, also die TextFelder nicht oder falsch ausgefüllt wurden, hierzu zählt auch die Eingabe von Sonderzeichen oder eine zu Große oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewählt haben
	 * @return Es wird true zurückgegeben, wenn alles richtig und vollständig ist und die Eingaben werden den ArrayList hinzugefügt
	 */
	public boolean checkSelection1and2 () {
		
		if((txtName1.getText().isEmpty()) || (txtName2.getText().isEmpty()) || (txtName2.getText().equals(txtName1.getText())) || (!txtName1.getText().matches("\\w+")) || (!txtName2.getText().matches("\\w+")) || (txtName1.getText().length() > 40) || (txtName1.getText().length() <= 1) || (txtName2.getText().length() > 40) || (txtName2.getText().length() <= 1)){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		if((cbColor1.getValue().isEmpty()) || (cbColor2.getValue().isEmpty()) || (cbColor2.getValue().equals(cbColor1.getValue()))) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}
		
		else {	
			playerName.add(txtName1.getText());
			color.add(cbColor1.getValue());
			rival.add(cbRival1.getValue());	
		
			playerName.add(txtName2.getText());
			color.add(cbColor2.getValue());
			rival.add(cbRival2.getValue());	
			return true;	
		}
	}
	
	/*
	 * Die Eingaben beim Spieler 3 werden auf Vollständigkeit und Richtigkeit überprüft.
	 * @return Es wird false zurückgegeben wenn nicht alles richtig und vollständig ist, also die TextFelder nicht oder falsch ausgefüllt wurden, hierzu zählt auch die Eingabe von Sonderzeichen oder eine zu Große oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewählt haben
	 * @return Es wird true zurückgegeben wenn alles richtig und vollständig ist und die Eingaben werden den ArrayList hinzugefügt
	 */
	public boolean checkSelection3 () {
		
		if((playerName.contains(txtName3.getText())) || (txtName3.getText().isEmpty()) || (!txtName3.getText().matches("\\w+")) || (txtName3.getText().length() > 40) || (txtName3.getText().length() <= 1)){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		// oder die Farbe3 bereits vergeben ist gibt es einen Fehler und die bisherigen Arraylist werden geleert
		if((cbColor3.getValue().isEmpty()) || (cbColor3.getValue().equals(cbColor1.getValue())) || (cbColor3.getValue().equals(cbColor2.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}
		else { 
			playerName.add(txtName3.getText());
			color.add(cbColor3.getValue());
			rival.add(cbRival3.getValue());	
			
			return true;
		} 	
	}
	
	/*
	 * Die Eingaben beim Spieler 4 werden auf Vollständigkeit und Richtigkeit überprüft.
	 * @return Es wird false zurückgegeben wenn nicht alles richtig und vollständig ist, also die TextFelder nicht oder falsch ausgefüllt wurden, hierzu zählt auch die Eingabe von Sonderzeichen oder eine zu Große oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewählt haben
	 * @return Es wird true zurückgegeben wenn alles richtig und vollständig ist und die Eingaben werden den ArrayList hinzugefügt
	 */
	public boolean checkSelection4 () {
		
		if((playerName.contains(txtName4.getText())) || (txtName4.getText().isEmpty()) || (!txtName4.getText().matches("\\w+")) || (txtName4.getText().length() > 40) || (txtName4.getText().length() <= 1)) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		
		if((cbColor4.getValue().isEmpty()) || (cbColor4.getValue().equals(cbColor1.getValue())) || (cbColor4.getValue().equals(cbColor2.getValue())) || (cbColor4.getValue().equals(cbColor3.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;			
		} 
		
		else { 
			playerName.add(txtName4.getText());
			color.add(cbColor4.getValue());	
			rival.add(cbRival4.getValue());
			
			return true;
		}	
	}
		
	/*
	 * Die Eingaben beim Spieler 5 werden auf Vollständigkeit und Richtigkeit überprüft.
	 * @return Es wird false zurückgegeben wenn nicht alles richtig und vollständig ist, also die TextFelder nicht oder falsch ausgefüllt wurden, hierzu zählt auch die Eingabe von Sonderzeichen oder eine zu Große oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewählt haben
	 * @return Es wird true zurückgegeben wenn alles richtig und vollständig ist und die Eingaben werden den ArrayList hinzugefügt
	 */
	public boolean checkSelection5 () {
		
		if((playerName.contains(txtName5.getText())) || (txtName5.getText().isEmpty()) || (!txtName5.getText().matches("\\w+")) || (txtName5.getText().length() > 40) || (txtName5.getText().length() <= 1)) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		
		if((cbColor5.getValue().isEmpty()) || (cbColor5.getValue().equals(cbColor1.getValue())) || (cbColor5.getValue().equals(cbColor2.getValue())) || (cbColor5.getValue().equals(cbColor3.getValue())) || (cbColor5.getValue().equals(cbColor4.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}	
		
		else { 
			playerName.add(txtName5.getText());
			color.add(cbColor5.getValue());	
			rival.add(cbRival5.getValue());
			
			return true;
		}
	}
		
	/*
	 * Die Eingaben beim Spieler 6 werden auf Vollständigkeit und Richtigkeit überprüft.
	 * @return Es wird false zurückgegeben wenn nicht alles richtig und vollständig ist, also die TextFelder nicht oder falsch ausgefüllt wurden, hierzu zählt auch die Eingabe von Sonderzeichen oder eine zu Große oder zu Kleine Eingabe erfolgt ist oder mehrere Spieler die gleiche Farbe gewählt haben
	 * @return Es wird true zurückgegeben wenn alles richtig und vollständig ist und die Eingaben werden den ArrayList hinzugefügt
	 */
	public boolean checkSelection6 () {
		if((playerName.contains(txtName6.getText())) || (txtName6.getText().isEmpty()) || (!txtName6.getText().matches("\\w+")) || (txtName6.getText().length() > 40) || (txtName6.getText().length() <= 1)) {
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		} 
		
		if((cbColor6.getValue().isEmpty()) || (cbColor6.getValue().equals(cbColor1.getValue())) || (cbColor6.getValue().equals(cbColor2.getValue())) || (cbColor6.getValue().equals(cbColor3.getValue())) || (cbColor6.getValue().equals(cbColor4.getValue())) || (cbColor6.getValue().equals(cbColor5.getValue()))){
			playerName.clear();
			color.clear();
			rival.clear();
			return false;
		}
		
		else { 
			playerName.add(txtName6.getText());
			color.add(cbColor6.getValue());
			rival.add(cbRival6.getValue());	
			
			return true;
			
		} 
	}
	
	@FXML		
	/*
	 *  Event Listener für den Start Button.
	 */
	public void buttonOnActionStart(ActionEvent event) {
		/*
		 * Schließen des Launcher Fensters
		 */
		Stage currentStage = (Stage)btnStartGame.getScene().getWindow();
		currentStage.close();
		
		/*
		 * Bei 3, 5 oder 6 Spielern wird das 6er Brett aufgerufen
		 */
		if((numberOfPlayers == 3) || (numberOfPlayers == 5) || (numberOfPlayers == 6)) {
			
			
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sixplayersgame/GameBoardSixPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardSixPlayersController gbsp = fxmlloader.getController(); 
				gbsp.initialize(playerName, color, rival, numberOfPlayers);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Game Board");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.setFullScreen(true);
				secondaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		} else {
						
			/*
			 * Bei 2 oder 4 Spielern wird das 4er Brett aufgerufen
			 */			
			try {
				FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/fourplayersgame/GameBoardFourPlayers.fxml"));
				Parent root = fxmlloader.load();
				GameBoardFourPlayersController gbfp = fxmlloader.getController(); 
				gbfp.initialize(playerName, color, rival, numberOfPlayers);
				Stage secondaryStage = new Stage();
				secondaryStage.setTitle("Game Board");
				secondaryStage.setScene(new Scene(root, 600, 450)); 
				secondaryStage.setFullScreen(true);
				secondaryStage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		} 
	}
	
	@FXML
	/*
	 *  Event Listener für den Button Spiel beenden.
	 *  Dieser schließt das Programm
	 */
	public void buttonOnActionExit(ActionEvent event) {
		
		System.exit(0);
	}
}
