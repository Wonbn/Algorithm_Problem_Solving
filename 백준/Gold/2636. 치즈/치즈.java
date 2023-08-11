import java.io.IOException;
import java.util.*;

public class Main {
    static int n, m;
    static int count = 0;
    static int time = 0;
    static int[][] square;
    static boolean[][] visit;
    static int[][] drc = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}}; // 북 동 남 서

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        m = sc.nextInt();

        square = new int[n][m];
        for (int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                square[i][j] = sc.nextInt();
            }
        }

        // 칸이 모두 공기이면 탐색을 중진한다.
        while (!checkO2()) {
            count = 0; // 녹인 치즈의 갯수
            time++; // 한번 치즈을 녹일때마다 한 시간씩 추가
            visit = new boolean[n][m];
            bfs();
        }

        // 치즈가 모두 녹아 공기가 된다면,
        // 그때의 시간과 공기가 되기 직전에 남아있었던 치즈의 갯수를 출력한다.
        System.out.println(time);
        System.out.println(count);
    }

    // bfs 를 이용해서 한 시간 동안 치즈를 녹인다.
    public static void bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {0, 0}); // 0, 0 부터 시작
        visit[0][0] = true;

        while (!q.isEmpty()) {
            int[] tile = q.poll();

            // 칸에 치즈가 놓여져 있다면, 그 치즈의 인접한 칸은 탐색하지 않도록 큐에 넣지 않고, 치즈를 녹여준다.
            // 방문한 칸을 제외한 인접한 칸을 탐색한다.
            // 이번 시간에 녹아 없어진 치즈 칸은 방문이 된 칸이기 때문에 그 칸의 인접한 칸은 탐색하지 않는다.
            for (int i = 0; i < 4; i++) {
                int nu = tile[0] + drc[i][0];
                int nv = tile[1] + drc[i][1];

                if ((nu >= 0 && nu < n) && (nv >= 0 && nv < m) && !visit[nu][nv]) {
                    visit[nu][nv] = true;
                    if(square[nu][nv] == 0) {
                        q.offer(new int[] {nu, nv});
                    } else {
                        square[nu][nv] = 0;
                        count++;
                    }
                }
            }

        }
    }

    public static boolean checkO2() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (square[i][j] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}