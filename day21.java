class Solution {
    public int[][] kClosest(int[][] points, int k) {
    int n=points.length;
    PriorityQueue<int[]> maxHeap=new PriorityQueue<>((e1,e2)->Integer.compare(e2[0],e1[0]));
    for(int i=0;i<n;i++){
        int a=points[i][0]*points[i][0];
        int b=points[i][1]*points[i][1];
        int dist=a+b;
        maxHeap.add(new int[]{dist,i});
        if(maxHeap.size()>k) maxHeap.poll();

    }
    int ans[][]=new int[k][2];
    for(int i=0;i<k;i++){
        ans[i]=points[maxHeap.poll()[1]];
        
    }
    return ans;
        
    }
}