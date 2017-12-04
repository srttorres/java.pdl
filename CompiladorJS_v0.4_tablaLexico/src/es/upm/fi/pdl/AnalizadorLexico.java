package es.upm.fi.pdl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AnalizadorLexico {
	static int caracteresRestantes;//se inicializar� a cero//en caso de ser -1 se ha llegado a final de fichero
	static boolean tokenEncontrado;//se inicializar� a falso
	static Token tokenGenerado;
	static boolean comienzoConcatenacion;//sirve para distinguir un caso de letras normales de uno de cadena
	static FileWriter fw;
	public static final int  EOF 				= 1;
	public static final int  COMA 				= 3;
	public static final int  PYCOMA				= 4;
	public static final int  PARENTESIS_A 		= 5;
	public static final int  PARENTESIS_C 		= 6;
	public static final int  LLAVE_A			= 7;
	public static final int  LLAVE_C			= 8;
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
		comienzoConcatenacion = false;
	}
	/**
	 * Llamada desde el Analizador Sint�ctico en busca de un token (en la version 0.4 se llama desde el Programa principal App)
	 * @param fr
	 * @return Token
	 * @throws IOException
	 */
	public Token ejecutar(FileReader fr) throws IOException {
		tokenEncontrado = false; 
		Token t = null;
		Estado estadoActual = new Estado();//empezamos en el estado 0
		char [] siguienteCaracter = new char[1];
		String lexema = null;
		do {			
			caracteresRestantes = fr.read(siguienteCaracter);
			lexema = Character.toString(siguienteCaracter[0]);
			System.out.println(">>BEACON:"+siguienteCaracter[0]);
			System.out.println(">>lexema:"+lexema);
			estadoActual = aplicarMatrizTransicion(siguienteCaracter[0], estadoActual, fr);
			lexema = estadoActual.getLexema();			
		}
		while((caracteresRestantes != -1) && !tokenEncontrado );
		if(tokenEncontrado) {
			t = getTokenGen(estadoActual);
		}
		else if(caracteresRestantes==-1){
			genToken(EOF,null);
		}		
        if (fr != null) {ManejadorFicheros.cerrarDescriptorEntrada(fr);}//si no hay ning�n token generado, no se abre el descriptor de Salida
        
        return t;
	}

	/**
	 * 
	 * @param c
	 * @param estadoActual
	 * @return Estado para decidir si seguir ejecutando o no.
	 * @throws IOException
	 * @comment Se utiliza un switch anidado
	 */
	private Estado aplicarMatrizTransicion(char c, Estado estadoActual, FileReader fr) throws IOException {
		Estado estadoSiguiente = new Estado();
		String lexema = null;
		switch (estadoActual.getEstado()) {
		
		
		case 0:/**ESTADO 0: inicio*/ 			
			switch (c) {
			//caso de EOF tratado en la condici�n de llamada a la funci�n aplicarMatrizTransicion()
			case ' ':break;//espacio, no genera token
				
			case ','://genera token COMA
				estadoSiguiente.setEstado(3);
				genToken(COMA, null);break;				
			case ';':
				estadoSiguiente.setEstado(4);
				genToken(PYCOMA, null);break;				
			case '(':
				estadoSiguiente.setEstado(5);
				genToken(PARENTESIS_A,null);break;								
			case ')':
				estadoSiguiente.setEstado(6);
				genToken(PARENTESIS_C,null);break;
			case '{':
				estadoSiguiente.setEstado(7);
				genToken(LLAVE_A,null);break;				
			case '}':
				estadoSiguiente.setEstado(8);
				genToken(LLAVE_C,null);break;
			case '"':
				estadoSiguiente.setEstado(9);
				comienzoConcatenacion = true;break;				
			case '+'://comprobaci�n otroCaracter = true then OP_ARIT_SUMA else ya se tratar� en el estado 21
				estadoSiguiente.setEstado(21);				
				if (otroCaracter(fr,estadoSiguiente)) {
					estadoSiguiente.setEstado(51);
					genToken(OP_ARIT_SUMA,null);
				}
				break;
			case '='://comprobaci�n otroCaracter = true then ASIG_SIMPLE else ya se tratar� en el estado 22
				estadoSiguiente.setEstado(22);
				if (otroCaracter(fr,estadoSiguiente)) {
					estadoSiguiente.setEstado(61);
					genToken(ASIG_SIMPLE,null);
				}
				break;
			case '&':
				estadoSiguiente.setEstado(25);
				break;
			case '-':
				genError(400);break;//simbolo no soportado				
			case '*':
				genError(400);break;//simbolo no soportadogenError(400);//simbolo no soportado				
			case '|':
				genError(400);break;//simbolo no encontrado				
			case '/':
				genError(400);break;//simbolo no soportado				
			case '%':
				genError(400);break;//simbolo no soportado			
			case '!':
				genError(400);break;//simbolo no soportado				
			case '>':
				genError(400);break;//simbolo no soportado				
			case '<':
				genError(400);break;//simbolo no soportado				
			case ':':
				genError(400);break;//simbolo no soportado				
			default://si no es un simbolo soportado, es una letra o un n�mero
				if(Character.isAlphabetic(c)) {
					estadoSiguiente.setEstado(23);
					String primerCaracter = Character.toString(c);					
					estadoActual.setLexema(primerCaracter);
					System.out.printf("primerCaracter: %s\n",estadoActual.getLexema());
				}
				if(Character.isDigit(c)) {
					estadoSiguiente.setEstado(24);					
				}
			}
			break;//case 0
			
			
		case 9:/**cadena, apertura de comillas*/			
			if (c=='"') {//OJO CADENA VACIA
				estadoSiguiente.setEstado(71);				
				genToken(CADENA,estadoSiguiente.getLexema()+c);
				genError(401);
			}
			else {
				estadoActual.setLexema("");
				estadoSiguiente.setEstado(70);				
				estadoSiguiente.setLexema(estadoActual.getLexema()+c);
				System.out.println(">>>>LEXEMA:"+estadoSiguiente.getLexema());
			}
			break;//case 9
		
			
		case 21:/**suma o asignaci�n con suma*/
			estadoSiguiente.setEstado(62);
			genToken(ASIG_SUMA,null);//porque se ha comprobado en el estado 0 si fuese otro caracter
			break;//case 21
			
			
		case 22:/**asignaci�n o operador relacional igual*/
			estadoSiguiente.setEstado(52);
			genToken(OP_REL_IGUAL,null);//porque se ha comprobado en el estado 0 si fuese otro caracter
			break;//case 22
			
			
		case 23:/** */
			if(Character.isAlphabetic(c)) {
				estadoSiguiente.setEstado(70);				
				estadoSiguiente.setLexema(estadoSiguiente.getLexema()+c);
			}
			break;//case 23
			
			
		case 24:/** */
			if (c=='"') {
				estadoSiguiente.setEstado(71);
				System.out.println("HOLADOLAcas24"+estadoSiguiente.getLexema()+c);
				genToken(CADENA,estadoSiguiente.getLexema()+c);				
			}
			else {
				estadoSiguiente.setEstado(70);				
				estadoSiguiente.setLexema(estadoSiguiente.getLexema()+c);
			}
			break;//case 24
			
			
		case 25:/** */
			if (c=='&') {
				estadoSiguiente.setEstado(53);
				genToken(OP_LOG_AND,null);
			}
			break;//case 25
			
			
		case 70:/**cadena, recibe caracter*/			
			if (c=='"') {
				estadoSiguiente.setEstado(71);				
				genToken(CADENA,estadoActual.getLexema());
				
			}
			else {				
				estadoSiguiente.setEstado(70);				
				estadoSiguiente.setLexema(estadoActual.getLexema()+c);
				System.out.println(">>>>LEXEMA:"+estadoSiguiente.getLexema());
			}
			
			break;//case 70
			
			
		default:
			System.out.printf("AL.aplivarMatrizTransici�n(): Ha entrado en un estado incorrecto %d/n",estadoActual.getEstado());
		}
		
		
		return estadoSiguiente;
	}



	private boolean otroCaracter(FileReader f,Estado e) throws IOException {
		//FALTA POR IMPLEMENTAR LA VERSION PROYECTADA
		boolean esOtroCaracter = false;
		char [] c = new char[1];
		FileReader faux = f;
		int caracteresRestantes = faux.read(c);
		if (caracteresRestantes != -1) {
			System.out.println(">>AnalizadorLexico.java/otroCaracter()->c[1]="+c[0]);
		
			switch (e.getEstado()) {
			case 9:/**cadena, apertura de comillas*/
				
				break;//case 9
			case 21:/**suma o asignaci�n con suma*/
			//	aqui podemos ver si es un =
				if(c[0] !='=') {
					esOtroCaracter = true;
					if(c[0]=='+') {
						genError(400);//operador ++ no soportado
					}
				}
				break;//case 21
			case 22:/**asignaci�n o operador relacional igual*/
				if(c[0] !='=') {
					esOtroCaracter = true;
				}
				break;//case 22
			case 23:/** */
				
				break;//case 23
			case 24:/** */
			
				break;//case 24
			case 25:/** */
			
				break;//case 25
			case 70:/**cadena, recibe caracter*/
				
				break;//case 70
			default:			
			}//switch
		}//if
			return esOtroCaracter;
	}
	
	private Token getTokenGen(Estado estadoActual) {
		Token t = tokenGenerado;
		
		return t;
	}
	public void setSalidaTokens (FileWriter fw) {
		this.fw = fw;
	}
	/**
	 * 
	 * @param tokenID
	 * @param lexem
	 * @throws IOException
	 * @comment Llamada a Token(int id, String name, String value)
	 */
	private void genToken(int tokenID, String lexema) throws IOException {
		
		tokenEncontrado = true;
		System.out.println("genToken("+tokenID+")");
		switch (tokenID) {
		case EOF: /*escribir token en tokenGenerado y en fichero salida*/;
			tokenGenerado = new Token(EOF,"EOF" ,null);  
			break;
		case COMA: //AQUI HAY QUE PONER TODOS LOS TOKENS GENERADOS
				//PRIMERO USAR FW PARA IMPRIMIR LOS TOKENS Y TAMBIEN UN SYSO
			break;
		case PYCOMA:			
			break;
		case PARENTESIS_A :
			break;
		case PARENTESIS_C :
			break;
		case LLAVE_A	:
			break;
		case LLAVE_C	:
			break;
		case OP_ARIT_SUMA	:
			break;
		case OP_REL_IGUAL	:
			break;
		case OP_LOG_AND		:
			break;
		case ASIG_SIMPLE	:
			break;
		case ASIG_SUMA			:
			break;
		case CADENA			:
			System.out.println("||||||||||||||||||||||||||||||||||||||||||");
			System.out.println("TOKEN GENERADO: <CADENA,"+lexema+">");
			System.out.println("||||||||||||||||||||||||||||||||||||||||||");
			break;
		case PALABRA_RESERVADA:
			break;
		case IDENTIFICADOR		:
			break;
		case ENTERO			:
			break;
		}
		
		if (fw != null) {ManejadorFicheros.cerrarDescriptorSalida(fw);}		
		
	}
	private void genError(int i) {
		String lineaEntrada = "linea por determinar";
		switch(i) {
		case 400: System.out.println("STOP=> ERROR ANALISIS LEXICO: SIMBOLO NO SOPORTADO "+lineaEntrada);
		case 401: System.out.println("STOP=> ERROR ANALISIS LEXICO: SIMBOLO NO ESPERADO TRAS ABRIR COMILLAS. CADENA VACIA");
		case 402: System.out.println("STOP=> ERROR ANALISIS LEXICO:");
		}
		
	}


}
