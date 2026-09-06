/**
 * @param {Function[]} functions
 * @return {Function}
 */

 // ye functions jo hai vo array input ke form me diya hai humko basically array ke functions ko ulte order me executrte krwana hai
var compose = function(functions) {

    // Hume ek naya function return karna hai Jo input x lekar saare functions ko execute karega
    return function(x) {
        // Current function ko x par apply karenge Aur jo result milega usko next function ke liye x bana denge
        for (let i = functions.length - 1; i >= 0; i--) {
            x = functions[i](x);
        }
        
        return x;
    }
};

/**
 * const fn = compose([x => x + 1, x => 2 * x])
 * fn(4) // 9
 */