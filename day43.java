//-----------------------Two Sum-2-------------------------
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int n=nums.length;
        int k=target;
        

        for(int i=0; i<n;i++){
            if(map.containsKey(k-nums[i])){
                return new int[] {i,map.get(k-nums[i])};
            }
            map.put( nums[i],i);
        }
        return new int[] {-1,-1};        
    }
}
//--------------------------Container With Most Water-------------------------
class Solution {
    public int maxArea(int[] height) {
        int n=height.length;
        int left=0;
        int right=n-1;
        int maxWater=Integer.MIN_VALUE;
        while(left<right){
            int width=right-left;
            int h=Math.min(height[left],height[right]);
            maxWater=Math.max(maxWater,width*h);
            if(height[left]<height[right]){
                left++;
            }
            else right--;
        }
        return maxWater;

    }
}