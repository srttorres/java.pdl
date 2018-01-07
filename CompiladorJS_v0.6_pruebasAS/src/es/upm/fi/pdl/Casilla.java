package es.upm.fi.pdl;


public class Casilla {
	int op;
	//op 0 error
	//op 1 Desplazar
	//op 2 Reducir
	int num;
	//numero de estado o regla por la que reduce
	int accion;
	//accion semántica identificada por un número
	
	public Casilla() {
		op = 0;
		num = 99;
		accion = 0;
	}
	public Casilla(int op, int num, int accion) {
		this.op = op;
		this.num = num;
		this.accion = accion;
	}
}
