class Solution {
    List<List<Integer>> answer = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        List<Integer> graph = new ArrayList<>();
        backTrack(new ArrayDeque<>(), new HashSet<>(), n, k, 1);
        return answer;
    }

    public void backTrack(Deque<Integer> path, Set<Integer> pathSet, int n, int k, int index) {
        if (path.size() == k) {
            answer.add(new ArrayList<>(path));
            return;
        }

        for (int i = index; i <= n; i++) {
            path.add(i);
            backTrack(path, pathSet, n, k, i + 1);
            path.removeLast();
        }
    }
}
