/* *********************************Question*************************************
 * Find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * 
 * For example, given the array [2,3,-2,4],
 * the contiguous subarray [2,3] has the largest product = 6.
 * ******************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-10-31
 * */
public class Solution {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        if(len == 1){
            return nums[0];
        }
        
        int result = nums[0];
        int record = 1;
        int record2 = 1;
        for(int i = 0; i < len; i++){
            if(nums[i] >= 0){
                record = Math.max(nums[i], record * nums[i]);
                record2 = Math.min(nums[i], record2 * nums[i]);
            }else{
                int t = record;
                record = Math.max(nums[i], record2 * nums[i]);
                record2 = Math.min(nums[i], t * nums[i]);
            }
            result = Math.max(result, record);
        }
        return result;
    }
}
