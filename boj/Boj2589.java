import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        char[][] graph = new char[row][col];

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();
            for (int j = 0; j < col; j++) {
                graph[i][j] = temp.charAt(j);
            }
        }

        int maxDistance = 1;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (graph[i][j] == 'W') {
                    continue;
                }

                int result = bfs(graph, i, j, new int[row][col], 0);
                if (result > maxDistance) {
                    maxDistance = result;
                }
            }
        }
        System.out.println(maxDistance - 1);
    }

    public static int bfs(char[][] graph, int startX, int startY, int[][] distance, int maxDistance) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY});
        distance[startX][startY] = 1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 'W') {
                    continue;
                }
                if (distance[nextX][nextY] != 0) {
                    continue;
                }

                distance[nextX][nextY] = distance[nowX][nowY] + 1;
                deque.add(new int[]{nextX, nextY});

                if (maxDistance < distance[nextX][nextY]) {
                    maxDistance = distance[nextX][nextY];
                }
            }
        }
        return maxDistance;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
