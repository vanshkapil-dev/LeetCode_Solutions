//--- Leetcode 239. Sliding Window Maximum

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        
        int[] ans=new int[n-k+1];
        int indx=0;
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<n;i++){
            //remove the elements out of the window
            if(!dq.isEmpty() && dq.peekFirst()==i-k){
                dq.pollFirst();
            }
            //remove the invalid elements from the last
            while(!dq.isEmpty() && nums[dq.peekLast()]<=nums[i]){
                dq.pollLast();
            }
            dq.offer(i);
            if(i>=k-1){
                ans[indx++]=nums[dq.peekFirst()];
            }
        }
        return ans;
        
    }
}