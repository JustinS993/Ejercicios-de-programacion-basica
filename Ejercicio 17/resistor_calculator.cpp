#include <iostream>
#include <string>
#include <map>
#include <algorithm>
#include <stdexcept>
#include <cmath>

class ResistorCalculator {
private:
    std::map<std::string, int> colorValues;
    
public:
    ResistorCalculator() {
        // Inicializar el mapa de colores en español e inglés
        colorValues["negro"] = 0;
        colorValues["black"] = 0;
        colorValues["marrón"] = 1;
        colorValues["brown"] = 1;
        colorValues["rojo"] = 2;
        colorValues["red"] = 2;
        colorValues["naranja"] = 3;
        colorValues["orange"] = 3;
        colorValues["amarillo"] = 4;
        colorValues["yellow"] = 4;
        colorValues["verde"] = 5;
        colorValues["green"] = 5;
        colorValues["azul"] = 6;
        colorValues["blue"] = 6;
        colorValues["violeta"] = 7;
        colorValues["violet"] = 7;
        colorValues["gris"] = 8;
        colorValues["grey"] = 8;
        colorValues["gray"] = 8;
        colorValues["blanco"] = 9;
        colorValues["white"] = 9;
    }
    
    /**
     * Convierte una cadena a minúsculas
     */
    std::string toLowerCase(std::string str) {
        std::transform(str.begin(), str.end(), str.begin(), ::tolower);
        return str;
    }
    
    /**
     * Calcula el valor de una resistencia basado en tres bandas de colores.
     * 
     * @param color1 Primera banda de color
     * @param color2 Segunda banda de color
     * @param color3 Tercera banda de color (multiplicador)
     * @return Valor de la resistencia con unidades apropiadas
     */
    std::string resistorColorTrio(std::string color1, std::string color2, std::string color3) {
        // Convertir a minúsculas para comparación
        color1 = toLowerCase(color1);
        color2 = toLowerCase(color2);
        color3 = toLowerCase(color3);
        
        // Verificar que los colores existan
        if (colorValues.find(color1) == colorValues.end() ||
            colorValues.find(color2) == colorValues.end() ||
            colorValues.find(color3) == colorValues.end()) {
            throw std::invalid_argument("Color no válido");
        }
        
        // Obtener valores de las primeras dos bandas
        int firstDigit = colorValues[color1];
        int secondDigit = colorValues[color2];
        
        // Calcular valor base (primeros dos dígitos)
        int baseValue = firstDigit * 10 + secondDigit;
        
        // Obtener multiplicador (cantidad de ceros)
        int multiplier = colorValues[color3];
        
        // Calcular valor final
        long long resistanceValue = baseValue * static_cast<long long>(std::pow(10, multiplier));
        
        // Determinar unidades apropiadas
        if (resistanceValue >= 1000000) {
            return std::to_string(resistanceValue / 1000000) + " megaohmios";
        } else if (resistanceValue >= 1000) {
            return std::to_string(resistanceValue / 1000) + " kiloohmios";
        } else {
            return std::to_string(resistanceValue) + " ohmios";
        }
    }
};

int main() {
    ResistorCalculator calculator;
    
    std::cout << "Calculadora de Resistencias" << std::endl;
    std::cout << "Colores disponibles: negro, marrón, rojo, naranja, amarillo, verde, azul, violeta, gris, blanco" << std::endl;
    std::cout << std::endl;
    
    // Ejemplos de uso
    std::cout << "Ejemplos:" << std::endl;
    std::cout << "naranja-naranja-negro: " << calculator.resistorColorTrio("naranja", "naranja", "negro") << std::endl;
    std::cout << "naranja-naranja-rojo: " << calculator.resistorColorTrio("naranja", "naranja", "rojo") << std::endl;
    std::cout << "naranja-naranja-naranja: " << calculator.resistorColorTrio("naranja", "naranja", "naranja") << std::endl;
    std::cout << std::endl;
    
    // Entrada del usuario
    try {
        std::string color1, color2, color3;
        
        std::cout << "Ingrese el primer color: ";
        std::getline(std::cin, color1);
        
        std::cout << "Ingrese el segundo color: ";
        std::getline(std::cin, color2);
        
        std::cout << "Ingrese el tercer color: ";
        std::getline(std::cin, color3);
        
        std::string result = calculator.resistorColorTrio(color1, color2, color3);
        std::cout << "\nValor de la resistencia: " << result << std::endl;
        
    } catch (const std::invalid_argument& e) {
        std::cout << "Error: " << e.what() << std::endl;
    } catch (const std::exception& e) {
        std::cout << "Error: " << e.what() << std::endl;
    }
    
    return 0;
}