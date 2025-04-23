import java.util.*;
import java.io.*;

class Main {

    public static void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        int[][] visited = new int[n][n];
        Set<Integer> set = new HashSet<>();
        int answer = 0;

        // graph setting
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());    
                graph[i][j] = temp;
                visited[i][j] = temp;
                set.add(temp);
            }
        }
        
        int index = 0;
        
        // graph 탐색
        for (int rain : set) {
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] == -1) {
                        continue;
                    }
                    if (graph[i][j] <= rain) {
                        continue;
                    }
                    count++;
                    bfs(graph, visited, i, j, rain);
                }
            }
            
            for (int i = 0; i < n; i++) {
                Arrays.fill(visited[i], 0);
            }
            answer = Math.max(count, answer);
        }

        if (answer == 0) {
            System.out.println(1);
            return;
        }
        System.out.println(answer);
    }

    public static void bfs(int[][] graph, int[][] visited, int startX, int startY, int rain) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[] {startX, startY});
        visited[startX][startY] = -1;

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        
        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];     

                if (nextX < 0 || nextX >= graph.length || nextY < 0 || nextY >= graph[0].length) {
                    continue;
                }
                if (visited[nextX][nextY] == -1) {
                    continue;
                }
                if (graph[nextX][nextY] <= rain) {
                    continue;
                }
                
                deque.add(new int[] {nextX, nextY});
                visited[nextX][nextY] = -1;
            }
        }
    }
    
    public static void main(String[] args) throws Exception {
        sol();
    }
}