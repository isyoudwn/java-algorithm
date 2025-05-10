import java.io.*;
import java.util.*;

class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int operations = Integer.parseInt(st.nextToken());

        int[][] graph = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nextX = startX;
        int nextY = startY;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        st = new StringTokenizer(br.readLine());

        StringBuilder sb = new StringBuilder();
        // 위, 남, 동, 서, 북, 아래
        int[] dice = {0, 0, 0, 0, 0, 0};

        for (int i = 0; i < operations; i++) {
            int operation = Integer.parseInt(st.nextToken()) - 1;
            int tempX = nextX + dx[operation];
            int tempY = nextY + dy[operation];

            if (tempX < 0 || tempY < 0 || tempX > N - 1 || tempY > M - 1) {
                continue;
            }
            nextX = tempX;
            nextY = tempY;

            // 동
            // 위, 남, 동, 서, 북, 아래
            if (operation == 0) {
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[5];
                dice[5] = dice[2];
                dice[2] = temp;
            }
            // 서
            if (operation == 1) {
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[5];
                dice[5] = dice[3];
                dice[3] = temp;
            }
            // 북
            if (operation == 2) {
                int temp = dice[0];
                dice[0] = dice[1];
                dice[1] = dice[5];
                dice[5] = dice[4];
                dice[4] = temp;
            }
            // 남
            if (operation == 3) {
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[5];
                dice[5] = dice[1];
                dice[1] = temp;
            }

            if (graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = dice[5];
            } else {
                dice[5] = graph[nextX][nextY];
                graph[nextX][nextY] = 0;
            }

            sb.append(dice[0]);
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
