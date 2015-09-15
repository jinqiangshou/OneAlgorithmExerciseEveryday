/************************************Question************************************
 * Given a binary tree, find the maximum path sum.
 * 
 * The path may start and end at any node in the tree.
 * 
 * For example:
 * Given the below binary tree,
 * 
 *        1
 *       / \
 *      2   3
 * Return 6.
 *********************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-09-15
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     struct TreeNode *left;
 *     struct TreeNode *right;
 * };
 **/
int maxRootToLeafPath(struct TreeNode* root, int *result)
{
	if(root == NULL) { return 0;}
	int leftMax = maxRootToLeafPath(root->left, result);
	int rightMax = maxRootToLeafPath(root->right, result);
	
	int sum = root->val;
	if(leftMax > 0){
		sum += leftMax;
	}
	if(rightMax > 0){
		sum += rightMax;
	}
	*result = sum>(*result)?sum:(*result);
	
	int max= leftMax>rightMax?leftMax:rightMax;
	return max>0?(max + root->val):root->val;
}

int maxPathSum(struct TreeNode* root) {
    int result = INT_MIN;
	maxRootToLeafPath(root, &result);
	return result;
}
