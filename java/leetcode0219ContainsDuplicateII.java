/* ************************************Question*****************************************
 * Given an array of integers and an integer k, find out 
 * whether there are two distinct indices i and j in the array such that nums[i] = nums[j] 
 * and the difference between i and j is at most k.
 * *************************************************************************************/

/* *
 * @author Horst Xu
 * @date 2016-01-12
 * */
public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for(int i=0; i<nums.length; i++){
            if(hm.containsKey(nums[i])){
                if(i-hm.get(nums[i])<=k){
                    return true;
                }
            }
            hm.put(nums[i], i);
        }
        return false;
    }
}
