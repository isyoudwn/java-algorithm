class Solution {
    boolean[][] visited;
    int n;
    int m;
    
    public int numIslands(char[][] grid) {
        n = grid.length;
        m = grid[0].length;
        int number = 0;
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == true) {
                    continue;
                } 
                if (grid[i][j] == '1') {
                    bfs(grid, i, j);
                    number++;
                }
            }
        }
        return number;
    }

    public void bfs(char[][] grid, int startX, int startY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, 1, -1};

            for (int i = 0; i < dx.length; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];
                
                if (nextX >= 0 && nextX < n && nextY >= 0 && nextY < m) {
                    if (grid[nextX][nextY] == '1' && visited[nextX][nextY] == false) {
                        deque.add(new int[]{nextX, nextY});
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}
