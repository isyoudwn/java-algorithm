import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] graph = new int[M][N];

        // 0 : not visited
        for (int k = 0; k < K; k++) {
            st = new StringTokenizer(br.readLine());

            //x y
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
`
            //x y
            int c = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            // 영역 표시하기
            for (int y = b; y < d; y++) {
                for (int x = a; x < c; x++) {
                    graph[M - 1 - y][x] = -1;
                }
            }
        }
        PriorityQueue<Integer> answer = new PriorityQueue<>();
        int areaCount = 0;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] != -2 && graph[i][j] != -1) {
                    graph[i][j] = -2;
                    areaCount++;
                    answer.add(bfs(graph, i, j));
                }
            }
        }
        StringBuilder sb = new StringBuilder();

        sb.append(areaCount);
        sb.append("\n");

        while (!answer.isEmpty()) {
            sb.append(answer.remove());
            sb.append(" ");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static int bfs(int[][] graph, int startX, int startY) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY});
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};

        int size = 1;

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
                if (graph[nextX][nextY] == -1) {
                    continue;
                }
                if (graph[nextX][nextY] == -2) {
                    continue;
                }
                deque.add(new int[]{nextX, nextY});
                graph[nextX][nextY] = -2;
                size++;
            }
        }
        return size;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
