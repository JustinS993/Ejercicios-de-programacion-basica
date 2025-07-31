/**
 * Clase que representa una pirámide
 * @author Ejercicios de programación orientada a objetos con Java y UML
 */
public class Piramide extends FiguraGeometrica {
    private double base;
    private double altura;
    private double apotema;
    
    /**
     * Constructor de la clase Pirámide
     * @param base Base de la pirámide en centímetros
     * @param altura Altura de la pirámide en centímetros
     * @param apotema Apotema de la pirámide en centímetros
     */
    public Piramide(double base, double altura, double apotema) {
        this.base = base;
        this.altura = altura;
        this.apotema = apotema;
    }
    
    /**
     * Calcula el volumen de la pirámide
     * @return Volumen de la pirámide en centímetros cúbicos
     */
    @Override
    public double calcularVolumen() {
        // Fórmula: V = (1/3) * área_base * altura
        // Para una pirámide de base cuadrada: área_base = base²
        return (1.0/3.0) * Math.pow(base, 2) * altura;
    }
    
    /**
     * Calcula la superficie de la pirámide
     * @return Superficie de la pirámide en centímetros cuadrados
     */
    @Override
    public double calcularSuperficie() {
        // Fórmula: S = área_base + área_lateral
        // área_base = base²
        // área_lateral = 4 * (1/2) * base * apotema = 2 * base * apotema
        double areaBase = Math.pow(base, 2);
        double areaLateral = 2 * base * apotema;
        return areaBase + areaLateral;
    }
    
    /**
     * Obtiene el nombre de la figura
     * @return Nombre de la figura
     */
    @Override
    public String getNombre() {
        return "Pirámide";
    }
    
    // Getters y setters
    public double getBase() {
        return base;
    }
    
    public void setBase(double base) {
        this.base = base;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
    
    public double getApotema() {
        return apotema;
    }
    
    public void setApotema(double apotema) {
        this.apotema = apotema;
    }
}