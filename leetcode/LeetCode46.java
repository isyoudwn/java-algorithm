class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
       // 첫 단추 for문 돌리기
       backTrack(0, new ArrayDeque<>(), nums);
       return answer;
    }
    
    public void backTrack(int index, Deque<Integer> path, int[] nums) {
        if (path.size() == nums.length) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (path.contains(nums[i])) {
                continue;
            }
            path.add(nums[i]);
            backTrack(index + 1, path, nums);
            path.removeLast();
        }
    }
}
