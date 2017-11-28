package es.upm.fi.pdl;

import java.io.FileReader;
import java.io.IOException;

public class AnalizadorLexico {
	static int caracteresRestantes;
	static boolean tokenEncontrado;
	
	public AnalizadorLexico() {
		caracteresRestantes = 0;
		tokenEncontrado = false;
	}
	
	public Token ejecutar(FileReader f) throws IOException {
		tokenEncontrado = false; 
		char [] siguienteCaracter = new char[1]; 
		char [] posibleValorToken = new char[1024];//esto tal vez lo podríamos recogerlo de un fichero de configuración
		Token t = null;
		caracteresRestantes = f.read(siguienteCaracter);
		
		
		while ( (caracteresRestantes != -1) && !tokenEncontrado ) {
			
			switch (siguienteCaracter[0]) {
			case ' ': System.out.println("espacio");
			case '&':  				
				caracteresRestantes = f.read(siguienteCaracter);
				if ((caracteresRestantes != -1) && siguienteCaracter[0]== '&') {
					t = genToken("OP_LOG_AND");						
				}
				break;
			default:
				int contador = 0;
				if (Character.isAlphabetic(siguienteCaracter[0])) {					
					while(Character.isAlphabetic(siguienteCaracter[0]) && !tokenEncontrado) {
						posibleValorToken[contador] = siguienteCaracter[0];
						System.out.printf("LEO %d %s tokenEncontrado:%s isLetter:%s \n",contador, siguienteCaracter[0], tokenEncontrado, Character.isAlphabetic(siguienteCaracter[0]));
						contador++;
						if(otroCaracter(siguienteCaracter[0])) {							
							t = genToken("CADENA",posibleValorToken);
						}
						else {
							if(Character.isDigit(siguienteCaracter[0])) {
								
							}
						}
						caracteresRestantes = f.read(siguienteCaracter);
					}
				}				
			}
			System.out.printf("LEO %d %s tokenEncontrado:%s isLetter:%s \n",0, siguienteCaracter[0], tokenEncontrado, Character.isAlphabetic(siguienteCaracter[0]));
				
			
						
        	caracteresRestantes = f.read(siguienteCaracter);
        }
        if (f != null) {f.close();}
        //importante cerrar descriptor de fichero (FileReader)
	     return t;
	}
	
	private boolean otroCaracter(char c) {
		boolean esOtroCaracter = false;
		if (c == ' ' || c == ')' || c == ';'|| c == '('|| c =='\r' || c =='}') {//aqui no se contempla el caso de que sea eof
			esOtroCaracter = true;
		}
		return esOtroCaracter;
	}

	private Token genToken(String string) {
		tokenEncontrado = true;
		System.out.println(string);
		return null;
		
	}
	private Token genToken(String string, char[] posibleValorToken) {
		tokenEncontrado = true;
		System.out.println(string);
		return null;
		
	}



}
