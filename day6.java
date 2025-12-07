class Solution {
    public int candy(int[] ratings) {
        int n=ratings.length;
        int i=1;
        
        int sum=1;
        while(i<n){
            int peak=1;
        while(i<n && ratings[i]>ratings[i-1]){
             peak++;
            sum+=peak;
           
            i++;
            }
        int down=1;
        while(i<n && ratings[i]<ratings[i-1]){
            
            sum+=down;
            down++;
            i++;
        }
        
        if(down>peak){
            sum+=down-peak;
        }
        while(i<n && ratings[i]==ratings[i-1]){
            sum++;
            i++;
        }
        }
        return sum;
        
    }
}