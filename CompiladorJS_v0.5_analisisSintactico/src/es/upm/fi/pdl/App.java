package es.upm.fi.pdl;

import java.io.IOException;

public class App {

	

   public static void main( String args[] ) throws IOException {	   
	   
	   AnalizadorLexico AL = new AnalizadorLexico();
	   String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	   String ficheroEntrada = "codigo_";
	   String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";
	   String numero = "18";
	   Token token; 
	   System.out.println("=========AL[Prueba "+numero+"]======");
	   AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
	   do {
	   token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
	   }
	   while (token.toString()!="<EOF,>");
	   
	   
}//main
}//App