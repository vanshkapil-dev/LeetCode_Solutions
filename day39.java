//--------------------All Nodes Distance K in Binary Tree----------------------
//**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> parents=new HashMap<>();
        markParent(root,parents);
        Queue<TreeNode> q=new LinkedList<>();
        Map<TreeNode,Boolean> visited=new HashMap<>();
        q.offer(target);
        visited.put(target,true);
        int dist=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(dist==k) break;
            dist++;
            for(int i=0;i<size;i++){
                TreeNode curr=q.poll();
                if(curr.left!=null && visited.get(curr.left)==null){
                    q.offer(curr.left);
                    visited.put(curr.left,true);
                }
                if(curr.right!=null && visited.get(curr.right)==null){
                    q.offer(curr.right);
                    visited.put(curr.right,true);
                }
                if(parents.get(curr)!=null && visited.get(parents.get(curr))==null){
                    q.offer(parents.get(curr));
                    visited.put(parents.get(curr),true);
                }
            }

        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode curr=q.poll();
            ans.add(curr.val);

        }
        return ans;
        
    }
    public void markParent(TreeNode root,Map<TreeNode,TreeNode> parents){
        Queue<TreeNode> q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
           TreeNode curr=q.poll();
           if(curr.left!=null){
            parents.put(curr.left,curr);
            q.offer(curr.left);
           }
           if(curr.right!=null){
            parents.put(curr.right,curr);
            q.offer(curr.right);
           }

        
        }
        
    }
}
//--------------------Count Complete Tree Nodes----------------------
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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left=getleftH(root);
        int right=getrightH(root);
        if(left==right) return (2<<(left))-1;
        else return 1 + countNodes(root.left) + countNodes(root.right);
        
    }
    public int getrightH(TreeNode root){
        int count=0;
        while(root.right!=null){
            count++;
            root=root.right;
        }
        return count;
    }
    public int getleftH(TreeNode root){
        int count=0;
        while(root.left!=null){
            count++;
            root=root.left;
        }
        return count;
    }
}