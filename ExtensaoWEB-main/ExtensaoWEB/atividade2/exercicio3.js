function multiMatrizes(matrizA, matrizB) {
    return matrizA.map((linhaA) =>
      matrizB[0].map((colB, j) =>
        linhaA.reduce((somatorio, resultado1, k) => somatorio + resultado1 * matrizB[k][j], 0)
      )
    );
  }
  
  const matrizA = [
    [1, 3],
    [2, 5]
  ];
  
  const matrizB = [
    [2, 2],
    [0, 1]
  ];
  
  const resultadoMatriz = multiMatrizes(matrizA, matrizB);
  
  console.log("Resultado da multiplicação AxB:");
  resultadoMatriz.forEach(linha => console.log(linha));
  
