import { createInterface } from 'readline';

const rl = createInterface({
    input: process.stdin,
    output: process.stdout
});

function isPrime(num){
    if (num<=1) return false;
    if (num<=3) return true;

    if(num % 2 === 0 || num % 3 === 0) return false;

    for (let i=5; i * i <=num; i += 6){
        if(num % i === 0 || num % (i + 2) === 0){
            return false;
        }
    }
    return true;
}

rl.requestion('Digite um número: ', (input) => {
    const number = parseInt(input);

    if (isPrime(number)){
        console.log("1 - O número é primo");
    }
    else{
        console.log("2 - o número não é primo");

    }

    rl.close();
});