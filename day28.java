//Check if a Knight's Tour is Valid
class Solution {
    public boolean checkValidGrid(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]!=0) return false;
        int[][]pos=new int[n*n][2];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                pos[grid[i][j]][0]=i;
                pos[grid[i][j]][1]=j;
            }
        }
        for(int i=0;i<n*n-1;i++){
            int r1=pos[i][0],c1=pos[i][1];
            int r2=pos[i+1][0],c2=pos[i+1][1];
            int ans1=Math.abs(r2-r1);
            int ans2=Math.abs(c2-c1);
            if(!((ans1==1 && ans2==2)||(ans1==2 && ans2==1))){
                return false;
            }
        }
        return true;
        
    }
}
//PTOD Four Divisors
class Solution {
    
    public int sumFourDivisors(int[] nums) {
        int totalsum=0;
        for(int num:nums){
            int sum=0;
            int cnt=0;
            for(int i=1;i*i<=num;i++){
                if(num % i == 0){
                    int other=num/i;
                    sum+=i;
                    cnt++;
                   if(other!=i){
                    sum+=other;
                    cnt++;
                   }
                }
                if(cnt>4) break;
                
            }
            if(cnt==4){
                totalsum+=sum;
                
            
            }

        }
        return totalsum;
        
    }
}