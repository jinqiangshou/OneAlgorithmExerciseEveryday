/****************************Question***************************
 * Given an array with n objects colored red, white or blue, 
 * sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.
 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
 * 
 * Note:
 * You are not suppose to use the library's sort function for this problem.
 * 
 * Follow up:
 * A rather straight forward solution is a two-pass algorithm using counting sort.
 * First, iterate the array counting number of 0's, 1's, and 2's, 
 * then overwrite array with total number of 0's, then 1's and followed by 2's.
 * Could you come up with an one-pass algorithm using only constant space?
 ***************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-14
 **/
class Solution {
public:
    void swap(int &a, int &b){
        int temp = a;
        a = b;
        b = temp;
    }
    
    void sortColors(vector<int>& nums) {
        int n = nums.size();
        if(n<2) return;
        
        int first = 0;
        int last = n-1;
        while(first<n && 0==nums[first])
            first++;
        while(last>=0 && 2==nums[last])
            last--;
            
        int i=first;
        while(first < last && i<=last){
            if (2==nums[i]){
                swap(nums[i],nums[last]);
                last--;
                while(last>=0 && 2==nums[last])
                    last--;
            }else if(0==nums[i]){
                swap(nums[i],nums[first]);
                first++;
                if(i<first) i=first;
                while(first<n && 0==nums[first])
                    first++;
            }else{
                i++;
            }
        }
    }
};
