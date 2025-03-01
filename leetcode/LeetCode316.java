class Solution {
    public String removeDuplicateLetters(String s) {
        Deque<String> deque = new ArrayDeque<>();
        Map<String, Integer> dequeMap = new HashMap<>();
        Map<String, Integer> counter = new HashMap<>();

        String[] arr = s.split("");

        for (String a : arr) {
            counter.put(a, counter.getOrDefault(a, 0) + 1);
            dequeMap.put(a, 0);
        }

        for (String a : arr) {
            if (deque.isEmpty()) {
                deque.add(a);
                dequeMap.put(a, dequeMap.get(a) + 1);
                counter.put(a, counter.get(a) - 1);
                continue;
            }

            if (dequeMap.get(a) >= 1) {
                counter.put(a, counter.get(a) - 1);
                continue;
            }

            while (!deque.isEmpty() && (deque.peekLast().compareTo(a) > 0) && counter.get(deque.peekLast()) != 0) {
                    String last = deque.removeLast();
                    dequeMap.put(last, dequeMap.get(last) - 1);
            }

            dequeMap.put(a, dequeMap.get(a) + 1);
            deque.add(a);
            counter.put(a, counter.get(a) - 1);
        }
        StringBuilder sb = new StringBuilder();

        while (!deque.isEmpty()) {
            sb.append(deque.removeFirst());
        }

        return sb.toString();
    }
}
