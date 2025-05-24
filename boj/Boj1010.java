import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            sol(br, sb);
        }
        System.out.println(sb);
    }

    public static void sol(BufferedReader br, StringBuilder sb) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int r = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());


        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        for (int i = 0; i < r; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }


        sb.append(numerator.divide(denominator)).append("\n");
    }
}
