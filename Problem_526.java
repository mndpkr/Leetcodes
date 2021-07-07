//526. Beautiful Arrangement
//Runtime: 66 ms, faster than 62.94% of Java online submissions for Beautiful Arrangement.
//Memory Usage: 35.9 MB, less than 45.61% of Java online submissions for Beautiful Arrangement.

class Solution {
    int sum =0;
    boolean ele[];
    public int countArrangement(int n) {
        ele = new boolean[n];
        Arrays.fill(ele, false);
        int perm[] = new int[n];
        perms(ele, perm, 0);
        return sum;
    }
    void perms(boolean ele[], int perm[], int pos){
        if(pos==ele.length){
            sum++;
        }
        else{
            int curr;
            for(int i=0; i<ele.length; i++)
                if(ele[i]==false){
                    curr = i+1;
                                 
                    if(curr%(pos+1)==0 || (pos+1)%curr==0){
                        ele[i] = true;  
                        perm[pos] = curr;
                        perms(ele,perm,pos+1); 
                        ele[i]=false;
                    }
                    
                }
            
    }
}}
