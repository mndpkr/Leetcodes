//1863. Sum of All Subset XOR Totals
//Runtime: 4 ms, faster than 47.29% of Java online submissions for Sum of All Subset XOR Totals.
//Memory Usage: 36.1 MB, less than 80.54% of Java online submissions for Sum of All Subset XOR Totals.



class Solution {
    int sum = 0;
    boolean ele[];
    public int subsetXORSum(int[] nums) {
        if(nums.length ==1)
            return nums[0];
        ele = new boolean[nums.length];
        Arrays.fill(ele, false);
        subset(nums,0);
        return sum;
    }
    void subset(int[] nums, int pos){
        if(pos==nums.length){
            int xor=0;
            for(int i=0; i<pos; i++)
                if(ele[i] == true)
                    xor = xor^nums[i];
        sum+=xor;
        }
        else{
            subset(nums,pos+1);
            ele[pos] = true;
            subset(nums,pos+1);  
            ele[pos] = false;
        }      
        
        }
}
