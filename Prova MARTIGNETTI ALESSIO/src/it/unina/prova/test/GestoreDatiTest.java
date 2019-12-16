package it.unina.prova.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.AfterEach;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unina.prova.control.GestoreDati;
import it.unina.prova.entity.*;

class GestoreDatiTest {

	GestoreDati gestoreTest;

	@BeforeEach
	void setUp() throws Exception {
		gestoreTest = new GestoreDati();
		gestoreTest.creaDocente("Roberto", "Natella", "D01");
	}

	@AfterEach
	void tearDown() throws Exception {
		gestoreTest.clear();
	}

	@Test
	void test1() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		gestoreTest.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");
		gestoreTest.creaStudente("Luca", "Rossi", "N46");
		gestoreTest.prenotaAppello("N46", "IS", 1);

		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("IS", 1);

		assertEquals(1, risultati.size());

		assertEquals(true, risultati.get(0).equals(new Studente("Luca", "Rossi", "N46")));
	}

	@Test
	void test2() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		gestoreTest.creaCorso("SO", "Sistemi Operativi", 9, "D01");

		// appelli IS
		gestoreTest.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");
		gestoreTest.creaAppello(2020, 1, 10, "SG-T2", TipoProva.SCRITTA, "IS");
		// appelli SO
		gestoreTest.creaAppello(2020, 1, 27, "SG-I2", TipoProva.AL_CALCOLATORE, "SO");
		gestoreTest.creaAppello(2020, 2, 17, "SG-T4", TipoProva.AL_CALCOLATORE, "SO");

		gestoreTest.creaStudente("Luca", "Rossi", "N46");
		gestoreTest.creaStudente("Marco", "Bini", "N47");

		gestoreTest.prenotaAppello("N46", "SO", 1);
		gestoreTest.prenotaAppello("N46", "SO", 2);
		gestoreTest.prenotaAppello("N46", "IS", 1);
		gestoreTest.prenotaAppello("N46", "IS", 2);

		gestoreTest.prenotaAppello("N47", "SO", 1);
		gestoreTest.prenotaAppello("N47", "SO", 2);
		gestoreTest.prenotaAppello("N47", "IS", 1);
		gestoreTest.prenotaAppello("N47", "IS", 2);

		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("IS", 1);

		assertEquals(2, risultati.size());

		assertEquals(true, risultati.get(0).equals(new Studente("Luca", "Rossi", "N46")));
		assertEquals(true, risultati.get(1).equals(new Studente("Marco", "Bini", "N47")));
	}

	@Test
	void test3() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		gestoreTest.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");

		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("IS", 1);

		assertEquals(0, risultati.size());
	}

	@Test
	void test4() {
		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("IS", 1);

		assertEquals(0, risultati.size());
	}

	@Test
	void test5() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		gestoreTest.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");
		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("SO", 1);

		assertEquals(0, risultati.size());
	}

	@Test
	void test6() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		gestoreTest.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");
		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("IS", 2);

		assertEquals(0, risultati.size());
	}

	@Test
	void test7() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		gestoreTest.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");
		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati(null, 1);

		assertEquals(0, risultati.size());
	}

	@Test
	void test8() {
		gestoreTest.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		ArrayList<Studente> risultati = gestoreTest.visualizzaPrenotati("IS", 1);

		assertEquals(0, risultati.size());
	}

}
