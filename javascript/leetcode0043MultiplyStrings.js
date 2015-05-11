/********************************Question********************************
 * Given two numbers represented as strings, return multiplication of the numbers as a string.
 * Note: The numbers can be arbitrarily large and are non-negative.
 ************************************************************************/
 

/**
 * @author Horst Xu
 * @date 2015-05-11
 * @param {string} num1
 * @param {string} num2
 * @return {string}
 */
var multiply = function(num1, num2) {
    var len1 = num1.length;
    var len2 = num2.length;
    var result = new Array(len1+len2);
    for(var k=0;k<result.length;k++){
        result[k] = 0;
    }
    
    for(var i=len1-1;i>=0;i--){
        for(var j=len2-1; j>=0;j--){
            var pos = len1-i+len2-j-2;
            
            /* Note: 48 is the character '0' in ASCII */
            var prod = (num1.substr(i,1).charCodeAt(0) - 48)*(num2.substr(j,1).charCodeAt(0) - 48);
            result[pos] += prod % 10;
            result[pos+1] += Math.floor(prod / 10);
            while(result[pos] >= 10){
                result[pos+1] += Math.floor(result[pos] / 10);
                result[pos] = result[pos] % 10;
            }
            while(result[pos+1] >= 10){
                if(pos+2 < len1+len2){
                    result[pos+2] += Math.floor(result[pos+1]/10);
                }
                result[pos+1] = result[pos+1] % 10;
            }
        }
    }
    var retString = "";
    for(var t=0;t<result.length;t++){
        retString = result[t]+retString;
    }
    var countZeros = 0;
    for(var d=0; d<retString.length;d++){
        if(retString.charAt(d) === '0'){
            countZeros ++;
        }else{
            break;
        }
    }
    if(countZeros === retString.length){
        retString = "0";
    }else{
        retString = retString.substring(countZeros, retString.length);
    }
    return retString;
};
