/**********************************Question*************************************
 * Given an integer n, return the number of trailing zeroes in n!.
 * 
 * Note: Your solution should be in logarithmic time complexity.
 *******************************************************************************/
 
 
/**
 * @author Horst Xu
 * @date 2015-11-23
 * @param {number} n
 * @return {number}
 */
var trailingZeroes = function(n) {
    var result = 0;
    while(n>=5){
        result += Math.floor(n / 5);
        n = Math.floor(n / 5);
    }
    return result;
};
