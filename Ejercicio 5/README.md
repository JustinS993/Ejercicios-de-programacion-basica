# Calculadora de Operaciones desde Archivo

## Descripción del Ejercicio
Este programa lee un archivo de texto (Challenge21.txt) que contiene una serie de números y operaciones matemáticas, realiza los cálculos correspondientes y muestra el resultado final. El programa está implementado en Python y Java.

### Características del Archivo Challenge21.txt
- Cada línea contiene un número o una operación (alternando entre ambos)
- Soporta números enteros y decimales
- Las operaciones soportadas son:
  * Suma (+)
  * Resta (-)
  * Multiplicación (*)
  * División (/)

### Validaciones
- Verifica que el formato del archivo sea correcto (alternancia entre números y operadores)
- Valida que los operadores sean válidos (+, -, *, /)
- Comprueba que los números tengan un formato válido
- Evita divisiones por cero

### Manejo de Errores
- Si el formato del archivo no es correcto, muestra un mensaje de error
- Si hay operaciones inválidas, indica el problema específico
- Si el archivo no existe, notifica al usuario

## Implementaciones

### Python (calculadora.py)
- Utiliza manejo de excepciones para validar números
- Implementa funciones separadas para validación y cálculo
- Lectura de archivo línea por línea

### Java (Calculadora.java)
- Implementa una clase auxiliar para manejar resultados y errores
- Utiliza BufferedReader para la lectura eficiente del archivo
- Manejo estructurado de excepciones

## Ejemplo de Archivo Challenge21.txt
```
5.2
+
3
*
2
-
4.5
/
1.5
+
8
```

## Cómo Ejecutar

### Python
```bash
python calculadora.py
```

### Java
Compilar y ejecutar:
```bash
javac Calculadora.java
java Calculadora
```

## Notas Importantes
- El archivo Challenge21.txt debe estar en el mismo directorio que los programas
- Los números pueden ser enteros o decimales
- Las operaciones se realizan en el orden en que aparecen en el archivo
- No se implementa precedencia de operadores