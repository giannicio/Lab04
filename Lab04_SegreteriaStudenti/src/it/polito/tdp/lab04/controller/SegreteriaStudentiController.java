package it.polito.tdp.lab04.controller;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;

import it.polito.tdp.lab04.model.Corso;
import it.polito.tdp.lab04.model.Model;
import it.polito.tdp.lab04.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SegreteriaStudentiController {

	private Model model;
	private List<Corso> corsi;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<Corso> elencoCorsi;

    @FXML
    private Button btnCercaIscritti;

    @FXML
    private TextField txtMatricola;

    @FXML
    private Button btnAutoCompl;

    @FXML
    private TextField nome;

    @FXML
    private TextField cognome;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnIscrivi;

    @FXML
    private TextArea txtResult;

    @FXML
    private Button btnReset;

    @FXML
    void doAutoCompl(ActionEvent event) {
    	int matricola = Integer.parseInt(txtMatricola.getText());
    	Studente s = model.getTuttoStudente(matricola);
    	nome.setText(s.getNome());
    	cognome.setText(s.getCognome());
    	// inserire un controllo sulla matricola, se non c'è nel database --> mostra errore
    }

    @FXML
    void doCercaCorsi(ActionEvent event) {

    	int matricola = Integer.parseInt(txtMatricola.getText());
    	List<Corso> listaCorsiIscritto = model.getCorsiIscrittoStudente(matricola);
    		if(model.getTuttoStudente(matricola) != null) {
		    	for (Corso c: listaCorsiIscritto) {
		    		txtResult.appendText(c.toString2() + "\n");
		    	}
    		}
			else {
				txtResult.setText("Inserire numero di matricola corretto!");
				}
    }
    
    

    @FXML
    void doCercaIscritti(ActionEvent event) {
    	Corso corso = elencoCorsi.getValue();
    	if (corso.getNome() == null) {
			txtResult.setText("Selezionare un corso.");
			return;
		}
    	List<Studente> studentiIscritti = model.getIscritti(corso);
    	for(Studente s: studentiIscritti) {
    		txtResult.appendText(s.toString2()+ "\n");
    	}
    	System.out.print(studentiIscritti.size());
    	
    }

    @FXML
    void doElencoCorsi(ActionEvent event) {
    	// Ottieni tutti i corsi dal model
    	corsi = model.getCorsi();
    	
    	// Aggiungi tutti i corsi alla ComboBox
    	elencoCorsi.getItems().addAll(corsi);  
    	Corso corso = elencoCorsi.getValue();
    	
    	String nomeCorso = corso.getNome();
    	
    }

    @FXML
    void doIscrivi(ActionEvent event) {

    }

    @FXML
    void doReset(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert elencoCorsi != null : "fx:id=\"elencoCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaIscritti != null : "fx:id=\"btnCercaIscritti\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtMatricola != null : "fx:id=\"matricola\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnAutoCompl != null : "fx:id=\"btnAutoCompl\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert nome != null : "fx:id=\"nome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert cognome != null : "fx:id=\"cognome\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnIscrivi != null : "fx:id=\"btnIscrivi\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
        assert btnReset != null : "fx:id=\"btnReset\" was not injected: check your FXML file 'SegreteriaStudenti.fxml'.";
    
    }

	public void setModel(Model model) {
		this.model = model;
		 elencoCorsi.getItems().addAll(model.getCorsi());
	}
    
    
    
}
