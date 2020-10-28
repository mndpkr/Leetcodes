//684. Redundant Connection
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Redundant Connection.
//Memory Usage: 39 MB, less than 5.66% of Java online submissions for Redundant Connection

class Solution {
    int[] parent;
    public int[] findRedundantConnection(int[][] edges) {
        int N = edges.length;  int[] cycleEdge = new int[]{};
        parent = new int[N];
        for(int i=0;i<N;i++)
            parent[i] = i;
        for(int i=0;i<N;i++){
            int u=edges[i][0]-1, v=edges[i][1]-1;
            int Uparent = find(u);  
            int Vparent = find(v);  
            if(Uparent!=Vparent)
                parent[Uparent] = Vparent;
            else
                cycleEdge = edges[i];
        }
        return cycleEdge;
    }
     
    int find(int v){
        int temp = v;
        while(parent[temp] != temp)
            temp = parent[temp];
        parent[v]= temp;
        return temp;
    }
    // void union(int u, int v){
    //     if(parent[u][1] <parent[v][1]){            
    //         parent[u][0] = v;
    //         parent[v][1] += parent[u][1];
    //     }
    //     else{
    //         parent[v][0] = u;
    //         parent[u][1] += parent[v][1];
    //     }
    // }
}
