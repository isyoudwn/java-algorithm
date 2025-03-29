import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        if (s == null || s.isEmpty()) {
            System.out.print("?");
            return;
        }

        String upperCase = s.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < upperCase.length(); i++) {
            char c = upperCase.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        List<Character> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));

        if (keys.size() > 1 && map.get(keys.get(0)).equals(map.get(keys.get(1)))) {
            System.out.println("?");
        } else {
            System.out.println(keys.get(0));
        }
    }


    public static void main(String[] args) throws Exception {
        solution();
    }
}
