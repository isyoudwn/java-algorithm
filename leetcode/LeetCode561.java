class Solution {
    public int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int answer = 0;

        for (int i = 0; i < nums.length - 1; i = i + 2) {
            int minValue = Math.min(nums[i], nums[i + 1]);
            answer += minValue;
        }
        return answer;
    }
}
