public class Ola {
    public static void main(String[] args) {

        int[] arrayA1 = ArrayReader.readArray(directorio1 + "ArrayA1.txt");
        System.out.println("Longitud de arraya1 es: "+arrayA1.length);
        int[] arrayA2 = ArrayReader.readArray(directorio1 + "ArrayA2.txt");
        System.out.println("Longitud de arrayaa2 es: "+arrayA2.length);




        for(int j = 0; j < arrayTemp.length - 1; j++){
            for(int k = j+1; k < arrayTemp.length; k++){
                if(arrayTemp[k] < arrayTemp[j]){
                    int aux = arrayTemp[k];
                    arrayTemp[k] = arrayTemp[j];
                    arrayTemp[j] = aux;
                }
            }
        }





    }
}
