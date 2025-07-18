import java.util.Scanner;

public class Palindromo {
    public static boolean esPalindromo(String palabra) {
        // Convertir a minúsculas y eliminar espacios
        palabra = palabra.toLowerCase().replaceAll("\\s+", "");
        
        // Crear un StringBuilder para invertir la palabra
        StringBuilder palabraInvertida = new StringBuilder(palabra).reverse();
        
        // Comparar la palabra original con la invertida
        return palabra.equals(palabraInvertida.toString());
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Solicitar entrada al usuario
        System.out.print("Introduce una palabra para verificar si es un palíndromo: ");
        String palabra = scanner.nextLine();
        
        // Verificar si es palíndromo
        if (esPalindromo(palabra)) {
            System.out.println('"' + palabra + '"' + " es un palíndromo!");
        } else {
            System.out.println('"' + palabra + '"' + " no es un palíndromo.");
        }
        
        scanner.close();
    }
}