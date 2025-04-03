import java.util.*;
import java.io.*;

class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];

        // setting graph
        for (int i = 0; i < n; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int next = Integer.parseInt(temp.nextToken());
                graph[i][j] = next;
            }
        }

        int max = 0;
        int picCount = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }
                max = bfs(graph, i, j, max);
                picCount++;
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(picCount);
        sb.append("\n");
        sb.append(max);
        System.out.print(sb);
    }

    public static int bfs(int[][] graph, int startX, int startY, int max) {
        Deque<int[]> deque = new ArrayDeque<>();
        int newMax = 1;
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        deque.add(new int[]{startX, startY});
        graph[startX][startY] = 0;

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + nowX;
                int nextY = dy[i] + nowY;

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 0) {
                    continue;
                }

                deque.add(new int[] {nextX, nextY});
                newMax++;
                graph[nextX][nextY] = 0;
            }
        }

        return Math.max(newMax, max);
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
