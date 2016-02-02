/* **************************************Question******************************************
 * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
 * 
 * For example:
 * Given n = 13,
 * Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.
 * 
 * Hint:
 * Beware of overflow.
 * ****************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-02-02
 * */
public class Solution {
    
    private int myPow(int m, int k){
        int ret = 1;
        while(k > 0){
            ret *= m;
            k --;
        }
        return ret;
    }
    
    public int countDigitOne(int n) {
        if(n <= 0){
            return 0;
        }else if(n < 10){
            return 1;
        }
        // parse n into n = a * (10^t) + b, where 0 < a < 10, t is as large as possible
        // example 326 = 3 * (10^2) + 26; 54321 = 5 * (10^4) + 4321
        int t = 0;
        int a, b;
        int temp = 1;
        while(n / temp >= 10){
            temp *= 10; t++;
        }
        
        temp = myPow(10, t);
        a = n / temp;
        b = n - a * temp;
        
        int result = 0;
        result += a * (t * myPow(10, t - 1));
        result += countDigitOne(b);
        result += ((a == 1)?(b+1):(temp));
        
        return result;
    }
}
