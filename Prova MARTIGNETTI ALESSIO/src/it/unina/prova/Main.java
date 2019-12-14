package it.unina.prova;

import it.unina.prova.control.GestoreDati;
import it.unina.prova.entity.*;

public class Main {

	public static void main(String[] args) {
		GestoreDati.creaDocente("Roberto", "Natella", "D1");
		GestoreDati.creaDocente("Umberto", "De Maio", "D2");
		GestoreDati.creaDocente("Luca", "Maresca", "D3");
		
		GestoreDati.creaCorso("IS", "Ingegneria del Software", 9, "D1");
		GestoreDati.creaCorso("AM1", "Analisi I", 9, "D2");
		GestoreDati.creaCorso("EG", "Elettronica", 9, "D3");
		
		GestoreDati.creaStudente("Alessio", "Martignetti", "N46");
		GestoreDati.creaStudente("Manuel", "Maddaluno", "N47");
		GestoreDati.creaStudente("Diodato", "Todisco", "N48");
		
		int appelloEG = GestoreDati.creaAppello(2019, 12, 16, "SG-T2", TipoProva.SCRITTA, "EG");
		int appelloAM1 = GestoreDati.creaAppello(2020, 1, 21, "SG-I2", TipoProva.SCRITTA, "AM1");
		int appelloIS = GestoreDati.creaAppello(2019, 12, 19, "SG-I1", TipoProva.AL_CALCOLATORE, "IS");
		
		GestoreDati.creaData(2020, 1, 23, "SG-II4", TipoProva.ORALE, "AM1", appelloAM1);
		
		GestoreDati.prenotaAppello("N46", "EG", appelloEG);
		GestoreDati.prenotaAppello("N46", "IS", appelloIS);
		GestoreDati.prenotaAppello("N47", "EG", appelloEG);
		GestoreDati.prenotaAppello("N47", "IS", appelloIS);
		GestoreDati.prenotaAppello("N48", "EG", appelloEG);
		GestoreDati.prenotaAppello("N48", "AM1", appelloAM1);
		
		System.out.println("**********Prenotati EG:**********");
		for (Studente s : GestoreDati.visualizzaPrenotati("EG", appelloEG)) {
			System.out.println(s.toString());
		}
		System.out.println("**********Prenotati IS:**********");
		for (Studente s : GestoreDati.visualizzaPrenotati("IS", appelloIS)) {
			System.out.println(s.toString());
		}
		System.out.println("**********Prenotati AM1:**********");
		for (Studente s : GestoreDati.visualizzaPrenotati("AM1", appelloAM1)) {
			System.out.println(s.toString());
		}
		
		System.out.println("**********Appelli EG:**********");
		for (Appello a : GestoreDati.visualizzaAppelli("EG")) {
			System.out.println(a.toString());
		}
		System.out.println("**********Appelli AM1:**********");
		for (Appello a : GestoreDati.visualizzaAppelli("AM1")) {
			System.out.println(a.toString());
		}
		
	}

}
