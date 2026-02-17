//-------------------------Combination Sum-------------------------

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combinations(candidates,target,new ArrayList<>(),ans,0);
        return ans;
        
    }
    public void combinations(int[] candidates, int target, List<Integer> list, List<List<Integer>> ans, int indx){
        if(target==0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(target<0){
            return;
        }
        for(int i=indx;i<candidates.length;i++){
            list.add(candidates[i]);
            combinations(candidates,target-candidates[i],list,ans,i);
            list.remove(list.size()-1);
        }
    }
}
//-------------------------Subsets-------------------------


class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        helper(nums,0,ans,new ArrayList<>());
        return ans;
        
    }
    public void helper(int[] nums, int i,List<List<Integer>> ans, List<Integer> list){
        if(i==nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[i]);
        helper(nums,i+1,ans,list);
        list.remove(list.size()-1);
        helper(nums,i+1,ans,list);

    }
}