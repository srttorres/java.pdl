package es.upm.fi.pdl;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class AnalizadorLexico {
	static int caracteresRestantes;//se inicializará a cero//en caso de ser -1 se ha llegado a final de fichero
	static boolean tokenEncontrado;//se inicializará a falso
	static Token tokenGenerado;
	static FileWriter fw;
	static Map<String, Integer> diccionarioPR;	
	static TablaSimbolos tablaSimbolos = new TablaSimbolos();
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
		/**
		 * CONSTRUCTOR
		 */
	public AnalizadorLexico() {
		caracteresRestantes = 0;
		tokenEncontrado = false;		
		diccionarioPR = new HashMap<String, Integer>();	//luego se recupera con get en el caso 23 de aplicarMatrizTransicion
		diccionarioPR.put("true",0);
		diccionarioPR.put("false",1);
		diccionarioPR.put("if",	2);
		diccionarioPR.put("while",3);
		diccionarioPR.put("do",4);
		diccionarioPR.put("var",5);
		diccionarioPR.put("bool",6);
		diccionarioPR.put("chars",7);
		diccionarioPR.put("int",8);
		diccionarioPR.put("function",9);
		diccionarioPR.put("prompt",10);
		diccionarioPR.put("write",11);
		diccionarioPR.put("return",13);		
	}
	/**
	 * Llamada desde el Analizador Sintáctico en busca de un token (en la version 0.4 se llama desde el Programa principal App)
	 * @param fr
	 * @return Token
	 * @throws IOException
	 */
	public Token ejecutar(FileReader fr) throws IOException {
		ManejadorFicheros.log("+AL.EJECUTAR()");
		tokenEncontrado = false; 
		Token t = null;
		Estado estadoActual = new Estado();//empezamos en el estado 0
		char [] siguienteCaracter = new char[1];
		String lexema = null;
		do {			
			caracteresRestantes = fr.read(siguienteCaracter);
			lexema = lexema+Character.toString(siguienteCaracter[0]);							
			estadoActual = aplicarMatrizTransicion(siguienteCaracter[0], estadoActual, fr);
			lexema = estadoActual.getLexema();			
		}
		while((caracteresRestantes != -1) && !tokenEncontrado );
		if(tokenEncontrado) {
			t = getTokenGen();
		}
		else if(caracteresRestantes==-1){
			genToken(EOF,null);
			t = getTokenGen();
		}		
        if (fr != null) {};//ManejadorFicheros.cerrarDescriptorSalida(fw);        
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
			//caso de EOF tratado antes de llamar a esta función
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
				break;				
			case '+':
				estadoSiguiente.setEstado(21);				
				break;
			case '=':
				estadoSiguiente.setEstado(22);
				break;
			case '&':
				estadoSiguiente.setEstado(25);
				break;
			case '\\':
				genError(400);break;//simbolo no soportado
			case '\'':
				genError(400);break;//simbolo no soportado	
			case '-':
				genError(400);break;//simbolo no soportado				
			case '*':
				genError(400);break;//simbolo no soportado				
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
			default://si no es un simbolo soportado, es una letra o un número
				if(Character.isAlphabetic(c)) {
					estadoActual.setLexema("");
					estadoSiguiente.setEstado(23);
					lexema = Character.toString(c);					
					estadoSiguiente.setLexema(lexema);
					ManejadorFicheros.log("AL>>LEXEMA: "+estadoSiguiente.getLexema());
				}
				if(Character.isDigit(c)) {
					if(c=='0') {
						genError(406);
					}
					estadoSiguiente.setEstado(24);
					int valor = Integer.parseInt(Character.toString(c));					
					estadoSiguiente.setValor(valor);																			
					//System.out.printf(">>>>VALOR: %s\n",estadoSiguiente.getValor());
				}
			}
			break;//case 0
			
			
		case 9:/**cadena, apertura de comillas*/			
			if (c=='"') {//OJO CADENA VACIA				
				if(lexema==null) {
					genError(401);
				}
			}
			else {
				estadoActual.setLexema("");
				estadoSiguiente.setEstado(70);				
				estadoSiguiente.setLexema(estadoActual.getLexema()+c);
				ManejadorFicheros.log("AL>>LEXEMA:"+estadoSiguiente.getLexema());
			}
			break;//case 9
		
			
		case 21:/**suma o asignación con suma*/
			if (otroCaracter(estadoActual,c)) {
				estadoSiguiente.setEstado(51);
				genToken(OP_ARIT_SUMA,null);
			}
			else if (c == '='){				
				estadoSiguiente.setEstado(62);
				genToken(ASIG_SUMA,null);				
			}
			break;//case 21
			
			
		case 22:/**asignación o operador relacional igual*/			
			if (otroCaracter(estadoActual,c)) {
				estadoSiguiente.setEstado(61);
				genToken(ASIG_SIMPLE,null);
			}
			else {
				estadoSiguiente.setEstado(52);
				genToken(OP_REL_IGUAL,null);//porque se ha comprobado en el estado 0 si fuese otro caracter
			}			
			
			break;//case 22
			
			
		case 23:/** */
			if(Character.isAlphabetic(c) || Character.isDigit(c)) {
				estadoSiguiente.setEstado(23);
				estadoSiguiente.setLexema(estadoActual.getLexema()+c);
				estadoSiguiente.setLexema(estadoSiguiente.getLexema());
				ManejadorFicheros.log("AL>>LEXEMA: "+estadoSiguiente.getLexema());
			}
			else {
				//si es otro caracter, es decir, espacio, operador o otra cosa, se genera el token				
				if (otroCaracter(estadoActual,c)){
					lexema = estadoActual.getLexema();
					estadoSiguiente.setLexema(estadoActual.getLexema());
					estadoSiguiente.setEstado(80);
					if(diccionarioPR.containsKey(lexema)) {
						int punteroPR = diccionarioPR.get(lexema);
						genToken(PALABRA_RESERVADA,Integer.toString(punteroPR));	
					}
					else if (tablaSimbolos.contieneID(lexema)) {
						int punteroTS = tablaSimbolos.buscaID(lexema);
						genToken(IDENTIFICADOR,Integer.toString(punteroTS));
					}
					else {
						int punteroTS = tablaSimbolos.añadirEntrada(lexema);						
						genToken(IDENTIFICADOR,Integer.toString(punteroTS));
					}					
				}
			}
			break;//case 23			
			
		case 24:/** */
			if (!Character.isDigit(c) && otroCaracter(estadoActual,c)) {
				if (estadoActual.getValor()>32767) {
					genError(405);
				}
				else {
					genToken(ENTERO,Integer.toString(estadoActual.getValor()));
				}
			}
			else {				
				estadoSiguiente.setEstado(24);
				int valor = estadoActual.getValor()*10 + Integer.parseInt(Character.toString(c));
				estadoSiguiente.setValor(valor);
				ManejadorFicheros.log("AL>>VALOR:"+estadoSiguiente.getValor());
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
				ManejadorFicheros.log("AL>>LEXEMA:"+estadoSiguiente.getLexema());
			}
			
			break;//case 70
			
			
		default:
			System.out.printf("AL.aplivarMatrizTransición(): Ha entrado en un estado incorrecto %d/n",estadoActual.getEstado());
		}
		
		
		return estadoSiguiente;
	}


	/**
	 * 
	 * @param f FileReader. El puntero apunta al último caracter leido
	 * @param e Estado
	 * @param UltimoCaracterLeido. Porque f lee uno mas, lee el siguiente
	 * @return true si es otro caracter para ese estado
	 * @throws IOException
	 */
	private boolean otroCaracter(Estado e,char ultimoCaracterLeido) throws IOException {
		//FALTA POR IMPLEMENTAR LA VERSION PROYECTADA
		boolean esOtroCaracter = false;								
		ManejadorFicheros.log("AL>>otroCaracter(): "+ultimoCaracterLeido);			
		switch (e.getEstado()) {
		case 9:/**cadena, apertura de comillas*/			
			break;//case 9 VACIO
		case 21:/**suma o asignación con suma*/
			//HABRIA QUE REVISAR QUE PASARIA si el caracter fuera = Y SI SE ESE CASO SE TRATA EN OTRO LADO
			if(ultimoCaracterLeido == '+') {
					esOtroCaracter = false;
					genError(400);//operador ++ no soportado
			}
			else if (ultimoCaracterLeido == '='){
				esOtroCaracter = false;
			}
			else {
				esOtroCaracter = true;
			}						
			break;//case 21
		case 22:/**asignación o operador relacional igual*/								
			if(ultimoCaracterLeido !='=') {
				esOtroCaracter = true;
			}
			break;//case 22
		case 23:/**caso letra pero sin comillas, ID o PR. aqui no se lee, se viene leido */						
			if (ultimoCaracterLeido == ' ' || ultimoCaracterLeido == '=' || ultimoCaracterLeido == '+' || ultimoCaracterLeido == '&' || ultimoCaracterLeido == '(' || ultimoCaracterLeido == ')' || ultimoCaracterLeido == '{' || ultimoCaracterLeido == '}'|| ultimoCaracterLeido == '\n' || ultimoCaracterLeido == '\r') {
				esOtroCaracter = true;
			}
			break;//case 23
		case 24:/**caso es digito */
			if (ultimoCaracterLeido == ' ' || ultimoCaracterLeido == '=' || ultimoCaracterLeido == '+' || ultimoCaracterLeido == '&' || ultimoCaracterLeido == '(' || ultimoCaracterLeido == ')' || ultimoCaracterLeido == '{' || ultimoCaracterLeido == '}'|| ultimoCaracterLeido == '\n' || ultimoCaracterLeido == '\r') {
				esOtroCaracter = true;
			}
			break;//case 24
		case 25:/** */
		
			break;//case 25
		case 70:/**cadena, recibe caracter*/
			
			break;//case 70
		default:			
		}//switch
		
			return esOtroCaracter;
	}
	
	private Token getTokenGen() {
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
	 * @comment Llamada a Token(int id, String name, String value) y grabación de datos en log y en fichero Tokens
	 */
	private void genToken(int tokenID, String lexema) throws IOException {
		tokenEncontrado = true;		
		switch (tokenID) {
		case EOF: /*escribir token en tokenGenerado y en fichero salida*/;
			tokenGenerado = new Token(EOF,null);
			grabarToken();
			break;
		case COMA:
			tokenGenerado = new Token(COMA,null);
			grabarToken();
			break;
		case PYCOMA:
			tokenGenerado = new Token(PYCOMA,null);
			grabarToken();
			break;
		case PARENTESIS_A :
			tokenGenerado = new Token(PARENTESIS_A,null);
			grabarToken();
			break;
		case PARENTESIS_C :
			tokenGenerado = new Token(PARENTESIS_C,null);
			grabarToken();
			break;
		case LLAVE_A:
			tokenGenerado = new Token(LLAVE_A,null);
			grabarToken();
			break;
		case LLAVE_C:
			tokenGenerado = new Token(LLAVE_C,null);
			grabarToken();
			break;
		case OP_ARIT_SUMA:
			tokenGenerado = new Token(OP_ARIT_SUMA,null);
			grabarToken();
			break;
		case OP_REL_IGUAL:
			tokenGenerado = new Token(OP_REL_IGUAL,null);
			grabarToken();
			break;
		case OP_LOG_AND:
			tokenGenerado = new Token(OP_LOG_AND,null);
			grabarToken();
			break;
		case ASIG_SIMPLE:
			tokenGenerado = new Token(ASIG_SIMPLE,null);
			grabarToken();
			break;
		case ASIG_SUMA:			
			tokenGenerado = new Token(ASIG_SUMA,null);
			grabarToken();;
			break;
		case CADENA:			
			tokenGenerado = new Token(CADENA,lexema);
			grabarToken();			
			break;
		case PALABRA_RESERVADA:
			
			tokenGenerado = new Token(PALABRA_RESERVADA,lexema);
			grabarToken();
			break;
		case IDENTIFICADOR:
			tokenGenerado = new Token(IDENTIFICADOR,lexema);
			grabarToken();
			break;
		case ENTERO:
			tokenGenerado = new Token(ENTERO,lexema);
			grabarToken();
			break;
		}		
		if (fw != null) {}		
		
	}
	private void grabarToken() throws IOException {
		String t = tokenGenerado.toString();
		ManejadorFicheros.log("AL>>----------"+t+"--------");
		fw.write(t);
		
	}
	private void genError(int i) {
		String lineaEntrada = "linea por determinar";
		switch(i) {
		case 400: System.out.println("STOP=> ERROR ANALISIS LEXICO: SIMBOLO NO SOPORTADO "+lineaEntrada);break;
		case 401: System.out.println("STOP=> ERROR ANALISIS LEXICO: SIMBOLO NO ESPERADO TRAS ABRIR COMILLAS. CADENA VACIA");break;
		case 402: System.out.println("STOP=> ERROR ANALISIS LEXICO:");break;
		case 403: System.out.println("STOP=> ERROR ANALISIS LEXICO: se esperaba un digito");break;
		case 405: System.out.println("STOP=> ERROR ANALISIS LEXICO: El entero supera el tamaño máximo permitido");break;
		case 406: System.out.println("STOP=> ERROR ANALISIS LEXICO: se esperaba un digito diferente a cero");break;
		}
		
	}


}
