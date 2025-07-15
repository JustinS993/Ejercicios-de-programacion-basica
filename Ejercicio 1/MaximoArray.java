// MaximoArray.java
// Este programa calcula el máximo de un array de números en Java

public class MaximoArray {
    // Método que recibe un array de enteros y retorna el máximo
    public static int maximoArray(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] numeros = {3, 7, 2, 9, 4};
        System.out.println("El máximo es: " + maximoArray(numeros));
    }
} 