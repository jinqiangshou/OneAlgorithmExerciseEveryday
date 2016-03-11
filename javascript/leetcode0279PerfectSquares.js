/************************************************Question**************************************************
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 * For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9.
 **********************************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-11
 * @param {number} n
 * @return {number}
 */
var numSquares = function(n) {
    if( n < 2 ){
        return n;
    }
    var arr = [0, 1];
    var temp = 1;
    var value = n;
    for(var i = 2; i <= n; i++){
        value = n;
        for(temp = 1; temp * temp <= i; temp ++){
            value = Math.min(value, 1+arr[i-temp*temp]);
        }
        arr.push(value);
    }
    return arr.pop();
};
