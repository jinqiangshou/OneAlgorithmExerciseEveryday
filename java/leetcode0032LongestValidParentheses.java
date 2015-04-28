/*******************************Question*******************************
 * Given a string containing just the characters '(' and ')', 
 * find the length of the longest valid (well-formed) parentheses substring.
 * For "(()", the longest valid parentheses substring is "()", which has length = 2.
 * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-28
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int len = s.length();
        if(len < 2){ return 0;}
        
        int arr[] = new int[len];
        arr[0] = 0;
        for(int i=1; i<arr.length;i++){
            if(s.charAt(i) == '('){
                arr[i] = arr[i-1];
            }else if(s.charAt(i) == ')'){
                int maxlen = 0;
                int recordValue = 1;
                for(int k=i-1; k>=0; k--){
                    switch(s.charAt(k)){
                        case '(':
                            recordValue --;
                            break;
                        case ')':
                            recordValue ++;
                            break;
                    }
                    if(recordValue < 0){
                        break;
                    }else if(recordValue == 0){
                        maxlen = i-k+1;
                    }
                }
                arr[i] = (maxlen>arr[i-1])?(maxlen):(arr[i-1]);
            }else {
                return 0;
            }
        }
        return arr[arr.length-1];
    }
}
