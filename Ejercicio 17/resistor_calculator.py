def resistor_color_trio(color1, color2, color3):
    """
    Calcula el valor de una resistencia basado en tres bandas de colores.
    
    Args:
        color1 (str): Primera banda de color
        color2 (str): Segunda banda de color
        color3 (str): Tercera banda de color (multiplicador)
    
    Returns:
        str: Valor de la resistencia con unidades apropiadas
    """
    
    # Diccionario de colores y sus valores
    color_values = {
        'negro': 0, 'black': 0,
        'marrón': 1, 'brown': 1,
        'rojo': 2, 'red': 2,
        'naranja': 3, 'orange': 3,
        'amarillo': 4, 'yellow': 4,
        'verde': 5, 'green': 5,
        'azul': 6, 'blue': 6,
        'violeta': 7, 'violet': 7,
        'gris': 8, 'grey': 8, 'gray': 8,
        'blanco': 9, 'white': 9
    }
    
    # Convertir colores a minúsculas para comparación
    color1 = color1.lower()
    color2 = color2.lower()
    color3 = color3.lower()
    
    # Obtener valores de las primeras dos bandas
    first_digit = color_values[color1]
    second_digit = color_values[color2]
    
    # Calcular valor base (primeros dos dígitos)
    base_value = first_digit * 10 + second_digit
    
    # Obtener multiplicador (cantidad de ceros)
    multiplier = color_values[color3]
    
    # Calcular valor final
    resistance_value = base_value * (10 ** multiplier)
    
    # Determinar unidades apropiadas
    if resistance_value >= 1000000:
        return f"{resistance_value // 1000000} megaohmios"
    elif resistance_value >= 1000:
        return f"{resistance_value // 1000} kiloohmios"
    else:
        return f"{resistance_value} ohmios"


def main():
    print("Calculadora de Resistencias")
    print("Colores disponibles: negro, marrón, rojo, naranja, amarillo, verde, azul, violeta, gris, blanco")
    print()
    
    # Ejemplos de uso
    print("Ejemplos:")
    print(f"naranja-naranja-negro: {resistor_color_trio('naranja', 'naranja', 'negro')}")
    print(f"naranja-naranja-rojo: {resistor_color_trio('naranja', 'naranja', 'rojo')}")
    print(f"naranja-naranja-naranja: {resistor_color_trio('naranja', 'naranja', 'naranja')}")
    print()
    
    # Entrada del usuario
    try:
        color1 = input("Ingrese el primer color: ")
        color2 = input("Ingrese el segundo color: ")
        color3 = input("Ingrese el tercer color: ")
        
        result = resistor_color_trio(color1, color2, color3)
        print(f"\nValor de la resistencia: {result}")
        
    except KeyError as e:
        print(f"Error: Color no válido - {e}")
    except Exception as e:
        print(f"Error: {e}")


if __name__ == "__main__":
    main()