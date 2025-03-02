class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            if (deque.isEmpty()) {
                deque.add(i);
            }

            else {
                while (!deque.isEmpty() && temperatures[deque.peekLast()] < temperatures[i]) {
                    int last = deque.removeLast();
                    answer[last] = i - last;
                }
                deque.add(i);
            }
        }
        return answer;
    }
}
