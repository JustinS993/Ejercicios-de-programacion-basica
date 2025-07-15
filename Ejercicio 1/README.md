# ¡Buscando el número más grande!

Este proyecto muestra cómo encontrar el número más grande en una lista de números utilizando cuatro lenguajes de programación diferentes: **Python**, **Java**, **JavaScript** y **C++**. Aunque el objetivo es el mismo, cada lenguaje tiene su propio estilo y personalidad.

## Archivos incluidos
- `maximo_array.py` — Python
- `MaximoArray.java` — Java
- `maximoArray.js` — JavaScript
- `maximo_array.cpp` — C++

## ¿Cómo resuelve el problema cada lenguaje?

### 🐍 Python (`maximo_array.py`)
Python destaca por su sencillez. En este caso, se utiliza la función `max()` para obtener el resultado de forma directa. El código es breve y fácil de entender, ideal para quienes buscan claridad y rapidez.

### ☕ Java (`MaximoArray.java`)
Java requiere un enfoque más detallado. No existe una función incorporada para encontrar el máximo en arrays primitivos, por lo que se recorre el array con un bucle y se compara cada elemento. La sintaxis es más estricta, pero el proceso es muy explícito.

### 🌐 JavaScript (`maximoArray.js`)
JavaScript aprovecha su flexibilidad y modernidad. Utiliza `Math.max` junto con el operador spread (`...`) para desempaquetar el array y obtener el máximo en una sola línea, lo que resulta muy práctico para aplicaciones web.

### 💻 C++ (`maximo_array.cpp`)
C++ ofrece un control cercano al hardware. Aquí también se recorre el array manualmente y se debe indicar el tamaño del array. Aunque es más técnico, permite un manejo detallado de los recursos.

## Diferencias entre los lenguajes
Aunque todos los programas buscan el mismo resultado, existen diferencias notables:
- **Sintaxis**: Cada lenguaje tiene su propio conjunto de reglas y estructura.
- **Funciones incorporadas**: Python y JavaScript proporcionan herramientas listas para usar, mientras que en Java y C++ suele ser necesario implementar la lógica manualmente.
- **Manejo de arrays/listas**: En Python y JavaScript, los arrays/listas son objetos con métodos útiles. En Java y C++, los arrays son estructuras más básicas.
- **Tipado**: Java y C++ exigen declarar el tipo de cada variable, mientras que Python y JavaScript son más flexibles en este aspecto.

## 🚀 Ejecución de los archivos
A continuación se explica cómo ejecutar cada uno de estos programas desde la terminal o consola, paso a paso:

### Python
1. Abrir una terminal y navegar a la carpeta donde se encuentra el archivo (`Ejercicio 1`).
2. Escribir el siguiente comando y presionar Enter:
   ```bash
   python maximo_array.py
   ```
   Si hay varias versiones de Python instaladas, puede ser necesario usar `python3` en vez de `python`.

### Java
1. Abrir una terminal y navegar a la carpeta donde se encuentra el archivo (`Ejercicio 1`).
2. Compilar el archivo Java con:
   ```bash
   javac MaximoArray.java
   ```
   Esto generará un archivo `MaximoArray.class`.
3. Ejecutar el programa con:
   ```bash
   java MaximoArray
   ```

### JavaScript (Node.js)
1. Verificar que Node.js esté instalado (se puede comprobar con `node -v`).
2. Abrir una terminal y navegar a la carpeta donde se encuentra el archivo (`Ejercicio 1`).
3. Ejecutar el archivo con:
   ```bash
   node maximoArray.js
   ```

### C++
1. Abrir una terminal y navegar a la carpeta donde se encuentra el archivo (`Ejercicio 1`).
2. Compilar el archivo con un compilador como `g++`:
   ```bash
   g++ maximo_array.cpp -o maximo_array
   ```
   Esto creará un ejecutable llamado `maximo_array` (o `maximo_array.exe` en Windows).
3. Ejecutar el programa con:
   - En Linux/Mac:
     ```bash
     ./maximo_array
     ```
   - En Windows:
     ```bash
     maximo_array.exe
     ```