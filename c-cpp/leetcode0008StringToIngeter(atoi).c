/****************************Question*******************************
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. 
 * If you want a challenge, please do not see below and ask yourself what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). 
 * You are responsible to gather all the input requirements up front.
 
 * Requirements for atoi:
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. 
 * Then, starting from this character, takes an optional initial plus or minus sign 
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number, 
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, 
 * or if no such sequence exists because either str is empty or it contains only whitespace characters, 
 * no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned. 
 * If the correct value is out of the range of representable values, 
 * INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 ********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-07
 **/
char *trim(char *str){
    if(str == NULL){
        return NULL;
    }   
    char *first = str;
    char *last = first + strlen(str) - 1;
    while(*first && isspace(*first)){
        first++;
    }   
    while(last>first && isspace(*last)){
        *last = '\0';
        last--;
    }   
    return first;
}

/**
 * @author Horst Xu
 * @date 2015-04-07
 **/
int myAtoi(char *str)
{
    if (str == NULL)
    {   
        return 0;
    }   
    
    str = trim(str);
    
    unsigned int result = 0;
    int isNeg = 0;
    if(*str == '-'){
        isNeg = 1;
        str++;
    }else if(*str == '+'){
        isNeg = 0;
        str++;
    }   
    while(*str>='0' && *str<= '9'){
        if(result > INT_MAX/10){
            return (isNeg?INT_MIN:INT_MAX);
        }   
        result = (unsigned int)(result * 10) + (unsigned int)(*str - '0');
        if(result > 0){
            if(result-1 == INT_MAX && isNeg==1){
                if(*(str+1)<'0' || *(str+1)>'9')
                    return INT_MIN;
                else
                    return (isNeg?INT_MIN:INT_MAX);
            }else if(result > INT_MAX){
                return (isNeg?INT_MIN:INT_MAX);
            }
        }
        str++;
    }
    return isNeg?(-(int)result):((int)result);
}
