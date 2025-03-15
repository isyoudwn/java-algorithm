class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        int answer = 0;
        for (int n : nums) {
            queue.add(n);
        }

        for (int i = 0; i < k; i++) {
            answer = queue.remove();
        }

        return answer;
    }
}
