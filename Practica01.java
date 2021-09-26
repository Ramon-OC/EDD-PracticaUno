import java.util.Arrays;

/**
* Práctica 1 del curso de Estructuras de Datos.
* @author Emmanuel Cruz Hernández.
* @version 2.0 Septiembre 2021.
* @since Laboratorio de Estructuras de Datos 2022-1.
*/
public class Practica01{

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

	public static int[] mergeSortedArraySolution(int[]arrayOne, int valueOne, int[]arrayTwo, int valueTwo){
		int size = valueOne+valueTwo; //5
		int[] arrayTemp = new int[size];//3

		//Lenar valueOne
		for (int i=0; i<valueOne; i++) { // 1+(n+1)+n = 2n+2
				arrayTemp[i] = arrayOne[i]; // 2
		}

		// Llenar valueTwo
		for(int j=0; j<valueTwo; j++){
				arrayTemp[j + valueOne] = arrayTwo[j]; //2
		}


		int numeroDePasos = 0;
		long inicioPrueba = System.currentTimeMillis();

		for (int j = 0; j < arrayTemp.length - 1; j++) {
			if (arrayTemp[j] > arrayTemp[j + 1]) {
				int temp = arrayTemp[j];
				arrayTemp[j] = arrayTemp[j + 1];
				arrayTemp[j + 1] = temp;
				j = -1;
				numeroDePasos++;
			}
		}


		long finalPrueba = System.currentTimeMillis();
		System.out.println("Tiempo xd: "+(finalPrueba-inicioPrueba));
		System.out.println("El numero de pasos es: "+numeroDePasos+(arrayTemp.length));


		for (int j = 0; j < arrayTemp.length - 1; j++) {
			// Buscar el más grande de todo el arreglo



		}




		/* Ordenar de menor a mayor
		for (int j = 0; j < arrayTemp.length - 1; j++) {
			if (arrayTemp[j] > arrayTemp[j + 1]) {
				int temp = arrayTemp[j];
				arrayTemp[j] = arrayTemp[j + 1];
				arrayTemp[j + 1] = temp;
				j = -1;
			}
		}*/






		return arrayTemp;
	}

    /**
    * Verifica si un tablero contiene los números desde 0 hasta n-1 en cada fila y cada columna.
    * @param board el tablero de nxn que contiene elementos dentro del rango [0, n-1].
    * @return true si el tablero contiene los números desde 0 hasta n-1 en cada fila y columna,
	* false en otro caso.
    */
    public static boolean mergeSortedArraySolution(int[][] board){
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

	public static boolean rotateArraySolutionxd(int[] num, int valor){
		int max = num [0];
		int value;
		boolean duplicate = false;
		for (int i = 0; i < num.length; i++) {
			if (num[i] > max) {
				max = num[i];
			}
		}
		int[] casillasDuplicadas = new int[max+1];

		for (int i = 0; i<num.length;i++){
			value = num[i];
			casillasDuplicadas[value] = casillasDuplicadas[value]+1;
			if(casillasDuplicadas[value]>1 || num[i]>num.length){ // La cifra no puede ser mayor al largo de nuestro arreglo
				duplicate = true;
				break;
			}
		}
		return duplicate;
	}

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
		String directorio1 = "Examples/ArrayExamples/";
		String directorio2 = "Examples/BoardExamples/";

		// Arreglos para los algoritmos de Manuel
		int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] arrayB1 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB2 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] arrayC1 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC2 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");

		// Arreglos para nuestros algoritmos
		int[] arrayA11 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
		int[] arrayA22 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
		int[] arrayB11 = ArrayReader.readArray(directorio1 + "ArrayB1.txt");
		int[] arrayB22 = ArrayReader.readArray(directorio1 + "ArrayB2.txt");
		int[] arrayC11 = ArrayReader.readArray(directorio1 + "ArrayC1.txt");
		int[] arrayC22 = ArrayReader.readArray(directorio1 + "ArrayC2.txt");

		System.out.println("\nEjemplos de actividad uno con el código de Manuel\n");
			inicio = System.currentTimeMillis();
			int[] resultA = mergeSortedArray(arrayA1, 500, arrayA2, 500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA1 con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado A: "+Arrays.toString(resultA));

			inicio = System.currentTimeMillis();
			int[] resultB = mergeSortedArray(arrayB1, 500, arrayB2, 500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB1 con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado B: "+Arrays.toString(resultB));

			inicio = System.currentTimeMillis();
			int[] resultC = mergeSortedArray(arrayC1, 500, arrayC2, 500);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC1 con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Resultado C: "+Arrays.toString(resultC));

		System.out.println("\nEjemplos de actividad dos con el código de Manuel\n");
			int[][] boardA = ArrayReader.readMatrix(directorio2 + "BoardA.txt");
			inicio = System.currentTimeMillis();
			boolean boardResultA = isValidBoard(boardA);
			fin = System.currentTimeMillis();
			System.out.println("El boardA con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero A con el algoritmo de Manuel es válido: "+boardResultA);

			int[][] boardB = ArrayReader.readMatrix(directorio2 + "BoardB.txt");
			inicio = System.currentTimeMillis();
			boolean boardResultB = isValidBoard(boardB);
			fin = System.currentTimeMillis();
			System.out.println("El boardB con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero B con el algoritmo de Manuel es válido: "+boardResultB);

			int[][] boardC = ArrayReader.readMatrix(directorio2 + "BoardC.txt");
			inicio = System.currentTimeMillis();
			boolean boardResultC = isValidBoard(boardC);
			fin = System.currentTimeMillis();
			System.out.println("El boardC con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero C con el algoritmo de Manuel es válido: "+boardResultC);

			int[][] boardD = ArrayReader.readMatrix(directorio2 + "BoardD.txt");
			inicio = System.currentTimeMillis();
			boolean boardResultD = isValidBoard(boardD);
			fin = System.currentTimeMillis();
			System.out.println("El boardD con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("El tablero D con el algoritmo de Manuel es válido: "+boardResultD);
		
		System.out.println("\nEjemplos de actividad tres con el código de Manuel\n");
			inicio = System.currentTimeMillis();
			rotateArray(arrayA1, 200);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA1 con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo A1 rotado 200 veces: " + Arrays.toString(arrayA11));

			inicio = System.currentTimeMillis();
			rotateArray(arrayB1, 200);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB1 con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo B1 rotado 200 veces: " + Arrays.toString(arrayA11));

			inicio = System.currentTimeMillis();
			rotateArray(arrayC1, 200);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC1 con el código de Manuel: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo C1 rotado 200 veces: " + Arrays.toString(arrayA11));

		System.out.println("\nEjemplos de actividad tres con nuestro código\n");
			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayA11, 200);
			fin = System.currentTimeMillis();
			System.out.println("El arrayA11 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo A1 rotado 200 veces: " + Arrays.toString(arrayA11));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayB11, 200);
			fin = System.currentTimeMillis();
			System.out.println("El arrayB11 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo B1 rotado 200 veces: " + Arrays.toString(arrayB11));

			inicio = System.currentTimeMillis();
			rotateArraySolution(arrayC11, 200);
			fin = System.currentTimeMillis();
			System.out.println("El arrayC11 con nuestro código tardó: "+ (fin - inicio) + " milisegundos.");
			//System.out.println("Arreglo C1 rotado 200 veces: " + Arrays.toString(arrayC11));


	}
}