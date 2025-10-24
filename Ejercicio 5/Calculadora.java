import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    private static boolean esNumero(String valor) {
        try {
            Double.parseDouble(valor);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    private static class ResultadoOperacion {
        Double resultado;
        String error;
        
        ResultadoOperacion(Double resultado, String error) {
            this.resultado = resultado;
            this.error = error;
        }
    }
    
    private static ResultadoOperacion calcularResultado(List<String> operaciones) {
        if (operaciones.size() % 2 == 0) {
            return new ResultadoOperacion(null, 
                "Error: Formato incorrecto. Debe haber alternancia entre números y operadores.");
        }
        
        try {
            double resultado = Double.parseDouble(operaciones.get(0));
            
            for (int i = 1; i < operaciones.size(); i += 2) {
                String operador = operaciones.get(i);
                double numero = Double.parseDouble(operaciones.get(i + 1));
                
                switch (operador) {
                    case "+":
                        resultado += numero;
                        break;
                    case "-":
                        resultado -= numero;
                        break;
                    case "*":
                        resultado *= numero;
                        break;
                    case "/":
                        if (numero == 0) {
                            return new ResultadoOperacion(null, "Error: División por cero.");
                        }
                        resultado /= numero;
                        break;
                    default:
                        return new ResultadoOperacion(null, 
                            "Error: Operador '" + operador + "' no válido.");
                }
            }
            
            return new ResultadoOperacion(resultado, null);
        } catch (NumberFormatException e) {
            return new ResultadoOperacion(null, "Error: Formato de número inválido.");
        } catch (Exception e) {
            return new ResultadoOperacion(null, "Error: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        try {
            // Leer el archivo
            List<String> lineas = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader("Challenge21.txt"));
            String linea;
            
            while ((linea = reader.readLine()) != null) {
                lineas.add(linea.trim());
            }
            reader.close();
            
            // Verificar formato básico
            for (int i = 0; i < lineas.size(); i++) {
                if (i % 2 == 0 && !esNumero(lineas.get(i))) {
                    System.out.println("No se han podido resolver las operaciones.");
                    System.out.println("Error: Se esperaba un número en la línea " + (i + 1) + 
                        ", pero se encontró '" + lineas.get(i) + "'");
                    return;
                } else if (i % 2 == 1 && !"+,-,*,/".contains(lineas.get(i))) {
                    System.out.println("No se han podido resolver las operaciones.");
                    System.out.println("Error: Se esperaba un operador en la línea " + (i + 1) + 
                        ", pero se encontró '" + lineas.get(i) + "'");
                    return;
                }
            }
            
            // Calcular resultado
            ResultadoOperacion resultado = calcularResultado(lineas);
            
            if (resultado.error != null) {
                System.out.println("No se han podido resolver las operaciones.");
                System.out.println(resultado.error);
            } else {
                System.out.println("El resultado es: " + resultado.resultado);
            }
            
        } catch (IOException e) {
            System.out.println("No se ha encontrado el archivo 'Challenge21.txt'");
        } catch (Exception e) {
            System.out.println("No se han podido resolver las operaciones.");
            System.out.println("Error: " + e.getMessage());
        }
    }
}