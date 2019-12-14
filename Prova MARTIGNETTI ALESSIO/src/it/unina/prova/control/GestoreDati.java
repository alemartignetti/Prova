package it.unina.prova.control;

import java.util.ArrayList;
import it.unina.prova.entity.*;

public abstract class GestoreDati {

	static private ArrayList<Docente> docenti = new ArrayList<Docente>();
	static private ArrayList<Corso> corsi = new ArrayList<Corso>();
	static private ArrayList<Studente> studenti = new ArrayList<Studente>();
	
	static public void creaCorso(String codiceCorso, String nome, int crediti, String codiceDocente) {
		for (Docente d : docenti) {
			if (d.getCodiceDocente().equals(codiceDocente)) {
				corsi.add(new Corso(codiceCorso,nome,crediti,d));
			}
		}
	}
	
	static public void creaDocente(String nome, String cognome, String codiceDocente) {
		docenti.add(new Docente(nome,cognome,codiceDocente));
	}
	
	static public void creaStudente(String nome, String cognome, String matricola) {
		studenti.add(new Studente(nome,cognome,matricola));
	}
	
	static public int creaAppello(int year, int month, int day, String luogo, TipoProva tipo, String codiceCorso) {
		for (Corso c : corsi) {
			if (c.getCodiceCorso().equals(codiceCorso)) {
				return c.aggiungiAppello(year, month, day, luogo, tipo); //ritorna id appello creato
			}
		}
		return 0;
	}
	
	static public void creaData(int year, int month, int day, String luogo, TipoProva tipo, String codiceCorso, int idAppello) {
		for (Appello a : visualizzaAppelli(codiceCorso)) {
			if (a.getId() == idAppello) {
				a.aggiungiData(year, month, day, luogo, tipo);
			}
		}
		return;
	}
	
	static public ArrayList<Appello> visualizzaAppelli(String codiceCorso) {
		ArrayList<Appello> risultati = new ArrayList<Appello>();
		for (Corso c : corsi) {
			if (c.getCodiceCorso().equals(codiceCorso)) {
				risultati = c.getAppelli();
			}
		}
		return risultati;
	}
	
	static public ArrayList<Studente> visualizzaPrenotati(String codiceCorso, int idAppello) {
		ArrayList<Studente> risultati = new ArrayList<Studente>();
		for (Appello a : visualizzaAppelli(codiceCorso)) {
			if (a.getId() == idAppello) {
				risultati = a.getPrenotati();
			}
		}
		return risultati;
	}
	
	static public void prenotaAppello(String matricola, String codiceCorso, int idAppello) {
		for (Studente s : studenti) {
			if (s.getMatricola().equals(matricola)) {
				for (Appello a : visualizzaAppelli(codiceCorso)) {
					if (a.getId() == idAppello) {
						a.aggiungiStudente(s);
					}
				}
			}
		}
		return;
	}

}
