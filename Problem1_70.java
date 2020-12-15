//70. Climbing Stairs
//Runtime: 0 ms, faster than 100.00% of Java online submissions for Climbing Stairs.
//Memory Usage: 36.2 MB, less than 7.66% of Java online submissions for Climbing Stairs.

class Solution {
    public int climbStairs(int n) {
        if(n==1)
             return 1;
        if(n==2)
            return 2;
        int[] arrSteps = new int[n+1];
        Arrays.fill(arrSteps, -1);    
        arrSteps[0] = 0;
        arrSteps[1] = 1;
        arrSteps[2] = 2;        
        return distWays(arrSteps, n);
    }
    int distWays(int[] arrMinSteps, int stairs){
        if(arrMinSteps[stairs] != -1)
            return arrMinSteps[stairs];
        else{
            arrMinSteps[stairs]= distWays(arrMinSteps, stairs-1) +1 + distWays(arrMinSteps, stairs-2) +1 -2;
            
            return arrMinSteps[stairs];
        }
    }
}
