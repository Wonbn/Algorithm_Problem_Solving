import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();


        int[] dp = new int[10001];
        dp[1] = 1;
        dp[2] = 3;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] % 10007 + 2 * dp[i - 2]) % 10007;
        }

        System.out.println(dp[n]);
    }
}