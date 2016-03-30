/****************************************Question***********************************************
 * Additive number is a string whose digits can form additive sequence.
 * A valid additive sequence should contain at least three numbers. 
 * Except for the first two numbers, each subsequent number in the sequence must be the sum of the preceding two.
 * 
 * For example:
 * "112358" is an additive number because the digits can form an additive sequence: 1, 1, 2, 3, 5, 8.
 * 
 * 1 + 1 = 2, 1 + 2 = 3, 2 + 3 = 5, 3 + 5 = 8
 * "199100199" is also an additive number, the additive sequence is: 1, 99, 100, 199.
 * 1 + 99 = 100, 99 + 100 = 199
 * Note: Numbers in the additive sequence cannot have leading zeros, so sequence 1, 2, 03 or 1, 02, 3 is invalid.
 * 
 * Given a string containing only digits '0'-'9', write a function to determine if it's an additive number.
 * 
 * Follow up:
 * How would you handle overflow for very large input integers?
 ***********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-30
 * @param {string} num
 * @return {boolean}
 **/
var isAdditiveNumber = function(num) {
    if(num.length < 3){
       return false;
    }
    for(var i = 1; i <= Math.ceil(num.length / 2); i++){
        for(var k = i; k < num.length; k++){
            var prev = num.substring(0, i);
            var curr = num.substring(i, k+1);
            var t = k;
            while(true){
                var sum = addString(prev, curr);
                var len = sum.length;
                prev = curr;
                curr = num.substring(t+1, t+1+len);
                
                if(t + 1 + len > num.length || sum !== curr){
                    break;   
                }
                if(t + 1 + len === num.length){
                    return true;
                }
                t += len;
            }
        }
    }
    return false;
};

var addString = function(num1, num2) {
    if(num1.charCodeAt(0) === 48 && num1.length !== 1){
        return "N";
    }
    if(num2.charCodeAt(0) === 48 && num2.length !== 1){
        return "N";
    }
    var arr1 = num1.split("").reverse();
    var arr2 = num2.split("").reverse();
    while(arr1.length < arr2.length){
        arr1.push('0');
    }
    while(arr2.length < arr1.length){
        arr2.push('0');
    }
    var jw = 0;
    var result = [];
    for(var i = 0; i < arr1.length; i++){
        var sum = jw + arr1[i].charCodeAt(0) - 48 + arr2[i].charCodeAt(0) - 48; // '0' 's char code is 48
        if(sum >= 10){
            sum -= 10;
            jw = 1;
        }else{
            jw = 0;
        }
        result.push(String.fromCharCode(48+sum));
    }
    if(jw === 1){
        result.push('1');
    }
    var ret = result.reverse().join("");
    return ret;
};
