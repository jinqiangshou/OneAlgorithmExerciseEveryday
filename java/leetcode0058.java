/* ********************************Question************************************
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', 
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example, 
 * Given s = "Hello World",
 * return 5.
 * ****************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-06-16
 **/
public class Solution {
    public int lengthOfLastWord(String s) {
        int len = s.length();
        if(0==len) return 0;
        
        int last = len;
        int first = 0;
        while(last>0 && s.charAt(last-1)==' '){
            last--;
        }
        while(first<last && s.charAt(first)==' '){
            first++;
        }
        if(0==last) return 0;
        
        int i;
        for(i=last-1;i>=first;i--){
            if(s.charAt(i)==' ')  break;
        }
        return (last-i-1);
    }
}
