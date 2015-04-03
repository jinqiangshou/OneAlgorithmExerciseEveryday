/* **********************Question*************************
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. 
 * However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. 
 * How would you handle such case?
 * There is a more generic way of solving this problem.
 * ********************************************************/

/* *
 * @author Horst Xu
 * @date 2015-04-03
 * @desc I supplied two solutions for this problem. 
 *       The second solution is better because Solution1 reversed the integer,
 *       which might overflow. However, both solutions passed online judge.
 * */
public class Solution1 {
    public boolean isPalindrome(int x) {
        int reverse = 0;
        int tempX = x;
        while(tempX>0){
            reverse = 10*reverse + tempX%10;
            tempX = tempX/10;
        }
        if(x == reverse){
            return true;
        }
        return false;
    }
}

/* *
 * @author Horst Xu
 * @date 2015-04-03
 * @desc This is a better solution because it's impossible to overflow.
 * */
public class Solution2 {
    public boolean isPalindrome(int x) {
        if(x < 0){ 
            return false; 
        }else if(x < 10){ 
            return true; 
        }
        
        int tempX = x/10;
        int highorder = 1;
        while(tempX > 0){
            highorder *= 10;
            tempX /= 10;
        }
        
        tempX=x;
        while(highorder > 0){
            if(tempX / highorder != tempX % 10)
            {
                return false;
            }
            tempX %= highorder;
            tempX /= 10;
            highorder /= 100;
        }
        return true;
    }
}
