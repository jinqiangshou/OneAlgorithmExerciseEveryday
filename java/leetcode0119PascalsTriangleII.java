/* *******************************Question*********************************
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * 
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * ************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-09
 * */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<Integer>();
        result.add(1);
        if(rowIndex == 0){
            return result;
        }
        long value = 1;
        for(int i=1;i<=rowIndex;i++){
            value = Math.round((value*1.0/i)*(rowIndex-i+1));
            result.add((int)value);
        }
        return result;
    }
}
