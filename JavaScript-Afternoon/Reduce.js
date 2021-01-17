function reducee(array, func) {

    let sum = 0;
    for( let i=0; i<array.length; i++)
        sum = func(sum, array[i])
    return sum;
}

let array = [1, 1, 2, 3, 5, 8];

var ans = reducee(array, (n, m) => {
    return n+=m
})

console.log(ans);