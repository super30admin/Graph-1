// Author: Subhed Chavan
// Batch: December 24
// Problem Statement: Copy List with Random Pointer
// Approach: Linked List 
// Time Complexity: O(N)
// Space Complexity: O(1)

/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/


class Solution {
    public:
        Node* copyRandomList(Node* head) {
            if (!head) {
                return nullptr;
            }
    
            Node* curr = head;
            while (curr) {
                Node* newNode = new Node(curr->val);
                newNode->next = curr->next;
                curr->next = newNode;
                curr = curr->next->next;
            }
    
            curr = head;
            while (curr) {
                if (curr->random) {
                    curr->next->random = curr->random->next;
                }
                curr = curr->next->next;
            }
    
            curr = head;
            Node* copyHead = curr->next;
            Node* copyCurr = copyHead;
            while (curr) {
                curr->next = curr->next->next;
                if (!copyCurr->next) {
                    break;
                }
                copyCurr->next = copyCurr->next->next;
                curr = curr->next;
                copyCurr = copyCurr->next;
            }
    
            return copyHead;
        }
    };
    