import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int num[] = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) num[i+1] = num[i] + Integer.parseInt(st.nextToken());

        int sum;
        for(int i = 0; i < m; i++) {
            sum = 0;
            st = new StringTokenizer(br.readLine());
            sum -= num[Integer.parseInt(st.nextToken())-1];
            sum += num[Integer.parseInt(st.nextToken())];
            bw.write(sum + "\n");
        }

        bw.flush();
        bw.close();
    }
}