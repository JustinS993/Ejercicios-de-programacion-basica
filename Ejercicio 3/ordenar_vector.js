const readline = require('readline');

/**
 * Ordena un vector de números de menor a mayor
 * @param {number[]} numeros - Array de números a ordenar
 * @returns {number[]} - Array ordenado
 */
function ordenarVector(numeros) {
    return numeros.slice().sort((a, b) => a - b);
}

/**
 * Función principal del programa
 */
async function main() {
    const rl = readline.createInterface({
        input: process.stdin,
        output: process.stdout
    });

    console.log("=== ORDENAR VECTOR DE NÚMEROS ===");
    console.log();

    try {
        // Solicitar al usuario que ingrese los números
        console.log("Ingresa los números separados por espacios (ejemplo: 5 2 8 1 9):");
        
        const entrada = await new Promise((resolve) => {
            rl.question("Números: ", resolve);
        });

        // Convertir la entrada en un array de números
        const numeros = entrada.split(' ').map(x => parseFloat(x)).filter(x => !isNaN(x));

        if (numeros.length === 0) {
            console.log("Error: No se ingresaron números válidos.");
            rl.close();
            return;
        }

        console.log(`\nVector original: [${numeros.join(', ')}]`);

        // Ordenar el vector
        const vectorOrdenado = ordenarVector(numeros);

        console.log(`Vector ordenado: [${vectorOrdenado.join(', ')}]`);

        // Mostrar estadísticas adicionales
        const suma = vectorOrdenado.reduce((acc, num) => acc + num, 0);
        const promedio = suma / vectorOrdenado.length;

        console.log(`\nEstadísticas:`);
        console.log(`- Cantidad de elementos: ${vectorOrdenado.length}`);
        console.log(`- Número más pequeño: ${Math.min(...vectorOrdenado)}`);
        console.log(`- Número más grande: ${Math.max(...vectorOrdenado)}`);
        console.log(`- Promedio: ${promedio.toFixed(2)}`);

    } catch (error) {
        console.log(`Error inesperado: ${error.message}`);
    } finally {
        rl.close();
    }
}

// Ejecutar el programa
if (require.main === module) {
    main();
} 