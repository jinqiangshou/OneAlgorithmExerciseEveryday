/*******************************Question*******************************
 * Sort a linked list using insertion sort.
 **********************************************************************/


/**
 * @author Horst Xu
 * @date 2015-10-23
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 **/
struct ListNode* insertionSortList(struct ListNode* head) {
    if(head == NULL || head->next == NULL){
        return head;
    }
    struct ListNode* sorted = head;
    struct ListNode* unsorted = head->next;
    head->next = NULL;
    while(unsorted != NULL){
        struct ListNode* curr = unsorted;
        unsorted = unsorted->next;
        curr->next = NULL;
        if(curr->val < sorted->val){
            curr->next = sorted;
            sorted = curr;
        }else{
            struct ListNode* temp = sorted;
            while(temp != NULL){
                if(temp->val <= curr->val && (temp->next == NULL || temp->next->val >= curr->val)){
                    curr->next = temp->next;
                    temp->next = curr;
                    break;
                }
                temp = temp->next;
            }
        }
    }
    return sorted;
}
