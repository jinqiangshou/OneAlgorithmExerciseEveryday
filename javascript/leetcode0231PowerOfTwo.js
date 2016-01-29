/*************************************Question*****************************************
 * Given an integer, write a function to determine if it is a power of two.
 **************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-01-29
 * @param {number} n
 * @return {boolean}
 **/
var isPowerOfTwo = function(n) {
    if(n <= 0) {
        return false;
    }
    while(n>1){
        if(n & 0x1 !== 0){
            return false;
        }
        n = (n >> 1);
    }
    return (n===1);
};
