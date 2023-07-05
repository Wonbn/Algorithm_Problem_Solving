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
        Arrays.sort(xy, ((o1, o2) -> {
            if(o1[0]-o2[0] == 0) return o1[1]-o2[1];
            return o1[0]-o2[0];
        })); // 람다식을 이용해서 x 값이 같다면 y 값을 비교하여 정렬하고, 기본적으로는 x 값을 기준으로 정렬한다.

        for(int i = 0; i < n; i++) System.out.println(xy[i][0]+" "+xy[i][1]);
    }
}