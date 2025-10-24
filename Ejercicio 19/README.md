# 🏁 Ejercicio 19: Componentes Gráficos JavaFX - Juego de Banderas (Versión Mejorada)

## 📋 Descripción del Ejercicio

Este ejercicio implementa el **Ejercicio 9.2** del libro "Ejercicios de programación orientada a objetos con Java y UML", que se enfoca en el uso de componentes gráficos de JavaFX para crear una aplicación interactiva de reconocimiento de banderas. **¡Ahora con 10 países y aleatorización completa!**

## 🎯 Objetivos de Aprendizaje

Al completar este ejercicio, habrás aprendido a:

- ✅ Utilizar **GridPane** para distribuir componentes en una ventana
- ✅ Insertar imágenes (simuladas) en ventanas gráficas
- ✅ Insertar diferentes componentes gráficos en un escenario
- ✅ Manejar eventos de botones con **setOnAction()**
- ✅ Aplicar efectos visuales como **DropShadow**
- ✅ Validar entrada de usuario y proporcionar retroalimentación visual
- ✅ **NUEVO:** Implementar aleatorización con **Collections** y **Random**
- ✅ **NUEVO:** Crear interfaces dinámicas que se adaptan al contenido
- ✅ **NUEVO:** Manejar múltiples eventos y reinicialización de juegos

## 🎮 Funcionalidad de la Aplicación

### Descripción del Juego
La aplicación presenta un juego educativo donde:

1. **Primera columna**: Muestra una lista de 10 países seleccionados aleatoriamente
2. **Segunda columna**: Campos de texto para que el usuario ingrese números
3. **Tercera columna**: Banderas numeradas del 1 al 10 (simuladas con colores, orden aleatorio)
4. **Sección inferior**: Botones de verificación y nuevo juego, más resultado de aciertos

### 🌟 Nuevas Características
- **🎲 Aleatorización completa**: Cada partida es diferente
- **🔄 Botón "Nuevo Juego"**: Reinicia con nueva combinación
- **📏 Interfaz expandida**: Ventana más grande (900x700) para acomodar más contenido
- **✨ Efectos hover**: Mejores efectos visuales en las banderas
- **🔧 Interfaz dinámica**: Se adapta automáticamente al número de países

### Países y Banderas Disponibles

| País | Colores Representativos |
|------|-------------------------|
| México | Verde, Blanco, Rojo |
| España | Rojo, Amarillo, Rojo |
| Francia | Azul, Blanco, Rojo |
| Italia | Verde, Blanco, Rojo |
| Alemania | Negro, Rojo, Amarillo |
| Brasil | Verde, Amarillo, Azul |
| Argentina | Azul, Blanco, Azul |
| Reino Unido | Azul, Blanco, Rojo |
| Japón | Blanco, Rojo, Blanco |
| Canadá | Rojo, Blanco, Rojo |

**⚠️ Importante**: En cada partida se seleccionan aleatoriamente 10 países y las banderas se mezclan en posiciones diferentes.

## 🧩 Componentes JavaFX Utilizados

### Componentes Principales
- **GridPane**: Layout principal para organizar elementos en filas y columnas
- **Label**: Títulos, nombres de países y números de banderas
- **TextField**: Campos de entrada para las respuestas del usuario
- **Button**: Botones para verificar respuestas y nuevo juego
- **VBox/HBox**: Contenedores para organizar banderas y elementos

### Efectos y Estilos
- **DropShadow**: Efecto de sombra en el título principal
- **CSS Styling**: Estilos personalizados para colores y apariencia
- **Font**: Configuración de fuentes y tamaños
- **Color**: Colores para texto y retroalimentación visual
- **Hover Effects**: Efectos visuales al pasar el mouse sobre las banderas

## 🏗️ Estructura del Código

### Métodos Principales

```java
// Método principal de JavaFX
public void start(Stage primaryStage)

// Configuración del layout
private GridPane crearGridPane()
private Label crearTitulo()
private void crearEncabezados(GridPane gridPane)
private void crearFilasPaises(GridPane gridPane)
private void crearSeccionBanderas(GridPane gridPane)
private void crearSeccionResultado(GridPane gridPane)

// Lógica del juego
private void verificarRespuestas()
private HBox crearBanderaSimulada(int numero, String colores)

// NUEVOS: Aleatorización y reinicio
private void inicializarJuegoAleatorio()
private void reiniciarJuego()
```

### Características Técnicas

- **Validación de entrada**: Verifica que las respuestas sean números válidos
- **Retroalimentación visual**: Campos se colorean según corrección (verde/rojo/amarillo)
- **Cálculo de porcentaje**: Muestra estadísticas de aciertos
- **Interfaz responsiva**: Layout adaptable con GridPane
- **Banderas simuladas**: Representación visual con colores característicos
- **NUEVO:** **Aleatorización**: Uso de Collections.shuffle() y Random
- **NUEVO:** **Interfaz dinámica**: Posicionamiento automático de elementos
- **NUEVO:** **Múltiples eventos**: Manejo de verificación y reinicio

