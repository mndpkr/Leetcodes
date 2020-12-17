//96. Unique Binary Search Trees
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Unique Binary Search Trees.
//Memory Usage: 37.5 MB, less than 5.46% of Java online submissions for Unique Binary Search Trees.

class Solution {
    public int numTrees(int n) {
        int[] numArr = new int[n+1];
         Arrays.fill(numArr, -1);
        return countTrees(numArr, n);
    }
     int countTrees(int[] numArr,int n){
         if(n==0 || n ==1)
             return 1;
         else if(numArr[n] != -1)
             return numArr[n];         
         else{
             int count = 0;
             for(int i=1; i<=n; i++){
                 count += countTrees(numArr, i-1)*countTrees(numArr, n-i);
             }
             numArr[n] = count;
             return numArr[n];
         }
     }
}
