package it.polito.tdp.alien.model;

import java.util.ArrayList;
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
	
	private Map<String, ArrayList<String>> dizionario;
	
	public AlienModel() {
		dizionario = new HashMap<String, ArrayList<String>>();
	}
	
	/**
	 * Ritorna la traduzione di una parola inserita
	 * @param entry La parola di cui avere la traduzione
	 * @return La parola se trovata, null altrimenti
	 */
	public String translate(String entry) {
		if (entry.contains("?"))
		for (char c='a'; c<='z'; c++) {
			if (dizionario.containsKey(entry.replace("?", ""+c))) {
				String elencotraduzioni = new String();
				for (String s : dizionario.get(entry.replace("?", ""+c)))
					elencotraduzioni += s+"\n";
						return elencotraduzioni;
			}
		} 
		if (dizionario.containsKey(entry)) {
			String elencotraduzioni = new String();
			for (String s : dizionario.get(entry))
				elencotraduzioni += s+"\n";
					return elencotraduzioni;
		}
		return null;
	}
	
	/**
	 * Aggiunge una parola al dizionario
	 * @param parola
	 * @param traduzione
	 */
	public void addParola(String parola, String traduzione) {
		if (dizionario.containsKey(parola)!=true) {
			ArrayList<String> temp = new ArrayList<String>();
			temp.add(traduzione);
			dizionario.put(parola, temp);
		}
		else if (dizionario.containsKey(parola)) {
			if (!dizionario.get(parola).contains(traduzione)) {
				ArrayList<String> temp = new ArrayList<String>(dizionario.get(parola));
				temp.add(traduzione);
				dizionario.put(parola, temp);
			}
		}
	}
	
	public void clearMap() {
		this.dizionario.clear();
	}

}
