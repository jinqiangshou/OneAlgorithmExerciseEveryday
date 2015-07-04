/***************************Question*******************************
 * Given an array of words and a length L, format the text such that 
 * each line has exactly L characters and is fully (left and right) justified.
 * You should pack your words in a greedy approach; 
 * that is, pack as many words as you can in each line. 
 * Pad extra spaces ' ' when necessary so that each line has exactly L characters.
 * Extra spaces between words should be distributed as evenly as possible. 
 * If the number of spaces on a line do not divide evenly between words, 
 * the empty slots on the left will be assigned more spaces than the slots on the right.
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * For example,
 * words: ["This", "is", "an", "example", "of", "text", "justification."]
 * L: 16.
 * 
 * Return the formatted lines as:
 * [
 *    "This    is    an",
 *    "example  of text",
 *    "justification.  "
 * ]
 * Note: Each word is guaranteed not to exceed L in length.
 * 
 * Corner Cases:
 * A line other than the last line might contain only one word. What should you do in this case?
 * In this case, that line should be left-justified.
 ****************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-04
 * @param {string[]} words
 * @param {number} maxWidth
 * @return {string[]}
 */
var fullJustify = function(words, maxWidth) {
    var result = [];//存储返回结果
    var recordLen = 0; //临时记录总长度，用于和maxWidth比较
    var resultRow = ""; //存储result中的每一行，用于向result插入
    var start = 0; //临时记录result每一行开始的arr位置脚标
    var end = 0; //临时记录result每一行结束的arr位置脚标
    var arr = words;
    var i=0;
    while(i<arr.length){
        start = i;
        recordLen = 0;
        resultRow = "";
        while(recordLen+(i-start) <= maxWidth && i<arr.length){
            recordLen += arr[i].length;
            if(recordLen+(i-start) > maxWidth){
                recordLen -= arr[i].length;
                break;
            }
            i++;
        }
        end = i-1;//start和end记录了本行中的字符在arr开始和结束点
        
        var space = maxWidth-recordLen;
        if(start === end || end === arr.length-1){
            while(start<=end){
                resultRow += arr[start];
                if(start<end){
                    resultRow += " ";
                }
                start++;
            }
            while(resultRow.length < maxWidth){
                resultRow += " ";
            }
        }else{
            var number = space % (end-start);
            var j = start;
            while(j<=end){
                resultRow += arr[j];
                if(j !== end){
                    var spcount = Math.floor(space/(end-start))+((j-start)<number?1:0);
                    while(spcount>0){
                        resultRow += " "; spcount--;
                    }
                }
                j++;
            }
        }
        result.push(resultRow);
    }
    return result;
};
