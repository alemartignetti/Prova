package it.unina.prova;

import it.unina.prova.control.GestoreDati;
import it.unina.prova.entity.*;

public class Main {

	public static void main(String[] args) {
		
		GestoreDati gestoreMain = new GestoreDati();
		
		gestoreMain.creaDocente("Roberto", "Natella", "D1");
		gestoreMain.creaDocente("Umberto", "De Maio", "D2");
		gestoreMain.creaDocente("Luca", "Maresca", "D3");
		
		gestoreMain.creaCorso("IS", "Ingegneria del Software", 9, "D1");
		gestoreMain.creaCorso("AM1", "Analisi I", 9, "D2");
		gestoreMain.creaCorso("EG", "Elettronica", 9, "D3");
		
		gestoreMain.creaStudente("Alessio", "Martignetti", "N46");
		gestoreMain.creaStudente("Manuel", "Maddaluno", "N47");
		gestoreMain.creaStudente("Domenico", "Palladino", "N48");
		
		int appelloEG = gestoreMain.creaAppello(2019, 12, 16, "SG-T2", TipoProva.SCRITTA, "EG");
		int appelloAM1 = gestoreMain.creaAppello(2020, 1, 21, "SG-I2", TipoProva.SCRITTA, "AM1");
		int appelloIS = gestoreMain.creaAppello(2019, 12, 19, "SG-I1", TipoProva.AL_CALCOLATORE, "IS");
		gestoreMain.creaAppello(2020, 2, 5, "SG-II1", TipoProva.SCRITTA, "IS");
		
		gestoreMain.creaData(2020, 1, 23, "SG-II4", TipoProva.ORALE, "AM1", appelloAM1);
		gestoreMain.creaData(2020, 1, 14, "SG-I4", TipoProva.ORALE, "IS", appelloIS);
		
		gestoreMain.prenotaAppello("N46", "EG", appelloEG);
		gestoreMain.prenotaAppello("N46", "IS", appelloIS);
		gestoreMain.prenotaAppello("N47", "EG", appelloEG);
		gestoreMain.prenotaAppello("N47", "IS", appelloIS);
		gestoreMain.prenotaAppello("N48", "EG", appelloEG);
		gestoreMain.prenotaAppello("N48", "AM1", appelloAM1);
		
		System.out.println("**********Prenotati EG:**********");
		for (Studente s : gestoreMain.visualizzaPrenotati("EG", appelloEG)) {
			System.out.println(s.toString());
		}
		System.out.println("**********Prenotati IS:**********");
		for (Studente s : gestoreMain.visualizzaPrenotati("IS", appelloIS)) {
			System.out.println(s.toString());
		}
		System.out.println("**********Prenotati AM1:**********");
		for (Studente s : gestoreMain.visualizzaPrenotati("AM1", appelloAM1)) {
			System.out.println(s.toString());
		}
		
		System.out.println("**********Appelli EG:**********");
		for (Appello a : gestoreMain.visualizzaAppelli("EG")) {
			System.out.println(a.toString());
		}
		System.out.println("**********Appelli AM1:**********");
		for (Appello a : gestoreMain.visualizzaAppelli("AM1")) {
			System.out.println(a.toString());
		}
		System.out.println("**********Appelli IS:**********");
		for (Appello a : gestoreMain.visualizzaAppelli("IS")) {
			System.out.println(a.toString());
		}
		
	}

}
