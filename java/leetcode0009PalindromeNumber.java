public class Solution {
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
