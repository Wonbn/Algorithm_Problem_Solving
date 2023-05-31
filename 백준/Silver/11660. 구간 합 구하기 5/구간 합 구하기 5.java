import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num[][] = new int[n+1][n+1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) num[i][j+1] = num[i][j] + Integer.parseInt(st.nextToken());
        }

        int sum; int x1; int y1; int x2; int y2;
        for(int i = 0; i < m; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            for(int j = x1; j <= x2; j++) sum += num[j][y2] - num[j][y1-1];
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
    }
}