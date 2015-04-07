/*************************Question***************************
 * Given a string S, find the longest palindromic substring in S. 
 * You may assume that the maximum length of S is 1000, 
 * and there exists one unique longest palindromic substring.
 ************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-04
 * @param {string} s
 * @returns {string}
 */
var longestPalindrome = function(s) {
    if(s.length === 0){
        return "";
    }else if(s.length === 1){
        return s;
    }
    
    var startPosition = 0;
    var maxLength = 0;
    
    var offset, tempLength;
    for(var i=0; i<s.length;i++){
        offset = 0;
        tempLength = -1;
        while(i-offset>=0 && i+offset <= s.length-1){
            if(s.charAt(i-offset) === s.charAt(i+offset)){
                tempLength += 2;
                offset++;
            }else{
                break;
            }
        }
        if(tempLength > maxLength){
            maxLength = tempLength;
            startPosition = i-offset+1;
        }
        
        offset = 0;
        tempLength = 0;
        while(i-offset >= 0 && i+offset+1 <= s.length-1){
            if(s.charAt(i-offset) === s.charAt(i+offset+1)){
                tempLength += 2;
                offset ++;
            }else{
                break;
            }
        }
        if(tempLength >maxLength){
            maxLength = tempLength;
            startPosition = i-offset+1;
        }
    }
    
    return s.substr(startPosition, maxLength);
};
