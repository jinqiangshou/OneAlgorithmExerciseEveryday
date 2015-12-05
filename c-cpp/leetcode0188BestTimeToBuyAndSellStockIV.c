/**********************************Question**************************************
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most k transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-05
 **/
int maxProfit(int k, int* prices, int pricesSize) {
    int result = 0;
    if (pricesSize<2) return result;
    if (k > pricesSize){
        for (int i=1; i<pricesSize; ++i){
            result += ((prices[i] > prices[i-1])?(prices[i]-prices[i-1]):0);
        }
        return result;
    }
    int *buy = (int *)malloc(sizeof(int)*(k+1));
    int *sell = (int *)malloc(sizeof(int)*(k+1));
    for (int i=0;i<=k;++i){
        buy[i] = INT_MIN;
        sell[i] = 0;
    }
    for (int i=0; i<pricesSize; i++){
        for(int j=k; j>0; j--){
            sell[j] = sell[j]>(buy[j] + prices[i])?(sell[j]):(buy[j] + prices[i]);
            buy[j] = buy[j]>(sell[j-1] - prices[i])?(buy[j]):(sell[j-1]-prices[i]);
        }
    }
    result = sell[k];
    free(buy);
    free(sell);
    return result;
}
