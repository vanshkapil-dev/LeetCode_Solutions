class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        combinations(candidates,target,ans,0,new ArrayList<>());
        return ans;
        
        
    }
    public static void combinations(int[] candidates, int target,List<List<Integer>> ans, int indx,List<Integer> list){
        if(target==0){
            ans.add(new ArrayList<>(list));
            
            return;
        }
        if(target<0){
           
           return ; 
        } 
        for(int i=indx;i<candidates.length;i++){
            
            list.add(candidates[i]);
            combinations(candidates,target-candidates[i],ans,i,list);
            list.remove(list.size()-1);
        }
        

    }
}