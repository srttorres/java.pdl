package es.upm.fi.pdl;

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
	public static FileReader getDescriptorEntrada(String rutaArchivo) throws IOException{
		
		FileReader inputStream = null;       
        try {           
        	inputStream = new FileReader("src/es/upm/fi/pdl/entrada/codigo_50.js");
            
            return inputStream;
        } finally {
            System.out.println("ManejadorFicheros.java/leerFichero==> El Stream está abierto :P");
        }//finally
			
	}//leerFichero
	/**
	 * @exception Input/output
	 * @param ruta del fichero a abrir
	 * @param texto a escribir en el fichero
	 */	
public static FileWriter getDescriptorSalida(String rutaArchivo) throws IOException{
				
        FileWriter outputStream = null;
        try {                   	
            outputStream = new FileWriter(rutaArchivo);            
            return outputStream;
        } finally {
        	System.out.println("ManejadorFicheros.java/EscribirFichero==> El Stream está abierto :\\ convendría cerrarlo");
        }
			
	}	
}
