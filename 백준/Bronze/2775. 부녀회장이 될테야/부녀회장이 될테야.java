import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] kn; int[][] sum;
        int T = Integer.parseInt(br.readLine());
        for(int i = 0; i < T; i++) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            kn = new int[k+1][n+1];
            sum = new int[k+1][n+1];
            for(int j = 1; j < n+1; j++) {
                kn[0][j] = j;
                sum[0][j] = kn[0][j] + sum[0][j-1];
            }
            for(int j = 1; j < k+1; j++) {
                for(int x = 1; x < n+1; x++) {
                    kn[j][x] = sum[j-1][x];
                    sum[j][x] = kn[j][x] + sum[j][x-1];
                }
            }
            System.out.println(kn[k][n]);
        }
    }
}