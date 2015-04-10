/* ***********************Question*************************
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * ********************************************************/


/* *
 * @author Horst Xu
 * @date 2015-04-10
 * */
public class Solution {
    public int romanTranslation(char c) {
        int ret = 0;
        switch(c){
            case 'I':
                ret = 1; break;
            case 'V':
                ret = 5; break;
            case 'X':
                ret = 10; break;
            case 'L':
                ret = 50; break;
            case 'C':
                ret = 100; break;
            case 'D':
                ret = 500; break;
            case 'M':
                ret = 1000; break;
        }
        return ret;
    }
    
    public int romanToInt(String s) {
        int len = s.length();
        int result = 0;
        int i=0;
        int record;
        while(i<len){
            record = romanTranslation(s.charAt(i));
            while(i != len-1 && s.charAt(i) == s.charAt(i+1)){
                record += romanTranslation(s.charAt(i));
                i++;
            }
            if(i == len-1 || romanTranslation(s.charAt(i))>romanTranslation(s.charAt(i+1))){
                result += record;
            }else{
                result -= record;
            }
            i++;
        }    
        return result;
    }
}
