# Ejercicio 18: Agenda de Contactos con JavaFX

## Descripción
Este ejercicio implementa una aplicación de escritorio utilizando JavaFX para gestionar una agenda de contactos personal. La aplicación permite ingresar, almacenar y visualizar información de contactos en una interfaz gráfica intuitiva.

## Objetivos de Aprendizaje
- Crear una ventana gráfica utilizando JavaFX
- Incorporar componentes gráficos a los contenedores de una ventana gráfica
- Gestionar eventos de usuario en una aplicación GUI
- Implementar validación de datos en formularios

## Funcionalidades

### Campos de Entrada
- **Nombres**: Campo de texto para ingresar los nombres del contacto
- **Apellidos**: Campo de texto para ingresar los apellidos del contacto
- **Fecha de Nacimiento**: Selector de fecha (DatePicker) para elegir la fecha de nacimiento
- **Dirección**: Campo de texto para la dirección del contacto
- **Teléfono**: Campo de texto para el número telefónico
- **Correo Electrónico**: Campo de texto para la dirección de email

### Funciones
- **Botón Agregar**: Añade el contacto a la lista después de validar los campos obligatorios
- **Lista de Contactos**: Muestra todos los contactos agregados en formato ListView
- **Validación**: Verifica que los campos obligatorios (nombres y apellidos) estén completos
- **Limpieza automática**: Los campos se limpian automáticamente después de agregar un contacto
- **Alertas**: Muestra mensajes de confirmación y error al usuario

## Componentes JavaFX Utilizados

| Componente | Descripción | Uso en la aplicación |
|------------|-------------|----------------------|
| `Application` | Clase principal de JavaFX | Clase base para la aplicación |
| `Stage` | Ventana principal | Contenedor principal de la aplicación |
| `Scene` | Escena que contiene los componentes | Define la apariencia de la aplicación |
| `GridPane` | Panel de cuadrícula | Organiza los campos de entrada |
| `VBox` | Panel vertical | Contenedor principal vertical |
| `Label` | Etiquetas de texto | Describe cada campo de entrada |
| `TextField` | Campos de texto | Entrada de datos textuales |
| `DatePicker` | Selector de fecha | Selección de fecha de nacimiento |
| `Button` | Botón | Acción de agregar contacto |
| `ListView` | Lista visual | Muestra los contactos agregados |
| `Alert` | Cuadros de diálogo | Mensajes al usuario |

## Estructura del Código

### Métodos Principales
- `init()`: Inicializa los componentes de la interfaz
- `start(Stage)`: Configura y muestra la ventana principal
- `agregarContacto()`: Procesa la adición de un nuevo contacto
- `limpiarCampos()`: Limpia todos los campos de entrada
- `mostrarAlerta()`: Muestra mensajes al usuario
- `stop()`: Libera recursos al cerrar la aplicación

## Requisitos del Sistema
- Java 8 o superior con JavaFX
- Sistema operativo: Windows, macOS o Linux

## Instrucciones de Compilación y Ejecución

### Opción 1: Línea de Comandos
```bash
# Compilar
javac --module-path "ruta/a/javafx/lib" --add-modules javafx.controls,javafx.fxml ContactosApp.java

# Ejecutar
java --module-path "ruta/a/javafx/lib" --add-modules javafx.controls,javafx.fxml ContactosApp
```

### Opción 2: IDE (Eclipse, IntelliJ, NetBeans)
1. Crear un nuevo proyecto Java
2. Configurar JavaFX en el proyecto
3. Copiar el código fuente
4. Ejecutar la clase `ContactosApp`

## Uso de la Aplicación

1. **Llenar los campos**: Ingrese la información del contacto en los campos correspondientes
2. **Campos obligatorios**: Los campos "Nombres" y "Apellidos" son obligatorios
3. **Seleccionar fecha**: Use el DatePicker para seleccionar la fecha de nacimiento
4. **Agregar contacto**: Presione el botón "Agregar" para añadir el contacto a la lista
5. **Ver contactos**: Los contactos agregados aparecerán en la lista inferior
6. **Mensajes**: La aplicación mostrará mensajes de confirmación o error según corresponda

## Características Técnicas

### Validación de Datos
- Verificación de campos obligatorios
- Manejo de excepciones
- Mensajes informativos al usuario

### Interfaz de Usuario
- Diseño responsivo con GridPane
- Espaciado consistente entre componentes
- Estilo CSS básico para mejorar la apariencia
- Botón que se ajusta al ancho disponible

### Gestión de Eventos
- Evento `setOnAction` para el botón Agregar
- Manejo de eventos de usuario
- Actualización automática de la interfaz

## Posibles Mejoras
- Persistencia de datos (guardar en archivo)
- Edición y eliminación de contactos
- Búsqueda y filtrado de contactos
- Validación de formato de email y teléfono
- Exportación de contactos
- Interfaz más avanzada con CSS

## Autor
Ejercicio desarrollado como parte del curso de Programación Orientada a Objetos con Java y UML.

---
*Este ejercicio demuestra los conceptos fundamentales de JavaFX y el desarrollo de aplicaciones GUI en Java.*