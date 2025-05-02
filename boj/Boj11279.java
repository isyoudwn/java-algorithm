import java.io.*;
import java.util.*;

class Main {
    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0 ; i < n; i++) {
            int operation = Integer.parseInt(br.readLine());

            if (operation == 0) {
                if (pq.isEmpty()) {
                    sb.append(0);
                    sb.append("\n");
                    continue;
                }
                Integer max = pq.remove();
                sb.append(max);
                sb.append("\n");
            }
            else {
                pq.add(operation);
            }
        }
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
