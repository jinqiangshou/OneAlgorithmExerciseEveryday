/******************************************Question*********************************************
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * 
 * Note that 1 is typically treated as an ugly number.
 * 
 * Hint:
 * 
 * The naive approach is to call isUgly for every number until you reach the nth one. 
 * Most numbers are not ugly. Try to focus your effort on generating only the ugly ones.
 * An ugly number must be multiplied by either 2, 3, or 5 from a smaller ugly number.
 * The key is how to maintain the order of the ugly numbers. 
 * Try a similar approach of merging from three sorted lists: L1, L2, and L3.
 * Assume you have Uk, the kth ugly number. Then Uk+1 must be Min(L1 * 2, L2 * 3, L3 * 5).
 ***********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-01
 **/
int nthUglyNumber(int n) {
    int* uglyNums = (int*)malloc(n * sizeof(int));

    uglyNums[0] = 1;

    int index2 = 0, index3 = 0, index5 = 0;

    int factor2 = 2, factor3 = 3, factor5 = 5;

    for(int i = 1; i < n; i++)
    {
        int temp = factor2 < factor3 ? factor2 : factor3;
        int min = temp < factor5 ? temp : factor5;

        uglyNums[i] = min;

        if(min == factor2)
        {
            factor2 = 2 * uglyNums[++index2];
        }

        if(min == factor3)
        {
            factor3 = 3 * uglyNums[++index3];
        }

        if(min == factor5)
        {
            factor5 = 5 * uglyNums[++index5];
        }
    }

    int result = uglyNums[n-1];
    free(uglyNums);
    return result;
}
