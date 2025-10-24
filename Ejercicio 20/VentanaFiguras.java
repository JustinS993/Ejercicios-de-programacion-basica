import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Clase principal que implementa la interfaz gráfica para calcular
 * el volumen y superficie de figuras geométricas
 * 
 * @author Ejercicios de programación orientada a objetos con Java y UML
 */
public class VentanaFiguras extends JFrame implements ActionListener {
    
    // Componentes de la interfaz
    private JComboBox<String> comboFiguras;
    private JPanel panelDatos;
    private JButton btnCalcular;
    private JLabel lblResultado;
    
    // Componentes para Cilindro
    private JTextField txtRadioCilindro;
    private JTextField txtAlturaCilindro;
    
    // Componentes para Esfera
    private JTextField txtRadioEsfera;
    
    // Componentes para Pirámide
    private JTextField txtBasePiramide;
    private JTextField txtAlturaPiramide;
    private JTextField txtApotemaPiramide;
    
    /**
     * Constructor de la ventana principal
     */
    public VentanaFiguras() {
        // Configuración de la ventana
        setTitle("Cálculo de Figuras Geométricas");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        // Configuración del contenedor principal
        Container contenedor = getContentPane();
        contenedor.setLayout(null);
        
        // Etiqueta de título
        JLabel lblTitulo = new JLabel("Cálculo de Volumen y Superficie");
        lblTitulo.setBounds(80, 20, 240, 30);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        contenedor.add(lblTitulo);
        
        // Etiqueta y combo para seleccionar figura
        JLabel lblFigura = new JLabel("Seleccione una figura:");
        lblFigura.setBounds(20, 60, 150, 20);
        contenedor.add(lblFigura);
        
        comboFiguras = new JComboBox<>(new String[] {"Cilindro", "Esfera", "Pirámide"});
        comboFiguras.setBounds(170, 60, 150, 20);
        comboFiguras.addActionListener(this);
        contenedor.add(comboFiguras);
        
        // Panel para los datos de entrada
        panelDatos = new JPanel();
        panelDatos.setBounds(20, 90, 350, 150);
        panelDatos.setLayout(null);
        panelDatos.setBorder(BorderFactory.createTitledBorder("Datos de entrada"));
        contenedor.add(panelDatos);
        
        // Botón para calcular
        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(150, 250, 100, 30);
        btnCalcular.addActionListener(this);
        contenedor.add(btnCalcular);
        
        // Etiqueta para mostrar resultados
        lblResultado = new JLabel("Ingrese los datos y presione Calcular");
        lblResultado.setBounds(20, 290, 350, 60);
        lblResultado.setHorizontalAlignment(SwingConstants.CENTER);
        contenedor.add(lblResultado);
        
        // Inicializar componentes para cada figura
        inicializarComponentesCilindro();
        inicializarComponentesEsfera();
        inicializarComponentesPiramide();
        
        // Mostrar inicialmente los componentes del cilindro
        mostrarComponentesCilindro();
    }
    
    /**
     * Inicializa los componentes para el cilindro
     */
    private void inicializarComponentesCilindro() {
        JLabel lblRadio = new JLabel("Radio (cm):");
        lblRadio.setBounds(20, 30, 100, 20);
        
        txtRadioCilindro = new JTextField();
        txtRadioCilindro.setBounds(120, 30, 100, 20);
        
        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(20, 60, 100, 20);
        
        txtAlturaCilindro = new JTextField();
        txtAlturaCilindro.setBounds(120, 60, 100, 20);
    }
    
    /**
     * Inicializa los componentes para la esfera
     */
    private void inicializarComponentesEsfera() {
        JLabel lblRadio = new JLabel("Radio (cm):");
        lblRadio.setBounds(20, 30, 100, 20);
        
        txtRadioEsfera = new JTextField();
        txtRadioEsfera.setBounds(120, 30, 100, 20);
    }
    
    /**
     * Inicializa los componentes para la pirámide
     */
    private void inicializarComponentesPiramide() {
        JLabel lblBase = new JLabel("Base (cm):");
        lblBase.setBounds(20, 30, 100, 20);
        
        txtBasePiramide = new JTextField();
        txtBasePiramide.setBounds(120, 30, 100, 20);
        
        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(20, 60, 100, 20);
        
        txtAlturaPiramide = new JTextField();
        txtAlturaPiramide.setBounds(120, 60, 100, 20);
        
        JLabel lblApotema = new JLabel("Apotema (cm):");
        lblApotema.setBounds(20, 90, 100, 20);
        
        txtApotemaPiramide = new JTextField();
        txtApotemaPiramide.setBounds(120, 90, 100, 20);
    }
    
