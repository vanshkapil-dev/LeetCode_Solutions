//----------------------------------------------
// 424. Longest Repeating Character Replacement
class Solution {
    public int characterReplacement(String s, int k) {
        int i=0;
        int maxlen=0;
        int[] cnt=new int[26];
        int maxcnt=Integer.MIN_VALUE;
        int n=s.length();
        for(int j=0;j<n;j++){
            cnt[s.charAt(j)-'A']++;

            maxcnt=Math.max(maxcnt,cnt[s.charAt(j)-'A']);
            while(((j-i+1)-maxcnt)>k){
                cnt[s.charAt(i)-'A']--;
                i++;
                
            }maxlen=Math.max(maxlen,j-i+1);


        }
        return maxlen;
    }
}
// 567. Permutation in String
class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int [] freq1=new int[26];
        int [] freq2= new int[26];
        int len=s1.length();
        int l=0;
        int r=0;
        for(int i=0;i<len;i++){
            freq1[s1.charAt(i)-'a']++;
        }
        while(r<s2.length()){
            freq2[s2.charAt(r)-'a']++;

            if(r-l+1 >len){
                freq2[s2.charAt(l)-'a']--;
                l++;
            }
            if(r-l+1 == len){
                if(Arrays.equals(freq1,freq2)) return true;
            }
            r++;


        }
        return false;
        
        
    }
}