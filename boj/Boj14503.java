
import java.io.*;
import java.util.*;

class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int head = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
        System.out.println(bfs(head, startX, startY, graph, visited));
    }

    public static int bfs(int head, int startX, int startY, int[][] graph, boolean[][] visited) {
        Deque<int[]> deque = new ArrayDeque<>();
        int area = 1;
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};

        deque.add(new int[]{startX, startY, head});
        visited[startX][startY] = true;

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];
            int direct = now[2];
            boolean moved = false;

            for (int i = 0; i < 4; i++) {
                direct = (direct + 3) % 4;  // 반시계 회전
                int nextX = dx[direct] + nowX;
                int nextY = dy[direct] + nowY;

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 1) {
                    continue;
                }
                if (visited[nextX][nextY]) {
                    continue;
                }
                // 청소 안 된 칸 있으면
                visited[nextX][nextY] = true;
                area++;  // 청소한 칸 증가
                deque.add(new int[]{nextX, nextY, direct});
                moved = true;
                break;
            }

            if (!moved) {
                int backDir = (direct + 2) % 4;
                int bx = nowX + dx[backDir];
                int by = nowY + dy[backDir];

                if (bx < 0 || by < 0 || bx >= graph.length || by >= graph[0].length || graph[bx][by] == 1) {
                    return area;
                }
                deque.add(new int[]{bx, by, direct});
            }
        }
        return area;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
