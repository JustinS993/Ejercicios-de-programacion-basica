/**
 * Módulo para la aplicación de Banderas JavaFX
 * Ejercicio 9.2: Componentes gráficos
 * 
 * Este módulo define las dependencias necesarias para ejecutar
 * la aplicación de reconocimiento de banderas usando JavaFX.
 */
module banderas.app {
    // Módulos de JavaFX requeridos
    requires javafx.controls;  // Para Button, Label, TextField, etc.
    requires javafx.fxml;      // Para soporte FXML (opcional)
    
    // Módulo base de Java para funcionalidades del escritorio
    requires java.desktop;     // Para efectos y funcionalidades adicionales
    
    // Exportar el paquete principal para que sea accesible
    exports banderas.app to javafx.graphics;
}