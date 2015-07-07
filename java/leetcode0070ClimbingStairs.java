/* *******************************Question************************************
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * ***************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-07-07
 * */
public class Solution {
    public int climbStairs(int n) {
        
        int result = 1;
        int temp1 = 0;
        int temp2 = 0;
        for(int i=0; i<n;i++){
            temp1 = temp2;
            temp2 = result;
            result = temp2+temp1;
        }
        return result;
    }
}
