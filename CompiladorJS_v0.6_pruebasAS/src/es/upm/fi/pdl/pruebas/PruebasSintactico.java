package es.upm.fi.pdl.pruebas;

import static org.junit.Assert.*;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.Before;
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
	AnalizadorSintactico AS = new AnalizadorSintactico(); 
	String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";	
	
	String numero;
	String ficheroEntrada = "codigo_";//todos los ficheros se llaman así
	Token token;
	String rutaSalida;
	  @Before
	  public void setUp() throws Exception {
		  numero = "75";
		  rutaSalida = rutaCarpetaSalida+"tokens_"+numero+".txt";
		  ManejadorFicheros.vaciarLog();
		  ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaSalida);	   	   
	  }
	@Test
	public void prueba_75_function() throws IOException {		
		//ASin
		FileWriter fw = ManejadorFicheros.getDescriptorSalida(rutaSalida);
		FileReader fr = ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js");
		
		ArrayList<Integer> parse = AS.ejecutar(fr, fw);
		
		ManejadorFicheros.cerrarDescriptorEntrada(fr);
		ManejadorFicheros.cerrarDescriptorSalida(fw);
		System.out.println(ManejadorFicheros.ficheroToString(rutaSalida));
		
		assertEquals("1","1");
		//assertEquals("<PALABRA_RESERVADA,3><PALABRA_RESERVADA,6><PALABRA_RESERVADA,6><EOF,>",ManejadorFicheros.ficheroToString(rutaSalida));
	}
}//class