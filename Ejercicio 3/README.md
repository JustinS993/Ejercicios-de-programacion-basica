# Ordenar un vector de números

Este ejercicio muestra cómo ordenar un vector (array) de números utilizando dos lenguajes de programación diferentes: **Python** y **JavaScript**.

## Archivos incluidos
- `ordenar_vector.py` — Python
- `ordenar_vector.js` — JavaScript

## ¿Cómo resuelve el problema cada lenguaje?

### 🐍 Python (`ordenar_vector.py`)
El programa pide al usuario que ingrese números separados por espacios, los convierte en una lista y utiliza la función `sorted()` para ordenarlos de menor a mayor. También muestra estadísticas adicionales como el mínimo, máximo y promedio.

### 🟨 JavaScript (`ordenar_vector.js`)
El programa solicita al usuario números separados por espacios, los convierte en un array y utiliza el método `sort()` con una función de comparación para ordenarlos correctamente. También incluye manejo de entrada asíncrona y muestra estadísticas del vector.

## 🚀 Ejecución de los archivos

### Python
1. Abrir una terminal y navegar a la carpeta `Ejercicio 3`.
2. Ejecutar:
   ```bash
   python ordenar_vector.py
   ```
   O, si tienes varias versiones de Python:
   ```bash
   python3 ordenar_vector.py
   ```

### JavaScript
1. Abrir una terminal y navegar a la carpeta `Ejercicio 3`.
2. Ejecutar:
   ```bash
   node ordenar_vector.js
   ```

## 📝 Ejemplo de uso

### Entrada:
```
Números: 5 2 8 1 9 3 7
```

### Salida esperada:
```
=== ORDENAR VECTOR DE NÚMEROS ===

Ingresa los números separados por espacios (ejemplo: 5 2 8 1 9):
Números: 5 2 8 1 9 3 7

Vector original: [5, 2, 8, 1, 9, 3, 7]
Vector ordenado: [1, 2, 3, 5, 7, 8, 9]

Estadísticas:
- Cantidad de elementos: 7
- Número más pequeño: 1
- Número más grande: 9
- Promedio: 5.00
```

## 🔧 Características del programa

- **Entrada flexible**: Acepta números enteros y decimales
- **Validación de entrada**: Verifica que se ingresen números válidos
- **Manejo de errores**: Gestiona entradas incorrectas de forma elegante
- **Estadísticas adicionales**: Muestra información útil sobre el vector
- **Interfaz clara**: Mensajes informativos y formato legible

## 💡 Algoritmo de ordenamiento

Ambos programas utilizan algoritmos de ordenamiento nativos de cada lenguaje:
- **Python**: `sorted()` - Implementa Timsort (híbrido de Merge Sort e Insertion Sort)
- **JavaScript**: `sort()` - Implementa el algoritmo de ordenamiento del motor V8 (generalmente QuickSort)

## 🎯 Objetivos de aprendizaje

- Entender cómo trabajar con arrays/vectores
- Aprender a ordenar datos numéricos
- Practicar el manejo de entrada de usuario
- Implementar validación de datos
- Calcular estadísticas básicas de un conjunto de datos 