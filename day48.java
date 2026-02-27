//n-queens 2
class Solution {
    public int cnt=0;
    public int totalNQueens(int n) {
        solveNQueens( n);
        
        return cnt;
        
    }
    
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                board[i][j]='.';
            }
        }
        placeQ(board, ans,0);
        return ans;
        
    }
    public void placeQ(char[][] board, List<List<String>> ans, int r){
        if(r==board.length){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<board.length;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            cnt++;
        }
        int col=board[0].length;
        for(int i=0;i<col;i++){
            if(isSafe(board,r,i)==true){
               board[r][i]='Q';
            placeQ(board,ans,r+1);
            board[r][i]='.'; 
            }
            
        }

    }
    public boolean isSafe(char[][] board, int r, int col){
        int n=board.length;
        //top
        for(int i=r-1;i>=0;i--){
            if(board[i][col]=='Q') return false;
        }
        //left diagonal
        for(int i=r-1,j=col-1;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q') return false;
        }
        //right diagonal
        for(int i=r-1,j=col+1;i>=0 && j<n;i--,j++){
            if(board[i][j]=='Q') return false;
        }
        return true;

    }

}
//next greater element 1
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n2=nums2.length;
        int n1=nums1.length;
        Stack<Integer> st=new Stack<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        int[] ans=new int[n1];
        for(int i=n2-1;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i]){
                st.pop();
            }
            if(!st.isEmpty() && nums2[i]<st.peek()){
                map.put(nums2[i],st.peek());
            }
            else{
                map.put(nums2[i],-1);
            }
            st.push(nums2[i]);
        }
        for(int i=0;i<n1;i++){
            ans[i]=map.get(nums1[i]);
        }
        return ans;

        
    }
}