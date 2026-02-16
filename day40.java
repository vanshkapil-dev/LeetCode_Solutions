//-------------------------Reverse Words in a String-------------------------
class Solution {
    public String reverseWords(String s) {
        if(s.length()==0) return "";
        String[] arr=s.trim().split("\\s+");
        StringBuilder ans=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--){
            ans.append(arr[i]);
            if(i!=0)ans.append(" ");

        }
        return ans.toString();

    }
}
//-------------------------Valid Anagram-------------------------
class Solution {
    public boolean isAnagram(String s, String t) {
        int n1=s.length();
        int n2=t.length();
        if(n1!=n2) return false;
        int [] temp=new int [26];
        for(int i=0;i<n1;i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            temp[ch1-'a']++;
            temp[ch2-'a']--;
        }
        for(int i=0;i<26;i++){
            if(temp[i]!=0) return false;
        }
        return true;

    }
}
