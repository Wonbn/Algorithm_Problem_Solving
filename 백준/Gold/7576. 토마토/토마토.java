import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 1019
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

        storage = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                storage[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bfs();

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(storage[i][j] == 0) {
                    day = -1;
                    break;
                }
            }
        }

        System.out.println(day);
    }

    private static void bfs() {
        Queue<List<int[]>> q = new LinkedList<>();
        List<int[]> tmp = new ArrayList<>();
        q.add(checkOne(tmp)); // 초기에 익은 토마토(1)를 찾아서 그 위치를 저장

        while(!q.isEmpty()) {
            List<int[]> pos = q.poll();
            tmp = new ArrayList<>();

            for(int i = 0; i < pos.size(); i++) {
                int on = pos.get(i)[0];
                int om = pos.get(i)[1];
                visited[on][om] = true;

                for(int j = 0; j < 4; j++) {
                    int dn = on + drc[j][0];
                    int dm = om + drc[j][1];

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

        if(tmp.size() == n*m) tmp = new ArrayList<>(); // 토마토가 모두 익어있는 경우

        return tmp;
    }
}