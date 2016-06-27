/*************************************Question*************************************
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * 
 * Example 1:
 * Given s = "hello", return "holle".
 *
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 **********************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-06-27
 */
char* reverseVowels(char* s) {
    int len = strlen(s);
    
    int start = 0;
    int end = len - 1;
    while(start < end)
    {
        while(start < end && s[start] !='a' && s[start] != 'e' && s[start] != 'i' && s[start] != 'o' && s[start] != 'u'
              && s[start] !='A' && s[start] != 'E' && s[start] != 'I' && s[start] != 'O' && s[start] != 'U' )
        {
            start ++;
        }
        while(start < end && s[end] !='a' && s[end] != 'e' && s[end] != 'i' && s[end] != 'o' && s[end] != 'u'
              && s[end] !='A' && s[end] != 'E' && s[end] != 'I' && s[end] != 'O' && s[end] != 'U' )
        {
            end --;
        }
        if(start >= end)
        {
            break;
        }
        char tmp = s[start];
        s[start] = s[end];
        s[end] = tmp;
        start ++;
        end --;
    }
    return s;
}
