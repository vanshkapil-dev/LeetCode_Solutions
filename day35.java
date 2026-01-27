//--------------------------------root to leaf paths in Binary Tree--------------------------------
/*

Definition for Binary Tree Node
class Node
{
    int data;
    Node left;
    Node right;

    Node(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }
}
*/

class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        // code here
        ArrayList<ArrayList<Integer>> ans=new ArrayList<>();
        paths(root,ans, new ArrayList<>());
        return ans;
    }
    public static void paths(Node root,ArrayList<ArrayList<Integer>> ans,ArrayList<Integer> path ){
        if(root==null) return;
        path.add(root.data);
        if(root.left==null && root.right==null){
            ans.add(new ArrayList<>(path));
        }
        else{
            paths(root.left,ans,path);
            paths(root.right,ans,path);
        }
        path.remove(path.size()-1);
    }
}
//----------------------------------Boundary Traversal of binary tree--------------------------------
/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node root) {
        // code here
        ArrayList<Integer> ans=new ArrayList<>();
        if(isLeaf(root)==false) ans.add(root.data);
        left(root,ans);
        leafs(root,ans);
        right(root,ans);
        return ans;
    }
    void left(Node root, ArrayList<Integer> ans){
        Node curr=root.left;
        while(curr!=null){
            if(isLeaf(curr)==false){
                ans.add(curr.data);
            }
            if(curr.left!=null) curr=curr.left;
            else curr=curr.right;
        }
    }
    void right(Node root, ArrayList<Integer> ans){
        Node curr=root.right;
        ArrayList<Integer> temp=new ArrayList<>();
        while(curr!=null){
            if(isLeaf(curr)==false) temp.add(curr.data);
            if(curr.right!=null) curr=curr.right;
            else curr=curr.left;
            
        }
        for(int i=temp.size()-1;i>=0;i--){
            ans.add(temp.get(i));
        }
    }
    boolean isLeaf(Node root){
        
        if(root.left==null && root.right==null) return true;
        return false;
        
    }
    void leafs(Node root,ArrayList<Integer> ans){
        if(isLeaf(root)){
            ans.add(root.data);
            return;
        }
        if(root.left!=null) leafs(root.left,ans);
        if(root.right!=null) leafs(root.right,ans);
    }
    
}