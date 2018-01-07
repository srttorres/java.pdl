package es.upm.fi.pdl;


public class Estado {
	private int numero;
	private String axioma;
	private String lexema;
	private int valor;
	public Estado() {
		this.numero = 0;
	}
	


public String getLexema() {
		return lexema;
	}
public void setLexema(String lexema) {
		this.lexema = lexema;
	}
public int getEstado() {
	return numero;
}
public void setEstado(int numero) {
	this.numero = numero;
}
public String getAxioma() {
	return axioma;
}
public void setAxioma(String axioma) {
	this.axioma = axioma;
}



public void setValor(int e) {
	this.valor = e;
	
}



public int getValor() {
	return valor;
}
}
