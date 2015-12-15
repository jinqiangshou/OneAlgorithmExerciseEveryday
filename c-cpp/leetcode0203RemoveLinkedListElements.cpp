/*****************************************Question********************************************
 * Remove all elements from a linked list of integers that have value val.
 * 
 * Example
 * Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
 * Return: 1 --> 2 --> 3 --> 4 --> 5
 *********************************************************************************************/


/**
 * @author Horst Xu
 * @date 2015-12-15
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 **/
class Solution {
public:
    ListNode* removeElements(ListNode* head, int val) {
        ListNode* myhead = new ListNode(1);
        myhead->next = head;
        ListNode* prev = myhead;
        ListNode* curr = head;
        while(curr){
            if(curr->val == val){
                prev->next = curr->next;
                delete curr;
                curr = prev->next;
            }else{
                prev = curr;
                curr = curr->next;
            }
        }
        ListNode* result = myhead->next;
        delete myhead;
        return result;
    }
};
