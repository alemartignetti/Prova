package it.unina.prova.entity;

public class Studente {

	private String nome;
	private String cognome;
	private String matricola;

	public Studente(String nome, String cognome, String matricola) {
		this.nome = nome;
		this.cognome = cognome;
		this.matricola = matricola;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public String getMatricola() {
		return matricola;
	}

	public void setMatricola(String matricola) {
		this.matricola = matricola;
	}
	
	public String toString() {
		return cognome + " " + nome + " " + matricola;
	}
	
	public boolean equals(Studente s) {
		if (s.getMatricola().equals(matricola) &&
			s.getNome().equals(nome) &&
			s.getCognome().equals(cognome)) 
		{
			return true;
		} else
			return false;
	}

}
