/* ***********************************Question**************************************
 * Given a string S, you are allowed to convert it to a palindrome by 
 * adding characters in front of it. Find and return the shortest palindrome 
 * you can find by performing this transformation.
 * 
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2016-01-04
 * */
public class Solution {
    public String shortestPalindrome(String s) {
        int slen = s.length();
    
        char[] temp = new char[slen];
        for (int i = 0; i < temp.length; i++){
            temp[i] = s.charAt(temp.length - 1 - i);
        }
        String reverse =  new String(temp);
        String rec = s + " " + reverse;
        
        int[] pi = new int[rec.length()];
        pi[0] = -1;
        for (int i = 1; i < pi.length; i++){
            int pos = pi[i-1];
            while (pos != -1 && rec.charAt(pos + 1) != rec.charAt(i)) {
                pos = pi[pos];
            }
            if (pos == -1){
                if (rec.charAt(0) == rec.charAt(i)){
                    pi[i]=0;
                }else{
                    pi[i] = -1;
                }
            }
            else if (rec.charAt(pos + 1) == rec.charAt(i)){
                pi[i] = pos + 1;
            }
        }
        
        int palinIndex=Math.min(pi[pi.length - 1], slen - 1);
        
        char result[] = new char[2 * slen - palinIndex - 1];
        
        for(int i = 0; i < slen - palinIndex - 1; i++){
            result[i] = s.charAt(slen - 1 - i);
        }
        for(int i = 0; i < slen; i++){
            result[slen - 1 - palinIndex + i] = s.charAt(i);
        }
        return new String(result);
    }
}
