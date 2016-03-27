/********************************Question************************************
 * Remove the minimum number of invalid parentheses in order 
 * to make the input string valid. Return all possible results.
 * 
 * Note: The input string may contain letters other than the parentheses ( and ).
 * 
 * Examples:
 * "()())()" -> ["()()()", "(())()"]
 * "(a)())()" -> ["(a)()()", "(a())()"]
 * ")(" -> [""]
 ****************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-27
 * @param {string} s
 * @return {string[]}
 **/
var removeInvalidParentheses = function(s) {
    var tempResult = [];
    if(s.length === 0){
        tempResult.push("");
        return tempResult;
    }
    var len = s.length;
    var sArr = s.split("");
    var queue = [];
    queue.push(s);
    while(queue.length > 0){
        var curr = queue.shift();
        if(queue.length > 0 && curr.length < queue[0].length){
            break;
        } 
        var pos = findIllegalPoint(curr, true);
        if(pos >= 0){
            for(var i = 0; i < pos + 1; i++){
                if(curr.charAt(i) === ')'){
                    queue.push(curr.substring(0,i) + curr.substring(i+1));
                }
            }
        }else if(pos < 0){
            pos = findIllegalPoint(curr, false);
            if(pos < 0){
                tempResult.push(curr);
                continue;
            }
            for(var j = pos; j < curr.length; j++){
                if(curr.charAt(j) ==='('){
                    queue.push(curr.substring(0,j)+ curr.substring(j+1));
                }
            }
        }
    }
    var hash = {};
    var finalResult = [];
    for (var k = 0; k < tempResult.length; k++) {
        if (!hash[tempResult[k]]) {
            finalResult.push(tempResult[k]);
            hash[tempResult[k]] = true;
        }
    }
    return finalResult;
};


var findIllegalPoint = function(s, isForward){
    var count = 0;
    if(isForward){
        for(var i = 0; i < s.length; i++){
            if(s[i] === '('){
                count++;
            }else if(s[i] === ')'){
                count--;
            }
            if(count < 0){
                return i;
            }
        }
    }else{
        for(var j = s.length - 1; j >= 0; j--){
            if(s[j] ===')'){
                count++;
            }else if(s[j] === '('){
                count--;
            }
            if(count < 0){
                return j;
            }
        }
    }
    return -1;
};
