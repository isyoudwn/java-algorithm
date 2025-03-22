import java.util.*;
import java.io.*;

class Main {

    public static int solution(int N, BufferedReader br) throws Exception {
        int[][] graph = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                graph[i][j] = value;
            }
        }
        return dijk(0, 0, graph);
    }

    public static int dijk(int startX, int startY, int[][] graph) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((int[] a) -> a[2]));
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        pq.add(new int[]{startX, startY, graph[startX][startX]});

        while (!pq.isEmpty()) {
            int[] nowNode = pq.remove();
            int nowX = nowNode[0];
            int nowY = nowNode[1];
            int nowWeight = nowNode[2];
            if (nowX == graph.length - 1 && nowY == graph.length - 1) {
                return nowWeight;
            }

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= graph.length || nextY >= graph[0].length) {
                    continue;
                }

                if (graph[nextX][nextY] == -2) {
                    continue;
                }
                pq.add(new int[]{nextX, nextY, nowWeight + graph[nextX][nextY]});
                graph[nextX][nextY] = -2;
            }
        }
        return -2;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        List<Integer> answers = new ArrayList<>();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) {
                break;
            }
            answers.add(solution(N, br));
        }

        for (int i = 0; i < answers.size(); i++) {
            sb.append("Problem ");
            sb.append(i + 1);
            sb.append(": ");
            sb.append(answers.get(i));

            if (i != answers.size() - 1) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}
