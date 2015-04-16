/* ************************Question*************************
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
 * determine if the input string is valid.
 * The brackets must close in the correct order, 
 * "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 * *********************************************************/


/* *
 * @author Horst Xu
 * @date 2015-04-17
 * */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> mystack = new Stack<Character>();
        int len = s.length();
        for(int i=0;i<len;i++){
            char ch = s.charAt(i);
            if(ch == '{' || ch =='(' || ch =='[') {
                mystack.push(ch);
            }else if(ch =='}' || ch ==')' || ch ==']'){
                if(mystack.size()<1){
                    return false;
                }
                char chr = mystack.pop();
                if((chr == '(' && ch != ')') || (chr == '[' && ch != ']')  || (chr == '{' && ch != '}') ){
                    return false;
                }
            }else {
                return false;
            }
        }
        return (mystack.size() == 0);
    }
}
