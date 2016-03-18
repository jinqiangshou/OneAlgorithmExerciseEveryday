/**************************************Question*****************************************
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, 
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * 
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). 
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) 
 * using the following four rules (taken from the above Wikipedia article):
 * 
 * 1. Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * 2. Any live cell with two or three live neighbors lives on to the next generation.
 * 3. Any live cell with more than three live neighbors dies, as if by over-population..
 * 4. Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * 
 * Follow up: 
 * 1. Could you solve it in-place? Remember that the board needs to be updated at the same time: 
 * You cannot update some cells first and then use their updated values to update other cells.
 * 2. In this question, we represent the board using a 2D array. 
 * In principle, the board is infinite, which would cause problems when the active area 
 * encroaches the border of the array. How would you address these problems?
 ***************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-18
 **/
void gameOfLife(int** board, int boardRowSize, int boardColSize) {
    int *row_copy = (int *)calloc(boardColSize, sizeof(int));
    int *prev_row = (int *)calloc(boardColSize, sizeof(int));

    for(int i = 0; i < boardRowSize; i++){
        memcpy(row_copy, board[i], boardColSize*sizeof(int));
        for(int j = 0; j < boardColSize; j++){
            int count = 0;
            
            if( i > 0 ) { count += prev_row[j]; }
            if( i < boardRowSize - 1 ) { count += board[i+1][j]; }
            if( j > 0 ) { count += row_copy[j-1]; }
            if( j < boardColSize - 1 ) { count += row_copy[j+1]; }
            if( i > 0 && j > 0 ) { count += prev_row[j-1]; }
            if( i > 0 && j < boardColSize - 1 ) { count += prev_row[j+1]; }
            if( i < boardRowSize - 1 && j > 0 ) { count += board[i+1][j-1]; }
            if( i < boardRowSize - 1 && j < boardColSize - 1) { count += board[i+1][j+1]; }

            if( board[i][j] == 1 ) {
                if( count < 2 || count > 3 ) { board[i][j] = 0; }
            } else {
                if( count == 3 ) { board[i][j] = 1; }
            }
        }
        memcpy(prev_row, row_copy, boardColSize*sizeof(int));
    }
    free(row_copy);
    free(prev_row);
}
