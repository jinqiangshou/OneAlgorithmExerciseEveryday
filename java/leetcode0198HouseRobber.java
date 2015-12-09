/* *************************************Question**************************************
 * You are a professional robber planning to rob houses along a street. 
 * Each house has a certain amount of money stashed, 
 * the only constraint stopping you from robbing each of them is that 
 * adjacent houses have security system connected and it will automatically contact the police 
 * if two adjacent houses were broken into on the same night.
 * 
 * Given a list of non-negative integers representing the amount of money of each house, 
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * ***********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-09
 * */
public class Solution {
    public int rob(int[] num) {
        int len = num.length;
        if(len < 1){
            return 0;
        }else if (len == 1){
            return num[0];
        }else if (len == 2){
            return num[0]>num[1]?num[0]:num[1];
        }
        
        int result = num[0]>num[1]?num[0]:num[1];
        int t1 = num[0];
        int t2 = result;
        for(int i=2; i<len; i++){
            if(t1+num[i]>t2){
                result = t1+num[i];
            }else{
                result = t2;
            }
            t1 = t2;
            t2 = result;
        }
        return result;
    }
}
