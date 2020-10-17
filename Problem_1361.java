//1361. Validate Binary Tree Nodes
//Runtime: 6 ms, Memory Usage: 52.1 MB

class Solution {
    static boolean visited[];
    static ArrayList<Integer> treeRoot;
    //static Stack<Integer> stack = new Stack<Integer>();
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        visited = new boolean[n];
        treeRoot = new ArrayList<Integer>();
  
        for(int i=0; i<n; i++){
            if(!visited[i]){
                 if(dfs(i, leftChild, rightChild))
                     treeRoot.add(i);
                else
                    return false;
             }                 
            }
        if(treeRoot.size() == 1)
            return true;      
        else
            return false;
    }
    
    boolean dfs(int node, int[] leftChild, int[] rightChild){
        visited[node] = true;
        boolean allOk = true;
        if(leftChild[node] != -1){
            if(!visited[leftChild[node]])
                 allOk = dfs(leftChild[node], leftChild, rightChild);
            else if(visited[leftChild[node]] && treeRoot.contains(leftChild[node])){
                treeRoot.remove(treeRoot.indexOf(leftChild[node]));
                allOk = true;
            }                
            else
                allOk = false;
        } 
        if(!allOk)
            return allOk;
        if(rightChild[node] != -1){
             if(!visited[rightChild[node]])
                allOk = dfs(rightChild[node], leftChild, rightChild);
            else if(visited[leftChild[node]] && treeRoot.contains(rightChild[node])){
                treeRoot.remove(treeRoot.indexOf(rightChild[node]));
                allOk = true;
            }                
            else
                 allOk = false;
        }
        return allOk;
    }
}
