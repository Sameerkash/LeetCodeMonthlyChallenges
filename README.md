# LeetCodeDecemberChallange

**LeetCode December Challenge 2020**

**Table of Content**
- [Dec1- MaxDepth of BT](#decemeber-1-maxdepth-of-a-binary-tree)
- [Dec2- Random Node of LL](#december-2-linked-list-random-node)




 ### Decemeber 1 MaxDepth of a Binary Tree
 
 
 Q: Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

A:
```
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null ) return 0;
        if (root.left == null && root.right ==  null) return 1;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) +1;
    }
}
```


### December 2 Linked List Random Node

Q: Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
A:
```
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
    ListNode head;
    Random random;
    public Solution(ListNode head) {
        this.head = head;
        this.random = new Random();
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
      ListNode iter = this.head;
        int res = iter.val;

        iter = iter.next;
        int n = 1;
        while(iter != null) {
            ++n;
            if(random.nextInt(n) == 0) {
                res = iter.val;
            }
            iter = iter.next;
        }
        return res;
        
    }
}
```
