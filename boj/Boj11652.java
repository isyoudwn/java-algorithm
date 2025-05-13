import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Long, Integer> temp = new HashMap<>();

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {
            Long t = Long.valueOf(br.readLine());
            temp.put(t, temp.getOrDefault(t, 0) + 1);
        }

        ArrayList<Long> keyList = new ArrayList<>(temp.keySet());
        keyList.sort(Comparator.comparing((Long a) -> temp.get(a)).reversed().thenComparing((Long a) -> a));
        System.out.println(keyList.get(0));
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
