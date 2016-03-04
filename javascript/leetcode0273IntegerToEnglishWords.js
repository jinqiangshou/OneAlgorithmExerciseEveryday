/*************************************Question****************************************
 * Convert a non-negative integer to its english words representation. 
 * Given input is guaranteed to be less than 2^31 - 1.
 * 
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * Hint:
 * Did you see a pattern in dividing the number into chunk of words? 
 * For example, 123 and 123000.
 * Group the number by thousands (3 digits). You can write a helper function 
 * that takes a number less than 1000 and convert just that chunk to words.
 * There are many edge cases. What are some good test cases? 
 * Does your code work with input such as 0? Or 1000010? (middle chunk is zero and should not be printed out)
 *************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-04
 * @param {type} num FROM 0 TO 99
 * @returns {String}
 */
var below100 = function(num){
    var ones = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine'];
    var tens = ['Ten', 'Twenty', 'Thirty', 'Forty', 'Fifty', 'Sixty', 'Seventy', 'Eighty', 'Ninety'];
    var dozens = ['Ten', 'Eleven', 'Twelve', 'Thirteen', 'Fourteen', 'Fifteen', 'Sixteen', 'Seventeen', 'Eighteen', 'Nineteen'];
    if(num === 0){
        return "";
    }else if(num > 0 && num < 10){
        return ones[num - 1];
    }else if(num >= 10 && num < 20){
        return dozens[num-10];
    }else{ // num>=20 && num < 100
        if(num % 10 === 0){
            return tens[Math.floor(num / 10) - 1];
        }else{
            return tens[Math.floor(num / 10) - 1] + " " + ones[(num % 10) - 1];
        }
    }
};

/**
 * @author Horst Xu
 * @date 2016-03-04
 * @param {type} num FROM 0 TO 999
 * @returns {String|result}
 */
var below1000 = function(num){
    var ones = ['One', 'Two', 'Three', 'Four', 'Five', 'Six', 'Seven', 'Eight', 'Nine'];
    if(num >= 0 && num < 100){
        return below100(num);
    }else{
        var result =  ones[Math.floor(num / 100) - 1] + " Hundred " + below100(num % 100);
        return result.trim();
    }
};

/**
 * @author Horst Xu
 * @date 2016-03-04
 * @param {number} num
 * @return {string}
 */
var numberToWords = function(num) {
    var billion = Math.floor(num / 1000000000);
    var million = Math.floor((num / 1000000)) % 1000;
    var thousand = Math.floor((num / 1000)) % 1000;
    var one = num % 1000;
    if(num === 0){
        result = 'Zero';
        return result;
    }
    var read_billion = below1000(billion);
    var read_million = below1000(million);
    var read_thousand = below1000(thousand);
    var read_one = below1000(one);
    var result = "";
    if(read_billion !== ""){
        result += (read_billion + " Billion ");
    }
    if(read_million !== ""){
        result += (read_million + " Million ");
    }
    if(read_thousand !== ""){
        result += (read_thousand + " Thousand ");
    }
    if(read_one !== ""){
        result += (read_one);
    }
    return result.trim();
};
