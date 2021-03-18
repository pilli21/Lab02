package it.polito.tdp.alien;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {
	
	AlienDictionary dizionario=new AlienDictionary();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtParole;

    @FXML
    private Button btnTranslate;

    @FXML
    private TextArea txtRisultato;

    @FXML
    private Button btnReset;

    @FXML
    void doReset(ActionEvent event) {
    	txtRisultato.clear();
    }

    @FXML
    void doTranslate(ActionEvent event) {

    	String parole= txtParole.getText().toLowerCase();
    	if(!parole.matches("[a-zA-Z? ]*")) {
    		txtRisultato.appendText("Errore inserimento!\n");
    		return;
    	}
    	if(parole.contains(" ")) {
    		try {
    			String s[]=parole.split(" ");
        		dizionario.addWord(s[0],s[1]);
    		}
    		catch(ArrayIndexOutOfBoundsException e) {
    			txtRisultato.appendText("Errore inserimento!\n");
    		}
    	}
    	else {
    		String ris = dizionario.translateWord(parole);
    		if(ris!=null) {
    			txtRisultato.appendText(parole+" Traduzione: "+ris+"\n");
    		}
    		else {
    			txtRisultato.appendText("Parola non presente nel dizionario!"+"\n");
    		}
    	}
    	
    }

    @FXML
    void initialize() {
        assert txtParole != null : "fx:id=\"txtParole\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnTranslate != null : "fx:id=\"btnTranslate\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtRisultato != null : "fx:id=\"txtRisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
