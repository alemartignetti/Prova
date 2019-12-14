package it.unina.prova.entity;

import java.sql.Date;

public class DataEsame {
	private java.sql.Date data;
	private String luogo;
	private TipoProva tipo;
	
	public DataEsame() {
		java.util.Date d = new java.util.Date();
		data = new java.sql.Date(d.getTime());
		luogo = "";
		tipo = TipoProva.GENERICA;
	}
	
	@SuppressWarnings("deprecation")
	public DataEsame(int year, int month, int day, String luogo, TipoProva tipo) {
		this.data = new java.sql.Date(year - 1900, month + 1, day);
		this.luogo = luogo;
		this.tipo = tipo;
	}

	public String getLuogo() {
		return luogo;
	}

	public void setLuogo(String luogo) {
		this.luogo = luogo;
	}

	public TipoProva getTipo() {
		return tipo;
	}

	public void setTipo(TipoProva tipo) {
		this.tipo = tipo;
	}

	public java.sql.Date getData() {
		return data;
	}

	
}
