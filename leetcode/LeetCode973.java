class Solution {
    public int[][] kClosest(int[][] points, int k) {
        int[][] answer = new int[k][2];

        Queue<int[]> queue = new PriorityQueue<>((a, b) -> 
        Double.compare(
            Math.pow(a[0], 2) + Math.pow(a[1], 2),
            Math.pow(b[0], 2) + Math.pow(b[1], 2)
        ));

        for (int[] point : points) {
            queue.add(point);
        }
    
        for (int i = 0; i < k; i++) {
            answer[i] = queue.poll();
        }

        return answer;
    }
}
