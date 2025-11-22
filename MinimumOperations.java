public class MinimumOperations {
    public int minimumOperations(int[] nums) {
        int count = 0; // counts how many numbers are NOT divisible by 3
        
        // iterate through each number in the array
        for (int i = 0; i < nums.length; i++) {
            
            // if remainder is not 0, it means the number is not divisible by 3
            if (nums[i] % 3 != 0) {
                count++; // this number needs one operation
            }
        }

        // total operations needed
        return count;
    }
}
