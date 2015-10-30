/**************************************Question*****************************************
 * Given an input string, reverse the string word by word.
 * 
 * For example,
 * Given s = "the sky is blue",
 * return "blue is sky the".
 * 
 * Clarification:
 * What constitutes a word?
 * A sequence of non-space characters constitutes a word.
 * Could the input string contain leading or trailing spaces?
 * Yes. However, your reversed string should not contain leading or trailing spaces.
 * How about multiple spaces between two words?
 * Reduce them to a single space in the reversed string.
 ***************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-30
 * @param {string} str
 * @returns {string}
 **/
var reverseWords = function(str) {
    var re = /^\s+$/;
    if(re.test(str)){
        return "";
    }

    var temp = str.trim().split(/\s+/);
    var result = "";
    for(var i=temp.length-1; i>=1; i--){
        result += (temp[i]+" ");
    }
    result += temp[0];
    return result;
};
