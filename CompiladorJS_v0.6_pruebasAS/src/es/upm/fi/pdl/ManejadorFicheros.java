package es.upm.fi.pdl;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ManejadorFicheros {
	/**
	 * @exception Input/output
	 * @param ruta del fichero a abrir
	 */	
	static FileReader FR;
	public static FileReader getDescriptorEntrada(String rutaArchivo) throws IOException{
		log("+Abriendo archivo para lectura: "+ rutaArchivo);
		FileReader inputStream = null;       
        try {           
        	inputStream = new FileReader(rutaArchivo);
        	FR = inputStream;//atributo de clase
            return inputStream;
        } finally {}		
	}//getDescriptorEntrada
	public static FileReader getLastDescriptorEntrada() {		
		return FR;
	}
	/**
	 * @exception Input/output
	 * @param ruta del fichero a abrir
	 * @param texto a escribir en el fichero
	 */	
	public static FileWriter getDescriptorSalida(String rutaArchivo) throws IOException{
		File file= new File (rutaArchivo);
		FileWriter fw;
		if (file.exists()){		
			fw = new FileWriter(file,true);//if file exists append to file. Works fine.
		}
		else{
			file.createNewFile();
			fw = new FileWriter(file);
		}
		return fw;			
	}
	/**
	 * @param fr
	 * @throws IOException
	 */
	public static void cerrarDescriptorEntrada(FileReader fr) throws IOException {
		fr.close();		
	}
	/**
	 * @param fw
	 * @throws IOException
	 */
	public static void cerrarDescriptorSalida(FileWriter fw) throws IOException {
		fw.close();
	}
	/**
	 * @param s
	 * @throws IOException
	 */
	public static void log(String s) throws IOException {
		FileWriter fw = getDescriptorSalida("src/es/upm/fi/pdl/salida/log.txt");
		fw.write(s+"\r");
		cerrarDescriptorSalida(fw);
	}
	/**
	 * 
	 * @param ruta del fichero
	 * @return String del fichero
	 * @throws IOException
	 */
	// utilizado para rellenar assert en Pruebas Multiples Tokens
	public static String ficheroToString(String r) throws IOException {
		log("+Abriendo archivo para lectura: "+ r);
		FileReader inputStream = null; 
		int content;
		char [] siguienteCaracter = new char[1];
		String lexema = "";
        try {           
        	inputStream = new FileReader(r);        	
            while((content = inputStream.read(siguienteCaracter))!=-1) {
            	lexema = lexema+Character.toString(siguienteCaracter[0]);		  	
            }
        } finally {inputStream.close();}            
        return lexema;
        
	}
	public static void vaciarLog() {
	    File fichero = new File("src/es/upm/fi/pdl/salida/log.txt");
	    if (fichero.delete()) {}	        
	    else {System.out.println("El fichero no pudó ser borrado");}		
	}




}//class
