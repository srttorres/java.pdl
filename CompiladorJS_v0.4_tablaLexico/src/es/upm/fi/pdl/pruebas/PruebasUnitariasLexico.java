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
public class PruebasUnitariasLexico {
	AnalizadorLexico AL = new AnalizadorLexico();
	String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	String ficheroEntrada = "codigo_";
	String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";	
	String numero;
	Token token;
	
	@Test
	public void test_01_02_ficheroVacio() throws IOException {		   				   		   
		numero = "01";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<EOF,>",token.toString());
		numero = "02";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<EOF,>",token.toString());
	}
	@Test
	public void test_03_coma() throws IOException {		   				   		   
		numero = "03";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<COMA,>",token.toString());
	}
	@Test
	public void test_04_puntoycoma() throws IOException {		   				   		   
		numero = "04";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PYCOMA,>",token.toString());
	}
	@Test
	public void test_05_parentesis() throws IOException {		   				   		   
		numero = "05";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PARENTESIS_A,>",token.toString());
		numero = "06";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PARENTESIS_C,>",token.toString());
	}
	@Test
	public void test_07_08_llaves() throws IOException {		   				   		   
		numero = "07";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<LLAVE_A,>",token.toString());
		numero = "08";		
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<LLAVE_C,>",token.toString());
	}
	@Test
	public void test_09_suma() throws IOException {		   				   		   
		numero = "09";		
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<OP_ARIT_SUMA,>",token.toString());
	}
	@Test
	public void test_10_operadorRelacionalIgual() throws IOException {		   				   		   
		numero = "10";
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<OP_REL_IGUAL,>",token.toString());
	}
	@Test
	public void test_11_operadorAnd() throws IOException {		   				   		   
		numero = "11";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<OP_LOG_AND,>",token.toString());
	}
	@Test
	public void test_12_asignacion() throws IOException {		   				   		   
		numero = "12";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<ASIG_SIMPLE,>",token.toString());
	}
	@Test
	public void test_17_asignacionConSuma() throws IOException {		   				   		   
		numero = "17";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<ASIG_SUMA,>",token.toString());
	}
	@Test
	public void test_13_cadena() throws IOException {		   				   		   
		numero = "13";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<CADENA,cad>",token.toString());
	}
	@Test
	public void test_14_palabraReservada() throws IOException {		   				   		   
		numero = "14";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PALABRA_RESERVADA,10>",token.toString());
	}
	@Test
	public void test_15_identificador() throws IOException {		   				   		   
		numero = "15";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<IDENTIFICADOR,100>",token.toString());
	}
	@Test
	public void test_16_entero() throws IOException {		   				   		   
		numero = "16";	
		ManejadorFicheros.log("+Abriendo archivo para escritura: "+ rutaCarpetaSalida+"tokens_"+numero+".txt");
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<ENTERO,2300>",token.toString());
	}
	
}
