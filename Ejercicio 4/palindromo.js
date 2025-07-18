function esPalindromo(palabra) {
    // Convertir a minúsculas y eliminar espacios
    palabra = palabra.toLowerCase().replace(/\s/g, '');
    // Convertir la palabra en un array, invertirlo y unirlo de nuevo
    const palabraInvertida = palabra.split('').reverse().join('');
    return palabra === palabraInvertida;
}

// Función principal
function main() {
    // Solicitar entrada al usuario
    const palabra = prompt("Introduce una palabra para verificar si es un palíndromo:");
    
    // Verificar si es palíndromo
    if (esPalindromo(palabra)) {
        console.log(`"${palabra}" es un palíndromo!`);
    } else {
        console.log(`"${palabra}" no es un palíndromo.`);
    }
}

// Ejecutar la función principal
main();