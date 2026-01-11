//------------------------------Construction of Binary Tree from Preorder and Inorder Traversal---------------------------------
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
    public int preindx=0;
    public HashMap<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        return build(preorder,0,preorder.length-1);
    }
    public TreeNode build(int[] preorder, int preStart, int preEnd){
            if(preStart>preEnd) return null;
            int rootval=preorder[preindx++];
            
            TreeNode temp=new TreeNode(rootval);
            int mid=map.get(rootval);
            temp.left=build(preorder,preStart,mid-1);
            temp.right=build(preorder,mid+1,preEnd);
            return temp;

            
        }
        
    }

//--------------------------------Construction of Binary Tree from Inorder and Postorder Traversal--------------------------------

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
    public int indx;
    public HashMap<Integer,Integer> map=new HashMap<>();

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        indx=postorder.length-1;
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
            
        }
        return build(postorder,0,postorder.length-1);
    }
    public TreeNode build(int [] postorder, int postStart, int postEnd){
        if(postStart>postEnd) return null;
        
        int rootval=postorder[indx--];
        TreeNode root=new TreeNode(rootval);
        int mid=map.get(rootval);
        root.right=build(postorder,mid+1,postEnd);
        root.left=build(postorder,postStart,mid-1);
        
        return root;
        
        
        

        }
        ///////
        
    
}