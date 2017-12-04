package es.upm.fi.pdl;

import java.io.IOException;

public class App {

	

   public static void main( String args[] ) throws IOException {	   
	   
	   AnalizadorLexico AL = new AnalizadorLexico();
	   String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	   String ficheroEntrada = "codigo_";
	   String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";
	   Integer num;
	   for (num = 1;num<=14;num++) {		   		   
		   String numero = num.toString();
		   if (num<10) {
			   numero = "0"+numero;
		   }
		   System.out.println("=========AL[Prueba "+numero+"]======");
		   AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+ficheroEntrada+numero+".txt"));
		   AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
	   
	   }
}//main
}//App