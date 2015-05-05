/*************************Question**************************
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * 
 * 5 3 . . 7 . . . .
 * 6 . . 1 9 5 . . .
 * . 9 8 . . . . 6 .
 * 8 . . . 6 . . . 3
 * 4 . . 8 . 3 . . 1
 * 7 . . . 2 . . . 6
 * . 6 . . . . 2 8 .
 * . . . 4 1 9 . . 5
 * . . . . 8 . . 7 9
 * A sudoku puzzle...
 * 5 3 4 6 7 8 9 1 2
 * 6 7 2 1 9 5 3 4 8
 * 1 9 8 3 4 2 5 6 7
 * 8 5 9 7 6 1 4 2 3
 * 4 2 6 8 5 3 7 9 1
 * 7 1 3 9 2 4 8 5 6
 * 9 6 1 5 3 7 2 8 4
 * 2 8 7 4 1 9 6 3 5
 * 3 4 5 2 8 6 1 7 9
 *
 * ...and its solution.
 ***********************************************************/

/**
 * @author Horst Xu
 * @date 2015-05-05
 */
bool isValid(char *board[9], int row, int column, char number){
	for(int i = 0; i < 9; i++){
		if(board[row][i] == number){
			return false;
		}
		if(board[i][column] == number){
			return false;
		}
	}

	for (int i = 0; i < 9; i++){
		int a = (row / 3) * 3 + i / 3;
		int b = (column / 3) * 3 + i % 3;
		if(board[a][b] == number){
			return false;
		}
	}
	return true;
}

bool sudukuSolution(char *board[9], int row, int column){
	if(row >= 9){
		return true;
	}
	if(board[row][column] != '.'){
		if(column >= 8){
			return sudukuSolution(board, row+1, 0);
		}else {
			return sudukuSolution(board, row, column+1);
		}
	}

	for(int i=0; i<9;i++){
		if(isValid(board, row, column, (char)('1'+i))){
			board[row][column] = (char)('1'+i);
			if(column >=8 && sudukuSolution(board, row+1, 0)){
				return true;
			}else if (sudukuSolution(board, row, column +1)){
				return true;
			}
			board[row][column] = '.';
		}
	}
	return false;
}

void solveSudoku(char *board[9]){
	if(sudukuSolution(board, 0, 0)){
		//successfully find the solution
	} else {
		// cannot find a solution
	}
	return;
}
