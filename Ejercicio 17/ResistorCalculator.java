import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ResistorCalculator {
    
    private static final Map<String, Integer> colorValues = new HashMap<>();
    
    static {
        // Inicializar el mapa de colores en español e inglés
        colorValues.put("negro", 0);
        colorValues.put("black", 0);
        colorValues.put("marrón", 1);
        colorValues.put("brown", 1);
        colorValues.put("rojo", 2);
        colorValues.put("red", 2);
        colorValues.put("naranja", 3);
        colorValues.put("orange", 3);
        colorValues.put("amarillo", 4);
        colorValues.put("yellow", 4);
        colorValues.put("verde", 5);
        colorValues.put("green", 5);
        colorValues.put("azul", 6);
        colorValues.put("blue", 6);
        colorValues.put("violeta", 7);
        colorValues.put("violet", 7);
        colorValues.put("gris", 8);
        colorValues.put("grey", 8);
        colorValues.put("gray", 8);
        colorValues.put("blanco", 9);
        colorValues.put("white", 9);
    }
    
    /**
     * Calcula el valor de una resistencia basado en tres bandas de colores.
     * 
     * @param color1 Primera banda de color
     * @param color2 Segunda banda de color
     * @param color3 Tercera banda de color (multiplicador)
     * @return Valor de la resistencia con unidades apropiadas
     */
    public static String resistorColorTrio(String color1, String color2, String color3) {
        // Convertir a minúsculas para comparación
        color1 = color1.toLowerCase();
        color2 = color2.toLowerCase();
        color3 = color3.toLowerCase();
        
        // Verificar que los colores existan
        if (!colorValues.containsKey(color1) || !colorValues.containsKey(color2) || !colorValues.containsKey(color3)) {
            throw new IllegalArgumentException("Color no válido");
        }
        
        // Obtener valores de las primeras dos bandas
        int firstDigit = colorValues.get(color1);
        int secondDigit = colorValues.get(color2);
        
        // Calcular valor base (primeros dos dígitos)
        int baseValue = firstDigit * 10 + secondDigit;
        
        // Obtener multiplicador (cantidad de ceros)
        int multiplier = colorValues.get(color3);
        
        // Calcular valor final
        long resistanceValue = baseValue * (long)Math.pow(10, multiplier);
        
        // Determinar unidades apropiadas
        if (resistanceValue >= 1000000) {
            return (resistanceValue / 1000000) + " megaohmios";
        } else if (resistanceValue >= 1000) {
            return (resistanceValue / 1000) + " kiloohmios";
        } else {
            return resistanceValue + " ohmios";
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Calculadora de Resistencias");
        System.out.println("Colores disponibles: negro, marrón, rojo, naranja, amarillo, verde, azul, violeta, gris, blanco");
        System.out.println();
        
        // Ejemplos de uso
        System.out.println("Ejemplos:");
        System.out.println("naranja-naranja-negro: " + resistorColorTrio("naranja", "naranja", "negro"));
        System.out.println("naranja-naranja-rojo: " + resistorColorTrio("naranja", "naranja", "rojo"));
        System.out.println("naranja-naranja-naranja: " + resistorColorTrio("naranja", "naranja", "naranja"));
        System.out.println();
        
        // Entrada del usuario
        try {
            System.out.print("Ingrese el primer color: ");
            String color1 = scanner.nextLine();
            
            System.out.print("Ingrese el segundo color: ");
            String color2 = scanner.nextLine();
            
            System.out.print("Ingrese el tercer color: ");
            String color3 = scanner.nextLine();
            
            String result = resistorColorTrio(color1, color2, color3);
            System.out.println("\nValor de la resistencia: " + result);
            
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}