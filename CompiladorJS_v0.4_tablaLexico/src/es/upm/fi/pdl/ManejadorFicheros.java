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
	public static FileReader getDescriptorEntrada(String rutaArchivo) throws IOException{
		log("+Abriendo archivo para lectura: "+ rutaArchivo);
		FileReader inputStream = null;       
        try {           
        	inputStream = new FileReader(rutaArchivo);            
            return inputStream;
        } finally {}		
	}//getDescriptorEntrada	
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



}
