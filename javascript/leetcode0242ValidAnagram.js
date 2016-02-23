/*************************************Question*****************************************
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * 
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * 
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * 
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 **************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-02-23
 * @param {string} s
 * @param {string} t
 * @return {boolean}
 **/
var isAnagram = function(s, t) {
    if(s.length !== t.length){
        return false;
    }
    var arr = new Array(26);
    for(var i = 0; i < 26; i++){
        arr[i] = 0;
    }
    for(var j = 0; j < s.length; j++){
        arr[s.charCodeAt(j) - 97] ++;
        arr[t.charCodeAt(j) - 97] --;
    }
    for(var k = 0; k < 26; k++){
        if(arr[k] !== 0){
            return false;
        }
    }
    return true;
};