    /**
     * Muestra los componentes para el cilindro
     */
    private void mostrarComponentesCilindro() {
        panelDatos.removeAll();
        
        JLabel lblRadio = new JLabel("Radio (cm):");
        lblRadio.setBounds(20, 30, 100, 20);
        panelDatos.add(lblRadio);
        panelDatos.add(txtRadioCilindro);
        
        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(20, 60, 100, 20);
        panelDatos.add(lblAltura);
        panelDatos.add(txtAlturaCilindro);
        
        panelDatos.repaint();
    }
    
    /**
     * Muestra los componentes para la esfera
     */
    private void mostrarComponentesEsfera() {
        panelDatos.removeAll();
        
        JLabel lblRadio = new JLabel("Radio (cm):");
        lblRadio.setBounds(20, 30, 100, 20);
        panelDatos.add(lblRadio);
        panelDatos.add(txtRadioEsfera);
        
        panelDatos.repaint();
    }
    
    /**
     * Muestra los componentes para la pirámide
     */
    private void mostrarComponentesPiramide() {
        panelDatos.removeAll();
        
        JLabel lblBase = new JLabel("Base (cm):");
        lblBase.setBounds(20, 30, 100, 20);
        panelDatos.add(lblBase);
        panelDatos.add(txtBasePiramide);
        
        JLabel lblAltura = new JLabel("Altura (cm):");
        lblAltura.setBounds(20, 60, 100, 20);
        panelDatos.add(lblAltura);
        panelDatos.add(txtAlturaPiramide);
        
        JLabel lblApotema = new JLabel("Apotema (cm):");
        lblApotema.setBounds(20, 90, 100, 20);
        panelDatos.add(lblApotema);
        panelDatos.add(txtApotemaPiramide);
        
        panelDatos.repaint();
    }
    
    /**
     * Maneja los eventos de la interfaz
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        // Si el evento viene del combo de figuras
        if (e.getSource() == comboFiguras) {
            int indice = comboFiguras.getSelectedIndex();
            switch (indice) {
                case 0: // Cilindro
                    mostrarComponentesCilindro();
                    break;
                case 1: // Esfera
                    mostrarComponentesEsfera();
                    break;
                case 2: // Pirámide
                    mostrarComponentesPiramide();
                    break;
            }
        }
        
        // Si el evento viene del botón calcular
        if (e.getSource() == btnCalcular) {
            calcular();
        }
    }
    
    /**
     * Realiza el cálculo según la figura seleccionada
     */
    private void calcular() {
        try {
            int indice = comboFiguras.getSelectedIndex();
            FiguraGeometrica figura = null;
            
            switch (indice) {
                case 0: // Cilindro
                    double radioCilindro = Double.parseDouble(txtRadioCilindro.getText());
                    double alturaCilindro = Double.parseDouble(txtAlturaCilindro.getText());
                    figura = new Cilindro(radioCilindro, alturaCilindro);
                    break;
                    
                case 1: // Esfera
                    double radioEsfera = Double.parseDouble(txtRadioEsfera.getText());
                    figura = new Esfera(radioEsfera);
                    break;
                    
                case 2: // Pirámide
                    double basePiramide = Double.parseDouble(txtBasePiramide.getText());
                    double alturaPiramide = Double.parseDouble(txtAlturaPiramide.getText());
                    double apotemaPiramide = Double.parseDouble(txtApotemaPiramide.getText());
                    figura = new Piramide(basePiramide, alturaPiramide, apotemaPiramide);
                    break;
            }
            
            if (figura != null) {
                double volumen = figura.calcularVolumen();
                double superficie = figura.calcularSuperficie();
                
                String resultado = String.format(
                    "<html>%s:<br>Volumen: %.2f cm³<br>Superficie: %.2f cm²</html>",
                    figura.getNombre(), volumen, superficie
                );
                
                lblResultado.setText(resultado);
            }
            
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                this,
                "Por favor, ingrese valores numéricos válidos",
                "Error de entrada",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }
    
    /**
     * Método principal para ejecutar la aplicación
     */
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            VentanaFiguras ventana = new VentanaFiguras();
            ventana.setVisible(true);
        });
    }
}