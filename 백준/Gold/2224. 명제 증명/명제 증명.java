import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        boolean[][] connect = new boolean[52][52];

        // 입력
        int N = Integer.parseInt(br.readLine());
        char a, b;
        for (int i = 0; i < N; i++) {
            String in = br.readLine();
            a = in.charAt(0);
            b = in.charAt(5);
            connect[atoi(a)][atoi(b)] = true; // 알파벳을 숫자로 변환하여 저장
        }

        // 플로이드 워셜 (모든 지점 to 모든 지점)
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                for (int k = 0; k < 52; k++) {
                    if (connect[j][i] && connect[i][k]) connect[j][k] = true;
                }
            }
        }

        // 출력
        int X = 0;
        for (int i = 0; i < 52; i++) {
            for (int j = 0; j < 52; j++) {
                if(i != j && connect[i][j]) {
                    X++;
                    sb.append(itoa(i)).append(" => ").append(itoa(j)).append("\n");
                }
            }
        }
        System.out.println(X);
        System.out.println(sb);
    }

    private static int atoi(char a) {
        return (a >= 'A' && a <= 'Z') ? a - 'A' : a - 'a' + 26;
    }

    private static char itoa(int i) {
        return (i >= 0 && i <= 25) ? (char)(i + 65) : (char) (i + 97 - 26);
    }
}