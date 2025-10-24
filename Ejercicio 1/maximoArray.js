// maximoArray.js
// Este script calcula el máximo de un array de números en JavaScript

// Definimos una función que recibe un array y retorna el máximo
function maximoArray(arr) {
    // Usamos el método Math.max junto con el spread operator
    return Math.max(...arr);
}

// Ejemplo de uso
const numeros = [3, 7, 2, 9, 4];
console.log("El máximo es:", maximoArray(numeros)); 