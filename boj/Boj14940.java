
import java.util.*;
import java.io.*;

class Main {

    public static int[][] graph;
    public static int[][] dist;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 행
        int m = Integer.parseInt(st.nextToken()); // 열

        graph = new int[n][m];
        dist = new int[n][m];

        int startX = 0;
        int startY = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int next = Integer.parseInt(temp.nextToken());
                graph[i][j] = next;
                dist[i][j] = -1;

                if (next == 2) {
                    startX = i;
                    startY = j;
                }

                if (next == 0) {
                    dist[i][j] = 0;
                }
            }
        }

        bfs(startX, startY);
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(dist[i][j]);

                if (j != m - 1) {
                    sb.append(" ");
                }
            }
            if (i != n - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }


    public static void bfs(int startX, int startY) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        graph[startX][startY] = 0;
        dist[startX][startY] = 0;
        deque.add(new int[]{startX, startY});

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                if (dist[nextX][nextY] != -1) {
                    continue;
                }
                if (graph[nextX][nextY] != 1) {
                    continue;
                }
                dist[nextX][nextY] = dist[nowX][nowY] + 1;
                deque.add(new int[]{nextX, nextY});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
