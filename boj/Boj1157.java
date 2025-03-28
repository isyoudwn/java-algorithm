import java.util.*;
import java.io.*;

class Main {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        if (s == null || s.isEmpty()) {  // ✅ null 체크 추가
            System.out.print("?");
            return;
        }

        String upperCase = s.toUpperCase();
        Map<Character, Integer> map = new HashMap<>();

        for (char c : upperCase.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        List<Character> keys = new ArrayList<>(map.keySet());
        keys.sort((a, b) -> map.get(b) - map.get(a));  // ✅ List 사용으로 정렬 간소화

        if (keys.size() > 1 && Objects.equals(map.get(keys.get(0)), map.get(keys.get(1)))) {
            System.out.print("?");
        } else {
            System.out.print(keys.get(0));
        }
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}