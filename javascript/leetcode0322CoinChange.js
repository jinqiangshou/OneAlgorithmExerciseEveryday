/****************************************Question*******************************************
 * You are given coins of different denominations and a total amount of money amount. 
 * Write a function to compute the fewest number of coins that you need to make up that amount. 
 * If that amount of money cannot be made up by any combination of the coins, return -1.
 * 
 * Example 1:
 * coins = [1, 2, 5], amount = 11
 * return 3 (11 = 5 + 5 + 1)
 * 
 * Example 2:
 * coins = [2], amount = 3
 * return -1.
 * 
 * Note:
 * You may assume that you have an infinite number of each kind of coin.
 *******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-18
 * @param {number[]} coins
 * @param {number} amount
 * @return {number}
 **/
var coinChange = function(coins, amount) {
    if(amount === 0) {
        return 0;
    }
    var arr = [];
    var maxVal = amount + 1;
    while(arr.length < amount){
        arr.push(maxVal);
        var len = arr.length;
        var v = maxVal;
        for(var i = 0; i < coins.length; i++) {
            if(len - coins[i] < 0) {
                continue;
            } else if(len - coins[i] === 0) {
                v = 1;
                break;
            } else {
                if(arr[len - coins[i] - 1] !== maxVal){
                    v = Math.min(v, arr[len - coins[i] - 1] + 1);
                }
            }
        }
        arr[arr.length - 1] = v;
    }
    return arr[arr.length - 1] === maxVal ? (-1) : arr[arr.length - 1];
};
