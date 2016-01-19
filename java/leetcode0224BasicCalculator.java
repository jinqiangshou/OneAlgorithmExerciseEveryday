/* **************************************Question*******************************************
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string may contain open ( and closing parentheses ), 
 * the plus + or minus sign -, non-negative integers and empty spaces .
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "1 + 1" = 2
 * " 2-1 + 2 " = 3
 * "(1+(4+5+2)-3)+(6+8)" = 23
 * Note: Do not use the eval built-in library function.
 * *****************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-19
 * */
public class Solution {
    private class Pair {
        int sign;
        int value;
        Pair(int a, int b){sign=a; value=b;}
    }
    public int calculate(String s) {
        Stack<Pair> st = new Stack<Pair>();
        StringBuilder sb = new StringBuilder(s);
        sb.append('+');
        int len = sb.length();
        int currSum = 0; //record the sum, and finally return it
        int currSign = 1; // 1 represents positive, -1 represents negative
        int number = 0; // record the current number
        for(int i=0;i<len;i++){
            switch(sb.charAt(i)){
                case '(':
                    st.push(new Pair(currSign, currSum));
                    currSign = 1;
                    currSum = 0;
                    break;
                case ')':
                    Pair p = st.pop();
                    currSum += number*currSign;
                    currSum = p.value + p.sign*currSum;
                    currSign = 1;
                    number = 0;
                    break;
                case ' ':
                    break;
                case '+':
                    currSum += number*currSign;
                    number = 0;
                    currSign = 1;
                    break;
                case '-':
                    currSum += number*currSign;
                    number = 0;
                    currSign = -1;
                    break;
                default:
                    int n = sb.charAt(i)-'0';
                    number = 10*number + n;
                    break;
            }
        }
        return currSum;
    }
}
