import java.io.*;
import java.util.*;

class Main {
    public static boolean solution(BufferedReader br) throws Exception {
        PriorityQueue<String> pq = new PriorityQueue<>();

        int size = Integer.parseInt(br.readLine());

        for (int i = 0; i < size; i++) {
            pq.add(br.readLine());
        }

        boolean status = true;
        String prefix = pq.remove();

        while (!pq.isEmpty()) {
            String now = pq.remove();
            if (now.startsWith(prefix)) {
                status = false;
            } else {
                prefix = now;
            }
        }
        return status;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testCase; i++) {
            boolean result = solution(br);
            if (result) {
                sb.append("YES\n");
            }
            else {
                sb.append("NO\n");
            }
        }
        System.out.print(sb);
    }
}

