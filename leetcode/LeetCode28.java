class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backTrack(new ArrayDeque<>(), 0, nums);   
        return answer;
    }

    public void backTrack(Deque<Integer> temp, int index, int[] nums) {
        
        answer.add(new ArrayList<>(temp));

        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backTrack(temp, i + 1, nums);
            temp.removeLast();
        }
    }
}
