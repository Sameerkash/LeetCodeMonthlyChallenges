# LeetCodeDecemberChallange

**LeetCode December Challenge 2020**

**Table of Content**
- [Dec1- MaxDepth of BT](#decemeber-1-maxdepth-of-a-binary-tree)
- [Dec2- Random Node of LL](#december-2-linked-list-random-node)
- [Dec3- Increasing Order of Search Tree](#decemeber-3-increasing-order-search-tree)
- [Dec4- The kth Factor of n](#decemeber-4-the-kth-factor-of-n)
- [Dec5- The kth Factor of n](#decemeber-5-can-place-flowers)
- [Dec6- The kth Factor of n](#decemeber-6-populating-next-right-pointers-in-each-node-ii)
- [Dec7- Spiral Matrix II](#december-7-spiral-matrix-ii)
- [Dec8- Pairs of Songs With Total Durations Divisible by 60](#decemeber-8-pairs-of-songs-with-total-durations-divisible-by-60)
- [Dec9- Binary Search Tree Iterator](#decemeber-9-binary-search-tree-iterator)
- [Dec10- Valid Mountain Array](#decemeber-10-valid-mountain-array)



 ### Decemeber 1 MaxDepth of a Binary Tree
 
 
 Q: Given the root of a binary tree, return its maximum depth.
A binary tree's maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

A:
```java
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


### Decemeber 3 Increasing Order Search Tree

Q: Given the root of a binary search tree, rearrange the tree in in-order so that the leftmost node in the tree is now the root of the tree, and every node has no left child and only one right child.

A:
```java
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
    TreeNode current;
    public TreeNode increasingBST(TreeNode root) {
      TreeNode head = new TreeNode(0);
        current = head;
        inorder(root);
        return head.right;
    }
    
    private void inorder(TreeNode root) {
        if(root == null) return;
        inorder(root.left);
        root.left = null;
        current = current.right = root;
        inorder(root.right);
    }
}
```

### Decemeber 4 The kth Factor of n

Q: Given two positive integers n and k.
A factor of an integer n is defined as an integer i where n % i == 0.
Consider a list of all factors of n sorted in ascending order, return the kth factor in this list or return -1 if n has less than k factors.


A:
```java
class Solution {
    public int kthFactor(int n, int k) {
     
        ArrayList<Integer> arr = new ArrayList<>();
        
        for(int i=1; i<=n; i++)
            if(n%i==0) arr.add(i);
        
        if(arr.size() < k) return -1;
        
        Collections.sort(arr);   
        
        return arr.get(k-1);
        
    }
}
```


### December 5 Can Place Flowers


Q: You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.
Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule.

A: 
```java
class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        
         if (flowerbed == null || flowerbed.length == 0) {
            return false;
        }
        
        int count = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (flowerbed[i] == 0 && (i == 0 || flowerbed[i - 1] == 0)
            && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
                flowerbed[i] = 1;
                count++;
            }
            if (count >= n) {
                return true;
            }
        }
        
        return false;
    }
}

```


### December 6 Populating Next Right Pointers in Each Node II


Q: Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.
Initially, all next pointers are set to NULL.

A: 
```java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        if(root == null) return root;
        Queue<Node> q = new LinkedList<>();
        
        if(q.isEmpty()) q.add(root);
        
        while(!q.isEmpty()){
            int s = q.size();
            Node prev = null;
            
            while(s-- > 0){
                 Node node = q.poll();
                
                if(prev!=null) prev.next = node;
                prev = node;
                
                
                if(node.left!=null) q.add(node.left);
                if(node.right!=null) q.add(node.right);
               
            }

        }
         return root;
    }
   
}
    
```


### December 7 Spiral Matrix II

Q: Given a positive integer n, generate an n x n matrix filled with elements from 1 to n2 in spiral order.

A: 
```java
class Solution {
    public int[][] generateMatrix(int n) {
        
        int[][] result = new int[n][n];
 
    int k=1; 
    int top=0;
    int bottom=n-1;
    int left=0;
    int right=n-1;
 
    while(k<=n*n){
        for(int i=left; i<=right; i++){
            result[top][i]=k;
            k++;
        }    
        top++;
 
        for(int i=top; i<=bottom; i++){
            result[i][right]=k;
            k++;
        }
        right--;
 
        for(int i=right; i>=left; i--){
            result[bottom][i]=k;
            k++;
        }
        bottom--;
 
        for(int i=bottom; i>=top; i--){
            result[i][left] = k;
            k++;
        }
        left++;
    }
 
    return result;
    }
}
```

### December 8 Pairs of Songs With Total Durations Divisible by 60

Q: You are given a list of songs where the ith song has a duration of time[i] seconds.
Return the number of pairs of songs for which their total duration in seconds is divisible by 60. Formally, we want the number of indices i, j such that i < j with (time[i] + time[j]) % 60 == 0.

A:
```java
class Solution {
    public int numPairsDivisibleBy60(int[] time) {
        int count =0 ;
        int map[] = new int[60];
        
        for(int t: time){
            if(t % 60 == 0)
                count+=map[0];
            else
                count+= map[60 - t % 60];
            map[t%60]++;
        }
    return count;
    }
}

```



### December 9  Binary Search Tree Iterator

Q: Implement the BSTIterator class that represents an iterator over the in-order traversal of a binary search tree (BST):
BSTIterator(TreeNode root) Initializes an object of the BSTIterator class. The root of the BST is given as part of the constructor. The pointer should be initialized to a non-existent number smaller than any element in the BST.
boolean hasNext() Returns true if there exists a number in the traversal to the right of the pointer, otherwise returns false.
int next() Moves the pointer to the right, then returns the number at the pointer.
Notice that by initializing the pointer to a non-existent smallest number, the first call to next() will return the smallest element in the BST.
You may assume that next() calls will always be valid. That is, there will be at least a next number in the in-order traversal when next() is called.

A:
```java
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
class BSTIterator {

    Stack<TreeNode> stack = new Stack<>();
    
    public  void pushToLeft(TreeNode node){
        if(node!=null){
            stack.push(node);
            pushToLeft(node.left);
        }
    }
    
    public BSTIterator(TreeNode root) {
        pushToLeft(root);
    }
    
    public int next() {
        TreeNode node = stack.pop();
        pushToLeft(node.right);
        return node.val;
    }
    
    public boolean hasNext() {
        if(stack.isEmpty())
            return false;
        return true;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */

```


### December 10 Valid Mountain Array

Q: Given an array of integers arr, return true if and only if it is a valid mountain array.
Recall that arr is a mountain array if and only if:
arr.length >= 3
There exists some i with 0 < i < arr.length - 1 such that:
arr[0] < arr[1] < ... < arr[i - 1] < A[i]
arr[i] > arr[i + 1] > ... > arr[arr.length - 1]

A:
```java
class Solution {
    public boolean validMountainArray(int[] arr) {
     int i =0;
      int j = arr.length-1;
        int n = arr.length-1;
        
        
        while(i+1 < n && arr[i] < arr[i+1])
            i++;
        
        while(j>0 && arr[j] < arr[j-1])
            j--;
        
        return i>0 && i==j && j<n;
    }
}

```



