from datetime import datetime

def is_leap_year(year):
    return year % 4 == 0 and (year % 100 != 0 or year % 400 == 0)

def validate_date(day, month, year):
    if not (2000 <= year <= 2099):
        return False, 'El año debe estar en el siglo 21 (2000-2099)'
        
    if not (1 <= month <= 12):
        return False, 'El mes debe estar entre 1 y 12'
        
    # Días por mes (considerando año bisiesto)
    days_in_month = [0, 31, 29 if is_leap_year(year) else 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31]
    
    if not (1 <= day <= days_in_month[month]):
        return False, f'Día inválido para el mes {month}'
        
    return True, ''

def get_day_of_week(day, month, year):
    days = ['Lunes', 'Martes', 'Miércoles', 'Jueves', 'Viernes', 'Sábado', 'Domingo']
    date = datetime(year, month, day)
    return days[date.weekday()]

def main():
    while True:
        try:
            print('\nIngrese una fecha del siglo 21:')
            day = int(input('Día: '))
            month = int(input('Mes: '))
            year = int(input('Año: '))
            
            valid, error_msg = validate_date(day, month, year)
            
            if not valid:
                print(f'Error: {error_msg}')
                continue
                
            day_name = get_day_of_week(day, month, year)
            print(f'\nEl {day}/{month}/{year} cae en {day_name}')
            
            if input('\n¿Desea consultar otra fecha? (s/n): ').lower() != 's':
                break
                
        except ValueError:
            print('Error: Por favor ingrese números válidos')

if __name__ == '__main__':
    main()