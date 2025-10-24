# maximo_array.py
# Este script calcula el máximo de un array de números en Python

# Definimos una función que recibe una lista de números y retorna el máximo

def maximo_array(arr):
    # Usamos la función incorporada max() para encontrar el máximo
    return max(arr)

# Ejemplo de uso
if __name__ == "__main__":
    numeros = [3, 7, 2, 9, 4]
    print("El máximo es:", maximo_array(numeros)) 