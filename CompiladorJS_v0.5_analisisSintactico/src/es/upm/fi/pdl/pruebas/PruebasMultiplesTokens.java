package es.upm.fi.pdl.pruebas;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.FileWriter;
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
		//debe reconocer 101 102 103 104 
		numero = "20";
		rutaSalida = rutaCarpetaSalida+"tokens_"+numero+".txt";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaSalida);
		
		FileWriter fw = ManejadorFicheros.getDescriptorSalida(rutaSalida);
		FileReader fr = ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js");
		AL.setSalidaTokens(fw);
		token = AL.ejecutar(fr);

		while(token.getIdentificador()!=1) {
			ManejadorFicheros.log("id de Token: "+token.getIdentificador());			
			token = AL.ejecutar(ManejadorFicheros.getLastDescriptorEntrada());						
		}
		ManejadorFicheros.cerrarDescriptorEntrada(fr);
		ManejadorFicheros.cerrarDescriptorSalida(fw);
		System.out.println(ManejadorFicheros.ficheroToString(rutaSalida));
		assertEquals("<ENTERO,101><ENTERO,102><ENTERO,103><ENTERO,104><EOF,>",ManejadorFicheros.ficheroToString(rutaSalida));
	}
	@Test
	public void prueba_21_varios_tokens_de_palabras_reservadas() throws IOException {		
		numero = "21";
		rutaSalida = rutaCarpetaSalida+"tokens_"+numero+".txt";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaSalida);
		
		FileWriter fw = ManejadorFicheros.getDescriptorSalida(rutaSalida);
		FileReader fr = ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js");
		AL.setSalidaTokens(fw);
		token = AL.ejecutar(fr);

		while(token.getIdentificador()!=1) {
			ManejadorFicheros.log("id de Token: "+token.getIdentificador());			
			token = AL.ejecutar(ManejadorFicheros.getLastDescriptorEntrada());						
		}
		ManejadorFicheros.cerrarDescriptorEntrada(fr);
		ManejadorFicheros.cerrarDescriptorSalida(fw);
		System.out.println(ManejadorFicheros.ficheroToString(rutaSalida));
		assertEquals("<PALABRA_RESERVADA,3><PALABRA_RESERVADA,6><PALABRA_RESERVADA,6><EOF,>",ManejadorFicheros.ficheroToString(rutaSalida));
	}
}//class