## 🚀 Compilación y Ejecución

### Requisitos del Sistema
- Java JDK 11 o superior
- JavaFX SDK (si no está incluido en el JDK)
- Sistema operativo: Windows, macOS, o Linux

### Opción 1: Usando el script de ejecución
```batch
# Windows
ejecutar.bat

# O el script mejorado (si está disponible)
ejecutar_mejorado.bat
```

### Opción 2: Compilación manual
```bash
# Compilar
javac --module-path "ruta/a/javafx/lib" --add-modules javafx.controls,javafx.fxml *.java

# Ejecutar
java --module-path "ruta/a/javafx/lib" --add-modules javafx.controls,javafx.fxml BanderasApp
```

### Opción 3: Si JavaFX está incluido en el JDK
```bash
javac *.java
java BanderasApp
```

## 🎯 Instrucciones de Uso

1. **Ejecutar la aplicación**: La ventana mostrará el juego de banderas
2. **Observar las banderas**: En la columna derecha verás 10 banderas numeradas (orden aleatorio)
3. **Ingresar respuestas**: En los campos de texto, escribe el número de la bandera que corresponde a cada país
4. **Verificar**: Presiona el botón "🔍 VERIFICAR RESPUESTAS"
5. **Ver resultado**: Los campos se colorearán y verás tu puntuación
6. **🆕 Nuevo juego**: Presiona "🎲 NUEVO JUEGO ALEATORIO" para una nueva combinación

### Código de Colores para Retroalimentación
- 🟢 **Verde**: Respuesta correcta
- 🔴 **Rojo**: Respuesta incorrecta
- 🟡 **Amarillo**: Respuesta no válida (no es un número)
- ⚪ **Sin color**: Campo vacío

## 📚 Conceptos Técnicos Demostrados

### 1. Layout Management
- Uso de **GridPane** para organización en cuadrícula
- Combinación con **VBox** y **HBox** para layouts anidados
- Configuración de espaciado y alineación
- **NUEVO:** Posicionamiento dinámico de elementos

### 2. Event Handling
- Implementación de **setOnAction()** para manejo de eventos
- Validación de entrada de usuario
- Actualización dinámica de la interfaz
- **NUEVO:** Manejo de múltiples botones y eventos

### 3. Styling y Efectos
- Aplicación de estilos CSS en JavaFX
- Uso de **DropShadow** para efectos visuales
- Configuración de fuentes y colores
- **NUEVO:** Efectos hover y transiciones

### 4. Componentes Interactivos
- **TextField** con validación y retroalimentación
- **Button** con estilos personalizados
- **Label** con diferentes configuraciones

### 5. Programación Avanzada
- **NUEVO:** **Collections Framework**: ArrayList y Collections.shuffle()
- **NUEVO:** **Random**: Generación de números aleatorios
- **NUEVO:** **Programación dinámica**: Interfaces que se adaptan
- **NUEVO:** **Reutilización de código**: Métodos para reinicializar

## ✅ Mejoras Implementadas

- ✅ **Más países**: Aumentado de 5 a 10 países
- ✅ **Aleatorización**: Cada partida es diferente
- ✅ **Botón nuevo juego**: Reinicia con nueva combinación
- ✅ **Interfaz mejorada**: Ventana más grande (900x700)
- ✅ **Efectos visuales**: Hover effects en banderas
- ✅ **Interfaz dinámica**: Se adapta automáticamente al contenido
- ✅ **Mejor experiencia**: Más variedad y rejugabilidad

## 🔧 Posibles Mejoras Futuras

- 📸 **Imágenes reales**: Reemplazar banderas simuladas con imágenes PNG/JPG
- ⏱️ **Temporizador**: Agregar límite de tiempo para responder
- 🏆 **Niveles de dificultad**: Fácil (5 países), Medio (10 países), Difícil (15+ países)
- 💾 **Persistencia**: Guardar mejores puntuaciones
- 🌍 **Más continentes**: Expandir a países de África, Asia y Oceanía
- 🎵 **Sonidos**: Efectos de sonido para aciertos/errores
- 📱 **Responsive**: Mejor adaptación a diferentes tamaños de pantalla
- 🎮 **Modo multijugador**: Competir con otros jugadores

## 📖 Referencias

- **Libro**: "Ejercicios de programación orientada a objetos con Java y UML"
- **Ejercicio**: 9.2 - Componentes gráficos (Versión mejorada)
- **Tecnología**: JavaFX
- **Patrón**: MVC (Model-View-Controller) simplificado
- **Nuevas tecnologías**: Collections Framework, Random, Programación dinámica

---

*Ejercicio implementado y mejorado como parte del aprendizaje avanzado de JavaFX y programación orientada a objetos.*