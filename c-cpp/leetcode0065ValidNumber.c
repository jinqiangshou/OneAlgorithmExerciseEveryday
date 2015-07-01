/****************************Question********************************
 * Validate if a given string is numeric.
 * 
 * Some examples:
 * "0" => true
 * " 0.1 " => true
 * "abc" => false
 * "1 a" => false
 * "2e10" => true
 * Note: It is intended for the problem statement to be ambiguous. 
 * You should gather all requirements up front before implementing one.
 *********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-01
 * parameter eIncluded: whether E/e has been counted in this string. 
 */
bool myIsNumber(char* s, bool eIncluded) {

    int dot = -1; //restore the position of dot '.'
    int hasE = -1; // restore the position of power sign 'E' or 'e'

    while(*s == ' '){s++;} // skip the preceding space

    if(*s == '+' || *s == '-'){s++;}//skip the sign

    if(*s == '\0' || s == NULL){return false;} //skip the empty string

    char *t = s;

    while(*t != '\0' && *t != ' '){
        if(*t == '.'){
            if(dot >= 0 || eIncluded ){return false;}
            dot = (t-s);
        }else if(*t == 'e' || *t == 'E'){
            if(eIncluded){return false;}
            hasE = (t-s);
            *t = '\0';
            break; // 'E' or 'e' divides the string into 2 parts, we solve it by calling myIsNumber 2 times
        }else if(*t<'0' || *t>'9'){
            return false;
        }
        t++;
    }

    int len = (t-s); //record the length of the string
    if(hasE == 0){return false;}

    while(*t == ' '){t++;} // skip the succeeding space

    if(*t != '\0'){return false;}

    if(dot == 0 && dot == len-1){return false;}

    if(hasE >0){return myIsNumber((t+1), true);} // 'E' divides the string into 2 parts.

    return true;
}

/**
 * @author Horst Xu
 * @date 2015-07-01
 */
bool isNumber(char *s){
    return myIsNumber(s, false);
}
