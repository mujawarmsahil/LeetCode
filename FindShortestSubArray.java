class FindShortestSubArray {
    public int findShortestSubArray(int[] nums) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        int degree = 0;
        int shortest = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);

            int freq = map.get(nums[i]).size();
            int length = i - map.get(nums[i]).get(0) + 1;

            if (freq > degree) {
                degree = freq;
                shortest = length;
            } else if (freq == degree) {
                shortest = Math.min(shortest, length);
            }
        }

        return shortest;
    }
}
