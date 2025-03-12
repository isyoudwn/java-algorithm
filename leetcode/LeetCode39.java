class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        backTrack(new ArrayDeque<>(), target, candidates, 0);

        return answer;
    }

    public void backTrack(Deque<Integer> temp, int target, int[] candidates, int index) {
        if (target < 0) {
            return;
        }
        
        if (target == 0) {
            answer.add(new ArrayList<>(temp));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            backTrack(temp, target - candidates[i], candidates, i);
            temp.removeLast();
        }
    }
}
