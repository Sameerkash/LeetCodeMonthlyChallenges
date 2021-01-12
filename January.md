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

- [January6 - Kth Missing Positive Number](#january-6-kth-missing-positive-number) [Try it out!](https://leetcode.com/problems/kth-missing-positive-number)
- [January7 - Longest Substring Without Repeating Characters](#january-7-longest-substring-without-repeating-characters) [Try it out!](https://leetcode.com/problems/longest-substring-without-repeating-characters)
- [January8 - Check If Two String Arrays are Equivalent](#january-8-check-if-two-string-arrays-are-equivalent) [Try it out!](https://leetcode.com/problems/check-if-two-string-arrays-are-equivalent)
- [January9 - Word Ladder](#january-9-word-ladder) [Try it out!](https://leetcode.com/problems/word-ladder)
- [January10 - Create Sorted Array through Instructions](#january-10-create-sorted-array-through-instructions) [Try it out!](https://leetcode.com/problems/create-sorted-array-through-instructions)
- [January11 - Merge Sorted Array](#january-11-merge-sorted-array) [Try it out!](https://leetcode.com/problems/merge-sorted-array)
<!-- - [January12 - ]() [Try it out!](https://leetcode.com/problems/) -->

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

### January 6 Kth Missing Positive Number

Q: Given an array arr of positive integers sorted in a strictly increasing order, and an integer k.

Find the kth positive integer that is missing from this array.

A:

```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        int low = 0;
        int high = arr.length;
        while(low<high){
            int mid = (high -low)/2 + low;

            if(arr[mid] -(mid +1) >= k){
                high = mid;
            } else{
                low =mid+1;
            }
        }

        return low +k;

    }
}
```

### January 7 Longest Substring Without Repeating Characters

Q: Given a string s, find the length of the longest substring without repeating characters.

A:

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
           int r = 0;
        int l = 0;
        int res = 0;
        Set<Character> set = new HashSet<>();
        while(r < s.length()){
            if(set.contains(s.charAt(r))){
                set.remove(s.charAt(l++));
            }
            else{
                set.add(s.charAt(r++));
                res = Math.max(res,set.size());
            }
        }

        return res;


    }
}
```

### January 8 Check If Two String Arrays are Equivalent

Q: Given two string arrays word1 and word2, return true if the two arrays represent the same string, and false otherwise.

A string is represented by an array if the array elements concatenated in order forms the string.

A:

```java
class Solution {
    public boolean arrayStringsAreEqual(String[] word1, String[] word2) {


        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();

        for(String ch : word1){
            s1.append(ch);
        }

          for(String ch : word2){
            s2.append(ch);
        }
        if(s1.toString().equals(s2.toString())) return true;
        else return false;
    }
}
```

### January 9 Word Ladder

Q: Given two words beginWord and endWord, and a dictionary wordList, return the length of the shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time.
Each transformed word must exist in the word list.
Return 0 if there is no such transformation sequence.

A:

```java
class Solution {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {

    if(!wordList.contains(endWord)) return 0;

    Set<String> beginSet=new HashSet<>();
    Set<String> endSet=new HashSet<>();
    Set<String> wordSet=new HashSet<>(wordList);
    beginSet.add(beginWord);
    endSet.add(endWord);
    return bfs(beginSet,endSet,wordSet,1);
  }

  int bfs(Set<String> beginSet,Set<String> endSet,Set<String> wordSet,int distance){


    if(beginSet.size()>endSet.size()){
      return bfs(endSet,beginSet,wordSet,distance);
    }

    Set<String> reachableWords=new HashSet<>();
    wordSet.removeAll(beginSet);
    for(String word:beginSet){
      for(int pos=0;pos<word.length();pos++){
        char[] charArray=word.toCharArray();
        for(char c='a';c<='z';c++){
          charArray[pos]=c;

          String newWord=new String(charArray);
          if(wordSet.contains(newWord)){
            if(endSet.contains(newWord)){
              return distance + 1;
            }
            reachableWords.add(newWord);

          }
        }
      }
    }
    distance++;
    if(reachableWords.size()==0){
      return 0;
    }
    else{
      return bfs(reachableWords,endSet,wordSet,distance);
    }
  }
}


```

### January 10 Create Sorted Array through Instructions

Q: Given an integer array instructions, you are asked to create a sorted array from the elements in instructions. You start with an empty container nums. For each element from left to right in instructions, insert it into nums. The cost of each insertion is the minimum of the following:

The number of elements currently in nums that are strictly less than instructions[i].
The number of elements currently in nums that are strictly greater than instructions[i].
For example, if inserting element 3 into nums = [1,2,3,5], the cost of insertion is min(2, 1) (elements 1 and 2 are less than 3, element 5 is greater than 3) and nums will become [1,2,3,3,5].

Return the total cost to insert all elements from instructions into nums. Since the answer may be large, return it modulo 109 + 7

A:

```java

class Solution {
   public int createSortedArray(int[] instructions) {
        Fenwick tree = new Fenwick(100002);
        long cost = 0;
        long MOD = 1000000007;

        for (int i = 0; i < instructions.length; i++) {
            int leftCost = tree.query(instructions[i] - 1);
            int rightCost = i - tree.query(instructions[i]);
            cost += Math.min(leftCost, rightCost);
            tree.add(instructions[i], 1);
        }

        return (int) (cost % MOD);
    }
}

    class Fenwick {
        int[] tree;
        int m;
        public Fenwick(int size) {
            tree = new int[size];
            m = size;
        }

        public void add(int index, int value) {
            while (index < m) {
                tree[index] += value;
                index += index & -index;
            }
        }

        public int query(int index) {
            int result = 0;
            while (index > 0) {
                result += tree[index];
                index -= index & -index;
            }
            return result;
        }
    }Î
```

### January 11 Merge Sorted Array

Q: Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

The number of elements initialized in nums1 and nums2 are m and n respectively. You may assume that nums1 has enough space (size that is equal to m + n) to hold additional elements from nums2.

A:

```java
class Solution {
     public void merge(int[] nums1, int m, int[] nums2, int n) {
      int p1 = m-1; int p2 = n-1; int i = m+n-1;

        while(p2 >= 0){

            if(p1>=0 && nums1[p1] > nums2[p2]){
                nums1[i--] = nums1[p1--];
            }else{
                nums1[i--] = nums2[p2--];

            }
        }
    }
}
```

<!--
### January

Q:

A:

```java

``` -->
