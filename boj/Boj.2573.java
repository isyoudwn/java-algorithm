import java.io.*;
import java.util.*;

class Main {
    public static int solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행
        int n = Integer.parseInt(st.nextToken());
        // 열
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        int[][] next = new int[n][m];
        Map<Integer, Set<Integer>> visited = new HashMap<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer temp = new StringTokenizer(br.readLine());

            for (int j = 0; j < m; j++) {
                int t = Integer.parseInt(temp.nextToken());
                graph[i][j] = t;
                next[i][j] = t;
                visited.putIfAbsent(i, new HashSet<>());
            }
        }

        int year = 0;
        while (true) {
            year++;
            boolean flag2 = false;
            int count = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    // 빙하 pass
                    if (graph[i][j] == 0) {
                        continue;
                    }
                    // 방문 노드 pass
                    flag2 = true;
                    if (visited.get(i).contains(j)) {
                        continue;
                    }

                    count++;
                    if (count >= 2) {
                        return year;
                    }

                    bfs(visited, graph, next, i, j);
                }
            }

            graph = next;

            if (!flag2) {
                return 0;
            }
            // 방문 노드 clear
            for (int key : visited.keySet()) {
                visited.get(key).clear();
            }
        }
    }

    public static void bfs(Map<Integer, Set<Integer>> visited, int[][] graph, int[][] next, int startX, int startY) {
        Deque<int[]> deque = new ArrayDeque<>();
        // now도 빙하 계산하기
        deque.add(new int[]{startX, startY});
        visited.get(startX).add(startY);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        // 시작 지점의 년도 별 녹는 거 계산
        for (int k = 0; k < 4; k++) {
            int x = startX + dx[k];
            int y = startY + dy[k];

            // 범위 벗어 날 경우
            if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) {
                continue;
            }
            // 0에 의해서 녹는 것을 반영
            if (graph[x][y] != 0) {
                continue;
            }
            next[startX][startY] = Math.max(0, next[startX][startY] - 1);
        }

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
                if (graph[nextX][nextY] == 0) {
                    continue;
                }
                if (visited.get(nextX).contains(nextY)) {
                    continue;
                }

                // 방문 처리
                visited.get(nextX).add(nextY);

                // 년도 별 녹는 거 계산
                for (int k = 0; k < 4; k++) {
                    int x = nextX + dx[k];
                    int y = nextY + dy[k];

                    // 범위 벗어 날 경우
                    if (x < 0 || x >= graph.length || y < 0 || y >= graph[0].length) {
                        continue;
                    }
                    // 0에 의해서 녹는 것을 반영
                    if (graph[x][y] != 0) {
                        continue;
                    }
                    next[nextX][nextY] = Math.max(0, next[nextX][nextY] - 1);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.print(solution());
    }
}
