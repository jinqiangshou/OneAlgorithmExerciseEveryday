/* *****************************************Question********************************************
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
 * 2, [[1,0],[0,1]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0, 
 * and to take course 0 you should also have finished course 1. So it is impossible.
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
 * Read more about how a graph is represented.
 * 
 * Hints:
 * This problem is equivalent to finding if a cycle exists in a directed graph. 
 * If a cycle exists, no topological ordering exists and therefore it will be impossible to take all courses.
 * Topological Sort via DFS - A great video tutorial (21 minutes) on Coursera 
 * explaining the basic concepts of Topological Sort. Topological sort could also be done via BFS.
 * *********************************************************************************************/
 

/* *
 * @author Horst Xu
 * @date 2015-12-22
 * */
public class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int len = prerequisites.length;
        
        int deg[] = new int[numCourses]; //入度
        for(int i=0; i<numCourses;i++){
            deg[i]=0;
        }
        LinkedList<LinkedList<Integer> > arr = new LinkedList<LinkedList<Integer> >();
        for(int i=0; i<numCourses; i++){
            arr.add(new LinkedList<Integer>());
        }
        for(int i=0; i<len;i++){
            arr.get(prerequisites[i][0]).add(prerequisites[i][1]);
            deg[prerequisites[i][1]]++;
        }
        
        Stack<Integer> st = new Stack<Integer>();
        for(int i=0; i<numCourses; i++){
            if(deg[i]==0){
                st.push(i);
            }
        }
        while(!st.empty()){
            int top = st.pop();
            deg[top]--;
            int rowlen = arr.get(top).size();
            for(int i=0; i<rowlen; i++){
                int t = arr.get(top).get(i);
                deg[t]--;
                if(deg[t]==0){
                    st.push(t);
                }
            }
        }
        for(int i=0; i<deg.length;i++){
            if(deg[i]>0){
                return false;
            }
        }
        return true;
    }
}
