package it.unina.prova.control;

import java.util.ArrayList;
import it.unina.prova.entity.*;

public class GestoreDati {

	private ArrayList<Docente> docenti = new ArrayList<Docente>();
	private ArrayList<Corso> corsi = new ArrayList<Corso>();
	private ArrayList<Studente> studenti = new ArrayList<Studente>();
	
	public void creaCorso(String codiceCorso, String nome, int crediti, String codiceDocente) {
		for (Docente d : docenti) {
			if (d.getCodiceDocente().equals(codiceDocente)) {
				corsi.add(new Corso(codiceCorso,nome,crediti,d));
			}
		}
	}
	
	public void creaDocente(String nome, String cognome, String codiceDocente) {
		for (Docente d : docenti) {
			if (d.getCodiceDocente().equals(codiceDocente))
				return;
		}
		docenti.add(new Docente(nome,cognome,codiceDocente));
	}
	
	public void creaStudente(String nome, String cognome, String matricola) {
		for (Studente s : studenti) {
			if (s.getMatricola().equals(matricola))
				return;
		}
		studenti.add(new Studente(nome,cognome,matricola));
	}
	
	public int creaAppello(int year, int month, int day, String luogo, TipoProva tipo, String codiceCorso) {
		for (Corso c : corsi) {
			if (c.getCodiceCorso().equals(codiceCorso)) {
				return c.aggiungiAppello(year, month, day, luogo, tipo); //ritorna id appello creato
			}
		}
		return 0;
	}
	
	public void creaData(int year, int month, int day, String luogo, TipoProva tipo, String codiceCorso, int idAppello) {
		for (Corso c : corsi) {
			if (c.getCodiceCorso().equals(codiceCorso)) {
				c.aggiungiData(year, month, day, luogo, tipo, idAppello);
			}
		}
	}
	
	public ArrayList<Appello> visualizzaAppelli(String codiceCorso) {
		ArrayList<Appello> risultati = new ArrayList<Appello>();
		for (Corso c : corsi) {
			if (c.getCodiceCorso().equals(codiceCorso)) {
				risultati = c.getAppelli();
			}
		}
		return risultati;
	}
	
	public ArrayList<Studente> visualizzaPrenotati(String codiceCorso, int idAppello) {
		ArrayList<Studente> risultati = new ArrayList<Studente>();
		for (Appello a : visualizzaAppelli(codiceCorso)) {
			if (a.getId() == idAppello) {
				risultati = a.getPrenotati();
			}
		}
		return risultati;
	}
	
	public void prenotaAppello(String matricola, String codiceCorso, int idAppello) {
		for (Studente s : studenti) {
			if (s.getMatricola().equals(matricola)) {
				for (Appello a : visualizzaAppelli(codiceCorso)) {
					if (a.getId() == idAppello) {
						for (Studente s1 : a.getPrenotati()) {
							if (s1.getMatricola().equals(matricola))
								return;
						}
						a.aggiungiStudente(s);
						return;
					}
				}
			}
		}
		return;
	}
	
	public void clear() {
		docenti.clear();
		studenti.clear();
		corsi.clear();
	}

}
