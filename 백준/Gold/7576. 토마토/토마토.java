import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int day = 0;
    static int n, m;
    static int[][] storage;
    static boolean[][] visited;
    static int[][] drc = {{-1,0},{0,1},{1,0},{0,-1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        // 입력
        storage = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        // 만약에 인접 칸을 모두 탐색하여 토마토를 모두 익혔는데
        // 익히지 못한 토마토가 있다면 -1 출력
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(storage[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }

        // 출력
        System.out.println(day);
    }

    // 초기에 익은 토마토(1)의 위치를 저장해서 List<int[]> 형태로 저장해놓는다.
    // 그 위치의 인접 칸을 탐색하면서 익지 않은 토마토를 익히고 그 위치를 다시 List<int[]> 형태로 저장한다.
    // 그리고 그 위치를 기준으로 또 인접 칸을 탐색을 반복한다.
    private static void bfs() {
        Queue<List<int[]>> q = new LinkedList<>();
        List<int[]> tmp = new ArrayList<>();
        q.add(checkOne(tmp)); // 초기에 익은 토마토(1)를 찾아서 그 위치를 저장

        while(!q.isEmpty()) {
            List<int[]> pos = q.poll();
            tmp = new ArrayList<>();

            for(int i = 0; i < pos.size(); i++) { // 값이 1인 칸을 모두 탐색
                int on = pos.get(i)[0];
                int om = pos.get(i)[1];
                visited[on][om] = true;

                for(int j = 0; j < 4; j++) { // 인접한 4방향을 탐색
                    int dn = on + drc[j][0];
                    int dm = om + drc[j][1];

                    // 만약에 허용범위 내 값이 0이고, 아직 방문하지 않은 칸이라면 저장
                    if(dn >= 0 && dn < n && dm >= 0 && dm < m) { 
                        if(!visited[dn][dm] && storage[dn][dm] == 0) {
                            tmp.add(new int[]{dn, dm});
                            storage[dn][dm] = 1;
                        }
                    }
                }
            }
            if(!tmp.isEmpty()) {
                q.add(tmp);
                day++;
            }
        }
    }

    private static List<int[]> checkOne(List<int[]> tmp) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(storage[i][j] == 1) {
                    tmp.add(new int[] {i, j});
                }
            }
        }

        return tmp;
    }
}