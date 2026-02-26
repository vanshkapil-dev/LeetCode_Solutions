//daily temperatures
class Solution {
    public int[] dailyTemperatures(int[] temp) {
        Stack<Integer> st=new Stack<>();
        int n=temp.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temp[i]>temp[st.peek()]){
                int prev=st.pop();
                ans[prev]=i-prev;
            }
            st.push(i);
        }
        return ans;

        
    }
}
//largest rectangle in histogram
class Solution {
    public int largestRectangleArea(int[] heights) {
        
        int n=heights.length;
        Stack<Integer> st=new Stack<>();
        int maxArea=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && heights[i]<heights[st.peek()]){
                int element=heights[st.pop()];
                int pse=(st.isEmpty())?-1:st.peek();
                int nse=i;
                maxArea=Math.max(maxArea,element*(nse-pse-1));
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int ele=heights[st.pop()];
            int nse=n;
            int pse=(st.isEmpty())?-1:st.peek();
            maxArea=Math.max(maxArea,ele*(nse-pse-1));
        }
        return maxArea;
    }
}