package es.upm.fi.pdl;

public class Estado {
	private int numero;
	private String axioma;
	
	public Estado() {
		this.numero = 0;
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
}
