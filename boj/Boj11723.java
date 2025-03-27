import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Set<Integer> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String operate = st.nextToken();

            if (operate.equals("all")) {
                set.clear();
                for (int j = 1; j <= 20; j++) {
                    set.add(j);
                }
                continue;
            }

            if (operate.equals("empty")) {
                set.clear();
                continue;
            }

            int value = Integer.parseInt(st.nextToken());

            if (operate.equals("add")) {
                set.add(value);
            }

            if (operate.equals("remove")) {
                set.remove(value);
            }

            if (operate.equals("check")) {
                if (set.contains(value)) {
                    sb.append(1);
                } else {
                    sb.append(0);
                }
                sb.append("\n");
            }
            if (operate.equals("toggle")) {
                if (set.contains(value)) {
                    set.remove(value);
                } else {
                    set.add(value);
                }
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.lastIndexOf("\n"));
        }
        System.out.print(sb);
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
