//longest consecutive sequence in an array
class Solution {
    public int longestConsecutive(int[] nums) {
        int n=nums.length;
        HashSet<Integer> set=new HashSet<>();
        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }
        int cnt=0;
        int maxlen=0;
       for(int num:set){
        if(!set.contains(num-1)){
            int x=num;
            cnt=1;
            while(set.contains(x+1)){
                x=x+1;
                cnt++;
            }
            maxlen=Math.max(maxlen,cnt);
        }
       }
       return maxlen;
    }
}
//most consecutive ones in an array with at most k flips
class Solution {
    public int longestOnes(int[] nums, int k) {
        int n=nums.length;
        int l=0;
        int r=0;
        int cnt=0;
        int maxlen=Integer.MIN_VALUE;
        while(r<n){
            if(nums[r]==0) cnt++;
            
            
            
            while(cnt>k){
                if(nums[l]==0)cnt--;
                l++;

            }
            maxlen=Math.max(maxlen,(r-l)+1);
            r++;

        }
        return maxlen;
        
    }
}