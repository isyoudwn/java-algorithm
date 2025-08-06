import java.io.*;
import java.util.*;

public class Main {

    public static void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<String> deque = new ArrayDeque<>();
        Deque<String> result = new ArrayDeque<>();
        Set<String> dupleSet = new HashSet<>();

        int limit = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        for (int i = 0; i < length; i++) {
            String studentNumber = br.readLine();
            deque.addFirst(studentNumber);
        }

        for (String source : deque) {
            if (dupleSet.contains(source)) {
                continue;
            }
            dupleSet.add(source);
            result.addFirst(source);
        }

        StringBuilder sb = new StringBuilder();

        while (!result.isEmpty()) {
            if (limit == 0) {
                break;
            }
            String front = result.removeFirst();
            limit--;
            sb.append(front);
            sb.append("\n");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws Exception {
        sol();
    }
}
