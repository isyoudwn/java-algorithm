import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int f = Integer.parseInt(st.nextToken()); // 가장 높은 층
        int s = Integer.parseInt(st.nextToken());  // 강호의 위치
        int g = Integer.parseInt(st.nextToken()); // 스타트링크가 있는 곳
        int u = Integer.parseInt(st.nextToken()); // +u만큼 이동
        int d = Integer.parseInt(st.nextToken()); // -d만큼 이동

        bfs(s, g, u, d, f);
    }

    public static void bfs(int start, int target, int up, int down, int max) {
        Deque<Integer> deque = new ArrayDeque<>();
        Map<Integer, Integer> dist = new HashMap<>();
        int count = 0;

        int[] d = {up, -down};

        dist.put(start, 0);
        deque.add(start);

        while (!deque.isEmpty()) {
            int now = deque.removeFirst();

            if (now == target) {
                System.out.println(dist.get(now));
                return;
            }

            for (int i = 0; i < d.length; i++) {
                int next = now + d[i];

                if (next < 1 || next > max) {
                    continue;
                }
                if (dist.containsKey(next)) {
                    continue;
                }
                deque.add(next);
                dist.put(next, dist.get(now) + 1);
            }
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}

