package es.upm.fi.pdl;

public class Token {
	
private static int identificador;

public static int getIdentificador() {
	return identificador;
}

public static void setIdentificador(int identificador) {
	Token.identificador = identificador;
}

public static String getValor() {
	return valor;
}

public static void setValor(String valor) {
	Token.valor = valor;
}

private static String valor;//Puede ser un lexema
							//o un puntero a TS
							//o un entero. 
							//En cada caso habrá que hacer una conversión de tipo
public Token(int id, String value) {
	this.identificador = id;

	if (value!=null)
		this.valor = value;
	}

static final int  EOF 				= 1;
static final int  COMA 				= 3;
static final int  PYCOMA			= 4;
static final int  PARENTESIS_A 		= 5;
static final int  PARENTESIS_C 		= 6;
static final int  LLAVE_A			= 7;
static final int  LLAVE_C			= 8;
static final int  OP_ARIT_SUMA		= 51;
static final int  OP_REL_IGUAL		= 52;
static final int  OP_LOG_AND		= 53;
static final int  ASIG_SIMPLE		= 61;
static final int  ASIG_SUMA			= 62;	
static final int  CADENA			= 71;
static final int  PALABRA_RESERVADA	= 81;
static final int  IDENTIFICADOR		= 82;	
static final int  ENTERO			= 91;

public String toString() {
	String s = "";
	switch(this.identificador) {
	case EOF: 
		s = "<EOF,>";
		break;
	case COMA: 
		s = "<COMA,>";
		break;
	case PYCOMA:
		s = "<PYCOMA,>";
		break;
	case PARENTESIS_A :
		s = "<PARENTESIS_A,>";
		break;
	case PARENTESIS_C :
		s = "<PARENTESIS_C,>";
		break;
	case LLAVE_A:
		s = "<LLAVE_A,>";
		break;
	case LLAVE_C:
		s = "<LLAVE_C,>";
		break;
	case OP_ARIT_SUMA:
		s = "<OP_ARIT_SUMA,>";
		break;
	case OP_REL_IGUAL:
		s = "<OP_REL_IGUAL,>";
		break;
	case OP_LOG_AND:
		s = "<OP_LOG_AND,>";
		break;
	case ASIG_SIMPLE:
		s = "<ASIG_SIMPLE,>";
		break;
	case ASIG_SUMA:
		s = "<ASIG_SUMA,>";
		break;
	case CADENA:
		s = "<CADENA,"+this.valor+">";
		break;
	case PALABRA_RESERVADA:		
		s = "<PALABRA_RESERVADA,"+this.valor+">";
		break;
	case IDENTIFICADOR:
		s = "<IDENTIFICADOR,"+this.valor+">";
		break;
	case ENTERO:
		s = "<ENTERO,"+this.valor+">";
		break;
	}
	return s;
	
}




}
