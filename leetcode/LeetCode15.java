class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> answer = new ArrayList<>();
        int N = nums.length;
        
        Arrays.sort(nums);

        for (int i = 0; i < N; i++) {
            int left = i + 1;
            int right = N - 1;
            
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (left < right && left >= 0 && right < N) {
                int tempSum = nums[i] + nums[left] + nums[right];

                if (tempSum > 0) {
                    // right - 1
                    right = right - 1;
                }
                else if (tempSum < 0) {
                    // left + 1
                    left = left + 1;
                }
                else {
                    // 0 인 경우
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
                    tempList.add(nums[left]);
                    tempList.add(nums[right]);
                    answer.add(tempList);     

                    while (left < right && nums[left] == nums[left + 1]) {
                        left = left + 1;
                    }
                    while (left < right && nums[right] == nums[right - 1]) {
                        right = right - 1;
                    }
                    left = left + 1;
                    right = right - 1;
                }
            }
        }
        return answer;
    }
}
