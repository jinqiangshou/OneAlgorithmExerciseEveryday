/*********************************Question**************************************
 * Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. 
 * (each operation is counted as 1 step.)
 * You have the following 3 operations permitted on a word:
 * a) Insert a character
 * b) Delete a character
 * c) Replace a character
 *******************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-11
 * @param {string} word1
 * @param {string} word2
 * @return {number}
 */
var minDistance = function(word1, word2) {
    var w1Len = word1.length;
    var w2Len = word2.length;
    if(w1Len === 0 || w2Len === 0){
        return (w1Len+w2Len);
    }
    var arr = [];
    var arrRow = [];
    for(var j=0;j<=w2Len;j++){
        arrRow.push(j);
    }
    while(w1Len>=0){
        arr.push(arrRow.slice());
        w1Len --;
    }
    for(var i=0; i<arr.length;i++){
        arr[i][0] = i;
    }
    for(var k=1; k<arr.length;k++){
        for(var g=1; g<arr[k].length;g++){
            if(word1.charCodeAt(k-1) === word2.charCodeAt(g-1)){
                arr[k][g] = arr[k-1][g-1];
            }else{
                arr[k][g] = Math.min(arr[k-1][g], arr[k][g-1], arr[k-1][g-1])+1;
            }
        }
    }
    return arr[arr.length-1][arr[0].length-1];
};
