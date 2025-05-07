import java.io.*;
import java.util.*;

class Main {
    private static final int MAX = 100000;

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int from = Integer.parseInt(st.nextToken());
        int to = Integer.parseInt(st.nextToken());
        int[] time = new int[MAX + 1];
        Arrays.fill(time, -1);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparing((a -> a[0])));

        pq.add(new int[]{0, from});

        while (!pq.isEmpty()) {
            int[] now = pq.remove();
            int nowTime = now[0];
            int nowNumber = now[1];

            if (time[nowNumber] != -1) {
                continue;
            }
            time[nowNumber] = nowTime;

            if (nowNumber == to) {
                System.out.println(time[to]);
                return;
            }
            int teleport = nowNumber * 2;
            int plusPort = nowNumber + 1;
            int minusPort = nowNumber - 1;

            if (teleport >= 0 && teleport <= MAX && time[teleport] == -1) {
                pq.add(new int[]{nowTime, teleport});
            }
            if (plusPort >= 0 && plusPort <= MAX && time[plusPort] == -1) {
                pq.add(new int[]{nowTime + 1, plusPort});
            }
            if (minusPort >= 0 && minusPort <= MAX && time[minusPort] == -1) {
                pq.add(new int[]{nowTime + 1, minusPort});
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
