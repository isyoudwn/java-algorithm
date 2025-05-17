import java.io.*;
import java.util.*;

class Main {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer a = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(a.nextToken()) - Integer.parseInt(a.nextToken());
        System.out.println(i);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
