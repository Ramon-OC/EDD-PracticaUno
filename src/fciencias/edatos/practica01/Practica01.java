package fciencias.edatos.practica01;

import java.util.Arrays;

/**
* Práctica Uno del curso de Estructuras de Datos.
* @author Pintor Muñoz Pedro Joshue - 420053796
* @author Ortiz Castañeda José Ramón - 318357115
* @version 2.0 01 de octubre de 2021
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class Practica01{

//EJERCICIO 1

	/** 
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite
	* @param array1 el primer arreglo a mezlar
	* @param n el límite de mezcla del primer arreglo
	* @param array2 el segundo arreglo a mezclar
	* @param m el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud m+n con la mezcla definida.
	*/
	public static int[] mergeSortedArray(int[] array1, int n, int[] array2, int m){
		if(n > array1.length || m > array2.length)
			throw new RuntimeException("Límites no válidos");
		
		int[] result = new int[n + m];
		int pointer;
		for(pointer = 0; pointer < n; pointer++)
			result[pointer] = array1[pointer];
		for(int i = 0 ; i < m ; i++, pointer++)
			result[pointer] = array2[i];
		
		// Ordenamiento del arreglo result
		for(int j = 0; j < result.length - 1; j++){
			for(int k = j+1; k < result.length; k++){
				if(result[k] < result[j]){
					int aux = result[k];
					result[k] = result[j];
					result[j] = aux;
				}
			}
		}
		return result;
	}

	/** 
	* Hace la mezcla de dos arreglos ordenados desde la primera posición hasta
	* una posición límite. Compara los extremos de la izquierda para ordenarlos nuevamente.
	* @param arrayOne el primer arreglo a mezlar
	* @param valueOne el límite de mezcla del primer arreglo
	* @param arrayTwo el segundo arreglo a mezclar
	* @param valueTwo el límite de mezcla del segundo arreglo.
	* @return un arreglo ordenado de longitud valueOne+valueTwo con la mezcla definida.
	*/
	public static int[] mergeSortedArraySolution(int[]arrayOne, int valueOne, int[]arrayTwo, int valueTwo){
		int[] arrayTemp = new int[valueOne+valueTwo];
		for(int i = 0, uno = 0, dos = 0; i<arrayTemp.length; i++){ // i es el contador del arreglo temporal, uno y dos de los arreglos
			if(arrayOne[uno]<arrayTwo[dos] && uno<valueOne || dos == valueTwo && uno < valueOne){
				arrayTemp[i]=arrayOne[uno];
				uno++;
			}else if(arrayTwo[dos]<arrayOne[uno] && dos < valueTwo || uno == valueOne && dos < valueTwo){
				arrayTemp[i]=arrayTwo[dos];
				dos++;
			}else if(arrayTwo[dos]==arrayOne[uno]){
				arrayTemp[i]=arrayOne[uno];
				arrayTemp[i+1]=arrayTwo[dos];
				i++;
				dos++;
				uno++;
			}
		}
		return arrayTemp;
	}

