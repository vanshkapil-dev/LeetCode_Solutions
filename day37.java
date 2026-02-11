//---------widthOfBinaryTree-------------------
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
class Pair{
    TreeNode node;
    int indx;
    Pair(TreeNode node,int indx){
        this.node=node;
        this.indx=indx;
    }
}
class Solution {

    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair> q=new LinkedList<>();
        int width=0;
        q.offer(new Pair(root,0));
        while(!q.isEmpty()){
            int size=q.size();
            int mmin=q.peek().indx;
            int first=0,last=0;

            for(int i=0;i<size;i++){
                int curr_indx=q.peek().indx-mmin;
                TreeNode node=q.peek().node;
                q.poll();
                if(i==0) first=curr_indx;
                if(i==size-1) last=curr_indx;
                if(node.left!=null) q.offer(new Pair(node.left,curr_indx*2+1));
                if(node.right!=null) q.offer(new Pair(node.right,curr_indx*2+2));
            }
            width=Math.max(width,last-first+1);
        }
        return width;
        
    }
}
//-------------------Children Sum Property----------------------
/*
class Node{
    int data;
    Node left,right;

    Node(int key)
    {
        data = key;
        left = right = null;
    }
}
*/
class Solution {
    public boolean isSumProperty(Node root) {
        //  code here
        if(root==null) return true;
        if(root.left==null && root.right==null) return true;
        int sum=0;
        if(root.left!=null) sum+=root.left.data;
        if(root.right!=null) sum+=root.right.data;
        if(sum!=root.data) return false;
        return isSumProperty(root.left) && isSumProperty(root.right);
        
        
    }
}