/****************************************Question******************************************
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, 
 * return the bitwise AND of all numbers in this range, inclusive.
 * 
 * For example, given the range [5, 7], you should return 4.
 ******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-12
 **/
class Solution {
public:
    int rangeBitwiseAnd(int m, int n) {
        int result = 0;
        if(m == n){
            return m;
        }
        
        int twoTo30 = (1<<30);
        while(true){
            if(m == 0 || n == 0){
                break;
            }
            if(m == 1 && n == 1){
                result += 1;
                break;
            }else if(m == 1 && n > 1){
                break;
            }
            if(m>=twoTo30){
                result += twoTo30;
                m -= twoTo30;
                n -= twoTo30;
                continue;
            }else if(m<twoTo30 && n>= twoTo30){
                break;
            }
            int order = 0;
            while(order<31){
                if( (1 << order) > m){
                    break;
                }
                order++;
            }
            
            if((1 << order)<=n){
                break;
            }else if((1 <<order) > n){
                result += (1 << (order-1));
                m -= (1 << (order-1));
                n -= (1 << (order-1));
            }
        }
        return result;
    }
};
