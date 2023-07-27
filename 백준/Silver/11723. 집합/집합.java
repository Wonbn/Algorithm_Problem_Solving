import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] s = new int[21];
    static String cmd;

    public static void main(String args[]) throws IOException {
        // 300만의 입출력이 있기 때문에 입출력 모두 버퍼를 이용해서 처리한다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int m = Integer.parseInt(br.readLine());

        int x = 0;
        for(int i = 1; i <= m; i++) {
            cmd = br.readLine();
            switch (cmd.charAt(0)) {
                case 'a' :
                    if(cmd.charAt(1) == 'd') {
                        x = Integer.parseInt(cmd.substring(4));
                        s[x] = 1;
                    } else
                        Arrays.fill(s, 1);
                    break;
                case 'r' :
                    x = Integer.parseInt(cmd.substring(7));
                    s[x] = 0;
                    break;
                case 'c' :
                    x = Integer.parseInt(cmd.substring(6));
                    bw.write(s[x]+"\n");
                    break;
                case 't' :
                    x = Integer.parseInt(cmd.substring(7));
                    s[x] = -(s[x]-1);
                    break;
                case 'e' :
                    Arrays.fill(s, 0);
                    break;
            }
        }
        bw.flush();

        br.close();
        bw.close();
    }
}