/* *********************************Question*************************************
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * There may be multiple correct orders, you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 2, [[1,0]]
 * There are a total of 2 courses to take. 
 * To take course 1 you should have finished course 0. So the correct course order is [0,1]
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. 
 * Both courses 1 and 2 should be taken after you finished course 0. 
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * *******************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-28
 * */
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int resultposition = 0;
        int []result = new int[numCourses];
        int []indegree = new int[numCourses];
        Set<Integer> []outvertex = new Set[numCourses];
        for(int i = 0; i < numCourses; i++){
            result[i] = 0;
            indegree[i] = 0;
            outvertex[i] = new HashSet<Integer>();
        }
        Stack<Integer> st = new Stack<>();
        
        for(int i = 0; i < prerequisites.length; i++){
            int course = prerequisites[i][0];
            int prerequest = prerequisites[i][1];
            if(outvertex[prerequest].add(course)){
                indegree[course] ++;
            }
        }
        for(int i = 0; i < numCourses; i++){
            if(indegree[i] == 0){
                st.push(i);
            }
        }
        while(!st.empty()){
            int currcourse = st.pop();
            result[resultposition] = currcourse;
            resultposition++;
            Iterator<Integer> it = outvertex[currcourse].iterator();
            while(it.hasNext()){
                int temp = it.next();
                indegree[temp]--;
                if(indegree[temp] == 0){
                    st.push(temp);
                }
            }
        }
        if(resultposition == numCourses){
            return result;
        }
        return new int[0];
    }
}
