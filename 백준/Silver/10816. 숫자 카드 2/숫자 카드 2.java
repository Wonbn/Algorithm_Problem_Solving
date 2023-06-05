import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine()); // 상근이가 가지고 있는 숫자카드의 개수

        int idx;
        int cardN[] = new int[20000001]; // -10,000,000 ~ 10,000,000 (index : 0 ~ 20,000,000) 숫자배열
        Arrays.fill(cardN, 0);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            idx = Integer.parseInt(st.nextToken()) + 10000000;
            cardN[idx]++; // 가지고 있는 숫자가 몇 개 있는 숫자배열에 저장한다.
        }

        int m = Integer.parseInt(br.readLine()); // 기준(비교) 숫자카드의 개수

        int num;
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < m; i++) {
            num = Integer.parseInt(st.nextToken());
            bw.write(cardN[num+10000000]+" ");
        }
        br.close();
        bw.flush();
        bw.close();
    }
}