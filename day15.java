class Solution {
    public boolean isSafe(char[][] board, int n, int row,int col){
        //horizontal
        for(int i=0;i<n;i++){
          if(board[row][i]=='Q'){
            return false;
         }  
        }
        //vertical
        for(int i=0;i<n;i++){
            if(board[i][col]=='Q'){
                return false;
            }

        }
        //left diagonal
        for(int i=row , j=col;i>=0 && j>=0;i--,j--){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        //right diagonal
        for(int i=row ,j=col ; i>=0 && j<n;i-- , j++){
            if(board[i][j]=='Q'){
                return false;
            }
        }
        return true;
         

    }
    public void NQueens(char[][] board,List<List<String>> ans,int n, int row){
        if(row==n){
            List<String> temp=new ArrayList<>();
            for(int i=0;i<n;i++){
                temp.add(new String(board[i]));
            }
            ans.add(temp);
            return;
        }


        for(int j=0;j<n;j++){
            if(isSafe(board,n,row,j)){
                board[row][j]='Q';
                NQueens(board,ans,n,row+1);
                board[row][j]='.';
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        char[][] board=new char[n][n];
        List<List<String>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            Arrays.fill(board[i],'.');
        }
        NQueens(board,ans,n,0);
        return ans;

        
    }
}