import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, m, b;
    static int[][] height;
    static int resultTime = Integer.MAX_VALUE;
    static int resultHgh = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        int maxHgh = 0;
        height = new int[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                height[i][j] = Integer.parseInt(st.nextToken());
                maxHgh = Math.max(maxHgh, height[i][j]);
            }
        }

        // 가장 높은 높이부터 한칸씩 내려오면서 가장 최소 작업시간을 결정한다.
        for(int h = maxHgh; h >= 0; h--) workingTime(h);

        // 최소작업시간과 그때의 높이 출력
        System.out.println(resultTime+" "+resultHgh);
    }

    // 작업시간을 구한 후 비교하는 메서드
    public static void workingTime(int h) {
        int time = 0;
        int item = b;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int diff = height[i][j] - h;
                if(diff > 0) {
                    time += diff*2;
                    item += diff;
                } else if (diff < 0) {
                    time += -diff;
                    item -= -diff;
                }
            }
        }

        if(item >= 0) {
          if(time < resultTime) {
              resultTime = time;
              resultHgh = h;
          }
        }
    }
}