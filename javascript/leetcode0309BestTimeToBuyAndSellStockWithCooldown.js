/***************************************Question****************************************
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. 
 * You may complete as many transactions as you like 
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 * 
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 * Example:
 * 
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-05
 * @param {number[]} prices
 * @return {number}
 **/
var maxProfit = function(prices) {
    if(prices.length < 2){
        return 0;
    }
    
    var cd_1 = -prices[0]; //cd_1 means I have 1 stock and I cooldown today 
    var cd_0 = 0;
    var se_1 = 0; //se_1 means I have 1 stock and I sell it today
    var by_0 = -prices[0]; //by_0 means I have 0 stock and I buy one today
    for(var i = 0; i < prices.length; i++){
        cd_1 = Math.max(cd_1, by_0);
        by_0 = cd_0 - prices[i];
        cd_0 = Math.max(se_1, cd_0);
        se_1 = cd_1 + prices[i];
    }
    return Math.max(se_1, cd_0);
};
