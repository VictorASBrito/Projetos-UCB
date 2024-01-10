function somar(...numeros) {
    var soma = 0;
    for (let i = 0; i < numeros.length; i++) {
        soma += numeros[i];
        
    }
    return soma;
}

console.log(somar(5, 23, 5, 7, -20));

function contar(n) {
    if (n > 0) {
        contar(n-1);
        console.log(n);
    }
}

contar(2);

const calculadora = {
    somar (a, b){
        return a + b;
    },

    subtrair (a,b){
        return a - b;
    }
}

console.log(calculadora.somar(1,2));

console.log(calculadora.subtrair(1,2));

function enviarEmail() {
    console.log(" EMAIL ENVIADO ");
}

function baixar(arquivo, callback) {
    console.log("Baixando arquivo " + arquivo);
    setTimeout(() => {
        console.log(arquivo + " baixado com sucesso");
        callback();
    }, 3000);
}



baixar("AuladeJS.mp4", enviarEmail);