/*******************************Question*******************************
 * Implement pow(x, n).
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-19
 **/
class Solution {
public:
    double myPow(double x, int n) {
        if (0==n) return 1.0;
        if (1==n) return x;

        int k = abs(n);
        int remainder = k % 2;
         
        double result = 1;
         
        result = myPow(x, k/2);
        result = result*result*(1==remainder?x:1);
         
        if (n>0)
            return result;
        else
            return 1.0/result; 
    }
};
