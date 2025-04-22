import java.util.*;
import java.io.*;

class Main {

    public static void sol(StringBuilder sb, BufferedReader br) throws Exception {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        
        int[][] graph = new int[m][n];

        for (int i = 0; i < k; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(temp.nextToken());
            int y = Integer.parseInt(temp.nextToken());

            graph[x][y] = 1;
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 0) {
                    continue;
                }
                bfs(i, j, graph);
                count++;
            }
        }
        sb.append(count);
        sb.append("\n");
    }

    public static void bfs(int startX, int startY, int[][] graph) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        graph[startX][startY] = 0;
        deque.add(new int[] {startX, startY});
        

        while (!deque.isEmpty()) {
            int[] now = deque.remove();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 0) {
                    continue;
                }

                graph[nextX][nextY] = 0;
                deque.add(new int[] {nextX, nextY});
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < testCase; i++) {
            sol(sb, br);
        }
        System.out.println(sb);
    }
}
