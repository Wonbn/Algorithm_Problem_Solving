import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] index = new long[n];
        long index_sum = 0;
        for(int i = 0; i < n; i++) {
            index[i] = Integer.parseInt(st.nextToken());
            index_sum += index[i]; // 모든 집 위치의 합을 구한다.
        }
        Arrays.sort(index); // 들어온 위치값 오름차순 정렬

        long left_sum = 0, right_sum = 0;
        long[] left = new long[n];
        long[] right = new long[n];
        for(int i = 0; i < n; i++) {
            left[i] = i*index[i] - left_sum;
            left_sum += index[i];
            // 자기 자신의 인덱스는 자기 자신보다 작거나 같은 위치의 갯수를 의미
            // 따라서 현위치*인덱스 - 이전 위치의 합을 구하면 자신보다 왼쪽에 있는 위치 간의 거리의 총합을 알 수 있다.
            right_sum = index_sum - left_sum;
            right[i] = right_sum - (n-i-1)*index[i];
            // 오른쪽에 있는 집 위치 간에 차이는 왼쪽에 위치 간의 총합을 전체 총합에서 빼준 후에
            // 자기 자신과 자신보다 높은 위치에 있는 집의 갯수만큼 자신의 위치를 빼준다.
        }

        // 자신의 위치를 제외한 양쪽 집 위치의 거리 차이를 모두 더해준 값들의 최소값을 구한다.
        long position = index[0];
        long min = right[0] + left[0];
        for(int i = 1; i < n; i++) {
            if(min > (right[i] + left[i])) {
                min = right[i] + left[i];
                position = index[i];
            }
        }
        System.out.println(position);
    }
}