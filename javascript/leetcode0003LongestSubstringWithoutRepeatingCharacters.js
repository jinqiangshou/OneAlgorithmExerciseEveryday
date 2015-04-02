/****************************Question**********************************
 * Given a string, find the length of the longest substring without repeating characters. 
 * For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", with the length of 1.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-02
 * @param {string} s
 * @return {number}
 */
var lengthOfLongestSubstring = function(s) {
    if(typeof(s) !== 'string' || s.length === 0){
            return 0;
        } else if(s.length === 1){
            return 1;
        }
        var hash = new Array(256);
        for(var i=0; i<hash.length;i++){
            hash[i] = 0;
        }
        var start = 0;
        var end = 0;
        var len=0;
        while(end<s.length){
            var num=s.charAt(end).charCodeAt();
            hash[num]++;
            if(hash[num] === 1){
                len=(end-start+1>len)?(end-start+1):(len);   
            }else{
                do{
                    hash[s.charAt(start).charCodeAt()]--;
                    start++;
                }while(start<end && hash[num] > 1);                
            }
            end++;           
        }
        return len;
};
