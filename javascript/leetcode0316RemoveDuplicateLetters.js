/*************************************Question**************************************
 * Given a string which contains only lowercase letters, 
 * remove duplicate letters so that every letter appear once and only once. 
 * You must make sure your result is the smallest in lexicographical order among all possible results.
 * 
 * Example:
 * Given "bcabc"
 * Return "abc"
 * 
 * Given "cbacdcbc"
 * Return "acdb"
 ***********************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-04-12
 * @param {string} s
 * @return {string}
 **/
var removeDuplicateLetters = function(s) {
    var i; // loop counter
    var len = s.length;
    var count = [];
    var inRes = [];
    for(i = 0; i < 128; i++) {
        count.push(0);
        inRes.push(false);
    }
    var res = s.split('');
    
    for (i = 0; i < len; i++) {
        res[i] = res[i].charCodeAt(0);
        count[res[i]]++;
    }
    
    var curr, temp;
    var end = -1;
    for (i = 0; i < len; i++) {
        curr = res[i];
        if (inRes[curr]) {  //若该字母已经设置过，则继续
            count[curr]--;
            continue;
        }
        while (end >= 0 && (temp = res[end]) >= curr && count[temp] > 0) {
            end--;
            inRes[temp] = false;
        }
        end++;
        res[end] = curr;
        count[curr]--;
        inRes[curr] = true;
    }
    for(i = 0; i < len; i++){
        res[i] = String.fromCharCode(res[i]);
    }
    return res.join('').substring(0, end + 1);
};
