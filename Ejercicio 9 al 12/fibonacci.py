def fibonacci(x, y, v, n):
    """
    Genera un vector de Fibonacci de longitud n, comenzando con x e y.
    Imprime el vector resultante.
    """
    v.clear()
    v.append(x)
    v.append(y)
    for i in range(2, n):
        v.append(v[i-1] + v[i-2])
    print("Serie de Fibonacci:", v)

if __name__ == "__main__":
    try:
        n = int(input("¿Cuántos elementos de Fibonacci quieres mostrar? (mínimo 2): "))
        if n < 2:
            print("El número de elementos debe ser al menos 2.")
        else:
            x = int(input("Introduce el primer número: "))
            y = int(input("Introduce el segundo número: "))
            v = []
            fibonacci(x, y, v, n)
    except ValueError:
        print("Por favor, introduce valores enteros válidos.") 