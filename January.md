<!---Template

- [January1 - ]()  [Try it out!](https://leetcode.com/problems/)

 --->
 <!---Template

### January

Q:

A:
```java

```
 --->

# LeetCode January Challange

**LeetCode January Challenge 2021 in Java**

**Table of Content**

- [January1 - Check Array Formation Through Concatenation](#january-1-check-array-formation-through-concatenation) [Try it out!](https://leetcode.com/problems/check-array-formation-through-concatenation/)
- [January2 - Find a Corresponding Node of a Binary Tree in a Clone of That Tree](#january-2-find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree) [Try it out!](https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/)

- [January3 - Beautiful Arrangement](#january-3-beautiful-arrangement) [Try it out!](https://leetcode.com/problems/beautiful-arrangement/)

- [January4 - Merge Two Sorted Lists](#january-4-merge-two-sorted-lists) [Try it out!](https://leetcode.com/problems/merge-two-sorted-lists/)

- [January5 - Remove Duplicates from Sorted List II](#january-5-remove-duplicates-from-sorted-list-ii) [Try it out!](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

### January 1 Check Array Formation Through Concatenation

Q: You are given an array of distinct integers arr and an array of integer arrays pieces, where the integers in pieces are distinct. Your goal is to form arr by concatenating the arrays in pieces in any order. However, you are not allowed to reorder the integers in each array pieces[i].

Return true if it is possible to form the array arr from pieces. Otherwise, return false.

A:

```java
class Solution {
    public boolean canFormArray(int[] arr, int[][] pieces) {

        int n = arr.length;
        Map<Integer, int[]> map = new HashMap<>();

        for(int []p : pieces){
            map.put(p[0],p);
        }

        int i =0 ;
        for(; i<n; i++){
        if(map.containsKey(arr[i])){


            int p[] = map.get(arr[i]);
            for(int num: p){
                if(num ==arr[i]) i++;
                else return false;
            }
          }else{
            return false;
        }
           i--;
        }
        return true;
    }
}
```

### January 2 Find a Corresponding Node of a Binary Tree in a Clone of That Tree

Q: Given two binary trees original and cloned and given a reference to a node target in the original tree.

The cloned tree is a copy of the original tree.

Return a reference to the same node in the cloned tree.

Note that you are not allowed to change any of the two trees or the target node and the answer must be a reference to a node in the cloned tree.

Follow up: Solve the problem if repeated values on the tree are allowed.

A:

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
            TreeNode root = cloned;
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        while(queue.size() > 0) {
            root = queue.poll();
            if(root.val == target.val)
                return root;
            if(root.left != null)
                queue.add(root.left);
            if(root.right != null)
                queue.add(root.right);
        }
        return null;

    }
}
```

### January 3 Beautiful Arrangement

Q:Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:

perm[i] is divisible by i.
i is divisible by perm[i].
Given an integer n, return the number of the beautiful arrangements that you can construct.

A:

```java
class Solution {
    int result = 0;
    public int countArrangement(int n) {

        int[] nums = new int[n+1];
        dfs(nums, 1, n);
        return result;

    }

    void dfs(int[] nums, int val, int n){
        if(val>n){
            result++;
            return;

        }


        for(int i=1; i<=n;i++){
            if(nums[i]==0 && (val%i ==0 || i%val ==0)){
                nums[i] =val;
                dfs(nums, val+1,n);
                nums[i] = 0;
            }
        }
    }
}
```

### January 4 Merge Two Sorted Lists

Q: Merge two sorted linked lists and return it as a sorted list. The list should be made by splicing together the nodes of the first two lists.

A:

```java
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
   public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(-1), current = dummyHead;
        while(l1 != null && l2 != null) {
            if(l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        if(l1 != null) current.next = l1;
        if(l2 != null) current.next = l2;

        return dummyHead.next;
    }
}
```

### January 5 Remove Duplicates from Sorted List II

Q:Given the head of a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list. Return the linked list sorted as well.

A:

```java
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
    public ListNode deleteDuplicates(ListNode head) {
     if(head == null || head.next == null){
            return head;
        }

        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode it = head;
        ListNode prev = dummy;

        while(it!=null && it.next!=null){

            boolean foundDuplication = false;
            while(it!=null && it.next!=null && it.val == it.next.val){
                foundDuplication  = true;
                it = it.next;
            }

            if(!foundDuplication){
                prev = prev.next;
            } else {
                prev.next = it.next;
            }

            it = it.next;
        }
        return dummy.next;
    }
}
```
