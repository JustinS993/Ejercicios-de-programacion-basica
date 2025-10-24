import math

def es_cuadrado_perfecto(num):
    raiz = int(math.isqrt(num))
    return raiz * raiz == num

def es_fibonacci(N):
    return es_cuadrado_perfecto(5*N*N + 4) or es_cuadrado_perfecto(5*N*N - 4)

if __name__ == "__main__":
    try:
        N = int(input("Introduce un número entero positivo: "))
        if N < 0:
            print("El número debe ser positivo.")
        else:
            if es_fibonacci(N):
                print(f"{N} SÍ es un número de la serie de Fibonacci.")
            else:
                print(f"{N} NO es un número de la serie de Fibonacci.")
    except ValueError:
        print("Por favor, introduce un número entero válido.") 