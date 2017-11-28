package es.upm.fi.pdl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalizadorLexico {
	static int caracteresRestantes;//se inicializar� a cero//en caso de ser -1 se ha llegado a final de fichero
	static boolean tokenEncontrado;//se inicializar� a falso
	static boolean aperturaComillas;//sirve para distinguir un caso de letras normales de uno de cadena
	static FileWriter fw;
	public static final int  EOF 				= 1;
	public static final int  COMA 				= 3;
	public static final int  PYCOMA				= 4;
	public static final int  PARENTESIS_A 		= 5;
	public static final int  PARENTESIS_C 		= 6;
	public static final int  LLAVE_A			= 7;
	public static final int  OP_ARIT_SUMA		= 51;
	public static final int  OP_REL_IGUAL		= 52;
	public static final int  OP_LOG_AND			= 53;
	public static final int  ASIG_SIMPLE		= 61;
	public static final int  ASIG_SUMA			= 62;	
	public static final int  CADENA				= 71;
	public static final int  PALABRA_RESERVADA	= 81;
	public static final int  IDENTIFICADOR		= 82;	
	public static final int  ENTERO				= 91;
	
	
	public AnalizadorLexico() {
		caracteresRestantes = 0;
		tokenEncontrado = false;
	}
	
	public Token ejecutar(FileReader fr) throws IOException {
		tokenEncontrado = false; 
		Token t = null;
		Estado estadoActual = new Estado();//empezamos en el estado 0
		char [] siguienteCaracter = new char[1]; 
		char [] lexema = new char[512];//el tama�o podr�a estar en un fichero de configuraci�n		
		do {
			System.out.println(siguienteCaracter[0]);//BEACON
			caracteresRestantes = fr.read(siguienteCaracter);
			estadoActual = aplicarMatrizTransicion(siguienteCaracter[0], estadoActual);
			
		}
			while((caracteresRestantes != -1) && !tokenEncontrado );
        if (fr != null) {fr.close();}
        //importante cerrar descriptor de fichero (FileReader y FileWriter)
	     return t;
	}
	
	private Estado aplicarMatrizTransicion(char c, Estado estadoActual) {
		Estado estadoSiguiente = new Estado();
		switch (estadoActual.getEstado()) {
		case 0:/**inicio*/ 			
			switch (c) {
			//caso de EOF tratado en la condici�n de llamada a la funci�n aplicarMatrizTransicion()
			case ' '://espacio, no genera token
				break;
			case ','://genera token COMA
				estadoSiguiente.setEstado(3);
				genToken(PYCOMA, null);
				break;
			case ';':
				
				break;
			case '(':
				break;
			case ')':
				break;
			case '{':
				break;
			case '}':
				
				break;
			case '"':
				break;
			case '+':
				break;
			case '=':
				estadoSiguiente.setEstado(22);
				//comprobaci�n del siguiente caracter
				break;
			case '&':
				
				break;
			case '-':
				genError(400);//simbolo no soportado
				break;
			case '*':
				genError(400);//simbolo no soportadogenError(400);//simbolo no soportado
				break;
			case '|':
				genError(400);//simbolo no encontrado
				break;
			case '/':
				genError(400);//simbolo no soportado
				break;
			case '%':
				genError(400);//simbolo no soportado
				break;
			case '!':
				genError(400);//simbolo no soportado
				break;
			case '>':
				genError(400);//simbolo no soportado
				break;
			case '<':
				genError(400);//simbolo no soportado
				break;
			case ':':
				genError(400);//simbolo no soportado
				break;
			default://si no es un simbolo soportado, es una letra o un n�mero
				
			}
			break;
		case 9:/**cadena, apertura de comillas*/
			
			break;
		case 21:/**suma o asignaci�n con suma*/
			
			break;
		case 22:/**asignaci�n o operador relacional igual*/
			
			break;
		case 23:/** */
			
			break;
		case 24:/** */
			
			break;
		case 25:/** */
			
			break;
		case 70:/**cadena, recibe caracter*/
			
			if (Character.isAlphabetic(c)) {
				estadoSiguiente.setEstado(70);
			}
			break;
		default:
			System.out.printf("AL.aplivarMatrizTransici�n(): Ha entrado en un estado incorrecto %d/n",estadoActual.getEstado());
		}
		return estadoSiguiente;
	}

	private void genError(int i) {
		// TODO Auto-generated method stub
		
	}

	private boolean otroCaracter(char c, Estado e) {
		//FALTA POR IMPLEMENTAR LA VERSION PROYECTADA
		boolean esOtroCaracter = false;
		switch (e.getEstado()) {
			case 0: 
				
		}
		if (c == ' ' || c == ')' || c == ';'|| c == '('|| c =='\r' || c =='}') {//aqui no se contempla el caso de que sea eof
			esOtroCaracter = true;
		}
		return esOtroCaracter;
	}


	private Token genToken(int tokenID, char[] lexema) {
		tokenEncontrado = true;
		System.out.println("genToken("+tokenID+")");
		switch (tokenID) {
		case 1: System.out.println("Fin de fichero");break;
		case 3: //AQUI HAY QUE PONER TODOS LOS TOKENS GENERADOS
				//PRIMERO USAR FW PARA IMPRIMIR LOS TOKENS Y TAMBIEN UN SYSO
		}
		return null;
		
	}
	public void setSalidaTokens (FileWriter fw) {
		this.fw = fw;
	}


}
