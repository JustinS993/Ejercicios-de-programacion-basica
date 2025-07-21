def validate_number(num_str, base):
    try:
        if base == 'binario':
            return all(d in '01' for d in num_str)
        elif base == 'octal':
            return all(d in '01234567' for d in num_str)
        elif base == 'decimal':
            return num_str.isdigit()
        elif base == 'hexadecimal':
            return all(d in '0123456789ABCDEFabcdef' for d in num_str)
        return False
    except:
        return False

def convert_number(num_str, from_base, to_base):
    # Primero convertimos a decimal
    if from_base == 'binario':
        decimal = int(num_str, 2)
    elif from_base == 'octal':
        decimal = int(num_str, 8)
    elif from_base == 'decimal':
        decimal = int(num_str)
    elif from_base == 'hexadecimal':
        decimal = int(num_str, 16)
    
    # Luego convertimos del decimal a la base deseada
    if to_base == 'binario':
        return bin(decimal)[2:]
    elif to_base == 'octal':
        return oct(decimal)[2:]
    elif to_base == 'decimal':
        return str(decimal)
    elif to_base == 'hexadecimal':
        return hex(decimal)[2:].upper()

def main():
    bases = ['binario', 'octal', 'decimal', 'hexadecimal']
    
    while True:
        num = input('Introduce el número: ')
        from_base = input('Introduce la base actual (binario/octal/decimal/hexadecimal): ').lower()
        
        if from_base not in bases:
            print('Base no válida')
            continue
            
        if not validate_number(num, from_base):
            print('Número no válido para la base especificada')
            continue
            
        to_base = input('Introduce la base a la que quieres convertir (binario/octal/decimal/hexadecimal): ').lower()
        
        if to_base not in bases:
            print('Base no válida')
            continue
            
        result = convert_number(num, from_base, to_base)
        print(f'El número {num} en base {to_base} es: {result}')
        
        if input('¿Deseas convertir otro número? (s/n): ').lower() != 's':
            break

if __name__ == '__main__':
    main()