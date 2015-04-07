/*******************Question*************************
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
 * (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 *
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 ****************************************************/

/**
 * @author Horst Xu
 * @date 2015-04-05
 **/
char *convert(char *s, int nRows){
    int len = strlen(s);
        
    char *result = (char *)malloc(sizeof(char)*(len+1));
    memset(result, 0, sizeof(result));
    if(nRows <= 1){ 
        strcpy(result, s); 
        return result;
    }   
        
    int copypos = 0;

    int i = 0;
    int k = 0;
    while(k<nRows){
        i = 0;
        while(2*i*(nRows-1)+k <= len -1 ){
            result[copypos] = s[2*i*(nRows-1)+k];
            copypos++;
            if(k > 0 && 2*(i+1)*(nRows-1)-k <= len-1 && 2*(i+1)*(nRows-1)-k > 2*i*(nRows-1)+k){
                result[copypos] = s[2*(i+1)*(nRows-1)-k];
                copypos++;
            }   
            i++;
        }   
        k++;
    }   
        
    result[len] = '\0';
    return result;
}
