/* *************************Question***************************
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). 
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). 
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container.
 * ************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-04-09
 * */
public class Solution {
    public int maxArea(int[] height) {
        if(height == null || height.length <= 1){
            return 0;
        }
        int len = height.length;
        int head=0, tail=len-1;
        int area = 0;
        while(head<tail){
            int temp = Math.abs(head-tail)*Math.min(height[head], height[tail]);
            if(temp>area){
                area = temp;
            }
            if(height[head]<height[tail]){
                head++;
            }else{
                tail--;
            }
        }
        return area;
    }
}
