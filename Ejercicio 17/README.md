# Calculadora de Resistencias - Ejercicio 17

## Descripción

Este proyecto implementa una calculadora de resistencias que decodifica el valor de una resistencia basándose en las bandas de colores. Las resistencias utilizan un código de colores para indicar su valor de resistencia, ya que son demasiado pequeñas para imprimir números legibles.

## Funcionamiento

El programa toma tres colores como entrada:
- **Primera banda**: Primer dígito del valor
- **Segunda banda**: Segundo dígito del valor
- **Tercera banda**: Multiplicador (cantidad de ceros a agregar)

### Código de Colores

| Color    | Valor |
|----------|-------|
| Negro    | 0     |
| Marrón   | 1     |
| Rojo     | 2     |
| Naranja  | 3     |
| Amarillo | 4     |
| Verde    | 5     |
| Azul     | 6     |
| Violeta  | 7     |
| Gris     | 8     |
| Blanco   | 9     |

### Ejemplos

- **naranja-naranja-negro**: 33 + 0 ceros = 33 ohmios
- **naranja-naranja-rojo**: 33 + 2 ceros = 3300 ohmios = 3 kiloohmios
- **naranja-naranja-naranja**: 33 + 3 ceros = 33000 ohmios = 33 kiloohmios

### Unidades

El programa automáticamente convierte a las unidades apropiadas:
- **ohmios**: valores menores a 1,000
- **kiloohmios**: valores de 1,000 a 999,999
- **megaohmios**: valores de 1,000,000 o mayores

## Implementaciones

Este proyecto incluye tres implementaciones del mismo algoritmo:

### 1. Python (`resistor_calculator.py`)

**Ejecutar:**
```bash
python resistor_calculator.py
```

**Características:**
- Función `resistor_color_trio()` para cálculos
- Interfaz de línea de comandos interactiva
- Manejo de errores para colores inválidos
- Soporte para nombres de colores en español e inglés

### 2. Java (`ResistorCalculator.java`)

**Compilar y ejecutar:**
```bash
javac ResistorCalculator.java
java ResistorCalculator
```

**Características:**
- Clase `ResistorCalculator` con método estático
- Uso de `HashMap` para mapeo de colores
- Manejo de excepciones con `IllegalArgumentException`
- Interfaz de usuario con `Scanner`

### 3. C++ (`resistor_calculator.cpp`)

**Compilar y ejecutar:**
```bash
g++ -o resistor_calculator resistor_calculator.cpp
./resistor_calculator
```

**Características:**
- Clase `ResistorCalculator` con encapsulación
- Uso de `std::map` para mapeo de colores
- Manejo de excepciones con `std::invalid_argument`
- Conversión automática a minúsculas

## Uso del Programa

1. **Ejecutar** cualquiera de las tres implementaciones
2. **Ver ejemplos** que se muestran automáticamente
3. **Ingresar** los tres colores cuando se solicite
4. **Obtener** el resultado con las unidades apropiadas

### Ejemplo de Ejecución

```
Calculadora de Resistencias
Colores disponibles: negro, marrón, rojo, naranja, amarillo, verde, azul, violeta, gris, blanco

Ejemplos:
naranja-naranja-negro: 33 ohmios
naranja-naranja-rojo: 3 kiloohmios
naranja-naranja-naranja: 33 kiloohmios

Ingrese el primer color: rojo
Ingrese el segundo color: verde
Ingrese el tercer color: amarillo

Valor de la resistencia: 250 kiloohmios
```

## Características Técnicas

### Validación de Entrada
- Verificación de colores válidos
- Conversión automática a minúsculas
- Manejo de errores con mensajes informativos

### Cálculo de Valores
- Algoritmo: `(primer_dígito × 10 + segundo_dígito) × 10^multiplicador`
- Conversión automática de unidades
- Soporte para valores grandes (hasta megaohmios)

### Compatibilidad
- Nombres de colores en español e inglés
- Variantes de escritura (gris/gray)
- Interfaz consistente en los tres lenguajes

## Requisitos del Sistema

- **Python**: Python 3.x
- **Java**: JDK 8 o superior
- **C++**: Compilador compatible con C++11 (g++, clang++, MSVC)

## Estructura del Proyecto

```
Ejercicio 17/
├── resistor_calculator.py    # Implementación en Python
├── ResistorCalculator.java   # Implementación en Java
├── resistor_calculator.cpp   # Implementación en C++
└── README.md                 # Este archivo
```

## Notas Adicionales

- Todos los programas muestran ejemplos automáticamente al iniciar
- Los colores pueden ingresarse en español o inglés
- El programa maneja errores de entrada de forma elegante
- Las tres implementaciones producen resultados idénticos

---

*Este ejercicio forma parte de los "Ejercicios de Programación Básica 1" y demuestra conceptos fundamentales como mapeo de datos, cálculos matemáticos, manejo de entrada/salida y validación de datos en múltiples lenguajes de programación.*