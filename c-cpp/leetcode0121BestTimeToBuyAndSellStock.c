/***************************************Question*****************************************
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction 
 * (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 ****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-11
 **/
int maxProfit(int* prices, int pricesSize) {
    int ret = 0;
    int past = 0;
    for(int i = 1; i < pricesSize; i++)
    {
        ret += prices[i] - prices[i-1];
        if(ret < 0){
            ret = 0;
        }
        if(ret > past){
            past = ret;
        }
    }
    return past;
}
