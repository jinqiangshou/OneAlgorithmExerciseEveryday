/***********************************Question*************************************
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
 * 
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its level order traversal as:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 ********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-08-17
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class pair {
        boolean level;
        TreeNode node;
        pair(boolean _level, TreeNode _node) {level = _level; node = _node;}
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<pair> q = new LinkedList<pair>();
        List< List<Integer> > lst = new LinkedList< List<Integer> >();
        if(root == null){
            return lst;
        }
        
        List<Integer> row = new LinkedList<Integer>();
        q.offer(new pair(true, root));
        boolean clevel = true;
        while(!q.isEmpty()){
            pair top = q.poll();
            if(top.level == clevel){
                row.add(top.node.val);
            }else{
                clevel = top.level;
                lst.add(row);
                row = new LinkedList<Integer>();
                row.add(top.node.val);
            }
            if(top.node.left != null){
                q.add(new pair(!top.level, top.node.left));
            }
            if(top.node.right != null){
                q.add(new pair(!top.level, top.node.right));
            }
        }
        lst.add(row);
        return lst;
    }
}
