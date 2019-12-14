package it.unina.prova.entity;

public class Docente {
	
	private String nome;
	private String cognome;
	private String codiceDocente;

	public Docente(String nome, String cognome, String codiceDocente) {
		this.nome = nome;
		this.cognome = cognome;
		this.codiceDocente = codiceDocente;
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

	public String getCodiceDocente() {
		return codiceDocente;
	}

	public void setCodiceDocente(String codiceDocente) {
		this.codiceDocente = codiceDocente;
	}
	
	public String toString() {
		return cognome + " " + nome + " " + codiceDocente;
	}

}
