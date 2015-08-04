/* **************************************Question*************************************
 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 *
 * For example,
 * Given n = 3, your program should return all 5 unique BST's shown below.
 *
 *   1         3     3      2      1
 *    \       /     /      / \      \
 *     3     2     1      1   3      2
 *    /     /       \                 \
 *   2     1         2                 3
 * ***********************************************************************************/


/* *
 * @author Horst Xu
 * @date 2015-08-04
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 * */
public class Solution {
    public List<TreeNode> generateTrees(int n) {
        return myGenerateTrees(1,n);
    }

    public List<TreeNode> myGenerateTrees(int start,int end){             
        List<TreeNode> trees = new ArrayList<TreeNode>();
        if(start>end){
            trees.add(null); 
            return trees;
        }
    
        for(int i=start;i<=end;i++){
            List<TreeNode> leftSubTrees=myGenerateTrees(start,i-1);
            List<TreeNode> rightSubTrees=myGenerateTrees(i+1,end);
    
            for(int j=0; j<leftSubTrees.size();j++){
                for(int k=0; k<rightSubTrees.size();k++){
                    TreeNode root=new TreeNode(i);
                    root.left=leftSubTrees.get(j);
                    root.right=rightSubTrees.get(k);
                    trees.add(root);
                }
            }
        }
        return trees;
    }
}
