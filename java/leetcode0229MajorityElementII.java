/* ***********************************Question**************************************
 * Given an integer array of size n, 
 * find all elements that appear more than ⌊ n/3 ⌋ times.
 * The algorithm should run in linear time and in O(1) space.
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-27
 * */
public class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> lst = new LinkedList<Integer>();
        if(nums.length == 0){
            return lst;
        }else if(nums.length == 1){
            lst.add(nums[0]);
            return lst;
        }
        
        int n1 = nums[0];
        int n2 = nums[1];
        int c1 = 0;
        int c2 = 0;
        for(int i=0; i<nums.length;i++){
            if(c1 == 0){
                n1 = nums[i];
                c1 = 1;
                continue;
            }else if(c2 == 0 && nums[i] != n1){
                n2 = nums[i];
                c2 = 1;
                continue;
            }
            
            if(nums[i] == n1){
                c1++;
            }else if(nums[i] == n2){
                c2++;
            }else{
                c2 = (c1>c2)?(c2-1):(c2);
                c1 = (c1>c2)?(c1):(c1-1);
            }
        }
        c1 = 0; c2 = 0;
        for(int i=0; i<nums.length;i++){
            if(n1 == nums[i]){ c1++;}
            else if(n2 == nums[i]){ c2++;}
        }
        if(c1 > nums.length / 3){
            lst.add(n1);
        }
        if(c2 > nums.length / 3){
            lst.add(n2);
        }
        return lst;
    }
}
