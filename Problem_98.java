//Validate Binary Search Tree
//Runtime 23ms, Memory 39MB

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
        return inRange(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }    
    
    boolean inRange(TreeNode root, long min, long max){
        if(root == null)
              return true;
        boolean cond = root.val>min && root.val<max;
        System.out.println(root.val+"   "+cond);
        if(root.left !=null)
            cond = cond && inRange(root.left, min, root.val) && root.left.val<root.val;
        if(root.right !=null)
            cond = cond && inRange(root.right, root.val, max) && root.right.val>root.val;
        return cond;              
    }
}
