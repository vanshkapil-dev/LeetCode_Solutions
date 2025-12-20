class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int weight:stones){
            pq.add(weight);
            
        }
        while(pq.size()>1){
            int x1=pq.poll();
            int x2=pq.poll();
            if(x1!=x2){
                pq.add(x1-x2);
                
            }
        }
        
        return pq.isEmpty()?0:pq.peek();
        
    }
}