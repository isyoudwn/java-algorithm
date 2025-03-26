import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for (int j = 0; j < N; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            pq.remove();
        }

        System.out.print(pq.remove());
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
