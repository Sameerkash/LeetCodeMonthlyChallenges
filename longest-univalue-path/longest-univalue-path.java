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
    
    int len = 0;
    public int longestUnivaluePath(TreeNode root) {
        if(root == null) return 0;
        
         dfs(root, root.val);
        return len;
    }
    
    int dfs(TreeNode root, int value){    
        if(root == null) return 0;
            int Llen = dfs(root.left, root.val);
            int Rlen = dfs(root.right, root.val);
            len = Math.max(len, Llen+Rlen);
                if(root.val == value) return Math.max(Llen, Rlen) +1;
        return 0;
    }
}