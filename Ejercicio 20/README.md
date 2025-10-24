# Ejercicio 8.3: Gestión de Eventos - Cálculo de Figuras Geométricas

Este proyecto implementa una aplicación Java con interfaz gráfica que permite calcular el volumen y superficie de diferentes figuras geométricas: cilindro, esfera y pirámide.

## Estructura del Proyecto

El proyecto está organizado en las siguientes clases:

1. **FiguraGeometrica.java**: Clase abstracta que define los métodos comunes para todas las figuras geométricas.
2. **Cilindro.java**: Clase que representa un cilindro y calcula su volumen y superficie.
3. **Esfera.java**: Clase que representa una esfera y calcula su volumen y superficie.
4. **Piramide.java**: Clase que representa una pirámide y calcula su volumen y superficie.
5. **VentanaFiguras.java**: Clase principal que implementa la interfaz gráfica y gestiona los eventos.

## Funcionalidades

- Selección de figura geométrica mediante un menú desplegable.
- Ingreso de datos específicos para cada figura:
  - Cilindro: radio y altura
  - Esfera: radio
  - Pirámide: base, altura y apotema
- Cálculo automático del volumen y superficie al presionar el botón "Calcular".
- Validación de entrada para asegurar que se ingresen valores numéricos válidos.

## Compilación y Ejecución

Para compilar el proyecto, ejecute el siguiente comando en la terminal:

```bash
javac *.java
```

Para ejecutar la aplicación:

```bash
java VentanaFiguras
```

## Requisitos

- Java Development Kit (JDK) 8 o superior
- Biblioteca Swing (incluida en el JDK)

## Implementación de Eventos

La aplicación utiliza el patrón de diseño Listener para manejar los eventos de la interfaz gráfica:

- La clase `VentanaFiguras` implementa la interfaz `ActionListener`.
- Los eventos se manejan en el método `actionPerformed(ActionEvent e)`.
- Se utilizan eventos para:
  - Cambiar los campos de entrada según la figura seleccionada.
  - Realizar los cálculos cuando se presiona el botón "Calcular".

## Fórmulas Utilizadas

### Cilindro
- Volumen: V = π * r² * h
- Superficie: S = 2π * r * (r + h)

### Esfera
- Volumen: V = (4/3) * π * r³
- Superficie: S = 4π * r²

### Pirámide (base cuadrada)
- Volumen: V = (1/3) * base² * altura
- Superficie: S = base² + 2 * base * apotema