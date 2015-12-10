/* *****************************Question******************************
 * Given a binary tree, imagine yourself standing on the right side of it, 
 * return the values of the nodes you can see ordered from top to bottom.
 * 
 * For example:
 * Given the following binary tree,
 *    1            <---
 *  /   \
 * 2     3         <---
 *  \     \
 *   5     4       <---
 * You should return [1, 3, 4].
 * *******************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-12-10
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    private class Pair {
        TreeNode tn;
        int level;
        Pair(TreeNode _tn, int _level){
            this.tn = _tn;
            this.level = _level;
        }
    }
    
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> lst = new LinkedList<Integer>();
        if(root == null){
            return lst;
        }
        Queue<Pair> qe = new LinkedList<Pair>();
        qe.offer(new Pair(root, 0));
        int target = 0; // target level
        while(!qe.isEmpty()){
            Pair p = qe.poll();
            if(target == p.level){
                lst.add(p.tn.val);
                target++;
            }
            if(p.tn.right != null){
                qe.offer(new Pair(p.tn.right, p.level+1));
            }
            if(p.tn.left != null){
                qe.offer(new Pair(p.tn.left, p.level+1));
            }
        }
        return lst;
    }
}
