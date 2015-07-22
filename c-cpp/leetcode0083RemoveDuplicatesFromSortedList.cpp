/****************************Question*******************************
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 * For example,
 * Given 1->1->2, return 1->2.
 * Given 1->1->2->3->3, return 1->2->3.
 *******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-22
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *p;
        p = head;
        if(!p) return head;
         
        while(p->next){
            if(p->next->val == p->val){
                ListNode *q;
                q=p->next;
                p->next = q->next;
                delete q;
            }else{
                p = p->next;
            }        
        }
        return head;
    }
};
