def calcular_area_volumen_paralelepipedo(largo, ancho, alto):
    # Cálculo del área total (suma de las áreas de todas las caras)
    area = 2 * (largo * ancho + largo * alto + ancho * alto)
    
    # Cálculo del volumen
    volumen = largo * ancho * alto
    
    return area, volumen

def main():
    while True:
        try:
            print('\nIngrese las dimensiones del paralelepípedo:')
            largo = float(input('Largo: '))
            ancho = float(input('Ancho: '))
            alto = float(input('Alto: '))
            
            if largo <= 0 or ancho <= 0 or alto <= 0:
                print('Error: Las dimensiones deben ser números positivos')
                continue
            
            area, volumen = calcular_area_volumen_paralelepipedo(largo, ancho, alto)
            
            print(f'\nResultados:')
            print(f'Área total: {area:.2f} unidades cuadradas')
            print(f'Volumen: {volumen:.2f} unidades cúbicas')
            
            if input('\n¿Desea calcular otro paralelepípedo? (s/n): ').lower() != 's':
                break
                
        except ValueError:
            print('Error: Por favor ingrese números válidos')

if __name__ == '__main__':
    main()