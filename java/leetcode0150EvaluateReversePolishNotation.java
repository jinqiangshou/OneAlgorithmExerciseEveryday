/* ***************************************Question*********************************************
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 * 
 * Some examples:
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
 *   ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * ********************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-29
 * */
public class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st = new Stack<>();
        int a1, b1;
        for (String token : tokens) {
            switch (token) {
                case "+":
                    a1 = st.pop(); b1 = st.pop();
                    st.add(a1+b1);
                    break;
                case "-":
                    a1 = st.pop(); b1 = st.pop();
                    st.add(b1-a1);
                    break;
                case "*":
                    a1 = st.pop(); b1 = st.pop();
                    st.add(a1*b1);
                    break;
                case "/":
                    a1 = st.pop(); b1 = st.pop();
                    st.add(b1/a1);
                    break;
                default:
                    st.add(Integer.parseInt(token));
                    break;
            }
        }
        int result = st.pop();
        return result;
    }
}
