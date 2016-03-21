/******************************************Question***********************************************
 * Given a pattern and a string str, find if str follows the same pattern.
 * 
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 * 
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters, and str contains lowercase letters separated by a single space.
 *************************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-21
 * @param {string} pattern
 * @param {string} str
 * @return {boolean}
 **/
var wordPattern = function(pattern, str) {
    var obj1 = {};
    var obj2 = {};
    var str_arr = str.split(" ");
    if( pattern.length !== str_arr.length ) {
        return false;
    }
    for( var i = 0; i < pattern.length; i++ ) {
        var str1 = pattern.substring( i, i + 1 );
        if( !obj1.hasOwnProperty(str1) ) {
            obj1[str1] = str_arr[i];
        } else {
            if( obj1[str1] !== str_arr[i] ) {
                return false;
            }
        }
        if( !obj2.hasOwnProperty(str_arr[i]) ) {
            obj2[str_arr[i]] = str1;
        } else {
            if( obj2[str_arr[i]] !== str1 ) {
                return false;
            }
        }
    }
    return true;
};
