# LeetCodeDecemberChallange

**LeetCode December Challenge 2020**

**Table of Content**
- [Dec1- MaxDepth of BT](#decemeber-1-maxdepth-of-a-binary-tree)
- [Dec2- Random Node of LL](#december-2-linked-list-random-node)
- [Dec3- Increasing Order of Search Tree](#decemeber-3-increasing-order-search-tree)
- [Dec4- The kth Factor of n](#december-4-the-kth-factor-of-n)
- [Dec5- Can Place Flowers](#december-5-can-place-flowers)
- [Dec6- The Populating the next right pointer of each node II](#december-6-populating-next-right-pointers-in-each-node-ii)
- [Dec7- Spiral Matrix II](#december-7-spiral-matrix-ii)
- [Dec8- Pairs of Songs With Total Durations Divisible by 60](#december-8-pairs-of-songs-with-total-durations-divisible-by-60)
- [Dec9- Binary Search Tree Iterator](#december-9-binary-search-tree-iterator)
- [Dec10- Valid Mountain Array](#december-10-valid-mountain-array)
- [Dec11- Remove Duplicates from Sorted Array II](#december-11-remove-duplicates-from-sorted-array-ii)
- [Dec12- Smallest Subtree with all the Deepest Nodes](#december-12-smallest-subtree-with-all-the-deepest-nodes)
- [Dec13- Burst Balloons](#december-13-burst-balloons)
- [Dec14- Palindrome Partitioning](#december-14-palindrome-partitioning)
- [Dec15- Squares of a sorted array](#december-15-squares-of-a-sorted-array)
- [Dec16- Validate Binary Search Tree](#december-16-validate-binary-search-tree)
- [Dec17- 4Sum II](#december-17-4sum-ii)
- [Dec18- Increasing Triplet Subsequence](#december-18-increasing-triplet-subsequence)
- [Dec19- Cherry Pickup II](#december-19-cherry-pickup-ii)
- [Dec20- Decoded String at Index](#december-20-decoded-string-at-index)
- [Dec21- Smallest Range II](#december-21-smallest-range-ii)
- [Dec22- Balanced Binary Tree](#december-22-balanced-binary-tree)
- [Dec23- Next Greater Element III](#december-23-next-greater-element-iii)
- [Dec24- Swap Nodes in Pairs](#december-24-swap-nodes-in-pairs)
- [Dec25- Diagonal Traverse](#december-25-diagonal-traverse)
- [Dec25- Decode Ways](#december-26-decode-ways)






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

### December 4 The kth Factor of n

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



### December 9 Binary Search Tree Iterator

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

### December 11 Remove Duplicates from Sorted Array II

Q:Given a sorted array nums, remove the duplicates in-place such that duplicates appeared at most twice and return the new length.
Do not allocate extra space for another array; you must do this by modifying the input array in-place with O(1) extra memory.

A:
```java
class Solution {
    public int removeDuplicates(int[] arr) {
    int n = arr.length;
    int j =0;
        
        for(int i=0;i<n;i++){
            if(i<n-2 && arr[i]==arr[i+2])
                continue;
            
            arr[j++] = arr[i];
        }
        return j;
    }
}
```



### December 12 Smallest Subtree with all the Deepest Nodes

Q:Given the root of a binary tree, the depth of each node is the shortest distance to the root.
Return the smallest subtree such that it contains all the deepest nodes in the original tree.
A node is called the deepest if it has the largest depth possible among any node in the entire tree.
The subtree of a node is tree consisting of that node, plus the set of all descendants of that node.

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
    int maxDepth =-1;
    TreeNode result=null;
    
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        
        postOrder(root,0);
        return result;
    }
     int postOrder(TreeNode node, int depth){
        if(node == null) return depth;
        
        int left = postOrder(node.left, depth+1);
        int right = postOrder(node.right, depth+1);
    
        if(left==right){
            maxDepth= Math.max(maxDepth,left);
            if(maxDepth==left)
                result = node;
        }
        return Math.max(left, right);
    }
}
```


### December 13 Burst Balloons

QGiven n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.
Find the maximum coins you can collect by bursting the balloons wisely.

A:
```java

class Solution {
    public int maxCoins(int[] nums) {
        int length = nums.length;
        int index = 1;
        int [] newNums = new int [length + 2];
        for (int number: nums)
            if (number > 0)
                newNums[index++] = number;
        newNums[0] = 1;
        newNums[index++] = 1;
        int [][] dp = new int [length+2][length+2];
       
        for (int k=2; k<length+2; k++) {
            for (int left = 0; left < index - k; left ++) {
                int right = left + k;
                for (int i=left+1; i<right; i++) {
                    dp[left][right] = Math.max(dp[left][right], newNums[left] * newNums[i] * newNums[right]
                                              + dp[i][right] + dp[left][i]);
                }
            }
        }
        return dp[0][index-1];       
    }
}
```



### December 14 Palindrome Partitioning

Q:Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.
A palindrome string is a string that reads the same backward as forward.

A:
```java
class Solution {
    public List<List<String>> partition(String s) {
         List<List<String>> res  = new ArrayList<>();
        if(s == null || s.length()==0){
            return res;
        }

        helper(res, new ArrayList<>(), s);
        return res;
    }
    
    private void helper(List<List<String>> res, List<String> currList, String inputStr){
        if(inputStr.length() == 0){
            res.add(new ArrayList<>(currList));
            return ;
        }
        for(int i=0;i<inputStr.length();i++){
            String firstPart = inputStr.substring(0, i+1);
            if(isPalindrome(firstPart)){
                currList.add(firstPart);
                String secondPart = inputStr.substring(i+1, inputStr.length());
                helper(res, currList, secondPart);
                currList.remove(currList.size() -1);

            }
        }
    }

    private boolean isPalindrome(String s){
        String reversedStr = new StringBuilder(s).reverse().toString();
        return s.equals(reversedStr);
    }
}
```



### December 15 Squares of a Sorted Array

Q:Given an integer array nums sorted in non-decreasing order, return an array of the squares of each number sorted in non-decreasing order.

A:
```java
class Solution {
    public int[] sortedSquares(int[] nums) {
     
        for(int i=0; i< nums.length; i++){
            nums[i] = (int)Math.pow(nums[i],2);
        }
        
        Arrays.sort(nums);
        
        return nums;
    }
}
```


### December 16 Validate Binary Search Tree

Q: Given the root of a binary tree, determine if it is a valid binary search tree (BST).
A valid BST is defined as follows:
The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.

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
    public boolean isValidBST(TreeNode root) {
        return validate(root, null, null);
    }
    
    public boolean validate(TreeNode root, Integer max, Integer min){
        if(root == null) return true;
        else if(max!= null && root.val >=max || min!=null && root.val<=min ) return false;
        else return validate(root.left,root.val,min) && validate(root.right, max, root.val);
      
    }
}
```


### December 17 4Sum II

Q: Given four lists A, B, C, D of integer values, compute how many tuples (i, j, k, l) there are such that A[i] + B[j] + C[k] + D[l] is zero.
To make problem a bit easier, all A, B, C, D have same length of N where 0 ≤ N ≤ 500. All integers are in the range of -228 to 228 - 1 and the result is guaranteed to be at most 231 - 1.


A:
```java
class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
         int count  =0 ;
     
        Map<Integer, Integer> map = new HashMap<>();
        int len = A.length;
        for(int i =0 ;i<len;i++){
            for(int j=0;j<len;j++) {
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0)+1);
            }
        }
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                int sum = C[i] +D[j];
                count += map.getOrDefault(-sum,0);
                    
            }
        }
        return count;
    }
}
```



### December 18 Increasing Triplet Subsequence

Q: Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.


A:
```java
class Solution {
    public boolean increasingTriplet(int[] nums) {
        Integer min = Integer.MAX_VALUE;
        Integer max = Integer.MAX_VALUE;
        
        for(int i: nums){
            if(i < min)min = i;            
            if(i > min) max= Math.min(max,i);
            if(i > max) return true;
        }
        return false;
    }
}
```



### December 19 Cherry Pickup II


Q: Given a rows x cols matrix grid representing a field of cherries. Each cell in grid represents the number of cherries that you can collect.
You have two robots that can collect cherries for you, Robot #1 is located at the top-left corner (0,0) , and Robot #2 is located at the top-right corner (0, cols-1) of the grid.
Return the maximum number of cherries collection using both robots  by following the rules below:
From a cell (i,j), robots can move to cell (i+1, j-1) , (i+1, j) or (i+1, j+1).
When any robot is passing through a cell, It picks it up all cherries, and the cell becomes an empty cell (0).
When both robots stay on the same cell, only one of them takes the cherries.
Both robots cannot move outside of the grid at any moment.
Both robots should reach the bottom row in the grid.


A:
```java
class Solution {
    // TC : O(n*m*m)
    // SC : O(n*m*m)
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        // i => Row index for both the robots
        // j1 => column index for 1st robot
        // j2 => column index for 2nd robot
        Integer[][][] dp = new Integer[n][m][m];

        return dfs(grid, n, m, 0, 0, m-1, dp);
    }

    private int dfs(int[][] grid, int n, int m, int r, int col1, int col2, Integer[][][] dp){
        if(r<0 || r>=n || col1 <0 || col1>=m || col2 <0 || col2>=m){
            return 0;
        }

        if(dp[r][col1][col2]!=null){
            return dp[r][col1][col2];
        }

        int maxCherries = 0;
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                int newCol1 = col1 + i;
                int newCol2 = col2+ j;
                maxCherries = Math.max(maxCherries, dfs(grid, n, m, r+1,newCol1, newCol2, dp ));
            }
        }
        int currCherry = 0;
        if(col1 == col2){
            currCherry = grid[r][col1];
        } else {
            currCherry = grid[r][col1] + grid[r][col2];
        }

        dp[r][col1][col2] = currCherry + maxCherries;
        return dp[r][col1][col2];
    }
    
}
```



### December 20 Decoded String at Index

Q: An encoded string S is given.  To find and write the decoded string to a tape, the encoded string is read one character at a time and the following steps are taken:
If the character read is a letter, that letter is written onto the tape.
If the character read is a digit (say d), the entire current tape is repeatedly written d-1 more times in total.
Now for some encoded string S, and an index K, find and return the K-th letter (1 indexed) in the decoded string.



A:
```java
class Solution {
    public String decodeAtIndex(String S, int K) {
     long size = 0; 
		int n = S.length();

		
		for(char c : S.toCharArray()) {
			if(Character.isDigit(c)){
				size = size * (c-'0');
			}
			else {
				size++;
			}
		}

		for(int i = n-1; i >= 0; i--) {
			char c= S.charAt(i);
			K%=size;
			if((K == 0 || K == size) && Character.isLetter(c)){
				return Character.toString(c);
			}
			if(Character.isDigit(c)){
				size = size / (c-'0');
			}
			else {
				size--;
			}
		}

		return null;   
    }
}
```



### December 21 Smallest Range II

Q: Given an integer array nums, return true if there exists a triple of indices (i, j, k) such that i < j < k and nums[i] < nums[j] < nums[k]. If no such indices exists, return false.


A:
```java
class Solution {
    public int smallestRangeII(int[] A, int K) {
         Arrays.sort(A); 
        int len = A.length -1;
        int lowest = A[0];
        int highest = A[len];
        int res = highest - lowest;
        for(int i=0;i<len;i++){ 
            int min = Math.min(lowest + K, A[i+1] -K);
            int max = Math.max(highest -K, A[i]+K);
            res =  Math.min(max - min, res);
        }
        return res;
    }
}
```



### December 22 Balanced Binary Tree

Q: Given a binary tree, determine if it is height-balanced.
For this problem, a height-balanced binary tree is defined as:
a binary tree in which the left and right subtrees of every node differ in height by no more than 1.


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
    public boolean isBalanced(TreeNode root) {
         if (root == null) return true;
        return  (Math.abs(height(root.left) - height(root.right)) <= 1) && isBalanced(root.left) &&  isBalanced(root.right);
    }
    
    public int height(TreeNode root) {
        if (root == null) return 0;
        return 1+Math.max(height(root.left), height(root.right));
    }
}
```



### December 23 Next Greater Element III

Q: Given a positive integer n, find the smallest integer which has exactly the same digits existing in the integer n and is greater in value than n. If no such positive integer exists, return -1.
Note that the returned integer should fit in 32-bit integer, if there is a valid answer but it does not fit in 32-bit integer, return -1.


A:
```java
class Solution {
    public int nextGreaterElement(int n) {
        
    char[] str = (n+"").toCharArray();

        int deflectionPoint = str.length-1;

        while(deflectionPoint>0){
            if(str[deflectionPoint] > str[deflectionPoint-1]) {
                break;
            }
            deflectionPoint--;
        }
        if(deflectionPoint == 0){
            return -1;
        }

        int firstSwappingIndex = deflectionPoint -1;

        int secondSwappingIndex = str.length -1;
        while(secondSwappingIndex>=firstSwappingIndex){
            if(str[firstSwappingIndex] < str[secondSwappingIndex]) {
                break;
            }
            secondSwappingIndex--;
        }

        // swap

        char temp = str[firstSwappingIndex];
        str[firstSwappingIndex] = str[secondSwappingIndex];
        str[secondSwappingIndex] = temp;

        // swapping at the point of deflection

        reverseChar(str, deflectionPoint);
        Long no = Long.parseLong(new String(str));
        if(no<=Integer.MAX_VALUE){
            return no.intValue();
        } else{
            return -1;
        }

    }

    private void reverseChar(char[] str, int i){
        int start = i;
        int end =str.length-1;
        while(end>=start){
            char temp = str[start];
            str[start] = str[end];
            str[end] = temp;
            end--;
            start++;

        }
    }
}
```




### December 24 Swap Nodes in Pairs

Q: Given a linked list, swap every two adjacent nodes and return its head.
You may not modify the values in the list's nodes. Only nodes itself may be changed.

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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        
      ListNode dummy = new ListNode(-1), prev = dummy, current = head;
        while(current != null && current.next != null) {
            prev.next = current.next;
            current.next = current.next.next;
            prev.next.next = current;
            current = current.next;
            prev = prev.next.next;
        }
        
        return dummy.next;
        
    }
}
```




### December 25 Diagonal Traverse

Q: Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.

A:
```java
class Solution {
    public int[] findDiagonalOrder(int[][] matrix) {
         if (matrix.length == 0)
            return new int[0];

        int m = matrix.length, n = matrix[0].length, r = 0, c = 0;
        int[] result = new int[m * n];

        for (int i = 0; i < result.length; i++) {
            result[i] = matrix[r][c];
            if ((r + c) % 2 == 0) {
                if (c == n - 1) {
                    r++;
                } else if (r == 0) {
                    c++;
                } else {
                    r--;
                    c++;
                }
            } else {
                if (r == m - 1) {
                    c++;
                } else if (c == 0) {
                    r++;
                } else {
                    r++;
                    c--;
                }
            }
        }

        return result;
    }
}
```





### December 26 Decode Ways

Q: A message containing letters from A-Z is being encoded to numbers using the following mapping:
'A' -> 1
'B' -> 2
...
'Z' -> 26
Given a non-empty string containing only digits, determine the total number of ways to decode it.
The answer is guaranteed to fit in a 32-bit integer.

A:
```java
class Solution {
    public int numDecodings(String s) {
     int[] dp = new int[s.length()];
        if(s.charAt(0) == '0'){
            return 0;
        }
        
        dp[0] =1;
        
        for(int i=1;i<s.length();i++){
            int tens = s.charAt(i-1) -'0';// prev char
            int ones = s.charAt(i) -'0';// curr char
            
            if(ones == 0 && tens!=1 && tens!=2){ // 16382284870.......
                
                return 0;
            }
            int no = getNo(tens,ones);
            if(no <=26 && no>=10){
                if(i>=2){
                    dp[i] += dp[i-2];
                } else{ 
                    dp[i] +=1;
                }
            }
            
            if(no!=10 && no!=20){
                dp[i] =dp[i] + dp[i-1];
            }
            
        }
        return dp[s.length()-1];
        
    }
    
    private int getNo(int tens, int ones){
        return 10*tens + ones;
    }
}
```





