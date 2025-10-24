# Ejercicio 8: Juego del Tablero 10x10

## Descripción del Ejercicio
Este ejercicio implementa un juego de autómatas celulares en un tablero de 10x10. El juego sigue reglas específicas basadas en los vecinos de cada celda, creando patrones dinámicos y evolutivos.

## Reglas del Juego

### Inicialización
- El tablero se llena aleatoriamente con valores de **0** y **1**
- Cada celda tiene 8 vecinos (arriba, abajo, izquierda, derecha y diagonales)

### Reglas de Evolución
Para cada celda en la siguiente generación:

1. **Más de 2/3 de vecinos iguales**: La celda mantiene su valor actual
2. **Menos de 1/3 de vecinos iguales**: La celda cambia su valor (0→1 o 1→0)
3. **Entre 1/3 y 2/3 de vecinos iguales**: 50% de probabilidad de mantener o cambiar el valor

### Visualización
- **■** = Valor 1 (uno)
- **□** = Valor 0 (cero)

## Archivo
- `juego_tablero.py` - Implementación completa del juego

## Características del Programa

### Clase JuegoTablero
- **Inicialización aleatoria** del tablero
- **Cálculo de vecinos** para cada celda
- **Aplicación de reglas** de evolución
- **Visualización gráfica** del tablero
- **Estadísticas** de ceros y unos

### Funcionalidades
1. **Inicializar tablero** - Crear nuevo tablero aleatorio
2. **Siguiente generación** - Calcular una nueva generación
3. **Múltiples generaciones** - Ejecutar varias generaciones secuencialmente
4. **Estadísticas** - Mostrar conteo de ceros y unos
5. **Interfaz interactiva** - Menú de opciones

## Cómo Ejecutar

```bash
python juego_tablero.py
```

## Ejemplo de Uso

```
=== JUEGO DEL TABLERO 10x10 ===
Reglas:
- Cada celda mantiene su valor si más de 2/3 de sus vecinos son iguales
- Cambia su valor si menos de 1/3 de sus vecinos son iguales
- 50% probabilidad si entre 1/3 y 2/3 de vecinos son iguales
- ■ = 1, □ = 0
--------------------------------------------------

OPCIONES:
1. Inicializar tablero aleatorio
2. Mostrar siguiente generación
3. Ejecutar múltiples generaciones
4. Mostrar estadísticas actuales
5. Salir

Selecciona una opción (1-5): 1

=== JUEGO DEL TABLERO - Generación 0 ===
Tablero 10x10
=====================================
    0 1 2 3 4 5 6 7 8 9
 0 | ■ □ ■ □ ■ □ ■ □ ■ □ |
 1 | □ ■ □ ■ □ ■ □ ■ □ ■ |
 2 | ■ □ ■ □ ■ □ ■ □ ■ □ |
 3 | □ ■ □ ■ □ ■ □ ■ □ ■ |
 4 | ■ □ ■ □ ■ □ ■ □ ■ □ |
 5 | □ ■ □ ■ □ ■ □ ■ □ ■ |
 6 | ■ □ ■ □ ■ □ ■ □ ■ □ |
 7 | □ ■ □ ■ □ ■ □ ■ □ ■ |
 8 | ■ □ ■ □ ■ □ ■ □ ■ □ |
 9 | □ ■ □ ■ □ ■ □ ■ □ ■ |
=====================================
■ = 1, □ = 0

--- ESTADÍSTICAS ---
Ceros (□): 50 (50.0%)
Unos (■):  50 (50.0%)
Total:     100
```

## Características Técnicas

### Algoritmo de Vecinos
- Revisa los 8 vecinos de cada celda
- Maneja correctamente los bordes del tablero
- Calcula proporciones para aplicar reglas

### Reglas de Evolución
```python
# Más de 2/3 de vecinos iguales: mantiene valor
if proporcion > 2/3:
    return valor_actual
# Menos de 1/3 de vecinos iguales: cambia valor
elif proporcion < 1/3:
    return 1 - valor_actual
# Entre 1/3 y 2/3: 50% probabilidad
else:
    return valor_actual if random.random() < 0.5 else 1 - valor_actual
```

### Visualización
- **Interfaz clara** con coordenadas
- **Símbolos visuales** (■ y □)
- **Estadísticas en tiempo real**
- **Limpieza de pantalla** para mejor visualización

## Conceptos Aplicados

### Autómatas Celulares
- Sistema de evolución basado en reglas locales
- Patrones emergentes de comportamiento global
- Simulación de sistemas complejos

### Programación Orientada a Objetos
- Clase `JuegoTablero` con métodos específicos
- Encapsulación de lógica del juego
- Interfaz clara y modular

### Algoritmos
- **Conteo de vecinos** eficiente
- **Aplicación de reglas** condicionales
- **Generación de números aleatorios**

## Posibles Extensiones

1. **Diferentes tamaños** de tablero
2. **Reglas personalizables** de evolución
3. **Guardado/carga** de configuraciones
4. **Animación automática** de generaciones
5. **Análisis de patrones** emergentes
6. **Exportación** de resultados

## Requisitos
- Python 3.6 o superior
- Módulos estándar: `random`, `time`, `os`
- No se requieren librerías externas

## Notas de Implementación
- Código bien documentado con comentarios
- Manejo de casos edge (bordes del tablero)
- Interfaz de usuario intuitiva
- Estadísticas en tiempo real
- Fácil de extender y modificar 