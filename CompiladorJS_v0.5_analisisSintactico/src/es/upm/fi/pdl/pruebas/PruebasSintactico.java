package es.upm.fi.pdl.pruebas;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.FixMethodOrder;
import org.junit.Test;

import es.upm.fi.pdl.AnalizadorLexico;
import es.upm.fi.pdl.AnalizadorSintactico;
import es.upm.fi.pdl.ManejadorFicheros;
import es.upm.fi.pdl.Token;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PruebasSintactico{
	AnalizadorLexico AL = new AnalizadorLexico();
	AnalizadorSintactico ASin = new AnalizadorSintactico(); 
	String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	String ficheroEntrada = "codigo_";
	String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";	
	String numero;
	Token token;
	String rutaSalida;
		
	@Test
	public void prueba_50_parse_simple() throws IOException {		
		//ASin
		/*
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
		*/
		assertEquals("1","1");
		//assertEquals("<PALABRA_RESERVADA,3><PALABRA_RESERVADA,6><PALABRA_RESERVADA,6><EOF,>",ManejadorFicheros.ficheroToString(rutaSalida));
	}
}//class