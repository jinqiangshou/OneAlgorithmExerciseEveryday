/***************************************Question******************************************
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * 
 * For example:
 * 
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28 
 *****************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-11-20
 * @param {string} s
 * @return {number}
 */
var titleToNumber = function(s) {
    var len = s.length;
    var ch;
    var result = 0;
    for(var i=len-1; i>=0; i--){
        ch = s.substr(i, 1);
        result += ((ch.charCodeAt(0) - 65) + 1)*Math.pow(26, len-i-1); // 65 is letter 'A'
    }
    return result;
};
