//--------------------------------Valid Binary Search Tree-------------------------------
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
        return valid(root,Long.MIN_VALUE,Long.MAX_VALUE);
        
    }
    public static boolean valid(TreeNode root,long min, long max){
        if(root==null) return true;
        if(root.val<=min || root.val>=max) return false;

        return valid(root.left,min,root.val) && valid(root.right,root.val,max);
    }
}
//
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
//-------------------------------Diameter of Binary Tree--------------------------------
class Solution {
    public static int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
        diameter=0;
        height(root);
        return diameter;

        
        
    }
    public static int height(TreeNode root){
        if(root==null) return 0;
        
        int lh=height(root.left);
        int rh=height(root.right);
        diameter=Math.max(diameter,lh+rh);

       
        return 1+Math.max(lh,rh);
    }

}