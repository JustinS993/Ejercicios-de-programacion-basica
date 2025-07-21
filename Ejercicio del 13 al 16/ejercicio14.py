def number_to_words(n):
    units = ['', 'One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine', 'Ten',
            'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen']
    tens = ['', '', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety']

    def helper(num):
        if num == 0:
            return ''
        elif num < 20:
            return units[num]
        elif num < 100:
            return tens[num // 10] + (' ' + units[num % 10] if num % 10 != 0 else '')
        elif num < 1000:
            return units[num // 100] + ' Hundred' + (' and ' + helper(num % 100) if num % 100 != 0 else '')
        else:
            return helper(num // 1000) + ' Thousand' + (' ' + helper(num % 1000) if num % 1000 != 0 else '')

    if n == 0:
        return 'Zero'
    return helper(n)

def main():
    while True:
        try:
            num = input('Enter a number (up to five digits): ')
            if not num.isdigit() or len(num) > 5:
                print('Please enter a valid number with up to five digits')
                continue
                
            num = int(num)
            result = number_to_words(num)
            print(f'{num} - {result}')
            
            if input('Do you want to convert another number? (y/n): ').lower() != 'y':
                break
                
        except ValueError:
            print('Please enter a valid number')

if __name__ == '__main__':
    main()