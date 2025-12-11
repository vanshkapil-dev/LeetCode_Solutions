class Solution {
    public int sumSubarrayMins(int[] arr) {
        int[] nse=findNse(arr);
        int[] pse=findPse(arr);
        int n=arr.length;
        long total=0;
        int mod=(int) 1e9+7;
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            total=(total+(left*1L*right*arr[i])%mod)%mod;

        }
        return (int)total;
        
    }
    public int[] findNse(int [] arr){
        int n=arr.length;
        int[] nse=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nse[i]=n;
            }
            else{
                nse[i]=st.peek();
            }
            st.push(i);
        }
        return nse;
    }
    public int[] findPse(int[] arr){
        int n=arr.length;
        Stack<Integer> st= new Stack<>();
        int[] pse=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pse[i]=-1;
            }
            else{
                pse[i]=st.peek();
            }
            st.push(i);
        }
        return pse;
    }
}