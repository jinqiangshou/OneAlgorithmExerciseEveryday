/*****************************Question********************************
 * Given a string S and a string T, find the minimum window in S which will 
 * contain all the characters in T in complexity O(n).
 * 
 * For example,
 * S = "ADOBECODEBANC"
 * T = "ABC"
 * Minimum window is "BANC".
 * 
 * Note:
 * If there is no such window in S that covers all characters in T, return the emtpy string "".
 * If there are multiple such windows, you are guaranteed that there 
 * will always be only one unique minimum window in S.
 *********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-15
 * @param {string} s
 * @param {string} t
 * @return {string}
 */
var minWindow = function(s, t) {
    var slow = 0;
    var fast = 0;
    var result = "";
    var hash = {};
    
    for(var i=0;i<t.length;i++){
        var pos = t.charAt(i);
        if(hash.hasOwnProperty(pos)){
            hash[pos]++;
        }else{
            hash[pos]=1;
        }
    }
    var slen = s.length;
    
    while(fast<slen){
        var ch = s.charAt(fast);
        if(hash.hasOwnProperty(ch)){
            hash[ch]--;
        }else{
            fast++;
            continue;
        }
        var getAns = true;
        for(var prop in hash){
            if(hash[prop]>0){
                getAns = false;
                break;
            }
        }
        if(getAns){
            if(result.length === 0 || result.length > fast-slow+1){
                result = s.substr(slow, fast-slow+1);
            }
            while(slow<=fast){
                var ch2 = s.charAt(slow);
                slow++;
                if(hash.hasOwnProperty(ch2)){
                    hash[ch2]++;
                    if(hash[ch2]<=0){
                        if(result.length === 0 || result.length > fast-slow+1){
                            result = s.substr(slow, fast-slow+1);
                        }
                    }else{
                        break;
                    }
                }else{
                    if(result.length === 0 || result.length > fast-slow+1){
                        result = s.substr(slow, fast-slow+1);
                    }
                }
            }
        }
        fast++;
    }
    return result; 
};
