import java.io.*;
import java.util.*;

class Main {
    public static void solution(BufferedReader br, StringBuilder sb, int L, int R, int C) throws Exception {
        Map<Integer, char[][]> graph = new HashMap<>();
        Map<Integer, int[][]> visited = new HashMap<>();

        int startX = 0;
        int startY = 0;
        int startZ = 0;

        int endX = 0;
        int endY = 0;
        int endZ = 0;

        // graph-setting
        for (int i = 0; i < L; i++) {
            graph.put(i, new char[R][C]);
            visited.put(i, new int[R][C]);

            for (int j = 0; j < R; j++) {
                String info = br.readLine();

                for (int k = 0; k < info.length(); k++) {
                    if (info.charAt(k) == 'S') {
                        startX = j;
                        startY = k;
                        startZ = i;
                    }
                    if (info.charAt(k) == 'E') {
                        endX = j;
                        endY = k;
                        endZ = i;
                    }
                    graph.get(i)[j][k] = info.charAt(k);
                    visited.get(i)[j][k] = -1;
                }
            }
            // 공란 제거 제거
            br.readLine();
        }
        // bfs
        int result = bfs(graph, startX, startY, startZ, endX, endY, endZ, visited, L, R, C);

        // print append
        if (result == -1) {
            sb.append("Trapped!\n");
        } else {
            sb.append(String.format("Escaped in %d minute(s).\n", result));
        }
    }

    public static int bfs(Map<Integer, char[][]> graph, int startX, int startY, int startZ, int endX, int endY,
                          int endZ, Map<Integer, int[][]> visited, int L, int R, int C) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{startX, startY, startZ});
        visited.get(startZ)[startX][startY] = 0;

        int[] dx = {1, -1, 0, 0, 0, 0};
        int[] dy = {0, 0, -1, 1, 0, 0};
        int[] dz = {0, 0, 0, 0, -1, 1};

        while (!deque.isEmpty()) {
            int[] now = deque.removeFirst();

            int nowX = now[0];
            int nowY = now[1];
            int nowZ = now[2];

            if (nowX == endX && nowY == endY && nowZ == endZ) {
                return visited.get(nowZ)[nowX][nowY];
            }

            for (int i = 0; i < dx.length; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];
                int nextZ = nowZ + dz[i];

                // out of range
                if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C || nextZ < 0 || nextZ >= L) {
                    continue;
                }

                // cant go
                if (graph.get(nextZ)[nextX][nextY] == '#') {
                    continue;
                }

                // already visited
                if (visited.get(nextZ)[nextX][nextY] != -1) {
                    continue;
                }

                deque.add(new int[]{nextX, nextY, nextZ});
                visited.get(nextZ)[nextX][nextY] = visited.get(nowZ)[nowX][nowY] + 1;
            }
        }

        return -1;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 층수 z
            int L = Integer.parseInt(st.nextToken());
            // 행 x
            int R = Integer.parseInt(st.nextToken());
            // 열 y
            int C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                System.out.print(sb);
                return;
            }
            solution(br, sb, L, R, C);
        }
    }
}
