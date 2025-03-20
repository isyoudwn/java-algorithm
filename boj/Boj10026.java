import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[][] graphNormal = new String[N][N];
        String[][] graphGreen = new String[N][N];

        for (int i = 0; i < N; i++) {
            String[] st = br.readLine().split("");
            for (int j = 0; j < st.length; j++) {
                String color = st[j];
                graphNormal[i][j] = color;

                if (color.equals("G")) {
                    graphGreen[i][j] = "R";
                } else {
                    graphGreen[i][j] = color;
                }
            }
        }

        int normal = 0;
        int redGreen = 0;
        for (int i = 0; i < N; i++) {`
            for (int j = 0; j < N; j++) {
                if (!graphNormal[i][j].equals("V")) {
                    bfs(i, j, graphNormal, graphNormal[i][j]);
                    normal++;
                }
                if (!graphGreen[i][j].equals("V")) {
                    bfs(i, j, graphGreen, graphGreen[i][j]);
                    redGreen++;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(normal);
        sb.append(" ");
        sb.append(redGreen);
        System.out.println(sb);
    }

    public static void bfs(int startX, int startY, String[][] graph, String color) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        Deque<int[]> deque = new ArrayDeque<>();

        deque.add(new int[]{startX, startY});
        graph[startX][startY] = "V";

        while (!deque.isEmpty()) {
            int[] curr = deque.removeFirst();
            int nowX = curr[0];
            int nowY = curr[1];

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + nowX;
                int nextY = dy[i] + nowY;

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }

                // 방문 했다면
                if (graph[nextX][nextY].equals("V")) {
                    continue;
                }

                // 다음 노드 색상이 전 노드와 같다면
                if (!graph[nextX][nextY].equals(color)) {
                    continue;
                }

                deque.add(new int[]{nextX, nextY});
                graph[nextX][nextY] = "V";
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
