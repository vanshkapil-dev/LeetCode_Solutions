//----------------------------------
// zigzagLevelOrder
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        
        List<List<Integer>> result= new ArrayList<>();
        if(root==null) return result;
        Queue<TreeNode> q=new LinkedList<>();
        boolean flag=true;
        q.add(root);
        while(!q.isEmpty()){
            
            int size=q.size();
            List<Integer> lvl=new ArrayList<>(size);
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                if(flag){
                    lvl.add(node.val);
                }
                else{
                    lvl.add(0,node.val);
                }
                if(node.left!=null){
                    q.add(node.left);
                }

            
                if(node.right!=null){
                    q.add(node.right);
                }
                

            
            }
                result.add(lvl);
                flag=!flag;
            
            
        }
        return result;


        
    }
}
//----------------------------------
// Binary Tree Maximum Path Sum--------------------------------
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
    public int maxsum=Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        int ans=helper(root);
        return maxsum;

        
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int left=Math.max(0,helper(root.left));
        int right=Math.max(0,helper(root.right));
        maxsum=Math.max(maxsum,root.val+(left+right));
        return root.val+Math.max(left,right);
        
    }
}