/* ***********************Question****************************
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * 0(space) 1(blank) 2(abc) 3(def)
 * 4(ghi) 5(jkl) 6(mno) 7(pqrs) 8(tuv) 9(wxyz)
 * Input:Digit string "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * Note:
 * Although the above answer is in lexicographical order, 
 * your answer could be in any order you want.
 * ***********************************************************/


/* *
 * @author Horst Xu
 * @date 2015-04-14
 * */
public class Solution {
    public List<String> letterCombinations(String digits) {
        String keyboard[] = {" ", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        int len = digits.length();
        List<String> result = new LinkedList<String>();
        
        for(int i=0;i<len;i++){
            int position = (int)(digits.charAt(i)-'0');
            if(i==0){
                String str = keyboard[position];
                for(int k=0; k<str.length();k++){
                    result.add(str.substring(k, k+1));
                }
            }else{
                int resultlen = result.size();
                for(int k=0;k<resultlen; k++){
                    for(int j=0;j<keyboard[position].length();j++){
                        String str = result.get(k);
                        str = str.concat(keyboard[position].substring(j, j+1));
                        result.add(str);
                    }
                }
                for(int k=0;k<resultlen;k++){
                    result.remove(0);
                }
            }
        }
        return result;
    }
}

