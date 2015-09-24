/* *********************************Question************************************
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 * 
 *   [
 *     ["aa","b"],
 *     ["a","a","b"]
 *   ]
 * *****************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-24
 * */
public class Solution {
    private boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0; i < len - 1 - i; i++){
            if(s.charAt(i) != s.charAt(len - 1 - i)){
                return false;
            }
        }
        return true;
    }
    
    private void myPartition(String s, List<List<String>> result, List<String> element, int startpos){
        int len = s.length();
        if(startpos >= len){
            result.add(new LinkedList<String>(element));
            return;
        }
        
        for(int i = 1; i <= len - startpos; i++){
            if (isPalindrome(s.substring(startpos, startpos + i))){
                element.add(s.substring(startpos, startpos + i));
                myPartition(s, result, element, startpos + i);
                element.remove(element.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String> > result = new LinkedList<List<String> >();
        List<String> element = new LinkedList<String>();
        myPartition(s, result, element, 0);
        return result;
    }
}
