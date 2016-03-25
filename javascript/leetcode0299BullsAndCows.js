/**************************************Question***************************************
 * You are playing the following Bulls and Cows game with your friend: 
 * You write down a number and ask your friend to guess what the number is. 
 * Each time your friend makes a guess, you provide a hint that indicates 
 * how many digits in said guess match your secret number exactly in both digit and position 
 * (called "bulls") and how many digits match the secret number 
 * but locate in the wrong position (called "cows"). 
 * Your friend will use successive guesses and hints to eventually derive the secret number.
 * 
 * For example:
 * 
 * Secret number:  "1807"
 * Friend's guess: "7810"
 * Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 * Write a function to return a hint according to the secret number and friend's guess, 
 * use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".
 * 
 * Please note that both secret number and friend's guess may contain duplicate digits, for example:
 * 
 * Secret number:  "1123"
 * Friend's guess: "0111"
 * In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 * You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 **************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-25
 * @param {string} secret
 * @param {string} guess
 * @return {string}
 **/
var getHint = function(secret, guess) {
    var secArr = secret.split("");
    var gueArr = guess.split("");
    var len = gueArr.length;
    var A = 0;
    var B = 0;
    for(var i = 0; i < len; i++){
        if(secArr[i] === gueArr[i]){
            A++;
            secArr[i] = '\0';
            gueArr[i] = '\0';
        }
    }
    var hash = {};
    for(var j = 0; j < len; j++){
        if(secArr[j] === '\0'){
            continue;
        } else {
            var tmp = 'a' + (secArr[j] - '0');
            if(hash.hasOwnProperty(tmp)){
                hash[tmp]++;
            }else{
                hash[tmp] = 1;
            }
        }
    }
    for(var k = 0; k < len; k++){
        if(gueArr[k] === '\0'){
            continue;
        } else {
            var tmp2 = 'a' + (gueArr[k] - '0');
            if(hash.hasOwnProperty(tmp2) && hash[tmp2] > 0){
                hash[tmp2] --;
                B++;
            }
        }
    }
    return (A + "A" + B + "B");
};
