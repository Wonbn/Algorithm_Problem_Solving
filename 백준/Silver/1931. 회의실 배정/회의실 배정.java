import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // 결국 많은 회의를 배정하려면 회의 중 가장 빨리 끝나는 회의를 넣어줘야 선택권이 많다.
        // 하지만, 여기서 회의 시작 시간 또한 가장 빠른 것이 좋다.
        // 따라서 회의가 끝나는 시간을 기준으로 정렬
        Arrays.sort(arr, (o1, o2) -> {
            if(o1[1] == o2[1])
                return o1[0]-o1[1];
            return o1[1]-o2[1];
        });

        // 회의의 끝나는 시간을 기준으로 정렬했기 때문에 그 시간을 기준으로
        // 크거나 같은 회의 시작시간을 고르고 그 중에 가장 빨리 회의가 끝나는 시간을 택한다.
        int endTime = 0; int result = 0;
        for(int i = 0; i < n; i++) {
            if(endTime <= arr[i][0]) {
                endTime = arr[i][1];
                result++;
            }
        }

        System.out.println(result);
    }
}