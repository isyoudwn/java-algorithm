import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

class Main {

    public static void solution() throws Exception {
        Deque<Integer> deque = new ArrayDeque<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operation = st.nextToken();

            if (operation.equals("push")) {
                deque.add(Integer.parseInt(st.nextToken()));
                continue;
            }
            if (operation.equals("empty")) {
                if (!deque.isEmpty()) {
                    sb.append(0);
                } else {
                    sb.append(1);
                }
                sb.append("\n");
                continue;
            }
            if (operation.equals("size")) {
                sb.append(deque.size());
                sb.append("\n");
                continue;
            }
            if (deque.isEmpty()) {
                sb.append(-1);
                sb.append("\n");
                continue;
            }
            if (operation.equals("top")) {
                sb.append(deque.peekLast());
            }
            if (operation.equals("pop")) {
                sb.append(deque.removeLast());
            }

            sb.append("\n");
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.print(sb);
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
