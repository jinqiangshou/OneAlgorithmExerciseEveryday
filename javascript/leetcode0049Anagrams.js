/*******************************Question*******************************
 * Given an array of strings, return all groups of strings that are anagrams.
 * Note: All inputs will be in lower-case.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-19
 * @param {string[]} strs
 * @return {string[]}
 */
var anagrams = function(strs) {
    var len = strs.length;
    var strsCopy = new Array(len);
    var i=0;
    for(i=0; i<len;i++){
        strsCopy[i]=strs[i].slice();
    }
    var result = [];
    var hash = {};
    for(i=0;i<len;i++){
        var strArr = strs[i].split("");
        strArr = strArr.sort();
        var newStr = strArr.join();
        if(hash.hasOwnProperty(newStr)){
            hash[newStr].push(i);
            if(hash[newStr].length >2){
                result.push(strsCopy[i]);
            }else{
                result.push(strsCopy[hash[newStr][0]]);
                result.push(strsCopy[i]);
            }
        }else{
            hash[newStr] = [i];
        }
    }
    return result;
};
