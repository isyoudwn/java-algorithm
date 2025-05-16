import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            Deque<Integer> deque = new ArrayDeque<>();
            String operations = br.readLine();
            int size = Integer.parseInt(br.readLine());

            String temp = br.readLine();
            temp = temp.replaceAll("\\[", "");
            temp = temp.replaceAll("]", "");
            StringTokenizer st = new StringTokenizer(temp, ",");

            for (int j = 0; j < size; j++) {
                deque.add(Integer.parseInt(st.nextToken()));
            }

            boolean flag = false;
            for (int j = 0; j < operations.length(); j++) {
                if (deque.isEmpty()) {
                    flag = true;
                    break;
                }
                if (operations.charAt(j) == 'R') {
                    deque = deque.reversed();
                }
                if (operations.charAt(j) == 'D') {
                    deque.removeFirst();
                }
            }

            if (flag) {
                System.out.println("error");
            }
            if (!deque.isEmpty()) {
                System.out.println(Arrays.toString(deque.toArray()));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
