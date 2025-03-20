import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> deque = new ArrayDeque<>();

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            StringTokenizer line = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                int value = Integer.parseInt(line.nextToken());
                graph[i][j] = value;

                if (value == 1) {
                    deque.add(new int[] {i, j});
                }
            }
        }

        int day = -1;

        while (!deque.isEmpty()) {
            bfs(deque, graph);
            day++;
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (graph[i][j] == 0) {
                    System.out.print(-1);
                    return;
                }
            }
        }

        System.out.print(day);
    }

    public static void bfs(Deque<int[]> deque, int[][] graph) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int size = deque.size();

        for (int i = 0; i < size; i++) {
            int[] nowNode = deque.removeFirst();
            int nowX = nowNode[0];
            int nowY = nowNode[1];

            for (int j = 0; j < dx.length; j++) {
                int nextX = dx[j] + nowX;
                int nextY = dy[j] + nowY;

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }

                if (graph[nextX][nextY] == - 1) {
                    continue;
                }

                if (graph[nextX][nextY] == 0) {
                    graph[nextX][nextY] = 1;
                    deque.add(new int[] {nextX, nextY});
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
