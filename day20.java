class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<int[]> pq=new PriorityQueue<>((e1,e2)->e1[0]-e2[0]);
        int rows=matrix.length;
        int cols=matrix[0].length;
        for(int i=0;i<rows;i++){
            pq.add(new int[]{
                matrix[i][0],
                i,
                0
            });
        }
        for(int i=1;i<=k-1;i++){
            int[] min=pq.poll();
            int val=min[0];
            int row=min[1];
            int col=min[2];
            if(col<cols-1){
                pq.add(
                    new int[]{matrix[row][col+1],row,col+1});
            }
            

        }
        return pq.peek()[0];
        
    }
}