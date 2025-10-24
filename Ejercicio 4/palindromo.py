def es_palindromo(palabra):
    # Convertir a minúsculas y eliminar espacios
    palabra = palabra.lower().replace(' ', '')
    # Comparar la palabra con su versión invertida
    return palabra == palabra[::-1]

def main():
    # Solicitar entrada al usuario
    palabra = input("Introduce una palabra para verificar si es un palíndromo: ")
    
    # Verificar si es palíndromo
    if es_palindromo(palabra):
        print(f'"{palabra}" es un palíndromo!')
    else:
        print(f'"{palabra}" no es un palíndromo.')

if __name__ == "__main__":
    main()