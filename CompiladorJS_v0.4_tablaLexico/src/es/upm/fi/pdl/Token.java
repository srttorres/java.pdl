package es.upm.fi.pdl;

public class Token {
	
private static int identificador;
private static String nombre;
private static String valor;//Puede ser un lexema
							//o un puntero a TS
							//o un entero. 
							//En cada caso habr� que hacer una conversi�n de tipo
public Token(int id, String name, String value) {
	this.identificador = id;
	this.nombre = name;
	if (value!=null)
		this.valor = value;
	}
}
