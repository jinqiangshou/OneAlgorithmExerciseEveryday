/* **************************************Question**************************************
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
 * *************************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-24
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        List<List<Integer> > result = new LinkedList<List<Integer> >();
        if(root == null){
            return result;
        }
        q.offer(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> list = new LinkedList<Integer>();
            for(int i=0; i<len;i++){
                TreeNode tn = q.poll();
                list.add(tn.val);
                if(tn.left != null){
                    q.offer(tn.left);
                }
                if(tn.right != null){
                    q.offer(tn.right);
                }
            }
            result.add(0, list);
        }
        return result;
    }
}
