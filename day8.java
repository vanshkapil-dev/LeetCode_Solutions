class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n=nums.length;
        int [] ans=new int [n];
        Stack<Integer> st=new Stack<>();
        for(int i=2*n-1;i>=0;i--){
            
            int indx=i%n;
            while(!st.isEmpty() && nums[indx]>=st.peek()){
                st.pop();
            }
            if(i<n){
                ans[indx]=st.isEmpty()?-1:st.peek();
               
            }
            
            st.push(nums[indx]);
            
            
            
            
        }
        return ans;
        
    }
}