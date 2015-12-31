/* ***********************************Question*************************************
 * Note: This is an extension of House Robber.
 * After robbing those houses on that street, the thief has found himself a new place for his thievery 
 * so that he will not get too much attention. 
 * This time, all houses at this place are arranged in a circle. 
 * That means the first house is the neighbor of the last one. 
 * Meanwhile, the security system for these houses remain the same as for those in the previous street.
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-31
 * */
public class Solution {
    public int rob(int[] nums) {
        int len = nums.length;
        if(len==0) return 0;
        if(len==1) return nums[0];
        if(len==2) return Math.max(nums[0],nums[1]);
        if(len==3) return Math.max(Math.max(nums[0],nums[1]),nums[2]);
        
        int prev2 = 0;
        int prev1 = 0;
        int curr1 = 0;
        for(int i=1; i<len; i++){
            curr1 = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = curr1;
        }
        
        prev2 = 0;
        prev1 = 0;
        int curr2 = 0;
        for(int i=2; i<len-1; i++){
            curr2 = Math.max(prev2+nums[i], prev1);
            prev2 = prev1;
            prev1 = curr2;
        }
        
        return Math.max(curr1, curr2+nums[0]);
    }
}
