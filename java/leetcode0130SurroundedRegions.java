/* *********************************Question********************************
 * Given a 2D board containing 'X' and 'O', capture all regions surrounded by 'X'.
 * 
 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
 * 
 * For example,
 * X X X X
 * X O O X
 * X X O X
 * X O X X
 * After running your function, the board should be:
 * 
 * X X X X
 * X X X X
 * X X X X
 * X O X X
 * *************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-09-23
 * */
public class Solution {
    private class Pair {
        int x;
        int y;
        Pair(int a, int b){x=a; y=b;}
    }
    
    public void solve(char[][] board) {
        int row = board.length;
        if(row <= 2){
            return;
        }
        int column = board[0].length;
        if(column <= 2){
            return;
        }
        Queue<Pair> q = new LinkedList<Pair>();
        for(int i = 0; i < column; i++){
            if(board[0][i] == 'O'){
                q.offer(new Pair(0, i)); board[0][i] = 'T';
            }
            if(board[row-1][i] == 'O'){
                q.offer(new Pair(row - 1, i)); board[row-1][i] = 'T';
            }
        }
        for(int i = 1; i < row; i++){
            if(board[i][0] == 'O'){
                q.offer(new Pair(i, 0)); board[i][0] = 'T';
            }
            if(board[i][column - 1] == 'O'){
                q.offer(new Pair(i, column - 1)); board[i][column - 1] = 'T';
            }
        }
        while(!q.isEmpty()){
            Pair p = q.poll();
            if(p.x > 0 && board[p.x - 1][p.y] == 'O'){
                q.offer(new Pair(p.x - 1, p.y)); board[p.x - 1][p.y] = 'T';
            }
            if(p.x < row - 1 && board[p.x + 1][p.y] == 'O'){
                q.offer(new Pair(p.x + 1, p.y)); board[p.x + 1][p.y] = 'T';
            }
            if(p.y > 0 && board[p.x][p.y - 1] == 'O'){
                q.offer(new Pair(p.x, p.y - 1)); board[p.x][p.y - 1] = 'T';
            }
            if(p.y < column - 1 && board[p.x][p.y + 1] == 'O'){
                q.offer(new Pair(p.x, p.y + 1)); board[p.x][p.y + 1] = 'T';
            }
        }
        for(int i = 0; i < row; i++){
            for(int j = 0; j < column; j++){
                if(board[i][j] == 'T'){
                    board[i][j] = 'O';
                }else if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
    }
}
