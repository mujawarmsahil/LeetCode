public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> quadruplets = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;

            for(int j = i+1; j < nums.length; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;

                int first = j + 1;
                int end = nums.length - 1;

                while(first < end){

                    long sum = (long) nums[i] + nums[j] + nums[first] + nums[end];

                    if(sum == target){
                        quadruplets.add(Arrays.asList(nums[i], nums[j], nums[first], nums[end]));

                        while(first < end && nums[first] == nums[first + 1]) first++;
                        while(first < end && nums[end] == nums[end - 1]) end--;

                        first++;
                        end--;
                    } 
                    else if(sum > target){
                        end--;
                    } 
                    else {
                        first++;
                    }
                }
            }
        }
        return quadruplets;
    }
}
