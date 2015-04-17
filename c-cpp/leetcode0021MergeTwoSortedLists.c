/*****************************Question*****************************
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 ******************************************************************/


/**
 * @author Horst Xu
 * @date 2015-04-17
 *
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode *insertOneNode(struct ListNode *list, struct ListNode *single){
    while(list->next != NULL && list->next->val <= single->val ){
        list = list->next;
    }
    if(list->next == NULL){
        list->next = single;
        list = list->next;
        return list;
    }
    if(list->next->val > single->val){
        struct ListNode *temp = list->next;
        list->next = single;
        single->next = temp;
        return single;
    }
}

/**
 * @author Horst Xu
 * @date 2015-04-17
 */
struct ListNode *mergeTwoLists(struct ListNode *l1, struct ListNode *l2) {
    if(l1 == NULL){
        return l2;
    }else if(l2 == NULL){
        return l1;
    }

    struct ListNode *small = (l1->val > l2->val)?(l2):(l1);
    struct ListNode *big = (l1->val > l2->val)?(l1):(l2);

    struct ListNode *bigfirst;
    while(big){
        bigfirst = big;
        big = big->next;
        bigfirst->next = NULL;
        small = insertOneNode(small, bigfirst);
    }
    return (l1->val > l2->val)?(l2):(l1);
}
