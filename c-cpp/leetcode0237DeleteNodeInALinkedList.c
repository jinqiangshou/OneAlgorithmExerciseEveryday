/********************************Question*************************************
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and 
 * you are given the third node with value 3, 
 * the linked list should become 1 -> 2 -> 4 after calling your function.
 *****************************************************************************/
 
/**
 * @author Horst Xu
 * @date 2016-02-17
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 **/
void deleteNode(struct ListNode* node) {
    node->val = node->next->val;
    struct ListNode* next = node->next;
    node->next = next->next;
    free(next);
}
