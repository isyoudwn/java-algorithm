
import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    public static void solution() throws Exception {
        Map<String, String> map = new HashMap<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String logName = st.nextToken();
            String logOperation = st.nextToken();

            if (!map.containsKey(logName)) {
                map.put(logName, logOperation);
            } else if (logOperation.equals("leave")) {
                map.remove(logName);
            }
        }
        String[] names = map.keySet().toArray(String[]::new);
        Arrays.sort(names, (a, b) -> b.compareTo(a));

        StringBuilder sb = new StringBuilder();

        for (String name : names) {
            sb.append(name);
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);
        System.out.print(sb);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
