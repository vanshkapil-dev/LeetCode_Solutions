class Solution {
    public long subArrayRanges(int[] arr) {
        long largest=sumSubarrayMax(arr);
        long smallest=sumSubarrayMins(arr);
        return largest-smallest;
        }
    public long sumSubarrayMax(int[] arr){
        int[] nge=findNGE(arr);
        int[] pge=findPGE(arr);
        int n=arr.length;
        long largest=0;
        int mod=(int)1e9+7;
        for(int i=0;i<n;i++){
            long left=i-pge[i];
            long right=nge[i]-i;
            largest=largest+(left*right*1L*arr[i]);
        }
        return largest;
    }
    public int[] findNGE(int [] arr){
        int n=arr.length;
        int[] nge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]<arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i]=n;
            }
            else{
                nge[i]=st.peek();
            }
            st.push(i);
        }
        return nge;

    }
    public int[] findPGE(int[] arr){
        int n=arr.length;
        int[] pge=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]<=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                pge[i]=-1;
            }
            else{
                pge[i]=st.peek();
            }
            st.push(i);
        }
        return pge;

    }
    public int[] findNSE(int[] arr){
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
    public int[] findPSE(int [] arr){
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
    public long sumSubarrayMins(int[] arr) {
        int[] nse=findNSE(arr);
        int[] pse=findPSE(arr);
        int n=arr.length;
        long smallest=0;
        int mod=(int) 1e9+7;
        for(int i=0;i<n;i++){
            long left=i-pse[i];
            long right=nse[i]-i;
            smallest=smallest+(left*1L*right*arr[i]);

        }
        return smallest;
        
    }
}