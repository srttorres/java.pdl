package es.upm.fi.pdl;
public enum Simbolo {
	
	pr1(0),
	pr2(1),
	pr3(2),
	pr4(3),
	pr5(4),
	pr6(5),
	pr7(6),
	pr8(7),
	pr9(8),
	pr10(9),
	pr11(10),
	pr12(11),
	pr13(12),
	eof(13),
    COMA(14),
    PYCOMA(15),
    PARENTESIS_A(16),
	PARENTESIS_C(17),
	LLAVE_A(18),
	LLAVE_C(19),
	OP_ARIT_SUMA(20),
	OP_REL_IGUAL(21),
	OP_LOG_AND(22),
	ASIG_SIMPLE(23),
	ASIG_SUMA(24),
	CADENA(25),
	PALABRA_RESERVADA(26),
	IDENTIFICADOR(27),
	ENTERO(28),
	DOLLAR(29);
	
	
	public final int id;
	Simbolo (int id){
		this.id = id;
	}
}