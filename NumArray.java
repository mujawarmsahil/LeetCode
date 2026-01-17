class NumArray {
    private int []prefixes;
    public NumArray(int[] nums) {
        this.prefixes = new int[nums.length+1];
        for(int i = 0 ; i < nums.length ; i++){
            this.prefixes[i+1] = this.prefixes[i] + nums[i];
        }
    }
    
    public int sumRange(int left, int right) {
        return this.prefixes[right+1] - this.prefixes[left];
    }
}
