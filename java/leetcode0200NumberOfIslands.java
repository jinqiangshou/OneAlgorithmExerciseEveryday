/* **********************************Question*****************************************
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * 11110
 * 11010
 * 11000
 * 00000
 * Answer: 1
 * 
 * Example 2:
 * 
 * 11000
 * 11000
 * 00100
 * 00011
 * Answer: 3
 * ***********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-11
 * */
public class Solution {
    private class Pair{
        int first = 0;
        int last = 0;
        Pair(int _first, int _second){
            this.first = _first;
            this.last = _second;
        }
    }
    
    private void removeOnes(char[][] grid, int i, int j){
        int row = grid.length;
        int col = grid[0].length;
        Stack<Pair> st = new Stack<Pair>();
        st.push(new Pair(i,j));
        while(!st.empty()){
            Pair temp = st.pop();
            grid[temp.first][temp.last] = '0';
            if(temp.first-1>=0 && grid[temp.first-1][temp.last] == '1') {
                st.push(new Pair(temp.first-1, temp.last));
            }
            if(temp.last+1<col && grid[temp.first][temp.last+1] == '1') {
                st.push(new Pair(temp.first, temp.last+1));
            }
            if(temp.first+1<row && grid[temp.first+1][temp.last] == '1') {
                st.push(new Pair(temp.first+1, temp.last));
            }
            if(temp.last-1>=0 && grid[temp.first][temp.last-1] == '1') {
                st.push(new Pair(temp.first, temp.last-1));
            }
        }
    }
    
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        
        int result = 0;
        for(int i=0; i<row;i++){
            for(int j=0; j<col; j++){
                if(grid[i][j] == '1'){
                    result++;
                    removeOnes(grid, i, j);
                }
            }
        }
        return result;
    }
}
