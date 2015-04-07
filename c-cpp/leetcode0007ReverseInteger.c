/**************************Question****************************
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 * 
 * Have you thought about this?
 * Here are some good questions to ask before coding. 
 * Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? 
 * Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows. 
 * How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * Update (2014-11-10):
 * Test cases had been added to test the overflow behavior.
 **************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-04-06
 **/
int reverse(int x)
{
    int isNeg = (x<0)?(1):(0);
    if(x > -10 && x < 10){
        return x;
    }   
    x = abs(x);
    int result = 0;
    int temp;
    while(x>0){
        temp = x % 10; 
        if(result > INT_MAX/10){
            return 0;
        }   
        result = result * 10 + temp;
        x = x / 10; 
    }   
    return isNeg?(-result):(result);
}
