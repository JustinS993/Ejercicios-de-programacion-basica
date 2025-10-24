def ordenar_vector(numeros):
    """
    Ordena un vector de números de menor a mayor
    """
    return sorted(numeros)

def main():
    print("=== ORDENAR VECTOR DE NÚMEROS ===")
    print()
    
    # Solicitar al usuario que ingrese los números
    print("Ingresa los números separados por espacios (ejemplo: 5 2 8 1 9):")
    entrada = input("Números: ")
    
    try:
        # Convertir la entrada en una lista de números
        numeros = [float(x) for x in entrada.split()]
        
        if not numeros:
            print("Error: No se ingresaron números.")
            return
        
        print(f"\nVector original: {numeros}")
        
        # Ordenar el vector
        vector_ordenado = ordenar_vector(numeros)
        
        print(f"Vector ordenado: {vector_ordenado}")
        
        # Mostrar estadísticas adicionales
        print(f"\nEstadísticas:")
        print(f"- Cantidad de elementos: {len(vector_ordenado)}")
        print(f"- Número más pequeño: {min(vector_ordenado)}")
        print(f"- Número más grande: {max(vector_ordenado)}")
        print(f"- Promedio: {sum(vector_ordenado) / len(vector_ordenado):.2f}")
        
    except ValueError:
        print("Error: Asegúrate de ingresar solo números válidos separados por espacios.")
    except Exception as e:
        print(f"Error inesperado: {e}")

if __name__ == "__main__":
    main() 