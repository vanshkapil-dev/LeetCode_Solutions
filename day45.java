//Find All Anagrams in a String
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans=new ArrayList<>();
        int n1=p.length();
        
        if(n1>s.length()) return ans;//edge casee

        int[] freq1=new int[26];
        //build frequency array of p
        for(int i=0;i<n1;i++){
            char ch=p.charAt(i);
            freq1[ch-'a']++;

        }

        int l=0;
        int r=0;
        int[] freq2=new int[26];
        //build freq array of first window of p.length() size inside s

        for(int k=r;k<n1;k++){
            char ch=s.charAt(k);
            freq2[ch-'a']++;

        }
        //if it equals add the first index to ans
        if(Arrays.equals(freq1,freq2)){
            ans.add(l);
        }
        r=n1-1;
        //move the fixed window
        while(r<s.length()-1){
            char ch1=s.charAt(l);
            //remove the character from left
            freq2[ch1-'a']--;
            l++;
            r++;
            //add the new character from right
            char ch2=s.charAt(r);
            freq2[ch2-'a']++;
            //keep checking if it equals
            if(Arrays.equals(freq1,freq2)){
            ans.add(l);
        }


        }
        return ans;
        
    }
}
//Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> set=new HashSet<>();
        int maxlen=0;
        int i=0;
        for(int j=0;j<s.length();j++){
            char ch=s.charAt(j);
            while(set.contains(ch)){
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            maxlen=Math.max(maxlen,(j-i)+1);
        }
        return maxlen;
    }
}