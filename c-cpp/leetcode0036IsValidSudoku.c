/************************Question***********************
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * 5 3 . . 7 . . . .
 * 6 . . 1 9 5 . . .
 * . 9 8 . . . . 6 .
 * 8 . . . 6 . . . 3
 * 4 . . 8 . 3 . . 1
 * 7 . . . 2 . . . 6
 * . 6 . . . . 2 8 .
 * . . . 4 1 9 . . 5
 * . . . . 8 . . 7 9
 * A partially filled sudoku which is valid.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 ********************************************************/


/**
 * @author Horst Xu
 * @date 2015-05-04
 */
bool isValidSudoku(char board[9][9]) {
    int count = 0;
	
	//横向判断
	for(int i=0;i<9;i++){
		count = 0;
		for(int k=0;k<9;k++){
			if(board[i][k] >= '1' && board[i][k] <= '9'){
				if((count >> (board[i][k]-'1')) & 0x1){
					return false;
				}
				count = (count | ((0x1) << (board[i][k]-'1'))); 
			}
		}
	}

	//纵向判断
	for(int i=0;i<9;i++){
		count = 0;
		for(int k=0;k<9;k++){
			if(board[k][i] >= '1' && board[k][i] <= '9'){
				if((count >> (board[k][i]-'1')) & 0x1){
					return false;
				}
				count = (count | ((0x1) << (board[k][i]-'1'))); 
			}
		}
	}

	//方块判断
	for(int i=0;i<=6; i += 3){
		for(int k=0;k<=6; k+= 3){
			count = 0;
			for(int a1=i;a1<i+3;a1++){
				for(int a2=k;a2<k+3;a2++){
					if(board[a1][a2] >= '1' && board[a1][a2] <= '9'){
						if((count >> (board[a1][a2]-'1')) & 0x1){
							return false;
						}
						count = (count | ((0x1) << (board[a1][a2]-'1'))); 
					}
				}
			}
		}
	}

	return true;
}
