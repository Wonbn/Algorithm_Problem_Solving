import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int m, n;
    static int[][] ground;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while(t-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            ground = new int[n][m];
            for(int i = 0; i < k; i++) {
                st = new StringTokenizer(br.readLine());
                int tmp = Integer.parseInt(st.nextToken());
                ground[Integer.parseInt(st.nextToken())][tmp]++;
            }

            // 필요한 배추흰지렁이 마리 수를 구해주는 메서드
            int count = 0;
            for(int i = 0; i < n; i++) {
                for(int j = 0; j < m; j++) {
                    if(ground[i][j] == 1) {
                        checkOne(i, j);
                        count++;
                    }
                }
            }

            System.out.println(count);
        }
    }

    // 배추흰지렁이가 갈 수 있는 모든 배추를 재귀를 통해서 한번에 구한다.
    private static void checkOne(int i, int j) {
        ground[i][j] = 0;
        if(i-1 >= 0 && ground[i-1][j] == 1) checkOne(i-1, j);
        if(i+1 < n && ground[i+1][j] == 1) checkOne(i+1, j);
        if(j-1 >= 0 && ground[i][j-1] == 1) checkOne(i, j-1);
        if(j+1 < m && ground[i][j+1] == 1) checkOne(i, j+1);
    }
}