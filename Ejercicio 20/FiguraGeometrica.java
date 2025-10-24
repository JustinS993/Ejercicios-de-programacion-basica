/**
 * Clase abstracta que representa una figura geométrica
 * @author Ejercicios de programación orientada a objetos con Java y UML
 */
public abstract class FiguraGeometrica {
    // Métodos abstractos que deben implementar las clases hijas
    public abstract double calcularVolumen();
    public abstract double calcularSuperficie();
    
    // Método para obtener el nombre de la figura
    public abstract String getNombre();
}