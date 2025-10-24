# Detector de Palíndromos

## Descripción del Ejercicio
Este ejercicio consiste en crear un programa que determine si una palabra introducida por el usuario es un palíndromo. Un palíndromo es una palabra o frase que se lee igual de izquierda a derecha que de derecha a izquierda, ignorando espacios y mayúsculas/minúsculas.

### Ejemplos de palíndromos:
- Ana
- Arenera
- Oso
- Radar
- Reconocer
- Rotor
- Salas
- Seres
- Somos
- Sometemos

## Soluciones Implementadas

Se han proporcionado implementaciones en varios lenguajes de programación:

### Python (palindromo.py)
- Utiliza slicing de strings para invertir la palabra
- Manejo simple y directo de strings en Python

### JavaScript (palindromo.js)
- Implementación usando métodos de array (split, reverse, join)
- Uso de expresiones regulares para eliminar espacios

### C++ (palindromo.cpp)
- Utiliza la biblioteca algorithm para invertir strings
- Manejo de caracteres individuales para limpieza de entrada

### Java (Palindromo.java)
- Implementación usando StringBuilder para invertir strings
- Uso de expresiones regulares para eliminar espacios

## Cómo Ejecutar

### Python
```bash
python palindromo.py
```

### JavaScript
Abrir el archivo palindromo.js en un navegador web o ejecutar con Node.js:
```bash
node palindromo.js
```

### C++
Compilar y ejecutar:
```bash
g++ palindromo.cpp -o palindromo
./palindromo
```

### Java
Compilar y ejecutar:
```bash
javac Palindromo.java
java Palindromo
```

## Características
- Ignora mayúsculas y minúsculas
- Elimina espacios en blanco
- Proporciona retroalimentación clara al usuario
- Implementación eficiente en cada lenguaje