//EJERCICIO 2

	/**
	 * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
	 * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
	 * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	 * false en otro caso.
	 */
	public static boolean isValidBoard(int[][] board){
		int length = board.length;
		for (int i = 0; i < length ; i++) {
			for (int j = 0; j < length ; j++ ) {
				boolean verificador = false;
				// Verifica sobre las filas
				for(int k = 0 ; k < length; k++){
					if(board[i][k] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
				verificador = false;
				// Verifica sobre las columnas
				for(int k = 0 ; k < length; k++){
					if(board[k][i] == j){
						verificador = true;
						break;
					}
				}
				if(!verificador){
					return false;
				}
			}
		}
		return true;
	}

	/**
	 * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
	 * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
	 * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	 * false en otro caso.
	 */
	public static boolean isValidBoardSolution(int[][] num){
			
		boolean duplicate = false;
		int[] columnaTemp = new int[num[0].length+1]; 
		int[] lineaTemp = new int[num[0].length+1];

		for(int i=0; i<num.length;i++ ){

			for(int j=0; j<num[0].length;j++){		//Revisa linea por linea si hay elementos repetidos					
				if(num[i][j]<=num[0].length){		//Verifica que la cifra sea menor o igual al largo de la tabla
					lineaTemp[num[i][j]]++;
				}else{
					System.out.println("ERROR: La cifra es mayor que el largo del arreglo");
				}
				if(lineaTemp[num[j][i]]>1){
					return true;
				}
			}				
			lineaTemp=new int[num[0].length+1];


			for(int j=0; j<num.length;j++){			//Revisa columna por columna si hay elementos repetidos		
				if(num[j][i]<=num.length){ 			//Verifica que la cifra sea menor o igual al largo de la tabla
					columnaTemp[num[j][i]]++;
				}else{
					System.out.println("ERROR: La cifra es mayor que el largo del arreglo");
				}
				if(columnaTemp[num[j][i]]>1){
					return true;
				}			
			}
			columnaTemp=new int[num.length+1];				
		}
		return duplicate;
	}


	//EJERCICIO 3

	/**
	* Rota position cantidad de veces los elementos de un arreglo
	* hacia el vecino izquierdo.
	* @param num el arreglo de enteros a rotar.
	* @param position la cantidad de espacios a rotar.
	*/
	public static void rotateArray(int[] num, int position){
		for(int i = 0; i < position ; i++){
			int aux = num[0];
			for(int j = 0; j < num.length -1 ; j++){
				num[j] = num[j+1];
			}
			num[num.length-1] = aux;
		}
	}

	/**
	 * Rota position cantidad de veces los elementos de un arreglo
	 * hacia el vecino izquierdo.
	 * @param arr el arreglo de enteros a rotar.
	 * @param lugares la cantidad de espacios a rotar.
	 */
	public static void rotateArraySolution(int[] arr, int lugares){
		int[] temp = new int[arr.length];
		int posicionNuevo;
		for(int i = 0; i < arr.length ; i++){
			posicionNuevo = i-lugares;
			if(posicionNuevo<0){
				temp[arr.length + posicionNuevo] = arr[i];
			}else{
				temp[posicionNuevo] = arr[i];
			}
		}
		// Copia el arreglo temporal en el orginal
		for(int i = 0; i < arr.length ; i++) {
			arr[i] = temp[i];
		}
	}


	public static void main(String[] args) {

		long inicio,fin; // Variables para medir el tiempo
		String directorio1 = "src/fciencias/edatos/practica01/Tests/ArrayTests/";
		String directorio2 = "src/fciencias/edatos/practica01/Tests/BoardTests/";

		// Arreglos para los algoritmos de Emmanuel
		int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] arrayB1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB2 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] arrayC1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC2 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");

		int[] arrayD1 = ArrayReader.readArray(directorio1 + "ArrayD1.txt");
		int[] arrayD2 = ArrayReader.readArray(directorio1 + "ArrayD2.txt");
		int[] arrayE1 = ArrayReader.readArray(directorio1 + "ArrayE1.txt");
		int[] arrayE2 = ArrayReader.readArray(directorio1 + "ArrayE2.txt");
		int[] arrayF1 = ArrayReader.readArray(directorio1 + "ArrayF1.txt");
		int[] arrayF2 = ArrayReader.readArray(directorio1 + "ArrayF2.txt");

		// Arreglos para el ejercicio tres (el método anterior los modfica)
		int[] arrayA11 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayB11 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayC11 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayD11 = ArrayReader.readArray(directorio1 + "ArrayD1.txt");
		int[] arrayE11 = ArrayReader.readArray(directorio1 + "ArrayE1.txt");
		int[] arrayF11 = ArrayReader.readArray(directorio1 + "ArrayF1.txt");

		// Arreglos bidimensionales para los algoritmos 
		int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
		int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
		int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
		int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
		int[][] boardE = ArrayReader.readMatrix(directorio2 + "BoardE.txt");
		int[][] boardF = ArrayReader.readMatrix(directorio2 + "BoardF.txt");


		System.out.println("\nEjemplos de actividad uno con el código de Emmanuel\n");
			inicio = System.currentTimeMillis();
			int[] resultA = mergeSortedArray(arrayA1, 500, arrayA2, 700);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA1 y arrayA2 con el código de Emmanuel tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado A: "+Arrays.toString(resultA));

			inicio = System.currentTimeMillis();
			int[] resultB = mergeSortedArray(arrayB1, 2000, arrayB2, 3500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB1 y arrayB2 con el código de Emmanuel tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado B: "+Arrays.toString(resultB));

			inicio = System.currentTimeMillis();
			int[] resultC = mergeSortedArray(arrayC1, 4000, arrayC2, 4000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC1 y arrayC2 con el código de Emmanuel tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado C: "+Arrays.toString(resultC));

			inicio = System.currentTimeMillis();
			int[] resultD = mergeSortedArray(arrayD1, 7000, arrayD2, 8000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayD1 y arrayD2 con el código de Emmanuel tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado D: "+Arrays.toString(resultD));

			inicio = System.currentTimeMillis();
			int[] resultE = mergeSortedArray(arrayE1, 15000, arrayE2, 19000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayE1 y arrayE2 con el código de Emmanuel tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado E: "+Arrays.toString(resultE));

			inicio = System.currentTimeMillis();
			int[] resultF = mergeSortedArray(arrayF1, 30000, arrayF2, 25000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayF1 y arrayF2 con el código de Emmanuel tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado F: "+Arrays.toString(resultF));

		System.out.println("\nEjemplos de actividad uno con nuestro código\n");

			inicio = System.currentTimeMillis();
			int[] resultAPropio = mergeSortedArraySolution(arrayA1, 500, arrayA2, 700);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA1 y arrayA2 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado A: "+Arrays.toString(resultAPropio));

			inicio = System.currentTimeMillis();
			int[] resultBPropio = mergeSortedArraySolution(arrayB1, 2000, arrayB2, 3500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB1 y arrayB2 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado B: "+Arrays.toString(resultBPropio));

			inicio = System.currentTimeMillis();
			int[] resultCPropio = mergeSortedArraySolution(arrayC1, 4000, arrayC2, 4000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC1 y arrayC2 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado C: "+Arrays.toString(resultCPropio));

			inicio = System.currentTimeMillis();
			int[] resultDPropio = mergeSortedArraySolution(arrayD1, 7000, arrayD2, 8000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayD1 y arrayD2 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado D: "+Arrays.toString(resultDPropio));

			inicio = System.currentTimeMillis();
			int[] resultEPropio = mergeSortedArraySolution(arrayE1, 15000, arrayE2, 19000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayE1 y arrayE2 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado E: "+Arrays.toString(resultEPropio));

			inicio = System.currentTimeMillis();
			int[] resultFPropio = mergeSortedArraySolution(arrayF1, 30000, arrayF2, 25000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayF1 y arrayF2 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado F: "+Arrays.toString(resultFPropio));

		System.out.println("\nEjemplos de actividad dos con el código de Emmanuel\n");
			inicio = System.currentTimeMillis();
			boolean boardResultA = isValidBoard(boardA);
			fin = System.currentTimeMillis();
			System.out.println("El boardA con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero A con el algoritmo de Emmanuel es válido: "+boardResultA);

			inicio = System.currentTimeMillis();
			boolean boardResultB = isValidBoard(boardB);
			fin = System.currentTimeMillis();
			System.out.println("El boardB con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero B con el algoritmo de Emmanuel es válido: "+boardResultB);

			inicio = System.currentTimeMillis();
			boolean boardResultC = isValidBoard(boardC);
			fin = System.currentTimeMillis();
			System.out.println("El boardC con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero C con el algoritmo de Emmanuel es válido: "+boardResultC);

			inicio = System.currentTimeMillis();
			boolean boardResultD = isValidBoard(boardD);
			fin = System.currentTimeMillis();
			System.out.println("El boardD con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero D con el algoritmo de Emmanuel es válido: "+boardResultD);

			inicio = System.currentTimeMillis();
			boolean boardResultE = isValidBoard(boardE);
			fin = System.currentTimeMillis();
			System.out.println("El boardE con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero E con el algoritmo de Emmanuel es válido: "+boardResultD);

			inicio = System.currentTimeMillis();
			boolean boardResultF = isValidBoard(boardF);
			fin = System.currentTimeMillis();
			System.out.println("El boardF con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero F con el algoritmo de Emmanuel es válido: "+boardResultD);

		System.out.println("\nEjemplos de actividad dos con nuestro código\n");
			inicio = System.currentTimeMillis();
			boolean boardSolutionA = isValidBoardSolution(boardA);
			fin = System.currentTimeMillis();
			System.out.println("El boardA con el nuestro código: "+ (fin - inicio) + " milisegundos.");

			inicio = System.currentTimeMillis();
			boolean boardSolutionB = isValidBoardSolution(boardB);
			fin = System.currentTimeMillis();
			System.out.println("El boardB con el nuestro código: "+ (fin - inicio) + " milisegundos.");

			inicio = System.currentTimeMillis();
			boolean boardSolutionC = isValidBoardSolution(boardC);
			fin = System.currentTimeMillis();
			System.out.println("El boardC con el nuestro código: "+ (fin - inicio) + " milisegundos.");

			inicio = System.currentTimeMillis();
			boolean boardSolutionD = isValidBoardSolution(boardD);
			fin = System.currentTimeMillis();
			System.out.println("El boardD con el nuestro código: "+ (fin - inicio) + " milisegundos.");

			inicio = System.currentTimeMillis();
			boolean boardSolutionE = isValidBoardSolution(boardE);
			fin = System.currentTimeMillis();
			System.out.println("El boardE con el nuestro código: "+ (fin - inicio) + " milisegundos.");

			inicio = System.currentTimeMillis();
			boolean boardSolutionF = isValidBoardSolution(boardF);
			fin = System.currentTimeMillis();
			System.out.println("El boardF con el nuestro código: "+ (fin - inicio) + " milisegundos.");

			/* ------------------------------------------------------------- */


		System.out.println("\nEjemplos de actividad tres con el código de Emmanuel\n");
			inicio = System.currentTimeMillis();
			rotateArray(arrayA1, 500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA1 con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo A1 rotado 500 veces: " + Arrays.toString(arrayA1));

			inicio = System.currentTimeMillis();
			rotateArray(arrayB1, 1000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB1 con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo B1 rotado 1000 veces: " + Arrays.toString(arrayB1));

			inicio = System.currentTimeMillis();
			rotateArray(arrayC1, 2000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC1 con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo C1 rotado 2000 veces: " + Arrays.toString(arrayC1));

			inicio = System.currentTimeMillis();
			rotateArray(arrayA1, 3000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayD1 con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo D1 rotado 3000 veces: " + Arrays.toString(arrayD1));

			inicio = System.currentTimeMillis();
			rotateArray(arrayB1, 10000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayE1 con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo E1 rotado 10000 veces: " + Arrays.toString(arrayE1));

			inicio = System.currentTimeMillis();
			rotateArray(arrayC1, 20000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayF1 con el código de Emmanuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo F1 rotado 20000 veces: " + Arrays.toString(arrayF1));

		System.out.println("\nEjemplos de actividad tres con nuestro código\n");
			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayA11, 500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA1 con nuestro código: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo A1 rotado 500 veces: " + Arrays.toString(arrayA1));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayB11, 1000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB1 con nuestro código: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo B1 rotado 1000 veces: " + Arrays.toString(arrayB11));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayC11, 2000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC1 con nuestro código: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo C1 rotado 2000 veces: " + Arrays.toString(arrayC11));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayD11, 3000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayD1 con nuestro código: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo D1 rotado 3000 veces: " + Arrays.toString(arrayD11));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayE11, 10000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayE1 con nuestro código: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo E1 rotado 10000 veces: " + Arrays.toString(arrayE11));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayF11, 20000);
			fin = System.currentTimeMillis();
			System.out.println("El arrayF1 con nuestro código: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo F1 rotado 20000 veces: " + Arrays.toString(arrayF11));

	}
}