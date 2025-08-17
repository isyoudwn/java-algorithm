import java.io.*;
import java.util.*;

public class Main {

    public static void solution() throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int i = Integer.parseInt(st.nextToken());
        int j = Integer.parseInt(st.nextToken());

        System.out.println(i/(double)j);
    }

    public static void main(String[] args) throws Exception {
        solution();
    }
}
