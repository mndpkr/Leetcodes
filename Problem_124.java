//124. Binary Tree Maximum Path Sum
//Runtime: 49 ms, Memory Usage: 43.8 MB
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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        findMaxPathSum(root);
        return max; 
    }
    
    public int findMaxPathSum(TreeNode root) {
        int maxLeft, maxRight, local;
        if(root.left==null && root.right==null){
            max = max<root.val?root.val:max;
            return root.val;
        }     
        else if(root.left==null){
            System.out.println(root.val+"  -ln--  "+max);
            maxRight = findMaxPathSum(root.right);
            local = (maxRight<0)?0:maxRight;
            max = (max<local+root.val)?local+root.val:max;  
            return local+root.val;
        }
        else if(root.right==null){
            System.out.println(root.val+"  --rn-  "+max);
            maxLeft = findMaxPathSum(root.left);
            local = (maxLeft<0)?0:maxLeft;
            max = (max<local+root.val)?local+root.val:max;      
            return local+root.val;
        }
        else{
            maxLeft = findMaxPathSum(root.left);
            maxRight = findMaxPathSum(root.right);
            System.out.println(root.val+"  ---  "+maxLeft+"   ----   "+maxRight);
            if(maxLeft<0 && maxRight<0 && root.val>=0){
                max = max<root.val?root.val:max;
                return root.val;
            }
            local = maxLeft>maxRight?maxLeft:maxRight;
            max = max<(local+root.val)?(local+root.val):max;
            max = (maxLeft+maxRight+root.val) > max? (maxLeft+maxRight+root.val):max;
            return local+root.val;
        }
    }
}
