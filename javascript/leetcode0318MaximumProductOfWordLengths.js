/***************************************Question*********************************************
 * Given a string array words, find the maximum value of length(word[i]) * length(word[j]) 
 * where the two words do not share common letters. 
 * You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
 * 
 * Example 1:
 * Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"]
 * Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2:
 * Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"]
 * Return 4
 * The two words can be "ab", "cd".
 * 
 * Example 3:
 * Given ["a", "aa", "aaa", "aaaa"]
 * Return 0
 * No such pair of words.
 *********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-13
 * @param {string[]} words
 * @return {number}
 **/
var maxProduct = function(words) {
    var bitArr = [];
    var numOfa = 'a'.charCodeAt(0);
    for(var i = 0; i < words.length; i++) {
        var res = 0;
        for(var j = 0; j < words[i].length; j++) {
            var ch = words[i].charCodeAt(j) - numOfa;
            res |= (1 << ch);
        }
        bitArr.push(res);
    }
    
    var result = 0;
    for(var k = 0; k < words.length; k++) {
        for(var m = k+1; m < words.length; m++) {
            if((bitArr[k] & bitArr[m]) === 0) {
                result = Math.max(result, words[k].length * words[m].length);
            }
        }
    }
    return result;
};
