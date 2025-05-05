import java.io.*;
import java.util.*;

class Main {
    public static void solution() throws Exception {
        int INF = 100000;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[INF + 1];
        int[] dist = new int[INF + 1];

        Deque<Integer> deque = new ArrayDeque<>();
        deque.add(from);
        visited[from] = true;

        while (!deque.isEmpty()) {
            int now = deque.removeFirst();

            if (now == to) {
                System.out.println(dist[now]);
                return;
            }

            for (int next : new int[]{now - 1, now + 1, now * 2}) {
                if (next < 0 || next > INF || visited[next]) {
                    continue;
                }
                visited[next] = true;
                dist[next] = dist[now] + 1;
                deque.add(next);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
