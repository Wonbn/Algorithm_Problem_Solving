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

        int[][] xy = new int[n][2];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            xy[i][0] = Integer.parseInt(st.nextToken());
            xy[i][1] = Integer.parseInt(st.nextToken());
        }

        // 삼항 연산자와 람다식을 이용한 x좌표, y좌표 정렬
        Arrays.sort(xy, ((o1, o2) -> o1[1] != o2[1] ? o1[1]-o2[1] : o1[0]-o2[0]));

        for(int i = 0; i < n; i++) System.out.println(xy[i][0]+" "+xy[i][1]);
    }
}