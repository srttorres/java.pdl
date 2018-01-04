package es.upm.fi.pdl;

import java.util.ArrayList;

public class AnalizadorSintactico {
	final static int DESPLAZAR = 1;
	final static int REDUCIR = 2;
	final static int ACEPTAR = 3;
	static Casilla [][] tablaSLR;//[Estado][simbolo]

	public AnalizadorSintactico() {
		tablaSLR = new Casilla[78][46];
		int i = 0, j=0;
		for(i=0;i<78;i++) {
			for(j=0;j<46;j++) {
				System.out.println("Casilla"+"["+i+","+j+"]----------------------");
				tablaSLR[i][j] = new Casilla();								
			}//for
		}//for
		/**
		 * valores de la tablaSLR agrupados por filas. de momento no hay accion semantica.
		 */
		tablaSLR[0][Simbolo.pr3.id] 			= new Casilla(DESPLAZAR,10,0);
		tablaSLR[0][Simbolo.pr6.id] 			= new Casilla(DESPLAZAR,5,0);
		tablaSLR[0][Simbolo.pr10.id]			= new Casilla(DESPLAZAR,11,0);
		tablaSLR[0][Simbolo.pr11.id] 			= new Casilla(DESPLAZAR,8,0);
		tablaSLR[0][Simbolo.pr12.id] 			= new Casilla(DESPLAZAR,9,0);
		tablaSLR[0][Simbolo.pr13.id] 			= new Casilla(DESPLAZAR,7,0);
		tablaSLR[0][Simbolo.eof.id] 			= new Casilla(DESPLAZAR,4,0);
		tablaSLR[0][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,6,0);
		tablaSLR[0][Goto.PP.id] 				= new Casilla(REDUCIR,1,0);
		tablaSLR[0][Goto.S.id] 					= new Casilla(REDUCIR,2,0);
		tablaSLR[0][Goto.F.id] 					= new Casilla(REDUCIR,3,0);
		
		tablaSLR[1][Simbolo.DOLLAR.id] = new Casilla(ACEPTAR,100,0);
		
		tablaSLR[2][Simbolo.pr3.id] 			= new Casilla(DESPLAZAR,10,0);
		tablaSLR[2][Simbolo.pr6.id] 			= new Casilla(DESPLAZAR,5,0);
		tablaSLR[2][Simbolo.pr10.id] 			= new Casilla(DESPLAZAR,11,0);
		tablaSLR[2][Simbolo.pr11.id] 			= new Casilla(DESPLAZAR,8,0);
		tablaSLR[2][Simbolo.pr12.id] 			= new Casilla(DESPLAZAR,9,0);
		tablaSLR[2][Simbolo.pr13.id] 			= new Casilla(DESPLAZAR,7,0);
		tablaSLR[2][Simbolo.eof.id] 			= new Casilla(DESPLAZAR,4,0);
		tablaSLR[2][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,6,0);
		tablaSLR[2][Goto.PP.id] 				= new Casilla(REDUCIR,12,0);
		tablaSLR[2][Goto.S.id] 					= new Casilla(REDUCIR,2,0);
		
		tablaSLR[3][Simbolo.pr3.id] 			= new Casilla(DESPLAZAR,10,0);
		tablaSLR[3][Simbolo.pr6.id] 			= new Casilla(DESPLAZAR,5,0);
		tablaSLR[3][Simbolo.pr10.id] 			= new Casilla(DESPLAZAR,11,0);
		tablaSLR[3][Simbolo.pr11.id] 			= new Casilla(DESPLAZAR,8,0);
		tablaSLR[3][Simbolo.pr12.id] 			= new Casilla(DESPLAZAR,9,0);
		tablaSLR[3][Simbolo.pr13.id] 			= new Casilla(DESPLAZAR,7,0);
		tablaSLR[3][Simbolo.eof.id] 			= new Casilla(DESPLAZAR,4,0);
		tablaSLR[3][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,6,0);
		tablaSLR[3][Goto.PP.id] 				= new Casilla(REDUCIR,43,0);
		tablaSLR[3][Goto.S.id] 					= new Casilla(REDUCIR,2,0);
		
		tablaSLR[4][Simbolo.DOLLAR.id] 			= new Casilla(REDUCIR,4,0);
		
		tablaSLR[5][Simbolo.IDENTIFICADOR.id]	= new Casilla(REDUCIR,13,0);
		
		tablaSLR[6][Simbolo.pr3.id]		= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.pr6.id]		= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.pr10.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.pr11.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.pr12.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.pr13.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.eof.id]		= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.COMA.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.PYCOMA.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.PARENTESIS_A.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.PARENTESIS_C.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.OP_ARIT_SUMA.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.OP_REL_IGUAL.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.OP_LOG_AND.id]		= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.ASIG_SIMPLE.id]		= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Simbolo.IDENTIFICADOR.id]	= new Casilla(REDUCIR,27,0);
		tablaSLR[6][Goto.LF.id]					= new Casilla(REDUCIR,14,0);
		
		tablaSLR[7][Simbolo.PYCOMA.id] 			= new Casilla(REDUCIR,40,0);
		tablaSLR[7][Simbolo.CADENA.id] 			= new Casilla(DESPLAZAR,22,0);
		tablaSLR[7][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[7][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[7][Simbolo.ENTERO.id] 			= new Casilla(DESPLAZAR,25,0);
		tablaSLR[7][Goto.OP_0.id] 				= new Casilla(REDUCIR,18,0);
		tablaSLR[7][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[7][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[7][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		tablaSLR[7][Goto.R.id] 					= new Casilla(REDUCIR,17,0);
		
		tablaSLR[8][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,27,0);
		tablaSLR[8][Goto.IO.id] 				= new Casilla(REDUCIR,27,0);
		
		tablaSLR[9][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,27,0);
		tablaSLR[9][Goto.IO.id] 				= new Casilla(REDUCIR,28,0);
		
		tablaSLR[10][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,29,0);
		
		tablaSLR[11][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,32,0);
		tablaSLR[11][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,33,0);
		tablaSLR[11][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,34,0);
		tablaSLR[11][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,31,0);
		tablaSLR[11][Goto.T.id] 				= new Casilla(REDUCIR,31,0);
		tablaSLR[11][Goto.RF.id] 				= new Casilla(REDUCIR,30,0);
		
		tablaSLR[12][Simbolo.DOLLAR.id] 		= new Casilla(REDUCIR,2,0);
		
		tablaSLR[13][Simbolo.ASIG_SIMPLE.id] 	= new Casilla(DESPLAZAR,35,0);
		
		tablaSLR[14][Simbolo.pr3.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.pr6.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.pr10.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.pr11.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.pr12.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.pr13.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.eof.id]			= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.LLAVE_C.id]		= new Casilla(REDUCIR,27,0);
		tablaSLR[14][Simbolo.IDENTIFICADOR.id]	= new Casilla(REDUCIR,27,0);
		
		tablaSLR[15][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[15][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[15][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[15][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[15][Goto.OP_0.id] 				= new Casilla(REDUCIR,36,0);
		tablaSLR[15][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[15][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[15][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[16][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[16][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[16][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[16][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[16][Goto.OP_0.id] 				= new Casilla(REDUCIR,37,0);
		tablaSLR[16][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[16][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[16][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[17][Simbolo.PYCOMA.id] 		= new Casilla(DESPLAZAR,38,0);
		
		tablaSLR[18][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,39,0);
		tablaSLR[18][Simbolo.OP_LOG_AND.id] 	= new Casilla(DESPLAZAR,39,0);
		
		tablaSLR[19][Simbolo.COMA.id] 			= new Casilla(REDUCIR,17,0);
		tablaSLR[19][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,17,0);		
		tablaSLR[19][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,17,0);
		tablaSLR[19][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(DESPLAZAR,40,0);
		tablaSLR[19][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,17,0);
		
		tablaSLR[20][Simbolo.COMA.id] 			= new Casilla(REDUCIR,19,0);
		tablaSLR[20][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,19,0);		
		tablaSLR[20][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,19,0);
		tablaSLR[20][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(DESPLAZAR,41,0);
		tablaSLR[20][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,19,0);
		tablaSLR[20][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,19,0);
		
		tablaSLR[21][Simbolo.COMA.id] 			= new Casilla(REDUCIR,21,0);
		tablaSLR[21][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,21,0);		
		tablaSLR[21][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,21,0);
		tablaSLR[21][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,21,0);
		tablaSLR[21][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,21,0);
		tablaSLR[21][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,21,0);
		
		tablaSLR[22][Simbolo.COMA.id] 			= new Casilla(REDUCIR,22,0);
		tablaSLR[22][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,22,0);		
		tablaSLR[22][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,22,0);
		tablaSLR[22][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,22,0);
		tablaSLR[22][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,22,0);
		tablaSLR[22][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,22,0);		
				
		tablaSLR[23][Simbolo.COMA.id] 			= new Casilla(REDUCIR,23,0);
		tablaSLR[23][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,23,0);		
		tablaSLR[23][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,23,0);
		tablaSLR[23][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,23,0);
		tablaSLR[23][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,23,0);
		tablaSLR[23][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,23,0);
		
		tablaSLR[24][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,16,0);
		tablaSLR[24][Goto.LF.id] 				= new Casilla(REDUCIR,42,0);
		
		tablaSLR[25][Simbolo.COMA.id] 			= new Casilla(REDUCIR,25,0);
		tablaSLR[25][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,25,0);		
		tablaSLR[25][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,25,0);
		tablaSLR[25][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,25,0);
		tablaSLR[25][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,25,0);
		tablaSLR[25][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,25,0);
		
		tablaSLR[26][Simbolo.PYCOMA.id] 	= new Casilla(DESPLAZAR,44,0);
		
		tablaSLR[27][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[27][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[27][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[27][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[27][Goto.OP_0.id] 				= new Casilla(REDUCIR,45,0);
		tablaSLR[27][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[27][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[27][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[28][Simbolo.PYCOMA.id] 	= new Casilla(DESPLAZAR,46,0);
		
		tablaSLR[29][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[29][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[29][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[29][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[29][Goto.OP_0.id] 				= new Casilla(REDUCIR,47,0);
		tablaSLR[29][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[29][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[29][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[30][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,48,0);
		
		tablaSLR[31][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,32,0);
		
		tablaSLR[32][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,12,0);
		
		tablaSLR[33][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,13,0);
		
		tablaSLR[34][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,14,0);
		
		tablaSLR[35][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[35][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[35][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[35][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[35][Goto.OP_0.id] 				= new Casilla(REDUCIR,49,0);
		tablaSLR[35][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[35][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[35][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[36][Simbolo.PYCOMA.id] 		= new Casilla(DESPLAZAR,50,0);
		tablaSLR[36][Simbolo.OP_LOG_AND.id] 	= new Casilla(DESPLAZAR,39,0);
		
		tablaSLR[37][Simbolo.COMA.id] 			= new Casilla(DESPLAZAR,53,0);
		tablaSLR[37][Simbolo.PARENTESIS_C.id] 	= new Casilla(DESPLAZAR,54,0);
		tablaSLR[37][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,39,0);
		tablaSLR[37][Goto.LF1.id] 				= new Casilla(REDUCIR,52,0);
		
		tablaSLR[38][Simbolo.pr3.id] 			= new Casilla(REDUCIR,8,0);		
		tablaSLR[38][Simbolo.pr6.id] 			= new Casilla(REDUCIR,8,0);		
		tablaSLR[38][Simbolo.pr10.id] 			= new Casilla(REDUCIR,8,0);
		tablaSLR[38][Simbolo.pr11.id] 			= new Casilla(REDUCIR,8,0);
		tablaSLR[38][Simbolo.pr12.id] 			= new Casilla(REDUCIR,8,0);
		tablaSLR[38][Simbolo.pr13.id] 			= new Casilla(REDUCIR,8,0);
		tablaSLR[38][Simbolo.eof.id] 			= new Casilla(REDUCIR,8,0);
		tablaSLR[38][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,8,0);
		tablaSLR[38][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,8,0);
		
		tablaSLR[39][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[39][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[39][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[39][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);		
		tablaSLR[39][Goto.OP_1.id] 				= new Casilla(REDUCIR,55,0);
		tablaSLR[39][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[39][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[40][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[40][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[40][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[40][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);				
		tablaSLR[40][Goto.OP_2.id] 				= new Casilla(REDUCIR,56,0);
		tablaSLR[40][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[41][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[41][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[41][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[41][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);						
		tablaSLR[41][Goto.OS.id] 				= new Casilla(REDUCIR,57,0);
		
		tablaSLR[42][Simbolo.COMA.id] 			= new Casilla(REDUCIR,24,0);
		tablaSLR[42][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,24,0);		
		tablaSLR[42][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,24,0);
		tablaSLR[42][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,24,0);
		tablaSLR[42][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,24,0);
		tablaSLR[42][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,24,0);
		
		tablaSLR[43][Simbolo.DOLLAR.id] 	= new Casilla(REDUCIR,3,0);
		
		tablaSLR[44][Simbolo.pr3.id] 			= new Casilla(REDUCIR,9,0);		
		tablaSLR[44][Simbolo.pr6.id] 			= new Casilla(REDUCIR,9,0);		
		tablaSLR[44][Simbolo.pr10.id] 			= new Casilla(REDUCIR,9,0);
		tablaSLR[44][Simbolo.pr11.id] 			= new Casilla(REDUCIR,9,0);
		tablaSLR[44][Simbolo.pr12.id] 			= new Casilla(REDUCIR,9,0);
		tablaSLR[44][Simbolo.pr13.id] 			= new Casilla(REDUCIR,9,0);
		tablaSLR[44][Simbolo.eof.id] 			= new Casilla(REDUCIR,9,0);
		tablaSLR[44][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,9,0);
		tablaSLR[44][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,9,0);
		
		tablaSLR[45][Simbolo.PARENTESIS_C.id] 	= new Casilla(DESPLAZAR,58,0);
		tablaSLR[45][Simbolo.OP_LOG_AND.id] 	= new Casilla(DESPLAZAR,39,0);
		
		tablaSLR[46][Simbolo.pr3.id] 			= new Casilla(REDUCIR,10,0);		
		tablaSLR[46][Simbolo.pr6.id] 			= new Casilla(REDUCIR,10,0);		
		tablaSLR[46][Simbolo.pr10.id] 			= new Casilla(REDUCIR,10,0);
		tablaSLR[46][Simbolo.pr11.id] 			= new Casilla(REDUCIR,10,0);
		tablaSLR[46][Simbolo.pr12.id] 			= new Casilla(REDUCIR,10,0);
		tablaSLR[46][Simbolo.pr13.id] 			= new Casilla(REDUCIR,10,0);
		tablaSLR[46][Simbolo.eof.id] 			= new Casilla(REDUCIR,10,0);
		tablaSLR[46][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,10,0);
		tablaSLR[46][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,10,0);
		
		tablaSLR[47][Simbolo.PARENTESIS_C.id] 	= new Casilla(DESPLAZAR,59,0);
		tablaSLR[47][Simbolo.OP_LOG_AND.id] 	= new Casilla(DESPLAZAR,39,0);
		
		tablaSLR[48][Simbolo.PARENTESIS_A.id] 	= new Casilla(DESPLAZAR,60,0);
		
		tablaSLR[49][Simbolo.PYCOMA.id] 		= new Casilla(DESPLAZAR,61,0);
		tablaSLR[49][Simbolo.OP_LOG_AND.id] 	= new Casilla(DESPLAZAR,39,0);
		
		tablaSLR[50][Simbolo.pr3.id] 			= new Casilla(REDUCIR,7,0);		
		tablaSLR[50][Simbolo.pr6.id] 			= new Casilla(REDUCIR,7,0);		
		tablaSLR[50][Simbolo.pr10.id] 			= new Casilla(REDUCIR,7,0);
		tablaSLR[50][Simbolo.pr11.id] 			= new Casilla(REDUCIR,7,0);
		tablaSLR[50][Simbolo.pr12.id] 			= new Casilla(REDUCIR,7,0);
		tablaSLR[50][Simbolo.pr13.id] 			= new Casilla(REDUCIR,7,0);
		tablaSLR[50][Simbolo.eof.id] 			= new Casilla(REDUCIR,7,0);
		tablaSLR[50][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,7,0);
		tablaSLR[50][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,7,0);
		
		tablaSLR[52][Simbolo.pr3.id] 			= new Casilla(REDUCIR,28,0);		
		tablaSLR[52][Simbolo.pr6.id] 			= new Casilla(REDUCIR,28,0);		
		tablaSLR[52][Simbolo.pr10.id] 			= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.pr11.id] 			= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.pr12.id] 			= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.pr13.id] 			= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.eof.id] 			= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.COMA.id] 			= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,28,0);		
		tablaSLR[52][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,28,0);
		tablaSLR[52][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,28,0);
		
		tablaSLR[53][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[53][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[53][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[53][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[53][Goto.OP_0.id] 				= new Casilla(REDUCIR,63,0);
		tablaSLR[53][Goto.OP_1.id] 				= new Casilla(REDUCIR,19,0);
		tablaSLR[53][Goto.OP_2.id] 				= new Casilla(REDUCIR,20,0);
		tablaSLR[53][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);
		
		tablaSLR[54][Goto.OP_0.id] 		= new Casilla(REDUCIR,64,0);
		
		tablaSLR[55][Simbolo.COMA.id] 			= new Casilla(REDUCIR,16,0);
		tablaSLR[55][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,16,0);		
		tablaSLR[55][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,16,0);
		tablaSLR[55][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(DESPLAZAR,65,0);
		tablaSLR[55][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,16,0);
		
		tablaSLR[56][Simbolo.COMA.id] 			= new Casilla(REDUCIR,18,0);
		tablaSLR[56][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,18,0);		
		tablaSLR[56][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,18,0);
		tablaSLR[56][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(DESPLAZAR,66,0);
		tablaSLR[56][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,18,0);
		tablaSLR[56][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,18,0);
		
		tablaSLR[57][Simbolo.COMA.id] 			= new Casilla(REDUCIR,20,0);
		tablaSLR[57][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,20,0);		
		tablaSLR[57][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,20,0);
		tablaSLR[57][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,20,0);
		tablaSLR[57][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,20,0);
		tablaSLR[57][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,20,0);
		
		tablaSLR[58][Simbolo.PYCOMA.id] 	= new Casilla(REDUCIR,15,0);
		
		tablaSLR[59][Simbolo.pr3.id] 			= new Casilla(DESPLAZAR,10,0);
		tablaSLR[59][Simbolo.pr6.id] 			= new Casilla(DESPLAZAR,5,0);		
		tablaSLR[59][Simbolo.pr11.id] 			= new Casilla(DESPLAZAR,8,0);
		tablaSLR[59][Simbolo.pr12.id] 			= new Casilla(DESPLAZAR,9,0);
		tablaSLR[59][Simbolo.pr13.id] 			= new Casilla(DESPLAZAR,7,0);		
		tablaSLR[59][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,6,0);		
		tablaSLR[59][Goto.S.id] 				= new Casilla(REDUCIR,67,0);
		
		tablaSLR[60][Simbolo.pr7.id] 	= new Casilla(DESPLAZAR,32,0);
		tablaSLR[60][Simbolo.pr8.id] 	= new Casilla(DESPLAZAR,33,0);
		tablaSLR[60][Simbolo.pr9.id] 	= new Casilla(DESPLAZAR,34,0);
		tablaSLR[60][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,33,0);
		tablaSLR[60][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,31,0);
		tablaSLR[60][Goto.T.id] 				= new Casilla(REDUCIR,31,0);
		tablaSLR[60][Goto.PF_0.id] 				= new Casilla(REDUCIR,68,0);
		
		tablaSLR[61][Simbolo.pr3.id] 			= new Casilla(REDUCIR,5,0);		
		tablaSLR[61][Simbolo.pr6.id] 			= new Casilla(REDUCIR,5,0);		
		tablaSLR[61][Simbolo.pr10.id] 			= new Casilla(REDUCIR,5,0);
		tablaSLR[61][Simbolo.pr11.id] 			= new Casilla(REDUCIR,5,0);
		tablaSLR[61][Simbolo.pr12.id] 			= new Casilla(REDUCIR,5,0);
		tablaSLR[61][Simbolo.pr13.id] 			= new Casilla(REDUCIR,5,0);
		tablaSLR[61][Simbolo.eof.id] 			= new Casilla(REDUCIR,5,0);
		tablaSLR[61][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,5,0);
		tablaSLR[61][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,5,0);
		
		tablaSLR[63][Simbolo.COMA.id] 			= new Casilla(DESPLAZAR,53,0);
		tablaSLR[63][Simbolo.PARENTESIS_C.id] 	= new Casilla(DESPLAZAR,54,0);
		tablaSLR[63][Simbolo.OP_LOG_AND.id] 	= new Casilla(DESPLAZAR,39,0);
		tablaSLR[63][Goto.LF1.id] 				= new Casilla(REDUCIR,69,0);
		
		tablaSLR[64][Simbolo.pr3.id] 			= new Casilla(REDUCIR,30,0);		
		tablaSLR[64][Simbolo.pr6.id] 			= new Casilla(REDUCIR,30,0);		
		tablaSLR[64][Simbolo.pr11.id] 			= new Casilla(REDUCIR,30,0);
		tablaSLR[64][Simbolo.pr12.id] 			= new Casilla(REDUCIR,30,0);
		tablaSLR[64][Simbolo.pr13.id] 			= new Casilla(REDUCIR,30,0);
		tablaSLR[64][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,30,0);		
		tablaSLR[64][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,30,0);
		tablaSLR[64][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,30,0);
		
		tablaSLR[65][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[65][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[65][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[65][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);
		tablaSLR[65][Goto.OP_2.id] 				= new Casilla(REDUCIR,70,0);
		tablaSLR[65][Goto.OS.id] 				= new Casilla(REDUCIR,21,0);

		tablaSLR[66][Simbolo.CADENA.id] 		= new Casilla(DESPLAZAR,22,0);
		tablaSLR[66][Simbolo.PALABRA_RESERVADA.id] = new Casilla(DESPLAZAR,23,0);
		tablaSLR[66][Simbolo.IDENTIFICADOR.id] 	= new Casilla(DESPLAZAR,24,0);
		tablaSLR[66][Simbolo.ENTERO.id] 		= new Casilla(DESPLAZAR,25,0);		
		tablaSLR[66][Goto.OS.id] 				= new Casilla(REDUCIR,71,0);
		
		tablaSLR[67][Simbolo.pr3.id] 			= new Casilla(REDUCIR,11,0);		
		tablaSLR[67][Simbolo.pr6.id] 			= new Casilla(REDUCIR,11,0);		
		tablaSLR[67][Simbolo.pr10.id] 			= new Casilla(REDUCIR,11,0);
		tablaSLR[67][Simbolo.pr11.id] 			= new Casilla(REDUCIR,11,0);
		tablaSLR[67][Simbolo.pr12.id] 			= new Casilla(REDUCIR,11,0);
		tablaSLR[67][Simbolo.pr13.id] 			= new Casilla(REDUCIR,11,0);
		tablaSLR[67][Simbolo.eof.id] 			= new Casilla(REDUCIR,11,0);
		tablaSLR[67][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,11,0);
		tablaSLR[67][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,11,0);
		
		tablaSLR[68][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,72,0);
		
		tablaSLR[69][Simbolo.pr3.id] 			= new Casilla(REDUCIR,29,0);		
		tablaSLR[69][Simbolo.pr6.id] 			= new Casilla(REDUCIR,29,0);				
		tablaSLR[69][Simbolo.pr11.id] 			= new Casilla(REDUCIR,29,0);
		tablaSLR[69][Simbolo.pr12.id] 			= new Casilla(REDUCIR,29,0);
		tablaSLR[69][Simbolo.pr13.id] 			= new Casilla(REDUCIR,29,0);
		tablaSLR[69][Simbolo.PARENTESIS_C.id]	= new Casilla(REDUCIR,29,0);
		tablaSLR[69][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,29,0);
		
		tablaSLR[70][Simbolo.COMA.id] 			= new Casilla(REDUCIR,18,0);
		tablaSLR[70][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,18,0);		
		tablaSLR[70][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,18,0);
		tablaSLR[70][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(DESPLAZAR,41,0);
		tablaSLR[70][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,18,0);
		tablaSLR[70][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,18,0);

		tablaSLR[71][Simbolo.COMA.id] 			= new Casilla(REDUCIR,20,0);
		tablaSLR[71][Simbolo.PYCOMA.id] 		= new Casilla(REDUCIR,20,0);		
		tablaSLR[71][Simbolo.PARENTESIS_C.id] 	= new Casilla(REDUCIR,20,0);
		tablaSLR[71][Simbolo.OP_ARIT_SUMA.id] 	= new Casilla(REDUCIR,20,0);
		tablaSLR[71][Simbolo.OP_REL_IGUAL.id] 	= new Casilla(REDUCIR,20,0);
		tablaSLR[71][Simbolo.OP_LOG_AND.id] 	= new Casilla(REDUCIR,20,0);
		
		tablaSLR[72][Simbolo.LLAVE_C.id] 		= new Casilla(DESPLAZAR,73,0);
		
		tablaSLR[73][Simbolo.pr3.id] 			= new Casilla(DESPLAZAR,10,0);
		tablaSLR[73][Simbolo.pr6.id] 			= new Casilla(DESPLAZAR,5,0);		
		tablaSLR[73][Simbolo.pr11.id] 			= new Casilla(DESPLAZAR,8,0);
		tablaSLR[73][Simbolo.pr12.id] 			= new Casilla(DESPLAZAR,9,0);
		tablaSLR[73][Simbolo.pr13.id] 			= new Casilla(DESPLAZAR,7,0);
		tablaSLR[73][Goto.S.id] 				= new Casilla(REDUCIR,75,0);
		tablaSLR[73][Goto.CF.id] 				= new Casilla(REDUCIR,74,0);
		
		tablaSLR[74][Simbolo.LLAVE_C.id] 		= new Casilla(DESPLAZAR,76,0);
		
		tablaSLR[75][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,37,0);
		tablaSLR[75][Goto.CF.id] 				= new Casilla(REDUCIR,75,0);
		tablaSLR[75][Goto.S.id] 				= new Casilla(REDUCIR,77,0);
		
		tablaSLR[76][Simbolo.pr3.id] 			= new Casilla(REDUCIR,26,0);		
		tablaSLR[76][Simbolo.pr6.id] 			= new Casilla(REDUCIR,26,0);		
		tablaSLR[76][Simbolo.pr11.id] 			= new Casilla(REDUCIR,26,0);
		tablaSLR[76][Simbolo.pr12.id] 			= new Casilla(REDUCIR,26,0);
		tablaSLR[76][Simbolo.pr13.id] 			= new Casilla(REDUCIR,26,0);
		tablaSLR[76][Simbolo.eof.id] 			= new Casilla(REDUCIR,26,0);
		tablaSLR[76][Simbolo.IDENTIFICADOR.id] 	= new Casilla(REDUCIR,26,0);
		
		tablaSLR[77][Simbolo.LLAVE_C.id] 		= new Casilla(REDUCIR,38,0);
		
	}//constructor
}//AS
