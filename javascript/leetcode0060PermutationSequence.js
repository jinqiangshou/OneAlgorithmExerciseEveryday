/***************************Question*****************************
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * 
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * 
 *Note: Given n will be between 1 and 9 inclusive.
 ****************************************************************/


/**
 * @author Horst Xu
 * @date 2015-06-18
 * @param {number} n
 * @param {number} k
 * @return {string}
 */
var getPermutation = function(n, k) {
    var str = "";
    for(var i=1; i<=n; i++){
        str += i.toString();
    }
    var result = "";
    var fact = 1;
    var rec = 1;
    var q=0;
    while(rec < n-1){
        rec++;
        fact *= rec;
    }
    while(rec>0){
        q = Math.floor((k-1)/fact);
        k = (k-1) % fact + 1;
        result += str.charAt(q);
        str = str.substr(0,q)+str.substr(q+1, str.length-q-1);
        fact = Math.floor(fact / rec);
        rec--;
    }
    result += str;
    return result;
};
