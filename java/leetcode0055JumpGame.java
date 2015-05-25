/********************************Question********************************
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 * 
 * For example:
 * A = [2,3,1,1,4], return true.
 * A = [3,2,1,0,4], return false.
 ************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-25
 */
public class Solution {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        if(1 == len) return true;
        if(0 == len) return false;
        
        int position = nums[0]; //longest possible position we get
        
        for(int i=1; i<len;i++){
            if(i > position){
                return false;
            }
            if(i+nums[i] > position){
                position = i+nums[i];
            }
            if(position >= len-1){
                return true;
            }
        }
        return false;
    }
}
