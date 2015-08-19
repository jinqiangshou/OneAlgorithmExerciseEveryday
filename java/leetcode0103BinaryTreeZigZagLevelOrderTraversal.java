/* ********************************Question**********************************
 * Given a binary tree, return the zigzag level order traversal of its nodes' values. 
 * (ie, from left to right, then right to left for the next level and alternate between).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *    3
 *   / \
 *  9  20
 *    /  \
 *   15   7
 * return its zigzag level order traversal as:
 * [
 *   [3],
 *   [20,9],
 *   [15,7]
 * ]
 * ***************************************************************************/
 

/* *
 * @author Horst Xu
 * @date 2015-08-19
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        if(root == null){
            return new LinkedList<List<Integer> >();
        }
        List<List<Integer>> result = new LinkedList<List<Integer> >();
        q.offer(root);
        boolean reverse = false;
        
        while(!q.isEmpty()){
            int nodenumber = q.size();
            List<Integer> list = new ArrayList<Integer>();
            for(int i=0; i<nodenumber;i++){
                TreeNode tn = q.poll();
                list.add(tn.val);
                if(tn.left != null){
                    q.add(tn.left);
                }
                if(tn.right != null){
                    q.add(tn.right);
                }
            }
            if(reverse){
                Collections.reverse(list);
            }
            reverse = (!reverse);
            result.add(list);
        }
        return result;
    }
}
