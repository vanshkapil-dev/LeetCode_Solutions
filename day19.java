class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        int bindx=0;
        while(bindx<heights.length-1){
            int diff=heights[bindx+1]-heights[bindx];
            if(diff<=0){
                bindx++;
                continue;
            }
            else{
                if(ladders>0){
                    ladders--;
                    pq.add(diff);
                    
                    
                }
                else{
                    int mindiff=(pq.isEmpty()?Integer.MAX_VALUE:pq.peek());
                    if(diff>mindiff){
                        bricks-=mindiff;
                        pq.poll();
                        pq.add(diff);
                        
                        
                    }
                    else{
                        bricks-=diff;
                        

                    }
                }
                if(bricks<0) return bindx;
                bindx++;
            }
            
            
        }
        return bindx;
        
    }
}