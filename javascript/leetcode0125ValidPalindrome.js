/**************************************Question*************************************
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * 
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * 
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * 
 * For the purpose of this problem, we define empty string as valid palindrome.
 ***********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-16
 * @param {string} s
 * @return {boolean}
 */
var isPalindrome = function(s) {
    var j = s.length - 1;
    var i = 0;
    var re = new RegExp("[0-9A-Za-z]");
    while(i<j){
        var istr = s.substr(i, 1);
        var jstr = s.substr(j, 1);
        var ichar = s.charCodeAt(i);
        var jchar = s.charCodeAt(j);
        while(i < j && !re.test(istr)){
            i++;
            istr = s.substr(i, 1);
            ichar = s.charCodeAt(i);
        }
        while(i < j && !re.test(jstr)){
            j--;
            jstr = s.substr(j, 1);
            jchar = s.charCodeAt(j);
        }
        if(i < j){
            //convert to lower case
            if(ichar >= 65 && ichar <= 90){
                ichar += 32;
            }
            if(jchar >= 65 && jchar <= 90){
                jchar += 32;
            }
            if(ichar !== jchar){
                return false;
            }
            i++;
            j--;
        }
    }
    return true;
};
