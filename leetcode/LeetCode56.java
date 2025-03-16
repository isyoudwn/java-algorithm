class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparing((int[] a) -> a[0]).thenComparing((int[] a) -> a[1]));
        Deque<int[]> deque = new ArrayDeque<>();
        for (int[] i : intervals) {
            if (deque.isEmpty()) {
                deque.add(i);
            }

            else {
                int[] temp = deque.removeLast();

                if (temp[1] >= i[0]) {
                    if (temp[1] < i[1]) {
                        temp[1] = i[1];
                    }
                    deque.add(temp);
                }
                else {
                    deque.add(temp);
                    deque.add(i);
                }
            }
        }
        
        return deque.stream().toArray(int[][]::new);
    }
}
