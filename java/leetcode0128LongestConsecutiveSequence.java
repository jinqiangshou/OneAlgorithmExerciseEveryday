/* ***********************************Question**************************************
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
 * 
 * For example,
 * Given [100, 4, 200, 1, 3, 2],
 * The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
 * 
 * Your algorithm should run in O(n) complexity.
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-21
 * */
public class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> s = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            s.add(nums[i]);
        }
        int longest = 0;
        int result = 1;
        int v, k;
        while(!s.isEmpty()){
            Iterator<Integer> it = s.iterator();
            if(it.hasNext()){
                v = it.next();
                longest = 1;
                s.remove(v);
            }else{
                break;
            }
            k = 1;
            while(s.contains(v + k)){
                s.remove(v + k);
                k++;
            }
            longest += (k - 1);
            k = 1;
            while(s.contains(v - k)){
                s.remove(v - k);
                k++;
            }
            longest += (k - 1);
            result = Math.max(longest, result);
        }
        return result;
    }
}
