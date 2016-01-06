/* **************************************Question***************************************
 * Find all possible combinations of k numbers that add up to a number n, 
 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 * 
 * Ensure that numbers within the set are sorted in ascending order.
 * 
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 * 
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * *************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-06
 * */
public class Solution {
    public void helper(List<List<Integer>> result, List<Integer> elem, int k, int n, int sum, int min){
        if(elem.size() == k){
            if(n == sum){
                List<Integer> tobeadded = new  LinkedList<>(); 
                for(int t : elem){
                    tobeadded.add(t);
                }
                result.add(tobeadded);
            }
            return;
        }
        if(elem.size() < k && sum + min > n){
            return;
        }
        for(int i = min; i <= n - sum; i++){
            if(i >= 10){
                break;
            }
            if(sum + i <= n){
                elem.add(i);
                helper(result, elem, k, n, sum + i, i + 1);
                elem.remove(elem.size()-1);
            }else{
                break;
            }
        }
    }
    
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer> > result = new LinkedList<>();
        List<Integer> list = new LinkedList<>();
        helper(result, list, k, n, 0, 1);
        return result;
    }
}
