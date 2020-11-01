//1584. Min Cost to Connect All Points
//Runtime: 80 ms, faster than 85.19% of Java online submissions
//Memory Usage: 58 MB, less than 5.02% of Java online submissions

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
        for(int i=1; i<len; i++){
            val = Math.abs(points[i][0]-points[0][0])+Math.abs(points[i][1]-points[0][1]);
            cost cs = new cost(0, i, val);
            pq.add(cs);
            }
        boolean[] visited = new  boolean[len];
        visited[0] = true;
         int[] parent = new int[len];
         for(int i=0;i<len;i++)
             parent[i] = i;
        int count =len;
         val = 0;
        while(count>1){
                cost next = pq.poll();
            int u=next.i, j=next.j;
            visited[j] = true;
            if(find(u, parent)!=find(j, parent)){
                count--;
                parent[j] = u;
                val += next.val;
                for(int i=0;i<len;i++){
                    if(!visited[i]){
                        int val1 = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                       cost cs = new cost(j, i, val1);
                        pq.add(cs);
                    }}
            }
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
