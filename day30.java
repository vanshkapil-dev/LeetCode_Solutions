//----------------------------longest substring without repeating characters----------------------------//
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int maxlen=0;
        int i=0;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            
            while(set.contains(ch)){
                 set.remove(s.charAt(i));
                 i++;
            }set.add(ch);
            maxlen=Math.max(maxlen,(j-i)+1);
           


        }
        return maxlen;
        
    }
}

//------------------------------binary tree maximum level sum----------------------------//

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
    public int maxLevelSum(TreeNode root) {
        int max=Integer.MIN_VALUE;
        int anslvl=1;
        int lvl=1;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            int levelsum=0;
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                levelsum+=node.val;

                if(node.left !=null) q.add(node.left);
                if(node.right !=null) q.add(node.right);

                
            }
            if(levelsum>max){
                    max=levelsum;
                    anslvl=lvl;
                }
                

            lvl++;
        }

        return anslvl;
    }
}