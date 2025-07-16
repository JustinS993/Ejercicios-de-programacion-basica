def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

if __name__ == "__main__":
    num = int(input("Introduce un número para calcular su factorial: "))
    if num < 0:
        print("El factorial no está definido para números negativos.")
    else:
        print(f"El factorial de {num} es {factorial(num)}") 