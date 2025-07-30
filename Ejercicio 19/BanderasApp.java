import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

/**
 * Ejercicio 9.2: Aplicación de Banderas
 * 
 * Esta aplicación muestra cinco países en una columna y cinco banderas numeradas
 * en otra columna. El usuario debe ingresar el número de la bandera que corresponde
 * a cada país y el programa calcula los aciertos.
 * 
 * @author Ejercicios de Programación Básica
 * @version 1.0
 */
public class BanderasApp extends Application {
    
    // Arrays con los países y las respuestas correctas
    private final String[] paises = {
        "México", "España", "Francia", "Italia", "Alemania"
    };
    
    // Respuestas correctas (número de bandera para cada país)
    private final int[] respuestasCorrectas = {1, 2, 3, 4, 5};
    
    // Campos de texto para las respuestas del usuario
    private TextField[] camposRespuesta;
    
    // Label para mostrar el resultado
    private Label labelResultado;
    
    @Override
    public void start(Stage primaryStage) {
        // Configurar el título de la ventana
        primaryStage.setTitle("Ejercicio 9.2 - Juego de Banderas");
        
        // Crear el panel principal con GridPane
        GridPane gridPane = crearGridPane();
        
        // Crear la escena
        Scene scene = new Scene(gridPane, 800, 600);
        
        // Configurar y mostrar la ventana
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
    
    /**
     * Crea y configura el GridPane principal con todos los componentes
     * @return GridPane configurado
     */
    private GridPane crearGridPane() {
        GridPane gridPane = new GridPane();
        
        // Configurar el GridPane
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(20));
        gridPane.setHgap(20);
        gridPane.setVgap(15);
        gridPane.setStyle("-fx-background-color: #f0f8ff;");
        
        // Crear título principal
        Label titulo = crearTitulo();
        gridPane.add(titulo, 0, 0, 3, 1);
        
        // Crear encabezados de columnas
        crearEncabezados(gridPane);
        
        // Crear filas de países y campos de respuesta
        crearFilasPaises(gridPane);
        
        // Crear sección de banderas
        crearSeccionBanderas(gridPane);
        
        // Crear botón de verificación y resultado
        crearSeccionResultado(gridPane);
        
        return gridPane;
    }
    
    /**
     * Crea el título principal de la aplicación
     * @return Label con el título
     */
    private Label crearTitulo() {
        Label titulo = new Label("🏁 JUEGO DE BANDERAS 🏁");
        titulo.setFont(Font.font("Arial", FontWeight.BOLD, 24));
        titulo.setTextFill(Color.DARKBLUE);
        
        // Agregar efecto de sombra
        DropShadow sombra = new DropShadow();
        sombra.setColor(Color.GRAY);
        sombra.setOffsetX(2);
        sombra.setOffsetY(2);
        titulo.setEffect(sombra);
        
        return titulo;
    }
    
    /**
     * Crea los encabezados de las columnas
     * @param gridPane GridPane donde agregar los encabezados
     */
    private void crearEncabezados(GridPane gridPane) {
        Label encabezadoPaises = new Label("PAÍSES");
        encabezadoPaises.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        encabezadoPaises.setTextFill(Color.DARKGREEN);
        gridPane.add(encabezadoPaises, 0, 1);
        
        Label encabezadoRespuesta = new Label("TU RESPUESTA");
        encabezadoRespuesta.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        encabezadoRespuesta.setTextFill(Color.DARKGREEN);
        gridPane.add(encabezadoRespuesta, 1, 1);
        
        Label encabezadoBanderas = new Label("BANDERAS NUMERADAS");
        encabezadoBanderas.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        encabezadoBanderas.setTextFill(Color.DARKGREEN);
        gridPane.add(encabezadoBanderas, 2, 1);
    }
    
    /**
     * Crea las filas con países y campos de respuesta
     * @param gridPane GridPane donde agregar las filas
     */
    private void crearFilasPaises(GridPane gridPane) {
        camposRespuesta = new TextField[paises.length];
        
        for (int i = 0; i < paises.length; i++) {
            // Crear label del país
            Label labelPais = new Label((i + 1) + ". " + paises[i]);
            labelPais.setFont(Font.font("Arial", FontWeight.NORMAL, 14));
            labelPais.setTextFill(Color.DARKBLUE);
            gridPane.add(labelPais, 0, i + 2);
            
            // Crear campo de texto para la respuesta
            TextField campoRespuesta = new TextField();
            campoRespuesta.setPrefWidth(80);
            campoRespuesta.setPromptText("Núm.");
            campoRespuesta.setStyle("-fx-font-size: 14px;");
            camposRespuesta[i] = campoRespuesta;
            gridPane.add(campoRespuesta, 1, i + 2);
        }
    }
    
