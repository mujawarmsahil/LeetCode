class MinimumDifference {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int minimumDifference = Integer.MAX_VALUE ;

        for(int i = 0  ; i <= nums.length - k ; i++){
            minimumDifference = Math.min(minimumDifference,nums[i+k-1]-nums[i]);
        }

        return minimumDifference;
    }
}
