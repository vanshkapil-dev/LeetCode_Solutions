class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int leftmax=0;
        int rightmax=0;
        int total=0;
        int l=0;
        int r=n-1;
        while(l<r){
            if(height[l]<=height[r]){
                if(leftmax>height[l]){
                    total+=leftmax-height[l];
                }
                else{
                    leftmax=height[l];
                }
                l=l+1;

            }
            else{
                if(rightmax>height[r]){
                    total+=rightmax-height[r];
                }
                else{
                    rightmax=height[r];
                }
                r=r-1;
            }
        }
        return total;
        
    }
}