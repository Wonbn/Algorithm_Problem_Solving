import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static long[] a, dp;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        a = new long[n];
        dp = new long[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        Arrays.fill(dp, -1);
        System.out.println(findMinForce(0));
    }

    public static long findMinForce(int x) {
        if(x == n-1) return 0;
        if(dp[x] != -1) return dp[x];

        dp[x] = Long.MAX_VALUE;

        for(int i = x+1; i < n; i++)
            dp[x] = Math.min(dp[x], Math.max(findMinForce(i),(i-x)*(1+Math.abs(a[x]-a[i]))));

        return dp[x];
    }
}