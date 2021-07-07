//Runtime: 0 ms, faster than 100.00% of Java online submissions for Sum of All Subset XOR Totals.
//Memory Usage: 36.6 MB, less than 53.11% of Java online submissions for Sum of All Subset XOR Totals./


class Solution {
    int sum = 0;
    public int subsetXORSum(int[] nums) {
        if(nums.length ==1)
            return nums[0];
        subset(0,nums,0);
        return sum;
    }
    void subset(int xor, int[] nums, int pos){
        if(pos==nums.length){
            sum+=xor;
        }
        else{
            subset(xor,nums,pos+1);
            xor = xor^nums[pos];
            subset(xor,nums,pos+1);  
        }      
        
        }
}
