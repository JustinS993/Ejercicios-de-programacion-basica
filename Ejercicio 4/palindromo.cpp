#include <iostream>
#include <string>
#include <algorithm>
#include <cctype>

using namespace std;

// Función para convertir string a minúsculas y eliminar espacios
string prepararPalabra(string palabra) {
    string resultado;
    // Eliminar espacios y convertir a minúsculas
    for (char c : palabra) {
        if (!isspace(c)) {
            resultado += tolower(c);
        }
    }
    return resultado;
}

bool esPalindromo(string palabra) {
    // Preparar la palabra
    palabra = prepararPalabra(palabra);
    
    // Comparar la palabra con su versión invertida
    string palabraInvertida = palabra;
    reverse(palabraInvertida.begin(), palabraInvertida.end());
    
    return palabra == palabraInvertida;
}

int main() {
    string palabra;
    
    // Solicitar entrada al usuario
    cout << "Introduce una palabra para verificar si es un palíndromo: ";
    getline(cin, palabra);
    
    // Verificar si es palíndromo
    if (esPalindromo(palabra)) {
        cout << '"' << palabra << '"' << " es un palíndromo!" << endl;
    } else {
        cout << '"' << palabra << '"' << " no es un palíndromo." << endl;
    }
    
    return 0;
}