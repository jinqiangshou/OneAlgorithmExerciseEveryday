/* *********************************************Question***********************************************
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by 
 * deleting some (can be none) of the characters without disturbing the relative positions 
 * of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * 
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * ****************************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-02
 * */
public class Solution {
    public int numDistinct(String s, String t) {
        int lens = s.length();
        int lent = t.length();
        if(lent == 0){ return 1; }
        if(lens == 0){ return 0; }
        
        List<Integer> list1 = new ArrayList<Integer>();
        List<Integer> list2 = new ArrayList<Integer>();
        for(int i=0; i<lens; i++){
            list1.add(0);
            list2.add(1);
        }
        List<Integer> currList = null;
        List<Integer> prevList = null;
                
        for(int i = 0; i < lent; i++){
            for(int k = 0; k < lens; k++){
                if(i % 2 == 0){
                    currList = list1;
                    prevList = list2;
                }else{
                    currList = list2;
                    prevList = list1;
                }
                if(i > k) {
                    currList.set(k, 0);
                    continue;
                }
                if( k == 0 && i != 0){
                    currList.set(k, 0);
                    continue;
                }else if (k == 0 && i == 0){
                    int value = ((t.charAt(0)==s.charAt(0))?(1):(0));
                    currList.set(k, value);
                    continue;
                }
                if(t.charAt(i) == s.charAt(k)){
                    currList.set(k, currList.get(k-1) + prevList.get(k-1));
                }else{
                    currList.set(k, currList.get(k-1));
                }
            }
        }
        return currList.get(lens-1);
    }
}
