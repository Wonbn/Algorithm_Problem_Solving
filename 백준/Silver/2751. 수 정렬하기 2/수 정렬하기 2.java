import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] num = new int[2000001];
        // -100만 ~ 100만까지 숫자를 담고 있는 배열을 미리 만들어준다.
        // (인덱스는 0 ~ 2000001까지)
        int N = Integer.parseInt(br.readLine());

        int a;
        for(int i = 0; i < N; i++) {
            a = Integer.parseInt(br.readLine());
            num[a+1000000] = 1;
        }

        for(int i = 0; i < num.length; i++) {
            if(num[i] == 1) bw.write((i-1000000)+"\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }
}