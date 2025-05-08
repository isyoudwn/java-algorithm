import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        // 행
        int N = Integer.parseInt(st.nextToken());
        // 열
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int Y = Integer.parseInt(st.nextToken());
        int operationsCount = Integer.parseInt(st.nextToken());
        int[][] graph = new int[N][M];

        int[] dice = new int[6]; // [윗면, 바닥면, 북쪽면, 남쪽면, 서쪽면, 동쪽면]

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int nowX = X;
        int nowY = Y;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {1, -1, 0, 0};

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < operationsCount; i++) {
            int direct = Integer.parseInt(st.nextToken()) - 1;

            int nextX = nowX + dx[direct];
            int nextY = nowY + dy[direct];

            // 올바르지 않은 경우
            if (nextX < 0 || nextY < 0 || nextX > N - 1 || nextY > M - 1) {
                continue;
            }
            
            // [윗면, 바닥면, 북쪽면, 남쪽면, 서쪽면, 동쪽면]
            if (direct == 0) { // 동쪽
                int temp = dice[0];
                dice[0] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
            } else if (direct == 1) { // 서쪽
                int temp = dice[0];
                dice[0] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
            } else if (direct == 2) { // 북쪽
                int temp = dice[0];
                dice[0] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
            } else if (direct == 3) { // 남쪽
                int temp = dice[0];
                dice[0] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
            }

            if (graph[nextX][nextY] == 0) {
                graph[nextX][nextY] = dice[1];  // 바닥면 값 복사
            } else {
                dice[1] = graph[nextX][nextY];  // 바닥면에 칸 값 복사
            }

            sb.append(dice[0]).append("\n");
            nowX = nextX;
            nowY = nextY;
        }

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
