import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int n, result;
    static int[][] s;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        s = new int[n][n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for(int j = 0; j < n; j++) s[i][j] = Integer.parseInt(st.nextToken());
        }

        result = Integer.MAX_VALUE;
        visit = new boolean[n]; // *방문여부*를 기준으로 스타트팀(true)과 링크팀(false)을 나눈다.
        solve(0);
        System.out.println(result);
    }

    // 재귀함수를 이용해서 1~n 까지의 모든 경우의 수를 계산
    private static void solve(int depth) {
        if (depth == n) {
            diff();
            return;
        }
        visit[depth] = true;
        solve(depth + 1);
        visit[depth] = false;
        solve(depth + 1);
    }

    // 방문여부를 이용한 스타트팀과 링크팀 차이를 구하는 메서드
    public static void diff() {
        int start = 0, link = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (visit[i] != visit[j]) continue; // 방문여부가 같지 않다면 다른 팀.
                if (visit[i]) start += s[i][j] + s[j][i]; // 방문여부가 true 이면 스타트팀에 능력치를 더해줌.
                else link += s[i][j] + s[j][i]; // 방문여부가 false 이면 링크팀에 능력치를 더해줌.
            }
        }
        int tmp = Math.abs(start - link);
        if (tmp < result) result = tmp; // 두 팀 간의 능력치 차이에 대한 최소값 구하기
    }
}