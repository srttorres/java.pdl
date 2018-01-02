package es.upm.fi.pdl.pruebas;

import static org.junit.Assert.*;
import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;

import es.upm.fi.pdl.AnalizadorLexico;
import es.upm.fi.pdl.ManejadorFicheros;
import es.upm.fi.pdl.Token;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebasMultiplesTokens{
	AnalizadorLexico AL = new AnalizadorLexico();
	String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	String ficheroEntrada = "codigo_";
	String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";	
	String numero;
	Token token;
	String rutaSalida;
	
	@Test
	public void prueba_20_varios_tokens_de_enteros() throws IOException {
		numero = "20";
		rutaSalida = rutaCarpetaSalida+"tokens_"+numero+".txt";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaSalida);
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaSalida));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		
		
		ManejadorFicheros.log("id de Token: "+token.getIdentificador());
		while(token.getIdentificador()!=1) {
			token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		}
		//assertEquals("<EOF,>",leerFichero(rutaSalida));
	}
}//class