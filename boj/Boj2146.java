import java.io.*;
import java.util.*;

public class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();
        Map<Integer, Set<Integer>> visited2 = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited.putIfAbsent(i, new HashSet<>());
            visited2.putIfAbsent(i, new HashSet<>());

            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 1;

        // 육지 분리
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (visited2.get(i).contains(j)) {
                    continue;
                }
                if (graph[i][j] == 0) {
                    continue;
                }
                graph[i][j] = index;
                divideArea(graph, visited2, i, j, index, nodes);
                index++;
            }
        }

        // 최단거리 찾기
        int distance = 1000000;
        Integer[] keys = nodes.keySet().toArray(Integer[]::new);

        for (int row : keys) {
            for (int col : nodes.get(row)) {
                // visited 초기화
                for (int k : visited.keySet()) {
                    visited.get(k).clear();
                }
                distance = shortestPath(distance, graph, visited, row, col, new int[n][n]);
            }
        }
        System.out.println(distance);
    }

    public static int shortestPath(int distance, int[][] graph, Map<Integer, Set<Integer>> visited, int startX,
                                    int startY, int[][] dist) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY});

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        int areaIndex = graph[startX][startY];

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];

            // 다른 지역 도달
            if (graph[nowX][nowY] != 0 && graph[nowX][nowY] != areaIndex) {
                distance = Math.min(distance, dist[nowX][nowY] - 1);
                continue;
            }
            if (dist[nowX][nowY] >= distance) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                if (visited.get(nextX).contains(nextY)) {
                    continue;
                }
                if (areaIndex == graph[nextX][nextY]) {
                    continue;
                }

                deque.add(new int[]{nextX, nextY});
                visited.get(nextX).add(nextY);
                dist[nextX][nextY] = dist[nowX][nowY] + 1;
            }
        }
        return distance;
    }

    public static void divideArea(int[][] graph, Map<Integer, Set<Integer>> visited, int startX, int startY, int index,
                                  Map<Integer, Set<Integer>> nodes) {

        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY});
        visited.get(startX).add(startY);

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];
            boolean flag = true;

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }

                if (graph[nextX][nextY] == 0) {
                    // 끝인지 확인 -> 주변에 0 있으면 now가 끝임
                    if (flag) {
                        nodes.putIfAbsent(nowX, new HashSet<>());
                        nodes.get(nowX).add(nowY);
                        flag = false;
                    }
                    continue;
                }

                if (visited.get(nextX).contains(nextY)) {
                    continue;
                }
                deque.add(new int[]{nextX, nextY});
                visited.get(nextX).add(nextY);
                graph[nextX][nextY] = index;
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
