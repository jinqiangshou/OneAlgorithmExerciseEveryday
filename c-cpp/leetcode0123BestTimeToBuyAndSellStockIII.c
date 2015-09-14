/****************************************Question******************************************
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete at most two transactions.
 * 
 * Note:
 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 ******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-14
 **/
int maxProfit(int* prices, int pricesSize) {
    int *buyBeforeMat = (int *)malloc(sizeof(int)*pricesSize);
    int *buyAfterMat = (int *)malloc(sizeof(int)*pricesSize);
    memset(buyBeforeMat, 0, sizeof(int)*pricesSize);
    memset(buyAfterMat, 0, sizeof(int)*pricesSize);
    
    int tempMin = prices[0];
    int maxBuyBefore = 0;
    for(int i=1; i<pricesSize;i++){
        if(prices[i]<tempMin){
            tempMin = prices[i];
        }else if(prices[i] - tempMin > maxBuyBefore){
            maxBuyBefore = prices[i] - tempMin;
        }
        buyBeforeMat[i] = maxBuyBefore;
    }
    
    int tempMax = prices[pricesSize-1];
    int maxBuyAfter = 0;
    for(int i=pricesSize-2; i>=0;i--){
        if(prices[i]>tempMax){
            tempMax = prices[i];
        }else if(tempMax - prices[i] > maxBuyAfter){
            maxBuyAfter = tempMax - prices[i];
        }
        buyAfterMat[i] = maxBuyAfter;
    }
    
    int result = 0;
    for(int i=0; i<pricesSize; i++){
        if(buyBeforeMat[i]+buyAfterMat[i] > result){
            result = buyBeforeMat[i] + buyAfterMat[i];
        }
    }
    free(buyBeforeMat);
    free(buyAfterMat);
    return result;
}
