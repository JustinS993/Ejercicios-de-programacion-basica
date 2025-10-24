def detectar_caracter(caracter):
    """
    Detecta si un carácter es letra, número u otro tipo
    """
    if caracter.isalpha():
        return "letra"
    elif caracter.isdigit():
        return "número"
    else:
        return "otro tipo"

def main():
    print("=== Detector de Caracteres ===")
    print("Este programa detecta si los caracteres introducidos son letras, números u otra cosa.")
    print("Para salir, escribe 'salir'")
    print("-" * 50)
    
    while True:
        # Pedir entrada al usuario
        entrada = input("Introduce un carácter (o 'salir' para terminar): ")
        
        # Verificar si quiere salir
        if entrada.lower() == 'salir':
            print("¡Hasta luego!")
            break
        
        # Verificar que solo se introduzca un carácter
        if len(entrada) != 1:
            print("Error: Por favor introduce solo UN carácter.")
            continue
        
        # Detectar el tipo de carácter
        tipo = detectar_caracter(entrada)
        
        # Mostrar resultado
        print(f"El carácter '{entrada}' es una {tipo}")
        
        # Mostrar información adicional
        if tipo == "letra":
            if entrada.isupper():
                print(f"  - Es una letra mayúscula")
            else:
                print(f"  - Es una letra minúscula")
        elif tipo == "número":
            print(f"  - Es el número {entrada}")
        else:
            print(f"  - Es un carácter especial o símbolo")
        
        print("-" * 30)

if __name__ == "__main__":
    main() 