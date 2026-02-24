//--------------------------Sudoku Solver-------------------------
class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }
    public boolean solve(char[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]=='.'){
                    for(char c='1';c<='9';c++){
                        if(isValid(board,i,j,c)){
                        board[i][j]=c;
                        if(solve(board)==true){
                            return true;
                        }
                        else{
                            board[i][j]='.';
                        }
                        }
                    }
                    return false;
                    
                }
                
            }
        }
        return true;
        
    }
    public boolean isValid(char[][] board,int i,int j,char c){
        for(int k=0;k<9;k++){
            if(board[i][k]==c) return false;
            if(board[k][j]==c) return false;
            if(board[3*(i/3)+k/3][3*(j/3)+k%3]==c) return false;
            
        }
        return true;
    }
}
//--------------------------N-Queens-------------------------
class Solution {
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