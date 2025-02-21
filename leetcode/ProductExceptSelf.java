class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftNum = new int[nums.length];
        int[] rightNum = new int[nums.length];

        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            leftNum[i] = curr;
            curr = curr * nums[i];
        }

        int curr2 = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            rightNum[i] = leftNum[i] * curr2;
            curr2 = curr2 * nums[i];
        }
        return rightNum;
    }
}
