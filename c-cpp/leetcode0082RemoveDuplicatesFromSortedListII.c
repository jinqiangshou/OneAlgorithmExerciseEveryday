/*****************************Question*********************************
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.
 * 
 * For example,
 * Given 1->2->3->3->4->4->5, return 1->2->5.
 * Given 1->1->1->2->3, return 2->3.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-07-21
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* deleteDuplicates(struct ListNode* head) {
    if(head == NULL || head->next == NULL){
        return head;
    }
    struct ListNode myhead;
    myhead.val = 0;
    myhead.next = head;
    struct ListNode* prev = &myhead;
    struct ListNode* curr = head;
    struct ListNode* next;
    int count = 0;
    while(curr != NULL){
        count = 0;
        next = curr->next;
        while(next != NULL && next->val == curr->val){
            next = next->next;
            count++;
        }
		
        if(count>0){
            prev->next = next;
            while(count>=0){
                struct ListNode* temp = curr;
                curr = curr->next;
                free(temp);
                temp = NULL;
                count--;
            }
        }else{
            prev = curr;
        }
        curr = next;
        if(curr!=NULL){
            next = next->next;
        }
    }
    return myhead.next;
}
