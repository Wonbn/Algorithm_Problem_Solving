import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] count = new int[100001];
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) arr[i] = Integer.parseInt(st.nextToken());

        int max = -1; int start = 0; int end = 0;
        while (true) {
            // 중복 허용 갯수를 넘지 않았다면 end인덱스를 증가시킨다. (+등장한 숫자 갯수 체크)
            if (end < n && count[arr[end]] < k) {
                count[arr[end]]++;
                end++;
            }

            if (end >= n) break; // end인덱스가 배열의 끝까지 갔다면 종료

            // 만약 중복 허용 갯수에 도달했다면 end인덱스를 멈추고 start인덱스를 증가시킨다.
            if (count[arr[end]] == k) {
                count[arr[start]]--;
                start++;
            }

            // 인덱스를 움직였다면 그때마다 길이 체크
            max = Math.max(max, end - start + 1);

        }

        System.out.println(max);
    }
}