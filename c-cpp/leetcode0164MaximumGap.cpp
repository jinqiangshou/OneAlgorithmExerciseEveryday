/******************************************Question********************************************
 * Given an unsorted array, find the maximum difference between the successive elements in its sorted form.
 * 
 * Try to solve it in linear time/space.
 * 
 * Return 0 if the array contains less than 2 elements.
 * 
 * You may assume all elements in the array are non-negative integers and fit in the 32-bit signed integer range.
 **********************************************************************************************/
 
 /**
  * @author Horst Xu
  * @date 2015-11-09
  **/
class Solution {
public:
    int maximumGap(vector<int>& nums) {
        int n = nums.size();
        if( n < 2 ) {
            return 0;
        }
        int maxvalue = nums[0];
        int minvalue = nums[0];
        int *bucket1 = new int[n];
        int *bucket2 = new int[n];
        
        for(int i = 0; i < n; i++){
            maxvalue = max(maxvalue, nums[i]);
            minvalue = min(minvalue, nums[i]);
            bucket1[i] = INT_MIN;
            bucket2[i] = INT_MAX;
        }
    
        int range = maxvalue - minvalue;
        if( range <= 1 ) {
            return range;
        }
    
        for(int i = 0; i < n; i++) {
            int index = (int)((double)(nums[i] - minvalue)  / range * (n - 1));
            bucket1[index] = max(bucket1[index], nums[i]);
            bucket2[index] = min(bucket2[index], nums[i]);
        }
    
        int gap = 0;
        int pre = bucket1[0];
        for(int i = 1; i < n; i++) {
            if( bucket1[i] == INT_MIN ){
                continue;
            }
            gap = max(gap, bucket2[i] - pre);
            pre = bucket1[i];
        }
        return gap;
    }
};