    /**
     * Crea la sección de banderas con imágenes simuladas
     * @param gridPane GridPane donde agregar las banderas
     */
    private void crearSeccionBanderas(GridPane gridPane) {
        VBox contenedorBanderas = new VBox(10);
        contenedorBanderas.setAlignment(Pos.CENTER);
        
        // Crear banderas simuladas (rectángulos de colores)
        String[] coloresBanderas = {
            "#006847;#FFFFFF;#CE1126", // México (Verde, Blanco, Rojo)
            "#AA151B;#F1BF00;#AA151B", // España (Rojo, Amarillo, Rojo)
            "#0055A4;#FFFFFF;#EF4135", // Francia (Azul, Blanco, Rojo)
            "#009246;#FFFFFF;#CE2B37", // Italia (Verde, Blanco, Rojo)
            "#000000;#DD0000;#FFCE00"  // Alemania (Negro, Rojo, Amarillo)
        };
        
        for (int i = 0; i < 5; i++) {
            HBox bandera = crearBanderaSimulada(i + 1, coloresBanderas[i]);
            contenedorBanderas.getChildren().add(bandera);
        }
        
        gridPane.add(contenedorBanderas, 2, 2, 1, 5);
    }
    
    /**
     * Crea una bandera simulada con colores
     * @param numero Número de la bandera
     * @param colores Colores de la bandera separados por ;
     * @return HBox con la bandera simulada
     */
    private HBox crearBanderaSimulada(int numero, String colores) {
        HBox bandera = new HBox();
        bandera.setAlignment(Pos.CENTER_LEFT);
        
        // Label con el número
        Label numeroLabel = new Label(numero + ". ");
        numeroLabel.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        
        // Crear franjas de colores
        String[] franjas = colores.split(";");
        HBox banderaColores = new HBox();
        
        for (String color : franjas) {
            Label franja = new Label("   ");
            franja.setStyle("-fx-background-color: " + color + "; -fx-border-color: black; -fx-border-width: 1px;");
            franja.setPrefHeight(30);
            franja.setPrefWidth(25);
            banderaColores.getChildren().add(franja);
        }
        
        bandera.getChildren().addAll(numeroLabel, banderaColores);
        return bandera;
    }
    
    /**
     * Crea la sección de resultado con botón y label de resultado
     * @param gridPane GridPane donde agregar la sección
     */
    private void crearSeccionResultado(GridPane gridPane) {
        // Crear botón de verificación
        Button botonVerificar = new Button("🔍 VERIFICAR RESPUESTAS");
        botonVerificar.setFont(Font.font("Arial", FontWeight.BOLD, 14));
        botonVerificar.setStyle(
            "-fx-background-color: #4CAF50; " +
            "-fx-text-fill: white; " +
            "-fx-padding: 10px 20px; " +
            "-fx-border-radius: 5px; " +
            "-fx-background-radius: 5px;"
        );
        
        // Configurar acción del botón
        botonVerificar.setOnAction(e -> verificarRespuestas());
        
        // Crear label para mostrar resultado
        labelResultado = new Label("Ingresa tus respuestas y presiona 'Verificar'");
        labelResultado.setFont(Font.font("Arial", FontWeight.BOLD, 16));
        labelResultado.setTextFill(Color.DARKBLUE);
        
        // Agregar componentes al grid
        int filaBoton = paises.length + 2;
        gridPane.add(botonVerificar, 0, filaBoton, 2, 1);
        gridPane.add(labelResultado, 0, filaBoton + 1, 3, 1);
    }
    
    /**
     * Verifica las respuestas del usuario y muestra el resultado
     */
    private void verificarRespuestas() {
        int aciertos = 0;
        int respuestasValidas = 0;
        
        for (int i = 0; i < camposRespuesta.length; i++) {
            String textoRespuesta = camposRespuesta[i].getText().trim();
            
            if (!textoRespuesta.isEmpty()) {
                try {
                    int respuestaUsuario = Integer.parseInt(textoRespuesta);
                    respuestasValidas++;
                    
                    if (respuestaUsuario == respuestasCorrectas[i]) {
                        aciertos++;
                        // Marcar campo como correcto
                        camposRespuesta[i].setStyle("-fx-background-color: #d4edda; -fx-border-color: #28a745;");
                    } else {
                        // Marcar campo como incorrecto
                        camposRespuesta[i].setStyle("-fx-background-color: #f8d7da; -fx-border-color: #dc3545;");
                    }
                } catch (NumberFormatException e) {
                    // Marcar campo como inválido
                    camposRespuesta[i].setStyle("-fx-background-color: #fff3cd; -fx-border-color: #ffc107;");
                }
            } else {
                // Resetear estilo si está vacío
                camposRespuesta[i].setStyle("");
            }
        }
        
        // Mostrar resultado
        if (respuestasValidas == 0) {
            labelResultado.setText("⚠️ Por favor, ingresa al menos una respuesta.");
            labelResultado.setTextFill(Color.ORANGE);
        } else {
            double porcentaje = (double) aciertos / respuestasValidas * 100;
            String mensaje = String.format(
                "🎯 Resultado: %d/%d aciertos (%.1f%%) de %d respuestas válidas",
                aciertos, respuestasValidas, porcentaje, respuestasValidas
            );
            
            labelResultado.setText(mensaje);
            
            if (porcentaje >= 80) {
                labelResultado.setTextFill(Color.GREEN);
            } else if (porcentaje >= 60) {
                labelResultado.setTextFill(Color.ORANGE);
            } else {
                labelResultado.setTextFill(Color.RED);
            }
        }
    }
    
    /**
     * Método principal para ejecutar la aplicación
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        launch(args);
    }
}