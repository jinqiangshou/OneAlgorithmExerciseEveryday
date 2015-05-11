/* **************************Question***************************
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it is able to trap after raining.
 * For example, 
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * *************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-05-10
 * */
public class Solution {
    
    public int caltrap(int[] height, int start, int end){
        if(end-start < 2){
            return 0;
        }
        int h = (height[start] < height[end])?height[start]:height[end];
        int result = 0;
        for(int i=start+1; i<end; i++){
            result += (h-height[i]); 
        }
        return result;
    }
    
    public int trap(int[] height) {
        int result = 0;
        int start = 0;
        int end = height.length-1;
        if(end < 2){
            return result;
        }
        while(start<end && height[start] <= height[start+1]){
            start ++;
        }
        while(start<end && height[end] <= height[end-1]){
            end --;
        }
        while(start<end){
            if(height[start] >= height[end]){
                 int temp = end - 1;
                 while(temp > start && height[temp]<height[end]){
                     temp --;
                 }
                 result += caltrap(height, temp, end);
                 end = temp;
            } else {
                int temp = start +1;
                while(temp < end && height[temp] < height[start]){
                    temp ++;
                }
                result += caltrap(height, start, temp);
                start = temp;
            }
        }
        return result;
    }
}
