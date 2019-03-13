package it.polito.tdp.alien.model;

import java.util.HashMap;
import java.util.Map;

public class AlienModel {
	
	// Possibilità aggiunta nuove parole e ricerca di esistenti
	// L'utente deve poter inserire una nuova parola e la sua 
	// traduzione nel formato <PAROLA> <TRADUZIONE>
	// cliccando sul bottone translate questa viene aggiunta al dizionario
	// Inserendo una sola parola e premendo sul bottone translate
	// visualizzo nell'area sottostante la traduzione
	// controllo di errore sull'input (ammetto solo lettere)
	// ricerca case insensitive
	
	private Map<String, String> dizionario;
	
	public AlienModel() {
		dizionario = new HashMap<String, String>();
	}
	
	/**
	 * Ritorna la traduzione di una parola inserita
	 * @param entry La parola di cui avere la traduzione
	 * @return La parola se trovata, null altrimenti
	 */
	public String translate(String entry) {
		if (dizionario.containsKey(entry))
			return dizionario.get(entry);
		return null;
	}
	
	/**
	 * Aggiunge una parola al dizionario
	 * @param parola
	 * @param traduzione
	 */
	public void addParola(String parola, String traduzione) {
		if (!dizionario.containsKey(parola))
			dizionario.put(parola, traduzione);
	}
	
	public void clearMap() {
		this.dizionario.clear();
	}

}
