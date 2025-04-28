package org.example;

import java.io.*;
import java.util.*;

public class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 행
        int n = Integer.parseInt(st.nextToken());
        // 열
        int m = Integer.parseInt(st.nextToken());

        int[][] graph = new int[n][m];
        int[][] next = new int[n][m];
        Map<Integer, Set<Integer>> visited = new HashMap<>();

        // setting
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

        // main logic
        while (true) {
            // vistied 초기화
            for (int i = 0; i < graph.length; i++) {
                visited.get(i).clear();
            }

            int count = 0;

            // 빙산 개수 탐색
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (graph[i][j] == 0) {
                        continue;
                    }
                    if (visited.get(i).contains(j)) {
                        continue;
                    }
                    count++;
                    bfs(graph, i, j, visited, next);
                }
            }

            if (count >= 2) {
                System.out.println(year);
                return;
            }
            if (count == 0) {
                System.out.println(0);
                return;
            }

            // 녹이고 next 저장
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    if (graph[i][j] == 0) {
                        next[i][j] = 0;
                        continue;
                    }
                    next[i][j] = countSeaArea(graph, i, j);
                }
            }

            // graph에 next 복사
            for (int i = 0; i < graph.length; i++) {
                for (int j = 0; j < graph[0].length; j++) {
                    graph[i][j] = next[i][j];
                }
            }
            year++;
        }
    }


    public static void bfs(int[][] graph, int startX, int startY, Map<Integer, Set<Integer>> visited,
                           int[][] nextYear) {
        Deque<int[]> deque = new ArrayDeque<>();
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        deque.add(new int[]{startX, startY});
        visited.get(startX).add(startY);

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();

            for (int i = 0; i < 4; i++) {
                int nextX = now[0] + dx[i];
                int nextY = now[1] + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                if (graph[nextX][nextY] == 0) {
                    continue;
                }
                if (visited.get(nextX).contains(nextY)) {
                    continue;
                }
                visited.get(nextX).add(nextY);
                deque.add(new int[]{nextX, nextY});
            }
        }
    }

    // 바닷물로 인한 빙산 높이 계산
    public static int countSeaArea(int[][] graph, int nowX, int nowY) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 0;

        for (int i = 0; i < 4; i++) {
            int x = nowX + dx[i];
            int y = nowY + dy[i];

            if (x < 0 || y < 0 || x >= graph.length || y >= graph[0].length) {
                continue;
            }
            if (graph[x][y] != 0) {
                continue;
            }
            count++;
        }
        return Math.max(0, graph[nowX][nowY] - count);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}

