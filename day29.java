//-------------------Generate Parentheses-------------------//
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans=new ArrayList<>();
        generate(ans,0,0,"",n);
        return ans;
        
    }
    public static void generate(List<String> ans, int open, int close,String str,int n){
        if(close>open) return;
        if(open>n) return;
        if((open==close) &&(close==n)){
            ans.add(str);
            return;
        }
        generate(ans,open+1,close,str+"(",n);
        generate(ans,open,close+1,str+")",n);
        

    }
}
//-------------------PTOD Maximize Matrix Sum-------------------//
class Solution {
    public long maxMatrixSum(int[][] matrix) {
        int min=Integer.MAX_VALUE;
        int cnt=0;
        long sum=0;
        int n=matrix.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                sum+=Math.abs(matrix[i][j]);
                if(matrix[i][j]<0){
                    cnt++;
                   
                } min=Integer.min(min,Math.abs(matrix[i][j]));
            }
        }
        if(cnt%2==0){
            return sum;
        }
        return sum-2*min;


        
    }
}