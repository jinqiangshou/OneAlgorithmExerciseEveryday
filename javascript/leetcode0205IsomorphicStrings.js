/*************************************Question****************************************
 * Given two strings s and t, determine if they are isomorphic.
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 * All occurrences of a character must be replaced with another character 
 * while preserving the order of characters. 
 * No two characters may map to the same character but a character may map to itself.
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-17
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 **/
var isIsomorphic = function(s, t) {
    var hash1 = {};
    var hash2 = {};
    var len1 = s.length;
    var len2 = t.length;
    if(len1 !== len2){
        return false;
    }
    for(var i=0; i<len1; i++){
        var ch1 = s.charAt(i);
        var ch2 = t.charAt(i);
        if(hash1.hasOwnProperty(ch1)){
            if(hash1[ch1] !== ch2){
                return false;
            }
        }else{
            hash1[ch1] = ch2;
        }
        if(hash2.hasOwnProperty(ch2)){
            if(hash2[ch2] !== ch1){
                return false;
            }
        }else{
            hash2[ch2] = ch1;
        }
    }
    return true;
};
