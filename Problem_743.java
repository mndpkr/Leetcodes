//743. Network Delay Time
//Runtime: 11 ms, Memory Usage: 42.3 MB
class Solution {
    class dist{
        int node;
        int time;
        
        dist(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
    class comp implements Comparator<dist>{
        @Override
        public int compare(dist d1, dist d2){
           // dist d1=(dist)o1;  dist d2=(dist)o2;
          return  d1.time - d2.time;
        }
    }
    public int networkDelayTime(int[][] times, int N, int K) {
        List<dist>[] graph = new ArrayList[N];
        for(int j=0;j<N;j++)
            graph[j]=new ArrayList<>();
        for(int i=0; i<times.length; i++){
            int[] edge = times[i];
            int u=edge[0]-1,v=edge[1]-1,w=edge[2];
            graph[u].add(new dist(v, w));            
        }
        
        PriorityQueue<dist> pq = new PriorityQueue<>(new comp());
        int[] nodeDist = new int[N];
        Arrays.fill(nodeDist, -1);
        pq.add(new dist(K-1, 0));
        nodeDist[K-1] = 0;
        while(!pq.isEmpty()){
            dist d = pq.remove(); 
            List<dist> lst = graph[d.node];
            Iterator<dist> itr = lst.iterator();
            while(itr.hasNext()){
                dist neigh = itr.next();
                if(nodeDist[neigh.node] == -1){
                    nodeDist[neigh.node] = d.time+neigh.time;
                    pq.add(new dist(neigh.node, nodeDist[neigh.node]));
                    //pq.add(nodeDist[neigh.node]);
                }
                if(nodeDist[neigh.node] > d.time+neigh.time){
                   nodeDist[neigh.node] = d.time+neigh.time; 
                    pq.remove(neigh);
                    pq.add(new dist(neigh.node, nodeDist[neigh.node]));
                }
            }
        }
        if(Arrays.stream(nodeDist).min().getAsInt() ==-1)
            return -1;
        return Arrays.stream(nodeDist).max().getAsInt();
    }
}
