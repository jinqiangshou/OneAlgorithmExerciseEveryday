/***************************Question******************************
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 *****************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-03
 * @param {string} a
 * @param {string} b
 * @return {string}
 */
var addBinary = function(a, b) {
    var alen = a.length-1;
    var blen = b.length-1;
    var result = "";
    var carry = 0;
    var ach, bch;
    while(alen >= 0 && blen >= 0){
        ach = a.substr(alen,1).charCodeAt(0) - 48; // 48 is the letter '0' in ASCII
        bch = b.substr(blen,1).charCodeAt(0) - 48;
        result = (ach+bch+carry)%2 + result;
        carry = Math.floor((ach+bch+carry)/2);
        alen --;
        blen --;
    }
    while(alen >= 0){
        ach = a.substr(alen,1).charCodeAt(0) - 48;
        result = (ach + carry)%2 + result;
        carry = Math.floor((ach+carry)/2);
        alen --;
    }
    while(blen >= 0){
        bch = b.substr(blen,1).charCodeAt(0) - 48;
        result = (bch + carry)%2 + result;
        carry = Math.floor((bch+carry)/2);
        blen --;
    }
    if(carry > 0){
        result = "1"+ result;
    }
    return result;
};
