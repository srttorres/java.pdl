package pdl.fi.upm.es;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
// to read files
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class App {

	//there is an error : java copiler level because de version of the java server faces is different
	//https://www.youtube.com/watch?v=s_PfopWcMwI
	
	public static void aplicarER(String ER, String s){
		System.out.println("==========================");
		System.out.println("aplicarER(ER,s)\n s:"+s);
		System.out.println("==========================");
		Pattern patronCompilado = Pattern.compile(ER);					
		Matcher coincidencias = patronCompilado.matcher(s);		
		while ( coincidencias.find() ){
			if (coincidencias.group().length() != 0){
				String posibleToken = coincidencias.group().trim();
				//System.out.println(posibleToken);
				if (posibleToken.equals("\\u000D")) {
					System.out.println("token:RC");
				}
				else if(posibleToken.equals("\\n")){
					System.out.println("token:RC");
				}
				else if(posibleToken.equals("\r\n")){
					System.out.println("token:RC");
				}
				else if(posibleToken.equals("\\r\\n")){
					System.out.println("token:RC");
				}
				else {
					System.out.println("token:"+ coincidencias.group().trim());	//este es el resultado de cada token palabra						
				//	System.out.println( "Start Index: " + coincidencias.start());
				//	System.out.println( "Start Index: " + coincidencias.end());
				}
			}
		}		
		System.out.println("==========================");
	}
	
	public static void leerFichero(String rutaArchivo){
		String fileName = "C:\\Workspaces\\2017_EXPONET\\JSF\\CompiladorJS_v0.1";

		//read file into stream, try-with-resources
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
			stream.forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
   public static void main( String args[] ) {

      String linea01 = " Derek Banas CA 12345 PA (412)555-1212 johnsmith@hotmail.com 412-555-1234 412 555-1234 ";
      String linea02 = "var nombre;nombre=243431;";
      String linea03 = "var nombre;\n nombre=\"pepe\";";
      String linea04 = "var n0mbr3;\n n0mbr3=\"pepe\";";//identificador con algun digito
      String linea05 = "var n0mbr3=\"pepe\";\nwhile(true) {n0mbr3=21212334+32323233}//esto es un comentario\n /*pero esto ya no lo es*/  ";//todos los caracteres permitidos en la gramática
      
      String patronIdentificador = "([A-Za-z]{1,500})*";//si el tamaño max de los ids es 500. 
      String patronIdentificador2 = "w{2,50}";
      String patronGramatica01 = "([A-Za-z]{1,500}|=|;|\\d*)";//no incluye los numeros en los id
      String patronGramatica02 = "(\\{+|=|;|\\d*)";//no incluye los identificadores con letras
      String patronGramatica03 = "([a-z0-9A-Z]+|=|;|\\+|-|,|(|)|\\d|"
      		+ "\\r\\n|[\\r\\n]|//[.]*|/\\*.\\*/|(?s).*[\\r\\n].*|\\s\\S|\\u000D)";//faltan llaves, comillas, salto de lineas, evitar los comentarios..
      //aplicarER("\\s[A-Za-z]*\\s", linea02);//\\s es para detectar un espacio
      //aplicarER("([A-Za-z]{1,500})*", linea02);//lo malo es que con esto se sacan todos los identificadores, cadenas y palabras reservadas pero puede saltarse caracteres importantes como un punto y coma o un igual
      //
      aplicarER(patronGramatica03, linea05);
      
      
   }
}