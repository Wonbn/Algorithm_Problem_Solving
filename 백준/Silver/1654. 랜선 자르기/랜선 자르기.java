import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// k 개의 주어진 랜선을 이용해서 동일한 길이의 n 개의 랜선을 만들어야 한다.
// 여기서 가장 중요한 것은 n 개 이상의 랜선을 만들면서 동시에 최대 길이의 랜선을 만들어야 한다.

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선 수
        int n = Integer.parseInt(st.nextToken()); // 만들어야 하는 랜선 수

        long max = 0;
        long lan[] = new long[k]; // 랜선의 길이를 담는 배열
        for(int i = 0; i < k; i++) {
            lan[i] = Integer.parseInt(br.readLine());
            if(max < lan[i]) max = lan[i]; // 미리 배열의 값 중 최대값을 구해놓는다.
        }

        long res = binaryMaxSearch(max ,lan, n);
        System.out.println(res);
        br.close();
    }

    public static long binaryMaxSearch(long max, long[] lan, int n) {
        long min = 1; long mid; int sum;
        // 배열 중 가장 큰 수를 기준으로 그 수를 쪼개가면서
        // 만들 수 있는 갯수(sum)를 체크하고 그 갯수를 기준으로 이분 분할 탐색을 진행한다.
        while(min <= max) {
            sum = 0;
            mid = (max+min)/2;
            for(int i = 0; i < lan.length; i++) sum += lan[i]/mid;
            if(sum < n) max = mid - 1;
            else min = mid + 1;
        }
        return (max + min)/2;
    }
}