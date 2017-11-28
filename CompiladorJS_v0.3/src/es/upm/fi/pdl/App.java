package es.upm.fi.pdl;

import java.io.IOException;

public class App {

	

   public static void main( String args[] ) throws IOException {	   
	   AnalizadorLexico AL = new AnalizadorLexico();
	   AL.ejecutar(ManejadorFicheros.leerFichero("src/es/upm/fi/pdl/entrada/codigo_50.js"));
	   
	   }
}