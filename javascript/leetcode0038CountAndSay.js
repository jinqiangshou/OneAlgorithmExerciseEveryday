/**************************Question**************************
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * 
 * Note: The sequence of integers will be represented as a string.
 ************************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-06
 * @param {number} n
 * @return {string}
 */
var countAndSay = function(n) {
    if( n < 2 ){
        return n.toString();
    }
    var result = "1";
    var newresult = "1";
    var currentchar = '\0';
    var currentcount = 0;
    var ch;
    for(var i=2; i<=n; i++){
        newresult="";
        for(var k=0;k<result.length;k++){
            ch = result.charAt(k);
            if(currentchar === '\0'){
                currentchar = ch;
                currentcount = 1;
            }else{
                if(ch === currentchar){
                    currentcount++;
                }else{
                    newresult += (currentcount.toString()+currentchar);
                    currentchar = ch;
                    currentcount = 1;
                }
            }
        }
        newresult += (currentcount.toString()+currentchar);
        currentchar = '\0';
        currentcount = 0;
        result = newresult;
    }
    return result;
};
