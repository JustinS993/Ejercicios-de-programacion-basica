# Ejercicios 6 y 7 - Programación Básica

Este directorio contiene dos ejercicios de programación básica implementados en Python.

## Ejercicio 6: Detector de Caracteres

### Descripción
Programa que detecta si los caracteres introducidos por el usuario son:
- **Letras** (mayúsculas o minúsculas)
- **Números** (0-9)
- **Otros tipos** (símbolos, espacios, etc.)

### Archivo
- `detector_caracteres.py` - Implementación en Python

### Características
- Detección automática del tipo de carácter
- Información adicional para letras (mayúscula/minúscula)
- Validación de entrada (solo un carácter)
- Interfaz interactiva con opción de salida
- Manejo de errores

### Cómo ejecutar
```bash
python detector_caracteres.py
```

### Ejemplo de uso
```
=== Detector de Caracteres ===
Introduce un carácter (o 'salir' para terminar): A
El carácter 'A' es una letra
  - Es una letra mayúscula
------------------------------
Introduce un carácter (o 'salir' para terminar): 5
El carácter '5' es un número
  - Es el número 5
------------------------------
Introduce un carácter (o 'salir' para terminar): @
El carácter '@' es otro tipo
  - Es un carácter especial o símbolo
------------------------------
```

---

## Ejercicio 7: Gestión de Alumnos

### Descripción
Sistema completo de gestión de alumnos que incluye:
- **Clase Alumno** con campos: nombre, apellidos, DNI y nota
- **Array/Lista** para almacenar todos los alumnos
- **Cálculo de nota media** de todos los alumnos
- **Filtrado por calificaciones**: Sobresaliente, Notable, Aprobado, Suspenso

### Archivo
- `gestion_alumnos.py` - Implementación en Python

### Estructura de la Clase Alumno
```python
class Alumno:
    - nombre: str
    - apellidos: str
    - dni: str
    - nota: float (0-10)
```

### Sistema de Calificaciones
- **Sobresaliente**: 9.0 - 10.0
- **Notable**: 7.0 - 8.9
- **Aprobado**: 5.0 - 6.9
- **Suspenso**: 0.0 - 4.9

### Funcionalidades
1. **Agregar alumno** - Crear nuevo alumno con validación de datos
2. **Ver todos los alumnos** - Lista completa con calificaciones
3. **Filtrar por calificación** - Ver alumnos por tipo de nota
4. **Estadísticas** - Nota media y conteo por calificación
5. **Interfaz de menú** - Navegación fácil y intuitiva

### Cómo ejecutar
```bash
python gestion_alumnos.py
```

### Ejemplo de uso
```
=== GESTIÓN DE ALUMNOS ===
==================================================
MENÚ PRINCIPAL:
1. Agregar alumno
2. Ver todos los alumnos
3. Ver alumnos con Sobresaliente
4. Ver alumnos con Notable
5. Ver alumnos con Aprobado
6. Ver alumnos con Suspenso
7. Ver estadísticas
8. Salir
==================================================

Selecciona una opción (1-8): 1

--- Crear nuevo alumno ---
Nombre: Juan
Apellidos: Pérez García
DNI: 12345678A
Nota (0-10): 8.5
Alumno Juan Pérez García agregado correctamente.
```

### Características técnicas
- **Programación orientada a objetos** con clases
- **Validación de datos** en tiempo real
- **Manejo de errores** robusto
- **Interfaz de usuario** intuitiva
- **Cálculos automáticos** de estadísticas
- **Filtrado eficiente** de datos

---

## Requisitos
- Python 3.6 o superior
- No se requieren librerías externas

## Estructura del proyecto
```
Ejercicio 6 y 7/
├── detector_caracteres.py    # Ejercicio 6
├── gestion_alumnos.py        # Ejercicio 7
└── README.md                 # Este archivo
```

## Notas de implementación
- Ambos ejercicios están completamente funcionales
- Código bien documentado con comentarios
- Manejo de casos edge y errores
- Interfaz de usuario amigable
- Fácil de extender y modificar 