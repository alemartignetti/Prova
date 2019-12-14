package it.unina.prova.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.unina.prova.control.GestoreDati;
import it.unina.prova.entity.*;

class GestoreDatiTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		GestoreDati.creaDocente("Roberto", "Natella", "D01");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test1() {
		GestoreDati.creaCorso("IS", "Ingegneria del Software", 9, "D01");
		int idAppello = GestoreDati.creaAppello(2019, 12, 19, "SG-T1", TipoProva.ORALE, "IS");
		GestoreDati.creaStudente("Luca", "Rossi", "N46");
		GestoreDati.prenotaAppello("N46", "IS", idAppello);
		
		Studente studenteTest = new Studente("Luca","Rossi","N46");
		
		ArrayList<Studente> risultati = GestoreDati.visualizzaPrenotati("IS", 1);
		
		assertEquals(risultati.size(),1);
		
		for (Studente s : risultati)
			assertEquals(true,s.equals(studenteTest));
		
	}

}
