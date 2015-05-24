/*******************************Question*********************************
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [−2,1,−3,4,−1,2,1,−5,4],
 * the contiguous subarray [4,−1,2,1] has the largest sum = 6.
 * click to show more practice.
 * 
 * More practice:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, 
 * which is more subtle.
 ************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-22
 */
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int len = nums.size();
        if(0>= len){return 0;}
        
        int b = 0;
        int sum = nums[0];
        for(int i=0; i<len;i++){
            if(b<0){
                b=0;
            }
            b = b+nums[i];
            if(b>sum){
                sum = b;
            }
        }
        return sum;
    }
};
