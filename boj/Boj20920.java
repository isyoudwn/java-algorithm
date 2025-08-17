import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj20920 {
    public static void sol() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Map<String, int[]> words = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String word = br.readLine();
            words.putIfAbsent(word, new int[2]);

            int length = word.length();
            int[] info = words.get(word);

            info[0] = info[0] + 1;
            info[1] = length;

            words.put(word, info);
        }

        List<String> keys = new ArrayList<>(words.keySet());

        keys.sort(
                Comparator.comparingInt((String a) -> words.get(a)[0])
                        .thenComparing(a -> words.get(a)[1]).reversed()
                        .thenComparing((a) -> a)
        );

        StringBuilder sb = new StringBuilder();

        for (String key : keys) {
            if (key.length() >= m) {
                sb.append(key);
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        sol();
    }
}
