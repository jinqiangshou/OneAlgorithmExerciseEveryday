/* ************************************Question***************************************
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * 
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * ***********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-25
 * */
public class Solution {
    private class Pair {
        int sign;
        int value;
        Pair(int a, int b){sign=a; value=b;}
    }
    
    public int calculate(String s) {
        Queue<Pair> st = new LinkedList<Pair>();
        StringBuilder sb = new StringBuilder(s);
        sb.append('+');
        int len = sb.length();
        int number1 = 0;
        int number2 = 1;
        boolean isMultiply = true;
        
        for(int i=0;i<len;i++){
            switch(sb.charAt(i)){
                case '+':
                    number2 = isMultiply?(number1 * number2):(number2 / number1);
                    st.offer(new Pair(1, number2));
                    number1 = 0;
                    number2 = 1;
                    isMultiply = true;
                    break;
                case '-':
                    number2 = isMultiply?(number1 * number2):(number2 / number1);
                    st.offer(new Pair(-1, number2));
                    number1 = 0;
                    number2 = 1;
                    isMultiply = true;
                    break;
                case ' ':
                    break;
                case '*':
                    number2 = isMultiply?(number1 * number2):(number2 / number1);
                    number1 = 0;
                    isMultiply = true;
                    break;
                case '/':
                    number2 = isMultiply?(number1 * number2):(number2 / number1);
                    number1 = 0;
                    isMultiply = false;
                    break;
                default:
                    int n = sb.charAt(i)-'0';
                    number1 = 10*number1 + n;
                    break;
            }
        }
        int currSign = 1;
        int result = 0;
        while(!st.isEmpty()){
            Pair p = st.poll();
            result += currSign*p.value;
            currSign = p.sign;
        }
        return result;
    }
}
