//Smallest String Starting From Leaf
//RunTime 57ms; Memory 39MB

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
    public String smallestFromLeaf(TreeNode root) {
        TreeNode prev=null, curr=null;
        char ch;
        Stack<TreeNode> s = new Stack<TreeNode>();
        s.push(root);
        StringBuffer str = new StringBuffer();
        String min = new String();
        curr = root;
        ch = (char)('a' + curr.val);
        str.insert(0, ch);
        while(!s.empty())    {        
            curr = s.peek();
            if(prev==null || prev.left==curr || prev.right==curr){
                System.out.println("1"+"-----"+str);
                if(curr.left !=null){
                    s.push(curr.left);
                    ch = (char)('a' + (curr.left).val);
                    str.insert(0, ch);
                }                    
                else if(curr.right !=null){
                    s.push(curr.right);
                    ch = (char)('a' + (curr.right).val);
                    str.insert(0, ch);
                }                    
                else{
                    min = (min.isEmpty() || min.compareTo(str.toString())>0)?str.toString():min;
                    str.deleteCharAt(0);
                    s.pop();
                }
            }
            else if(curr.left ==prev){
                System.out.println("2"+"-----"+str);
                if(curr.right !=null){
                    ch = (char)('a' + (curr.right).val);
                    str.insert(0, ch);
                    s.push(curr.right);
                }                    
            }
            else{
                System.out.println("3"+"-----"+str);
                str.deleteCharAt(0);
                s.pop();
            }
            prev = curr;
                               
            }
        return min;
    }
}
