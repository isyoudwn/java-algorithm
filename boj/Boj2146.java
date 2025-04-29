package org.example;

import java.io.*;
import java.util.*;

class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] graph = new int[n][n];
        Map<Integer, Set<Integer>> nodes = new HashMap<>();
        Map<Integer, Set<Integer>> visited = new HashMap<>();

        for (int i = 0; i < graph.length; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            visited.putIfAbsent(i, new HashSet<>());

            for (int j = 0; j < graph[0].length; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int index = 1;

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (visited.get(i).contains(j)) {
                    continue;
                }
                if (graph[i][j] == 0) {
                    continue;
                }
                // 육지 분리
                graph[i][j] = index;
                bfs(graph, visited, i, j, index, nodes);
            }
        }

        // 최단거리 찾기
        int distance = -1;
        Integer[] keys = nodes.keySet().toArray(Integer[]::new);
        for (int row : keys) {
            for (int col : nodes.get(row)) {
                // visited 초기화
                for (int k : visited.keySet()) {
                    visited.get(k).clear();
                }
                shortPath(distance, graph, visited, row, col, new int[n][n]);
            }
        }

        System.out.println(distance);
    }

    public static void shortPath(int answer, int[][] graph, Map<Integer, Set<Integer>> visited, int startX, int startY,
                                 int[][] dist) {
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
                if (answer == -1) {
                    answer = dist[nowX][nowY];
                } else {
                    answer = Math.min(answer, dist[nowX][nowY]);
                }
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
    }

    public static void bfs(int[][] graph, Map<Integer, Set<Integer>> visited, int startX, int startY, int index,
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

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                if (visited.get(nextX).contains(nextY)) {
                    continue;
                }
                deque.add(new int[]{nextX, nextY});
                visited.get(nextX).add(nextY);
                graph[nextX][nextY] = index;

                // 끝단 add
                if (nextX == 0 || nextY == 0 || nextX == graph.length - 1 || nextY == graph[0].length - 1) {
                    nodes.putIfAbsent(nextX, new HashSet<>());
                    nodes.get(nextX).add(nextY);
                }
            }
        }
        index++;
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
