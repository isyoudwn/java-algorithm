import java.io.*;
import java.util.*;

public class Main {

    public static void sol() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Map<String, String> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            String pw = st.nextToken();

            map.putIfAbsent(site, pw);
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            String site = st.nextToken();
            sb.append(map.get(site));
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws Exception {
        sol();
    }
}
