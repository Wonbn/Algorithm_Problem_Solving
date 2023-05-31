import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    // 두 수 사이의 최대공약수를 찾는 알고리즘
    public static int gcd(int a, int b) {
        if(b == 0) {
            return a;
        }else {
            return gcd(b, a%b);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int num[] = new int[n+2];
        for(int i = 1; i <= n; i++) num[i] = Integer.parseInt(st.nextToken());

        int[] lgcd = new int[n+2]; // 왼쪽부터 시작해서 1~i 까지의 최대공약수
        int[] rgcd = new int[n+2]; // 오른쪽부터 시작해서 n~i 까지의 최대공약수

        for(int i = 1; i <= n; i++) lgcd[i] = gcd(num[i], lgcd[i-1]);
        for(int i = n; i > 0; i--) rgcd[i] = gcd(num[i], rgcd[i+1]);

        int ans = -1;
        int max = -1;
        for(int i=1; i<=n; i++) {
            int res = gcd(lgcd[i-1], rgcd[i+1]);
            // i 번째를 제외한 왼쪽 숫자들의 최대공약수와
            // 오른쪽 숫자들의 최대공약수의 최대공약수를 구해준다.
            if(res > max) {
                if(num[i]%res !=0) {
                    max = res;
                    ans = num[i];
                }
            } // i 번째를 뺀 숫자들의 최대공약수들의 최대값을 구한다.
        }     // 뺀 수를 k 라고 하면, 나머지 수의 최대공약수가 k의 약수이면 안된다.

        if(ans == -1) System.out.println(-1);
        else System.out.println(max+" "+ans);
    }
}