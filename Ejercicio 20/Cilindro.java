/**
 * Clase que representa un cilindro
 * @author Ejercicios de programación orientada a objetos con Java y UML
 */
public class Cilindro extends FiguraGeometrica {
    private double radio;
    private double altura;
    
    /**
     * Constructor de la clase Cilindro
     * @param radio Radio del cilindro en centímetros
     * @param altura Altura del cilindro en centímetros
     */
    public Cilindro(double radio, double altura) {
        this.radio = radio;
        this.altura = altura;
    }
    
    /**
     * Calcula el volumen del cilindro
     * @return Volumen del cilindro en centímetros cúbicos
     */
    @Override
    public double calcularVolumen() {
        // Fórmula: V = π * r² * h
        return Math.PI * Math.pow(radio, 2) * altura;
    }
    
    /**
     * Calcula la superficie del cilindro
     * @return Superficie del cilindro en centímetros cuadrados
     */
    @Override
    public double calcularSuperficie() {
        // Fórmula: S = 2π * r * (r + h)
        return 2 * Math.PI * radio * (radio + altura);
    }
    
    /**
     * Obtiene el nombre de la figura
     * @return Nombre de la figura
     */
    @Override
    public String getNombre() {
        return "Cilindro";
    }
    
    // Getters y setters
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
    
    public double getAltura() {
        return altura;
    }
    
    public void setAltura(double altura) {
        this.altura = altura;
    }
}