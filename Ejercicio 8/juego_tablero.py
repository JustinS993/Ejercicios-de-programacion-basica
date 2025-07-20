import random
import time
import os

class JuegoTablero:
    """
    Juego de tablero 10x10 con reglas de autómatas celulares
    """
    def __init__(self, filas=10, columnas=10):
        self.filas = filas
        self.columnas = columnas
        self.tablero = []
        self.generacion = 0
        
    def inicializar_tablero(self):
        """Inicializa el tablero con valores aleatorios de 0 y 1"""
        self.tablero = []
        for i in range(self.filas):
            fila = []
            for j in range(self.columnas):
                fila.append(random.randint(0, 1))
            self.tablero.append(fila)
        self.generacion = 0
        print("Tablero inicializado aleatoriamente.")
    
    def contar_vecinos_iguales(self, fila, columna):
        """
        Cuenta cuántos vecinos tienen el mismo valor que la celda actual
        """
        valor_actual = self.tablero[fila][columna]
        vecinos_iguales = 0
        total_vecinos = 0
        
        # Revisar los 8 vecinos (arriba, abajo, izquierda, derecha y diagonales)
        for i in range(max(0, fila-1), min(self.filas, fila+2)):
            for j in range(max(0, columna-1), min(self.columnas, columna+2)):
                if i != fila or j != columna:  # No contar la celda actual
                    total_vecinos += 1
                    if self.tablero[i][j] == valor_actual:
                        vecinos_iguales += 1
        
        return vecinos_iguales, total_vecinos
    
    def calcular_nuevo_valor(self, fila, columna):
        """
        Calcula el nuevo valor de una celda según las reglas del juego
        """
        vecinos_iguales, total_vecinos = self.contar_vecinos_iguales(fila, columna)
        valor_actual = self.tablero[fila][columna]
        
        if total_vecinos == 0:
            return valor_actual
        
        # Calcular la proporción de vecinos iguales
        proporcion = vecinos_iguales / total_vecinos
        
        # Reglas del juego:
        # - Más de 2/3 de vecinos iguales: mantiene valor
        # - Menos de 1/3 de vecinos iguales: cambia valor
        # - Entre 1/3 y 2/3: 50% probabilidad de mantener/cambiar
        
        if proporcion > 2/3:
            # Más de dos tercios: mantiene su valor
            return valor_actual
        elif proporcion < 1/3:
            # Menos de un tercio: cambia su valor
            return 1 - valor_actual
        else:
            # Entre un tercio y dos tercios: 50% probabilidad
            if random.random() < 0.5:
                return valor_actual
            else:
                return 1 - valor_actual
    
    def siguiente_generacion(self):
        """Calcula la siguiente generación del tablero"""
        nuevo_tablero = []
        
        for i in range(self.filas):
            nueva_fila = []
            for j in range(self.columnas):
                nuevo_valor = self.calcular_nuevo_valor(i, j)
                nueva_fila.append(nuevo_valor)
            nuevo_tablero.append(nueva_fila)
        
        self.tablero = nuevo_tablero
        self.generacion += 1
    
    def mostrar_tablero(self):
        """Muestra el tablero actual en pantalla"""
        os.system('cls' if os.name == 'nt' else 'clear')  # Limpiar pantalla
        
        print(f"=== JUEGO DEL TABLERO - Generación {self.generacion} ===")
        print(f"Tablero {self.filas}x{self.columnas}")
        print("=" * (self.columnas * 2 + 3))
        
        # Mostrar números de columnas
        print("   ", end="")
        for j in range(self.columnas):
            print(f"{j:2}", end="")
        print()
        
        # Mostrar tablero
        for i in range(self.filas):
            print(f"{i:2} |", end="")
            for j in range(self.columnas):
                if self.tablero[i][j] == 1:
                    print(" ■", end="")
                else:
                    print(" □", end="")
            print(" |")
        
        print("=" * (self.columnas * 2 + 3))
        print("■ = 1, □ = 0")
    
    def contar_ceros_y_unos(self):
        """Cuenta cuántos ceros y unos hay en el tablero"""
        ceros = sum(fila.count(0) for fila in self.tablero)
        unos = sum(fila.count(1) for fila in self.tablero)
        return ceros, unos
    
    def mostrar_estadisticas(self):
        """Muestra estadísticas del tablero actual"""
        ceros, unos = self.contar_ceros_y_unos()
        total = ceros + unos
        
        print(f"\n--- ESTADÍSTICAS ---")
        print(f"Ceros (□): {ceros} ({ceros/total*100:.1f}%)")
        print(f"Unos (■):  {unos} ({unos/total*100:.1f}%)")
        print(f"Total:     {total}")

def main():
    """Función principal del juego"""
    print("=== JUEGO DEL TABLERO 10x10 ===")
    print("Reglas:")
    print("- Cada celda mantiene su valor si más de 2/3 de sus vecinos son iguales")
    print("- Cambia su valor si menos de 1/3 de sus vecinos son iguales")
    print("- 50% probabilidad si entre 1/3 y 2/3 de vecinos son iguales")
    print("- ■ = 1, □ = 0")
    print("-" * 50)
    
    # Crear el juego
    juego = JuegoTablero(10, 10)
    
    while True:
        print("\nOPCIONES:")
        print("1. Inicializar tablero aleatorio")
        print("2. Mostrar siguiente generación")
        print("3. Ejecutar múltiples generaciones")
        print("4. Mostrar estadísticas actuales")
        print("5. Salir")
        
        opcion = input("\nSelecciona una opción (1-5): ").strip()
        
        if opcion == "1":
            juego.inicializar_tablero()
            juego.mostrar_tablero()
            juego.mostrar_estadisticas()
            
        elif opcion == "2":
            if juego.generacion == 0:
                print("Primero debes inicializar el tablero (opción 1)")
                continue
            
            juego.siguiente_generacion()
            juego.mostrar_tablero()
            juego.mostrar_estadisticas()
            
        elif opcion == "3":
            if juego.generacion == 0:
                print("Primero debes inicializar el tablero (opción 1)")
                continue
            
            try:
                num_generaciones = int(input("¿Cuántas generaciones quieres ejecutar? "))
                if num_generaciones <= 0:
                    print("Debe ser un número positivo")
                    continue
                
                print(f"Ejecutando {num_generaciones} generaciones...")
                for i in range(num_generaciones):
                    juego.siguiente_generacion()
                    juego.mostrar_tablero()
                    juego.mostrar_estadisticas()
                    
                    if i < num_generaciones - 1:  # No pausar en la última
                        input("Presiona Enter para continuar...")
                        
            except ValueError:
                print("Por favor introduce un número válido")
                
        elif opcion == "4":
            if juego.generacion == 0:
                print("Primero debes inicializar el tablero (opción 1)")
                continue
            
            juego.mostrar_tablero()
            juego.mostrar_estadisticas()
            
        elif opcion == "5":
            print("¡Gracias por jugar!")
            break
            
        else:
            print("Opción no válida. Por favor selecciona del 1 al 5.")

if __name__ == "__main__":
    main() 