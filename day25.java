class Solution {
    public class task{
        int cnt;
        int time;
        task(int cnt, int time){
            this.cnt=cnt;
            this.time=time;
        }
    }
    public int leastInterval(char[] tasks, int n) {
        int time=0;
        int[] freq=new int[26];
        int not=tasks.length;//not=number of tasks
        for(int i=0;i<not;i++){
            freq[tasks[i]-'A']++;
        }
        PriorityQueue<task> maxheap=new PriorityQueue<>((e1,e2)->e2.cnt-e1.cnt);
        for(int i=0;i<26;i++){
            if(freq[i]>=1){
                maxheap.add(new task(freq[i],0));
            }
        }
        Queue<task> q=new LinkedList<>();
        while(!maxheap.isEmpty() || !q.isEmpty()){
            
            if(!q.isEmpty() && (time-q.peek().time)>n){
                maxheap.add(q.remove());
            }
            if(!maxheap.isEmpty()){
                task t=maxheap.poll();
                t.cnt--;
                t.time=time;
                if(t.cnt>0) q.add(t);
                
            }

            time++;
        }
        return time;

        
    }
}
