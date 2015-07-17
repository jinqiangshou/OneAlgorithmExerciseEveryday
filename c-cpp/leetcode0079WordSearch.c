/************************Question***************************
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, 
 * where "adjacent" cells are those horizontally or vertically neighboring. 
 * The same letter cell may not be used more than once.
 * 
 * For example,
 * Given board =
 * 
 * [
 *   ["ABCE"],
 *   ["SFCS"],
 *   ["ADEE"]
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 ***********************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-18
 **/
bool myExist(char **board, int boardRowSize, int boardColSize, char* word, int sRow, int sCol){
    if(word[0] == '\0'){
        return true;
    }
    if(strlen(word)==1){
        return word[0] == board[sRow][sCol];
    }
    if(word[0] != board[sRow][sCol]){
        return false;
    }
    char temp = board[sRow][sCol];
    board[sRow][sCol] = '\0';

    bool result = false;
    char* newWord = word+1;
    if(sRow-1>=0){
        result = result || myExist(board, boardRowSize, boardColSize, newWord, sRow-1, sCol);
    }
    if(sRow+1<boardRowSize){
        result = result || myExist(board, boardRowSize, boardColSize, newWord, sRow+1, sCol);
    }
    if(sCol-1>=0){
        result = result || myExist(board, boardRowSize, boardColSize, newWord, sRow, sCol-1);
    }
    if(sCol+1 < boardColSize){
        result = result || myExist(board, boardRowSize, boardColSize, newWord, sRow, sCol+1);
    }
    board[sRow][sCol] = temp;
    return result;
}

/**
 * @author Horst Xu
 * @date 2015-07-18
 **/
bool exist(char** board, int boardRowSize, int boardColSize, char* word) {
    if(*word == '\0' || word == NULL){
        return true;
    }
    for(int i=0; i<boardRowSize; i++){
        for(int j=0; j<boardColSize; j++){
            if(board[i][j] == word[0]){
                if(myExist(board, boardRowSize, boardColSize, word, i, j)){return true;}
            }
        }
    }
    return false;
}
