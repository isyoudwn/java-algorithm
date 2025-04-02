
import java.util.*;
import java.io.*;

class Main {
    public static void solution() throws Exception {
        // 1, 1에서 -> n,m의 위치로 이동할 때 까지 최단거리
        // bfs 문제
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];
        int[][] visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] s = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                visited[i][j] = -1;
                graph[i][j] = Integer.parseInt(s[j]);
            }
        }

        System.out.print(bfs(graph, 0, 0, N - 1, M - 1, visited));
    }

    public static int bfs(int[][] graph, int startX, int startY, int endX, int endY, int[][] visited) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        deque.add(new int[]{startX, startY});
        visited[startX][startY] = 1;

        while (!deque.isEmpty()) {
            int[] nowNode = deque.removeFirst();
            int nowX = nowNode[0];
            int nowY = nowNode[1];

            if (nowX == endX && nowY == endY) {
                return visited[endX][endY];
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX > endX || nextY > endY) {
                    continue;
                }
                if (graph[nextX][nextY] == 0) {
                    continue;
                }
                if (visited[nextX][nextY] != -1) {
                    continue;
                }

                deque.add(new int[]{nextX, nextY});
                visited[nextX][nextY] = visited[nowX][nowY] + 1;
            }
        }

        return -1;
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
