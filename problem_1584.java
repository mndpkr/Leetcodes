//1584. Min Cost to Connect All Points
//Runtime: 557 ms, faster than 34.79% of Java online submissions 
//Memory Usage: 61.7 MB, less than 5.02% of Java online submissions 

class Solution {
    class cost implements Comparable<cost>{
        int val;
        int i,j;
            cost(int i,int j, int val){
                this.val = val;
                this.i=i; this.j=j;
        }
        @Override
        public int compareTo(cost cs){
            return this.val -cs.val;
        }
    }
    public int minCostConnectPoints(int[][] points) {
        int val, len = points.length;
        if(len ==1)
            return 0;
        PriorityQueue<cost> pq = new PriorityQueue<>();
        for(int i=0; i<len-1; i++){
            for(int j=i+1; j<len; j++){
                val = Math.abs(points[j][0]-points[i][0])+Math.abs(points[j][1]-points[i][1]);
                cost cs = new cost(i, j, val);
                pq.add(cs);
            }
        }
        int[] parent = new int[len];
        int[] rank = new int[len];
        for(int i=0;i<len;i++){
             parent[i] = i;
            rank[i] = 1;
        }
           
        val = 0;
        
        while(!pq.isEmpty()){
            cost next = pq.poll();
            int i=next.i, j=next.j;
            int ip = find(i, parent), jp = find(j, parent);
            if(ip!=jp){
                 val += next.val;
                if(rank[ip]>=rank[jp]){
                    parent[jp] = ip;
                    rank[ip] =+ rank[jp];
                }
                else{
                    parent[ip] = jp;
                    rank[jp] =+ rank[ip];
                }
            }
            len--;
        }
        return val;
    }
    int find(int i, int[] parent){
        int temp = i;
        while(temp!=parent[temp])
           temp = parent[temp];
        return parent[i] = temp;
    }
   
}
