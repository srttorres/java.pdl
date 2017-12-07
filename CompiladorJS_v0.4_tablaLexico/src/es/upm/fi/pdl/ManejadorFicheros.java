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
		
		FileReader inputStream = null;       
        try {           
        	inputStream = new FileReader(rutaArchivo);
            
            return inputStream;
        } finally {
            //System.out.println("ManejadorFicheros.java/leerFichero==> Stream de lectura");
        }//finally
			
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
		//System.out.println("Abriendo archivo "+ rutaArchivo);
	   fw = new FileWriter(file,true);//if file exists append to file. Works fine.
	}
	else
	{
	   //System.out.println("Creando archivo "+rutaArchivo);
	   file.createNewFile();
	   //System.out.println("Obteniendo puntero");
	   fw = new FileWriter(file);
	}
	return fw;
			
	}	
public static void cerrarDescriptorEntrada(FileReader fr) throws IOException {
	fr.close();
	//System.out.println("AnalizadorLexico.java/ejecutar==>Stream de lectura cerrado");
}
public static void cerrarDescriptorSalida(FileWriter fw) throws IOException {
	fw.close();
	//System.out.println("AnalizadorLexico.java/ejecutar==>Stream de lectura cerrado");
}
public static void log(String t) throws IOException {
	FileWriter fw = getDescriptorSalida("src/es/upm/fi/pdl/salida/log.txt");
	
}



}
