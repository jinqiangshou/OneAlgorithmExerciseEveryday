/* **********************************Question***************************************
 * Given an array of integers, find out whether there are two distinct indices i and j in the array 
 * such that the difference between nums[i] and nums[j] is at most t and the difference between i and j is at most k.
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-13
 * */
public class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if(nums.length < 2 || t < 0){
            return false;
        }
        Map<Integer, Integer> mp1 = new HashMap<Integer, Integer>();
        Map<Integer, Integer> mp2 = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int t1 = (nums[i] >= 0)? nums[i]/(t+1):nums[i]/(t+1)-1;
            if(mp1.containsKey(t1) && mp1.get(t1) >= i - k){
                return true;
            }
            mp1.put(t1, i);
            int t2 = (nums[i] >= 0)? (nums[i]+t/2+1)/(t+1):(nums[i]+t/2+1)/(t+1)-1;
            if(mp2.containsKey(t2) && mp2.get(t2) >= i - k){
                return true;
            }
            mp2.put(t2, i);
        }
        return false;
    }
}
