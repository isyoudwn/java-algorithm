import java.util.*;
import java.io.*;

class Boj4179 {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int row = Integer.parseInt(st.nextToken());
        int col = Integer.parseInt(st.nextToken());

        int[][] jDist = new int[row][col];
        int[][] fireDist = new int[row][col];

        char[][] graph = new char[row][col];

        Deque<int[]> jDeque = new ArrayDeque<>();
        Deque<int[]> fireDeque = new ArrayDeque<>();

        for (int i = 0; i < row; i++) {
            String temp = br.readLine();

            for (int j = 0; j < temp.length(); j++) {
                graph[i][j] = temp.charAt(j);
                fireDist[i][j] = -1;
                jDist[i][j] = -1;

                if (graph[i][j] == 'F') {
                    fireDeque.add(new int[]{i, j});
                    fireDist[i][j] = 0;
                }

                if (graph[i][j] == 'J') {
                    jDeque.add(new int[]{i, j});
                    jDist[i][j] = 0;
                }
            }
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        while (!fireDeque.isEmpty()) {
            int[] now = fireDeque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }

                if (graph[nextX][nextY] == '#') {
                    continue;
                }

                if (fireDist[nextX][nextY] != -1) {
                    continue;
                }

                fireDeque.add(new int[]{nextX, nextY});
                fireDist[nextX][nextY] = fireDist[nowX][nowY] + 1;
            }
        }

        while (!jDeque.isEmpty()) {
            int[] now = jDeque.removeFirst();
            int nowX = now[0];
            int nowY = now[1];

            if (nowX == 0 || nowY == 0 || nowX == graph.length - 1 || nowY == graph[0].length - 1) {
                System.out.print(jDist[nowX][nowY] + 1);
                return;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }
                int nextDist = jDist[nowX][nowY] + 1;

                if (graph[nextX][nextY] == '#' || jDist[nextX][nextY] != -1) {
                    continue;
                }

                if (fireDist[nextX][nextY] != -1 && fireDist[nextX][nextY] <= nextDist) {
                    continue;
                }

                jDeque.add(new int[]{nextX, nextY});
                jDist[nextX][nextY] = nextDist;
            }
        }
        System.out.print("IMPOSSIBLE");
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
