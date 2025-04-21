import java.util.*;
import java.io.*;

class Main {
    public static void sol() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n % 2 == 0) {
            System.out.println("CY");
            return;
        }
        System.out.println("SK");
    }
    
    public static void main(String[] args) throws Exception {
        sol();
    }
}
