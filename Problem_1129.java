//1129. Shortest Path with Alternating Colors
//Runtime: 50 ms,Memory Usage: 39.6 MB

class Solution {
    static int dist[];
    Queue<Pair<Integer, Character>> q;
    public int[] shortestAlternatingPaths(int n, int[][] red_edges, int[][] blue_edges) {
        int level =0;
        Map<Integer, ArrayList<Pair<Integer, Character>>> adjList = new HashMap<Integer, ArrayList<Pair<Integer, Character>>>();
        addEdges(adjList, red_edges, new Character('r'));
        addEdges(adjList, blue_edges, new Character('b'));
        q = new LinkedList<Pair<Integer, Character>>();
            
        // for(int i : adjList.keySet()){
        //     System.out.println("\nKey is "+i);
        //     ArrayList<Pair<Integer, Character>> arrList = adjList.get(i);
        //     for(Pair p : arrList){
        //         System.out.print(p.getKey()+"  "+p.getValue()+";");
        //     }             
        // }
        
        dist = new int[n];  Arrays.fill(dist,-1);     
        dist[0] = 0;
        q.add(new Pair(0, 'a'));
        q.add(new Pair(-1, 'a'));
        while(q.size() >1){
            Pair qpair = q.remove();
            if((int)qpair.getKey() == -1){
                q.add(new Pair(-1, 'a'));
                level++;
                continue;
            }
            int prevNode = (int)qpair.getKey();
            char colorPrevEdge = (char)qpair.getValue();
            System.out.println("Node :"+qpair);
            ArrayList<Pair<Integer, Character>> arrList = adjList.get(prevNode);
            if(arrList == null)
                continue;
            ArrayList<Pair<Integer, Character>> removePairs = new ArrayList<>();
            for(Pair p: arrList){
                char colorEdge = (char)p.getValue();
                if( colorEdge != colorPrevEdge){
                    System.out.println("nxt neigh :"+p);
                    int neigh = (int)p.getKey();
                    if(dist[neigh] ==-1)
                        dist[neigh] = level+1;
                    q.add(p); 
                    removePairs.add(p);
                }
            }
            arrList.removeAll(removePairs);
            adjList.put(prevNode, arrList);
        }
        return dist;
    }
        
    
    void addEdges(Map<Integer, ArrayList<Pair<Integer, Character>>> adjList, int[][] edgeList, Character ch){
        for(short i=0; i<edgeList.length; i++){
            int arr[] = edgeList[i];
            Pair p = new Pair(arr[1], ch);
            
            if(!(adjList.keySet()).contains(arr[0])){
                ArrayList<Pair<Integer, Character>> arrList = new ArrayList<>();
                arrList.add(p);
                adjList.put(arr[0], arrList);                    
            }
            else{
                ArrayList<Pair<Integer, Character>> arrList = adjList.get(arr[0]);
                arrList.add(p);
                adjList.put(arr[0], arrList);
            }
            
        }
    }
   // void dfs(int node, int[][] red_edges, int[][] blue_edges)
}
