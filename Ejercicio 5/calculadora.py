def es_numero(valor):
    try:
        float(valor)
        return True
    except ValueError:
        return False

def calcular_resultado(operaciones):
    if len(operaciones) % 2 == 0:
        return None, "Error: Formato incorrecto. Debe haber alternancia entre números y operadores."
    
    try:
        resultado = float(operaciones[0])
        
        for i in range(1, len(operaciones), 2):
            operador = operaciones[i]
            numero = float(operaciones[i + 1])
            
            if operador == '+':
                resultado += numero
            elif operador == '-':
                resultado -= numero
            elif operador == '*':
                resultado *= numero
            elif operador == '/':
                if numero == 0:
                    return None, "Error: División por cero."
                resultado /= numero
            else:
                return None, f"Error: Operador '{operador}' no válido."
                
        return resultado, None
    except ValueError:
        return None, "Error: Formato de número inválido."
    except Exception as e:
        return None, f"Error: {str(e)}"

def main():
    try:
        # Leer el archivo
        with open('Challenge21.txt', 'r') as archivo:
            lineas = [linea.strip() for linea in archivo.readlines()]
        
        # Verificar formato básico
        for i, linea in enumerate(lineas):
            if i % 2 == 0 and not es_numero(linea):
                print("No se han podido resolver las operaciones.")
                print(f"Error: Se esperaba un número en la línea {i + 1}, pero se encontró '{linea}'")
                return
            elif i % 2 == 1 and linea not in ['+', '-', '*', '/']:
                print("No se han podido resolver las operaciones.")
                print(f"Error: Se esperaba un operador en la línea {i + 1}, pero se encontró '{linea}'")
                return
        
        # Calcular resultado
        resultado, error = calcular_resultado(lineas)
        
        if error:
            print("No se han podido resolver las operaciones.")
            print(error)
        else:
            print(f"El resultado es: {resultado}")
            
    except FileNotFoundError:
        print("No se ha encontrado el archivo 'Challenge21.txt'")
    except Exception as e:
        print("No se han podido resolver las operaciones.")
        print(f"Error: {str(e)}")

if __name__ == "__main__":
    main()