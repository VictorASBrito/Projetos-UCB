function printMatriz (matriz) {
    for (let i = 0; i < matriz.length; i++) {
        console.log(matriz[i].join(' '));
    }
}

function transposeMatriz(matriz) {
    const row = matriz.length;
    const cols = matriz[0].length;
    const transposed = [];

    for (let i = 0; i < cols; i++) {
        transposed.push([]);
        for (let j = 0; j < row; j++) {
            transposed[i].push(matriz[j][i]);
        }
        
    }
    return transposed;
}

const matrizA = [
    [1, 2],
    [3, 4],
    [5, 6]
];

const matrizB = [
    [1, 2, 7],
    [3, 4, 8],
    [5, 6, 9]
];
console.log("matriz A: ")
printMatriz(matrizA);


const transposeMatrizA = transposeMatriz(matrizA);
console.log("\nMatriz Transposta de A: ");
printMatriz(transposeMatrizA);

console.log("matriz B: ")
printMatriz(matrizB);

const transposeMatrizB = transposeMatriz(matrizB);
console.log("\nMatriz Transposta de B: ");
printMatriz(transposeMatrizB);

