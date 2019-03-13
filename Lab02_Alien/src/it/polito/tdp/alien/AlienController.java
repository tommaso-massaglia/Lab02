package it.polito.tdp.alien;

/**
 * Sample Skeleton for 'Alien.fxml' Controller Class
 */



import java.net.URL;
import java.util.ResourceBundle;

import it.polito.tdp.alien.model.AlienModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class AlienController {
	
	private AlienModel model;
	
    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField txtWord;
    @FXML
    private TextArea txtResult;
    @FXML
    private Button btnTranslate;
    @FXML
    private Button btnReset;
        
    
    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
    	assert txtWord != null : "fx:id=\"txtWord\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnTranslate != null : "fx:id=\"bntTranslate\" was not injected: check your FXML file 'Alien.fxml'.";
    	assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'Alien.fxml'.";
    	
    }
  
    
    @FXML
    void doTranslate(ActionEvent event) {
    	this.function();
    }
    	
    @FXML
    void doTranslateEnter(KeyEvent event) {
    	if(event.getCode() == KeyCode.ENTER)
			this.function();
    }
    
    void function() {
    	
    	if (this.isAlpha(txtWord.getText().replaceAll(" ", ""))==false) {
    		txtResult.appendText("AGGIUNTI CARATTERI NON SUPPORTATI\n");
    		return;
    	}
    	
    	String[] entry = txtWord.getText().trim().toLowerCase().split(" ");
    	
    	if (entry.length>2) {
    		txtResult.appendText("TROPPE PAROLE INSERITE\n");
    		return;
    	}
    	
    	
    	if (entry.length==1) {
    		String traduzione = model.translate(entry[0]);
    		if (traduzione!=null)
    			txtResult.appendText(traduzione+"\n");
    		else 
    			txtResult.appendText("PAROLA NON PRESENTE\n");
    	}    	
    	if (entry.length==2) {
    		model.addParola(entry[0], entry[1]);
    		txtResult.appendText("AGGIUNTA NUOVA PAROLA AL DIZIONARIO\n");
    	}
    	
    }
    
    
    @FXML
    void doReset(ActionEvent event) {
    	
    	txtResult.clear();
    	txtWord.clear();
    	model.clearMap();
    	    	
    }
    
    public void setModel(AlienModel model) {
		this.model = model;
	}
    
    public boolean isAlpha(String name) {
        char[] chars = name.toCharArray();
        int istanze = 1;

        for (char c : chars) {
            if(!Character.isLetter(c) && c!='?') {
            	if (c=='?')
            		istanze++;
                return false;
            }
        }
        
        if (istanze>1) {
        	return false;
        }

        return true;
    }
}
