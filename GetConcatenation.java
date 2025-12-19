class GetConcatenation {
    public int[] getConcatenation(int[] nums) {

        // Create a new array of size 2 * n to store the concatenation
        int[] concatenatedNumbers = new int[2 * nums.length];

        int n = nums.length;

        // Loop through the original array
        for (int i = 0; i < n; i++) {

            // Copy element to the first half
            concatenatedNumbers[i] = nums[i];

            // Copy the same element to the second half
            concatenatedNumbers[i + n] = nums[i];
        }

        // Return the concatenated array
        return concatenatedNumbers;
    }
}
