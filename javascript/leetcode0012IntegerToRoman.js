/************************Question**************************
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 **********************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-10
 * @param t: a digit between 0 and 9
 *        ch1, ch2, ch3: 3 single roman letters representing sequential numbers
 * @returns roman number (string type) representing digit t.
 * @example range(9, 'I', 'V', 'X') returns "IX"
 **/
var range = function(t, ch1, ch2, ch3){
    var num = parseInt(t);
    var ret = "";
    if(num>9 || num <0){
        return null;
    }
    
    if(num<=3){
        while(num > 0){
            ret += ch1;
            num --;
        }
    }else if(num === 4){
        ret += (ch1+ch2);
    }else if(num <= 8){
        ret += ch2;
        num -= 5;
        while(num>0){
            ret += ch1;
            num --;
        }
    }else if(num === 9){
        ret += (ch1+ch3);
    }
    return ret;
};

/**
 * @author Horst Xu
 * @date 2015-04-10
 * @param {number} num
 * @returns {string}
 */
var intToRoman = function(num) {
    var result = "";
    while(num>=1000){
        result+= "M";
        num -= 1000;
    }
    var hundred = Math.floor(num/100);
    result += range(hundred, 'C', 'D', 'M');
    
    num = num % 100;
    var ten = Math.floor(num / 10);
    result += range(ten, 'X', 'L', 'C');
    
    num = num % 10;
    var one = Math.floor(num);
    result += range(one, 'I', 'V', 'X');
    
    return result;
};
