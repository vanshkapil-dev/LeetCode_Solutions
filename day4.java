class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res=new ArrayList<>();
        if(digits==null || digits.length()==0) return new ArrayList<>();

        HashMap<Integer,String> map=new HashMap<>();
        map.put(2,"abc");
        map.put(3,"def");
        map.put(4,"ghi");
        map.put(5,"jkl");
        map.put(6,"mno");
        map.put(7,"pqrs");
        map.put(8,"tuv");
        map.put(9,"wxyz");
        StringBuilder comb=new StringBuilder();
        backtrack(digits,map,0,comb,res);

        return res;


        
    }
    public void backtrack(String digits,HashMap<Integer,String> map, int indx,StringBuilder comb,List<String> res){
        if(indx==digits.length()){
            res.add(comb.toString());
            return;
        }
        String letters=map.get(digits.charAt(indx)-'0');
        for(char letter:letters.toCharArray()){
            comb.append(letter);
            backtrack(digits,map,indx+1,comb,res);
            comb.deleteCharAt(comb.length()-1);

        }
    }
}