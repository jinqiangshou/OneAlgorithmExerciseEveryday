/******************************Question******************************
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 ********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-21
 */
var isValid = function(arr, i, j){
    var len = arr.length;
    for(var t=0; t<len; t++){
        if(arr[t] !== -1 && Math.abs(arr[t]-j) === Math.abs(t-i))
            return false;
        if(arr[t] !== -1 && arr[t] === j)
            return false;
    }
    return true;
};

/**
 * @author Horst Xu
 * @date 2015-05-21
 */
var mysolution = function(n, start, arr, result){
    if(start >= n){
       result.value++;
       return;
    }
    for(var j=0; j<n; j++){   
        if(isValid(arr,start,j)){
            arr[start]= j;
            mysolution(n, start+1, arr, result);
            arr[start] = -1;
        } 
    }
};

/**
 * @author Horst Xu
 * @date 2015-05-21
 * @param {number} n
 * @return {number}
 */
var totalNQueens = function(n) {
    var result = {value: 0};
    if(n === 1){
        return 1;
    }

    var arr = new Array(n);
    var i;
    for(i=0;i<n;i++){
        arr[i] = -1;
    }

    mysolution(n, 0, arr, result);
    return result.value;
};
