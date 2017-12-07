package es.upm.fi.pdl.pruebas;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

import es.upm.fi.pdl.AnalizadorLexico;
import es.upm.fi.pdl.ManejadorFicheros;
import es.upm.fi.pdl.Token;
public class PruebasUnitariasLexico {
	AnalizadorLexico AL = new AnalizadorLexico();
	String rutaCarpetaEntrada = "src/es/upm/fi/pdl/entrada/";
	String ficheroEntrada = "codigo_";
	String rutaCarpetaSalida = "src/es/upm/fi/pdl/salida/";	
	String numero;
	Token token;
	
	@Test
	public void ficheroVacio() throws IOException {		   				   		   
		numero = "01";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<EOF,>",token.toString());
		numero = "02";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<EOF,>",token.toString());
	}
	@Test
	public void coma() throws IOException {		   				   		   
		numero = "03";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<COMA,>",token.toString());
	}
	@Test
	public void puntoycoma() throws IOException {		   				   		   
		numero = "04";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PYCOMA,>",token.toString());
	}
	@Test
	public void parentesis() throws IOException {		   				   		   
		numero = "05";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PARENTESIS_A,>",token.toString());
		numero = "06";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PARENTESIS_C,>",token.toString());
	}
	@Test
	public void llaves() throws IOException {		   				   		   
		numero = "07";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<LLAVE_A,>",token.toString());
		numero = "08";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<LLAVE_C,>",token.toString());
	}
	@Test
	public void suma() throws IOException {		   				   		   
		numero = "09";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<OP_ARIT_SUMA,>",token.toString());
	}
	@Test
	public void operadorRelacionalIgual() throws IOException {		   				   		   
		numero = "10";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<OP_REL_IGUAL,>",token.toString());
	}
	@Test
	public void operadorAnd() throws IOException {		   				   		   
		numero = "11";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<OP_LOG_AND,>",token.toString());
	}
	@Test
	public void asignacion() throws IOException {		   				   		   
		numero = "12";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<ASIG_SIMPLE,>",token.toString());
	}
	@Test
	public void asignacionConSuma() throws IOException {		   				   		   
		numero = "17";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<ASIG_SUMA,>",token.toString());
	}
	@Test
	public void cadena() throws IOException {		   				   		   
		numero = "13";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<CADENA,cad>",token.toString());
	}
	@Test
	public void palabraReservada() throws IOException {		   				   		   
		numero = "14";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<PALABRA_RESERVADA,10>",token.toString());
	}
	@Test
	public void identificador() throws IOException {		   				   		   
		numero = "15";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<IDENTIFICADOR,100>",token.toString());
	}
	@Test
	public void entero() throws IOException {		   				   		   
		numero = "16";					
		AL.setSalidaTokens(ManejadorFicheros.getDescriptorSalida(rutaCarpetaSalida+"tokens_"+numero+".txt"));
		token = AL.ejecutar(ManejadorFicheros.getDescriptorEntrada(rutaCarpetaEntrada+ficheroEntrada+numero+".js"));
		assertEquals("<ENTERO,2300>",token.toString());
	}
	
}
