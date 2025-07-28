import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.time.LocalDate;

public class ContactosApp extends Application {
    
    private TextField txtNombres;
    private TextField txtApellidos;
    private DatePicker dpFechaNacimiento;
    private TextField txtDireccion;
    private TextField txtTelefono;
    private TextField txtCorreo;
    private ListView<String> listViewContactos;
    
    @Override
    public void init() {
        // Inicializar componentes
        txtNombres = new TextField();
        txtApellidos = new TextField();
        dpFechaNacimiento = new DatePicker();
        txtDireccion = new TextField();
        txtTelefono = new TextField();
        txtCorreo = new TextField();
        listViewContactos = new ListView<>();
    }
    
    @Override
    public void start(Stage escenario) {
        // Crear etiquetas
        Label lblNombres = new Label("Nombres:");
        Label lblApellidos = new Label("Apellidos:");
        Label lblFechaNacimiento = new Label("Fecha de Nacimiento:");
        Label lblDireccion = new Label("Dirección:");
        Label lblTelefono = new Label("Teléfono:");
        Label lblCorreo = new Label("Correo Electrónico:");
        
        // Crear botón
        Button btnAgregar = new Button("Agregar");
        btnAgregar.setMaxWidth(Double.MAX_VALUE);
        
        // Configurar evento del botón
        btnAgregar.setOnAction(e -> agregarContacto());
        
        // Crear panel principal con GridPane
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPadding(new Insets(20));
        gridPane.setStyle("-fx-background-color: #f0f0f0;");
        
        // Añadir componentes al grid
        gridPane.add(lblNombres, 0, 0);
        gridPane.add(txtNombres, 1, 0);
        gridPane.add(lblApellidos, 0, 1);
        gridPane.add(txtApellidos, 1, 1);
        gridPane.add(lblFechaNacimiento, 0, 2);
        gridPane.add(dpFechaNacimiento, 1, 2);
        gridPane.add(lblDireccion, 0, 3);
        gridPane.add(txtDireccion, 1, 3);
        gridPane.add(lblTelefono, 0, 4);
        gridPane.add(txtTelefono, 1, 4);
        gridPane.add(lblCorreo, 0, 5);
        gridPane.add(txtCorreo, 1, 5);
        gridPane.add(btnAgregar, 0, 6, 2, 1);
        
        // Crear VBox principal
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));
        
        // Añadir título para la lista
        Label lblContactos = new Label("Lista de Contactos:");
        lblContactos.setStyle("-fx-font-weight: bold; -fx-font-size: 14px;");
        
        vbox.getChildren().addAll(gridPane, lblContactos, listViewContactos);
        
        // Crear escena
        Scene scene = new Scene(vbox, 500, 600);
        
        // Configurar escenario
        escenario.setScene(scene);
        escenario.setTitle("Agenda de Contactos");
        escenario.sizeToScene();
        escenario.show();
    }
    
    private void agregarContacto() {
        try {
            // Validar que los campos obligatorios no estén vacíos
            if (txtNombres.getText().trim().isEmpty() || 
                txtApellidos.getText().trim().isEmpty()) {
                
                mostrarAlerta("Error", "Campos obligatorios", 
                    "Los campos Nombres y Apellidos son obligatorios.");
                return;
            }
            
            // Crear string del contacto
            StringBuilder contacto = new StringBuilder();
            contacto.append(txtNombres.getText().trim())
                   .append(" ")
                   .append(txtApellidos.getText().trim());
            
            if (dpFechaNacimiento.getValue() != null) {
                contacto.append(" - Nacimiento: ")
                       .append(dpFechaNacimiento.getValue().toString());
            }
            
            if (!txtDireccion.getText().trim().isEmpty()) {
                contacto.append(" - Dir: ")
                       .append(txtDireccion.getText().trim());
            }
            
            if (!txtTelefono.getText().trim().isEmpty()) {
                contacto.append(" - Tel: ")
                       .append(txtTelefono.getText().trim());
            }
            
            if (!txtCorreo.getText().trim().isEmpty()) {
                contacto.append(" - Email: ")
                       .append(txtCorreo.getText().trim());
            }
            
            // Añadir contacto a la lista
            listViewContactos.getItems().add(contacto.toString());
            
            // Limpiar campos
            limpiarCampos();
            
            // Mostrar confirmación
            mostrarAlerta("Éxito", "Contacto agregado", 
                "El contacto ha sido agregado exitosamente.");
            
        } catch (Exception ex) {
            mostrarAlerta("Error", "Error al agregar contacto", 
                "Ocurrió un error al agregar el contacto: " + ex.getMessage());
        }
    }
    
    private void limpiarCampos() {
        txtNombres.setText("");
        txtApellidos.setText("");
        dpFechaNacimiento.setValue(null);
        txtDireccion.setText("");
        txtTelefono.setText("");
        txtCorreo.setText("");
    }
    
    private void mostrarAlerta(String titulo, String cabecera, String contenido) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(cabecera);
        alert.setContentText(contenido);
        alert.showAndWait();
    }
    
    @Override
    public void stop() {
        // Liberar recursos si es necesario
        System.out.println("Aplicación cerrada correctamente.");
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}