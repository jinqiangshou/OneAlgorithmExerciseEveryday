/****************************************Question*******************************************
 * Write a function that takes a string as input and returns the string reversed.
 * 
 * Example:
 * Given s = "hello", return "olleh".
 *******************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-06-27
 * @param {string} s
 * @return {string}
 **/
var reverseString = function(s) {
    var result = '';
    for(var i = s.length-1; i >= 0; i--) {
        result += s.charAt(i);
    }
    return result;
};
