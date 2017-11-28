package es.upm.fi.pdl;

import java.io.IOException;

public class App {

	

   public static void main( String args[] ) throws IOException {	   
	   AnalizadorLexico AL = new AnalizadorLexico();
	   String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	   String ficheroEntrada = "codigo_50";
	   String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";	  
	   AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+ficheroEntrada+".txt"));
	   AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+".js"));
	   
	   }
}