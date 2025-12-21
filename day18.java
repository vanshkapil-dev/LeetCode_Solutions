class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        
        int rows=mat.length;
        int cols=mat[0].length;

        PriorityQueue<int[]> list=new PriorityQueue<>((e1,e2)->{
            if(e1[0]==e2[0]) return e2[1]-e1[1];
            return e2[0]-e1[0];
        });
        for(int x=0; x<rows; x++){
            int soldiers=0;
            int left=0;
            int right=cols-1;
            while(left<right){
                int mid=left+(right-left)/2;
                if(mat[x][mid]==0){
                    right=mid;
                }
                else {
                    left=mid+1;


                }
            }
            soldiers= (mat[x][left]==0?left:cols);
            list.add(new int[]{soldiers,x});
            if(list.size()>k){
                list.poll();
            }

        }
        // Collections.sort(list,(e1,e2)->{
        //     if(e1[0]==e2[0]) return e1[1]-e2[1];
        //     return e1[0] -e2[0];
        // });
        int[] ans=new int[k];
        for(int i=k-1;i>=0;i--){
            ans[i]=list.poll()[1];
        }
        return ans;

    }
}