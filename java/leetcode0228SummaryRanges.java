/* ***************************************Question*******************************************
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * ******************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-26
 * */
public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new LinkedList<String>();
        
        if(nums.length == 0){
            return result;
        }else if(nums.length == 1){
            String s = nums[0]+"";
            result.add(s);
            return result;
        }
        int a = nums[0];
        int b = nums[0];
        int i=1;
        for(; i<nums.length;i++){
            if(nums[i] == b+1){
                b = nums[i];
            }else{
                if(b>a){
                    String temp = a + "->" + b;
                    result.add(temp);
                    a = nums[i];
                    b = nums[i];
                }else{
                    String temp = a + "";
                    result.add(temp);
                    a = nums[i];
                    b = nums[i];
                }
            }
        }
        if(b>a){
            String temp = a + "->" + b;
            result.add(temp);
            a = nums[i-1];
            b = nums[i-1];
        }else{
            String temp = a + "";
            result.add(temp);
            a = nums[i-1];
            b = nums[i-1];
        }
        return result;
    }
}
