/* ****************************Question******************************
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
 * Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 *
 *  A solution set is:
 *  (-1,  0, 0, 1)
 *  (-2, -1, 1, 2)
 *  (-2,  0, 0, 2)
 * *******************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-04-15
 * */
public class Solution {
    public List<List<Integer>> fourSum(int[] num, int target) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int len = num.length;
        if(len<4){return result;}
        
        Arrays.sort(num);
        for(int i=0;i<len-3;i++){
            if(i>0 && num[i]==num[i-1]){
                continue;
            }
            for(int k=i+1;k<len-2;k++){
                if(k>i+1 && num[k] == num[k-1]){
                    continue;
                }
                int start = k+1;
                int end = len-1;
                while(start<end){
                    while(start>k+1 && start<end && num[start] == num[start-1]){
                        start++;
                    }
                    while(end<len-1 && start<end && num[end] == num[end+1]){
                        end--;
                    }
                    if(start<end && num[start]+num[end]+num[i]+num[k] == target){
                        List<Integer> element = new LinkedList<Integer>();
                        element.add(num[i]);
                        element.add(num[k]);
                        element.add(num[start]);
                        element.add(num[end]);
                        result.add(element);
                        start++;
                        end--;
                    }else if (start<end && num[start]+num[end]+num[i]+num[k] > target){
                        end--;
                    }else if (start<end && num[start]+num[end]+num[i]+num[k] < target){
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
