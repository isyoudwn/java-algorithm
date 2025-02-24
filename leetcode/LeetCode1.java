import java.util.*;
class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        // 10000 O(nlogn)
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];

            if (map.containsKey(temp) && (map.get(temp) != i)) {
                return new int[] {map.get(temp), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{0};
    }
}
