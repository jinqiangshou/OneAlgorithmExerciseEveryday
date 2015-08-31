/* ***********************************Question**************************************
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22,
 *               5
 *              / \
 *             4   8
 *            /   / \
 *           11  13  4
 *          /  \    / \
 *         7    2  5   1
 * return
 * [
 *    [5,4,11,2],
 *    [5,8,4,5]
 * ]
 * *********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-31
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    
    public void findSum(TreeNode root, int sum, List<List<Integer> > result, List<Integer> list, int currSum){
        currSum = root.val + currSum;
        list.add(root.val);
        
        if(root.left == null && root.right == null){
            if(currSum == sum){
                result.add(new LinkedList<Integer>(list));
            }
        }
        
        if(root.left != null){
            findSum(root.left, sum, result, list, currSum);
        }
        
        if(root.right != null){
            findSum(root.right, sum, result, list, currSum);
        }
        
        int size = list.size();
        currSum = currSum - list.get(size-1);
        list.remove(size-1);
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer> > result = new LinkedList<List<Integer> >();
        if(root == null){
            return result;
        }
        List<Integer> list = new LinkedList<Integer>();
        findSum(root, sum, result, list, 0);
        return result;
    }
}
