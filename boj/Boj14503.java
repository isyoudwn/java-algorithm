import java.io.*;
import java.util.*;

class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int direct = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
                visited[i][j] = false;
            }
        }
        System.out.println(bfs(startX, startY, graph, direct, visited));
    }

    public static int bfs(int startX, int startY, int[][] graph, int direct, boolean[][] visited) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] dx = {-1, 0, 1, 0};
        int[] dy = {0, 1, 0, -1};
        int areaCount = 1;

        deque.add(new int[]{startX, startY, direct});
        visited[startX][startY] = true;

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];
            int nowDirect = now[2];
            boolean flag = true;

            if (!visited[nowX][nowY]) {
                areaCount++;
                visited[nowX][nowY] = true;
            }

            for (int i = 0; i < dx.length; i++) {
                nowDirect = (nowDirect + 3) % 4;
                int nextX = nowX + dx[nowDirect];
                int nextY = nowY + dy[nowDirect];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 1) {
                    continue;
                }
                // 청소 유무
                if (visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                areaCount++;
                deque.add(new int[] {nextX, nextY, nowDirect});
                flag = false;
                break;
            }

            if (flag) {
                // 후진
                int mD = (nowDirect + 2) % 4;
                int nnextX = nowX + dx[mD];
                int nnextY = nowY + dy[mD];

                if (nnextX < 0 || nnextX >= graph.length || nnextY < 0 || nnextY >= graph[0].length || graph[nnextX][nnextY] == 1) {
                    return areaCount;
                }
                deque.add(new int[] {nnextX, nnextY, nowDirect});
            }
        }
        return areaCount;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
