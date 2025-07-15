// maximo_array.cpp
// Este programa calcula el máximo de un array de números en C++

#include <iostream>
using namespace std;

// Función que recibe un array y su tamaño, y retorna el máximo
int maximoArray(int arr[], int n) {
    int max = arr[0];
    for (int i = 1; i < n; i++) {
        if (arr[i] > max) {
            max = arr[i];
        }
    }
    return max;
}

int main() {
    int numeros[] = {3, 7, 2, 9, 4};
    int n = sizeof(numeros) / sizeof(numeros[0]);
    cout << "El máximo es: " << maximoArray(numeros, n) << endl;
    return 0;
} 