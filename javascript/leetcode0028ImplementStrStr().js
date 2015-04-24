/***********************************Question*************************************
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * Update (2014-11-02):
 * The signature of the function had been updated to return the index instead of the pointer. 
 * If you still see your function signature returns a char * or String, 
 * please click the reload button to reset your code definition.
 *********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-24
 * @param {string} haystack
 * @param {string} needle
 * @return {number}
 */
var strStr = function(haystack, needle) {
    var hlen = haystack.length;
    var nlen = needle.length;
    
    for(var i=0;i<hlen-nlen+1;i++){
        var substr = haystack.substr(i, nlen);
        if(substr.valueOf() === needle.valueOf()){
            return i;
        }
    }
    return -1;
};
