import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(br.readLine());
            if (value == 0) {
                int front = 0;
                if (!pq.isEmpty()) {
                    front = pq.remove();
                }
                sb.append(front);
                sb.append("\n");
            } else {
                pq.add(value);
            }
        }

        sb.deleteCharAt(sb.lastIndexOf("\n"));

        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
