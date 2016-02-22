/* *************************************Question****************************************
 * Given a string of numbers and operators, 
 * return all possible results from computing all the different possible ways to group numbers and operators. 
 * The valid operators are +, - and *.
 * 
 * Example 1
 * Input: "2-1-1".
 * 
 * ((2-1)-1) = 0
 * (2-(1-1)) = 2
 * Output: [0, 2]
 * 
 * Example 2
 * Input: "2*3-4*5"
 * 
 * (2*(3-(4*5))) = -34
 * ((2*3)-(4*5)) = -14
 * ((2*(3-4))*5) = -10
 * (2*((3-4)*5)) = -10
 * (((2*3)-4)*5) = 10
 * Output: [-34, -14, -10, -10, 10]
 * *************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-02-22
 * */
public class Solution {
    private class Pair {
        int num;
        char op;
        Pair(int _num, char _op){
            num = _num;
            op = _op;
        }
    }
    
    public List<Integer> merge(List<Integer> left, List<Integer> right, char op){
        List<Integer> ret = new LinkedList<Integer>();
        for(int i = 0; i < left.size(); i++){
            for(int j = 0; j < right.size(); j++){
                int num = 0;
                switch(op){
                    case '+':
                        num = left.get(i) + right.get(j);
                        break;
                    case '-':
                        num = left.get(i) - right.get(j);
                        break;
                    case '*':
                        num = left.get(i) * right.get(j);
                        break;
                }
                ret.add(num);
            }
        }
        return ret;
    }
    
    public List<Integer> myCompute(List<Pair> l, int start, int end){
        List<Integer> result = new LinkedList<Integer>();
        if(start >= end){
            result.add(l.get(start).num);
            return result;
        }
        
        for(int i = start; i < end; i++){
            List<Integer> left = myCompute(l, start, i);
            List<Integer> right = myCompute(l, i + 1, end);
            result.addAll(merge(left, right, l.get(i).op));
        }
        return result;
    }
    
    public List<Integer> diffWaysToCompute(String input) {
        int len = input.length();
        List<Pair> list = new LinkedList<Pair>();
        int number = 0;
        for(int i = 0; i < len; i++){
            char ch = input.charAt(i);
            switch(ch){
                case '+':
                case '-':
                case '*':
                    list.add(new Pair(number, ch));
                    number = 0;
                    break;
                default: //number
                    number = number*10 + (int)(ch-'0');
            }
        }
        list.add(new Pair(number, '+'));
        List<Integer> result = myCompute(list, 0, list.size()-1);
        
        return result;
    }
}
