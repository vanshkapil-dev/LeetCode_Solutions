//----------------------------------------------
//--  Day 31: Kth Smallest Element in a BST  --
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
     int count=0;
     int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        kth(root,k);
        return ans;
        
    }
    public  void kth(TreeNode root, int k){
        if(root==null || ans!=-1) return;
        kth(root.left,k);
        if(ans!=-1) return;
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        kth(root.right,k);
    }
}
//----------------------------------------------
//-- Day 32: Lowest Common Ancestor of a BST --
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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(p.val<root.val && q.val<root.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        if(p.val>root.val && q.val>root.val){
            return lowestCommonAncestor(root.right,p,q);
        }
        return root;

        
    }
}