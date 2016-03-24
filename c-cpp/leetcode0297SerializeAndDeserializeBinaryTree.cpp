/*************************************Question*****************************************
 * Serialization is the process of converting a data structure or object into a sequence of bits 
 * so that it can be stored in a file or memory buffer, or transmitted across a network connection link 
 * to be reconstructed later in the same or another computer environment.
 * 
 * Design an algorithm to serialize and deserialize a binary tree. 
 * There is no restriction on how your serialization/deserialization algorithm should work. 
 * You just need to ensure that a binary tree can be serialized to a string and 
 * this string can be deserialized to the original tree structure.
 * 
 * For example, you may serialize the following tree
 * 
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 * as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. 
 * You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 * Note: Do not use class member/global/static variables to store states. 
 * Your serialize and deserialize algorithms should be stateless.
 ***************************************************************************************/


/**
 * @author Horst Xu
 * @date 2016-03-24
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
 * };
 **/
class Codec {
public:

    // Encodes a tree to a single string.
    string serialize(TreeNode* root) {
        string result("");
        queue<TreeNode*> q;
        q.push(root);
        int loop_counter = 1;
        int next_loop = 0;
        while(loop_counter > 0){
            TreeNode* tn = q.front();
            q.pop();
            loop_counter--;
            
            if(tn == NULL){
                result += "n";
            } else {
                char tmp[20] = {0};
                sprintf(tmp,"%d", tn->val);
                string t = tmp;
                result += t;
                q.push(tn->left);
                q.push(tn->right);
                next_loop += 2;
            }
            if(loop_counter == 0){
                loop_counter = next_loop;
                next_loop = 0;
                result += ",";
            }else{
                result += ",";
            }
        }
        return result;
    }
    
    // Decodes your encoded data to tree.
    TreeNode* deserialize(string data) {
        int pos1 = 0; 
        int pos2 = 0;
        queue<TreeNode*> q;
        TreeNode* result = NULL;
        bool left = true;
        TreeNode* tn2 = NULL;
        for(;;){
            pos2 = data.find(',',pos1);
            if(pos2 != string::npos){
                string tmp = data.substr(pos1, pos2-pos1);
                if(q.empty()){
                    if(tmp.compare("n") == 0){
                        return NULL;
                    } else {
                        result = new TreeNode(atoi(tmp.c_str()));
                        q.push(result);
                    }
                    pos1 = pos2+1;
                    continue;
                }
                TreeNode* topNode = q.front();
                if(tmp.compare("n") == 0){
                    tn2 = NULL;
                } else {
                    tn2 = new TreeNode(atoi(tmp.c_str()));
                    q.push(tn2);
                }	
                if(left){
                    topNode->left = tn2;
                } else {
                    topNode->right = tn2;
                    q.pop();
                }
                left = (!left);
            } else {
                break;
            }
            pos1 = pos2+1;
        }
        return result;
    }
};

// Your Codec object will be instantiated and called as such:
// Codec codec;
// codec.deserialize(codec.serialize(root));
