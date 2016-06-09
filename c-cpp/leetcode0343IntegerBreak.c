/************************************Question**************************************
 * Given a positive integer n, break it into the sum of at least two positive integers 
 * and maximize the product of those integers. Return the maximum product you can get.
 * 
 * For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).
 * 
 * Note: you may assume that n is not less than 2.
 * 
 * Hint:
 * 1. There is a simple O(n) solution to this problem.
 * 2. You may check the breaking results of n ranging from 7 to 10 to discover the regularities.
 **********************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-06-09
 **/
int integerBreak(int n) {
    if(n == 2 || n == 3) {
        return n - 1;
    }
    if(n == 4) {
        return n;
    }
    int count2 = 0;
    int count3 = 0;
    if(n % 3 == 0) {
        count3 = n / 3;
    }
    if((n-2) % 3 == 0) {
        count2 = 1;
        count3 = (n-2) / 3;
    }
    if((n-4) % 3 == 0) {
        count2 = 2;
        count3 = (n-4) / 3;
    }
    int result = 1;
    while(count2 > 0) {
        result *= 2;
        count2 --;
    }
    while(count3 > 0) {
        result *= 3;
        count3 --;
    }
    return result;
}
