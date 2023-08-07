import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = stoi(br.readLine());

        // 입력
        int[] difficulty = new int[n+1];
        int[] mistake = new int[n+1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++) {
            difficulty[i] = stoi(st.nextToken());
        }

        // 실수한 악보 누적합 배열 구하는 메서드
        for(int i = 2; i <= n; i++) {
            mistake[i-1] += mistake[i-2];
            if(difficulty[i-1] > difficulty[i]) {
                mistake[i-1]++;
            }
        }

        // 질문에 따른 결과값을 생성하는 메서드
        int q = stoi(br.readLine());
        while(q-- > 0) {
            st = new StringTokenizer(br.readLine());
            int x = stoi(st.nextToken());
            int y = stoi(st.nextToken());

            int result = mistake[y-1] - mistake[x-1];

            bw.write(result+"\n");
        }

        bw.flush();
        br.close();
        bw.close();

    }

    private static int stoi(String in) {
        return Integer.parseInt(in);
    }
}