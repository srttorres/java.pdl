package es.upm.fi.pdl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// to read files
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {
	
	public static void aplicarER(String ER, String s){
		//CON IF TENEMOS UN PROBLEMA
		System.out.println("==========================");
		System.out.println(">>>>aplicarER(ER,s)");
		System.out.println("==========================");
		Pattern patronCompilado = Pattern.compile(ER);
		
		for(String linea : s.split("\n")) {
			System.out.println("LINEA:     "+linea);
			
			if(linea.contains("\r")){				
				System.out.println("token:RC");			
			}
			else {
				Matcher coincidencias = patronCompilado.matcher(linea);		
				while ( coincidencias.find() ){
					if (coincidencias.group().length() != 0){
						String posibleToken = coincidencias.group().trim();
						System.out.println("token:"+posibleToken);
					}
				}		
			}//else
		}//for
			
		System.out.println("==========================");
	}
	public static void aplicarER2(String ER, String s){
		System.out.println("==========================");
		System.out.println(">>>>aplicarER(ER,s)");
		System.out.println("==========================");
		Pattern patronCompilado = Pattern.compile(ER);
		
		for(String linea : s.split("\n")) {
			//System.out.println("LINEA:     "+linea);
			String primerCaracter = Character.toString(linea.charAt(0));
			switch(primerCaracter) {
			case "\r":
				System.out.println("token:RC");
			default: 
				Matcher coincidencias = patronCompilado.matcher(linea);
				while(coincidencias.find()) {
					if (coincidencias.group().length() != 0) {
						String posibleToken = coincidencias.group().trim();
						System.out.println("token: "+ posibleToken);
					}
				}
			}//switch

		}//for
			
		System.out.println("==========================");
	}
	
	public static String leerFichero(String rutaArchivo){
		String fileName = "C:\\Workspaces\\2017_FI\\PDL\\CompiladorJS_v0.2\\src\\es\\upm\\fi\\pdl\\entrada\\codigo_50.js";
		String fileName2 = "C:\\fileName.js";
		String f = fileName;
		String content = null;
		System.out.println("\n==========================");
		try {
			content = new String(Files.readAllBytes(Paths.get(f)));
			System.out.println(">>>>leerFichero("+f+"):");
			System.out.println("==========================");
			System.out.println(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return content;		
	}
   public static void main( String args[] ) {

      String linea01 = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
      String linea02 = "var nombre;nombre=243431;";
      String linea03 = "var nombre;\n nombre=\"pepe\";";
      String linea04 = "var n0mbr3;\n n0mbr3=\"pepe\";";//identificador con algun digito
      String linea05 = "var n0mbr3=\"pepe\";\nwhile(true) {n0mbr3=21212334+32323233}//esto es un comentario\n /*pero esto ya no lo es*/  ";//todos los caracteres permitidos en la gramática
      String linea06 = "esto son ids //comment zone \n this is /*sparta*/";
      
      String patronIdentificador = "([A-Za-z]{1,500})*";//si el tamaño max de los ids es 500. 
      String patronIdentificador2 = "w{2,50}";
      String patronGramatica01 = "([A-Za-z]{1,500}|=|;|\\d*)";//no incluye los numeros en los id
      String patronGramatica02 = "(\\{+|=|;|\\d*)";//no incluye los identificadores con letras
      String patronGramatica03 = "([a-z0-9A-Z]+|=|;|\\+|-|,|(|)|\\d|"
      		+ "\\r\\n|[\\r\\n]|//[.]*|/\\*.\\*/|(?s).*[\\r\\n].*|\\s\\S|\\u000D)";//faltan llaves, comillas, salto de lineas, evitar los comentarios..
      String patronGramatica04 = "([a-z0-9A-Z]+|=|;|\\+|-|,|(|)|\\{|}|\".*\"|\\d|)";//las llaves no las detecta, los comentarios no los desecha
      String patronGramatica05 = "([a-z0-9A-Z]+|=|;|\\+|-|,|(|)|\\{|}|\".*\"|\\d|)|\\(?!\\\\[a-z0-9A-Z]+)";//las llaves no las detecta, los comentarios no los desecha
      String patronGramatica06 = "[a-z0-9A-Z]+|(?!//[a-z0-9A-Z | ]*)";//intentando desechar los comentarios
      String patronGramatica07 = "^(?!\\s*//)";
      String patronGramatica08 = "^[^/][^/].*";
      String patronGramatica09 = "^(?!//)";//copia 07
      
      //aplicarER("\\s[A-Za-z]*\\s", linea02);//\\s es para detectar un espacio
      //aplicarER("([A-Za-z]{1,500})*", linea02);//lo malo es que con esto se sacan todos los identificadores, cadenas y palabras reservadas pero puede saltarse caracteres importantes como un punto y coma o un igual
      //
      //aplicarER(patronGramatica03, linea05);
      aplicarER2(patronGramatica09, linea06);
      

      
      
      
      
   }
}