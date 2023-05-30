import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // n개의 칸 (1~n) -> 칸마다 높이를 가지고 있음
        int m = Integer.parseInt(st.nextToken()); // 조교들의 수 (m명)

        st = new StringTokenizer(br.readLine());
        int h[] = new int[n+1]; // 연병장 각 칸의 높이
        for(int i = 1; i < n+1; i++) h[i] = Integer.parseInt(st.nextToken());

        int[] addK = new int[n+2];
        while(m-- > 0) { // 조교 m명의 지시 통합
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            addK[a] += k;
            addK[b+1] -= k;
            // k값이 각각 더해지고 빼지는 지점을 정의한다.
        }

        int addM = 0;
        for(int i = 1; i <= n; i++) {
            addM += addK[i]; // 지점마다 k값을 갱신해준다.
            h[i] += addM; // 각 지점에서 변화해야할 k값의 총 변화값을 갱신해준다.
            bw.write(h[i] + " ");
        }
        bw.flush();
        bw.close();
    }
}