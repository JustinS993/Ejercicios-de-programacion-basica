def suma_cuadrados(inf, sup):
    if inf > sup:
        return 0
    return inf * inf + suma_cuadrados(inf + 1, sup)

if __name__ == "__main__":
    try:
        inf = int(input("Introduce el límite inferior: "))
        sup = int(input("Introduce el límite superior: "))
        if inf > sup:
            print("El límite inferior debe ser menor o igual al superior.")
        else:
            print(f"La suma de los cuadrados de {inf} a {sup} es: {suma_cuadrados(inf, sup)}")
    except ValueError:
        print("Por favor, introduce valores enteros válidos.") 