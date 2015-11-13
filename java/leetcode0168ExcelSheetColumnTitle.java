/* *********************************Question****************************************
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * 
 * For example:
 * 
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB 
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-11-13
 * */
public class Solution {
    public String convertToTitle(int n) {
        String str = "";
        while(n>0){
            int t = (n%26>0)?(n%26):26;
            str = ((char)(t+64))+(str);
            n = (n-1)/26;
        }
        return str;
    }
}
