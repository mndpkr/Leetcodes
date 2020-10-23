//210. Course Schedule II
//Runtime: 34 ms,Memory Usage: 40.2 MB

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int i;  int[] ordering = new int[numCourses];
        int indeg[] = new int[numCourses];
        Arrays.fill(indeg, 0);
        List<List<Integer>> adjlist = new ArrayList<>(numCourses);
        for(i=0; i<numCourses; i++)
            adjlist.add(new LinkedList<>());
        
        for(i=0; i<prerequisites.length; i++){
            int[] pair = prerequisites[i];
            indeg[pair[0]]++;            
            List<Integer> lst = adjlist.get(pair[1]);
            lst.add(pair[0]);
            adjlist.set(pair[1], lst);
        }
        
        int j =0;
        List<Integer> zeroIndeg = new ArrayList<>();
        for(i=0; i<numCourses; i++)
            if(indeg[i] == 0)
                 zeroIndeg.add(i);
        
                  
        while(zeroIndeg.size()>0){  
            System.out.println(zeroIndeg);
            for(int zeroIndegNode: zeroIndeg){
                System.out.println("-----"+j+"  "+zeroIndegNode);
                ordering[j++] = zeroIndegNode;
                indeg[zeroIndegNode] = -1;
                List<Integer> lst = adjlist.get(zeroIndegNode);
                for(int each : lst)
                    indeg[each]--; 
            }
                
            zeroIndeg.clear();
            for(i=0; i<numCourses; i++)
                 if(indeg[i] == 0)
                    zeroIndeg.add(i);
        }
    if(j<numCourses)
            return new int[]{};
    return ordering;
    }
}
