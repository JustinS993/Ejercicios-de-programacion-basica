/**
 * Clase que representa una esfera
 * @author Ejercicios de programación orientada a objetos con Java y UML
 */
public class Esfera extends FiguraGeometrica {
    private double radio;
    
    /**
     * Constructor de la clase Esfera
     * @param radio Radio de la esfera en centímetros
     */
    public Esfera(double radio) {
        this.radio = radio;
    }
    
    /**
     * Calcula el volumen de la esfera
     * @return Volumen de la esfera en centímetros cúbicos
     */
    @Override
    public double calcularVolumen() {
        // Fórmula: V = (4/3) * π * r³
        return (4.0/3.0) * Math.PI * Math.pow(radio, 3);
    }
    
    /**
     * Calcula la superficie de la esfera
     * @return Superficie de la esfera en centímetros cuadrados
     */
    @Override
    public double calcularSuperficie() {
        // Fórmula: S = 4π * r²
        return 4 * Math.PI * Math.pow(radio, 2);
    }
    
    /**
     * Obtiene el nombre de la figura
     * @return Nombre de la figura
     */
    @Override
    public String getNombre() {
        return "Esfera";
    }
    
    // Getters y setters
    public double getRadio() {
        return radio;
    }
    
    public void setRadio(double radio) {
        this.radio = radio;
    }
}