import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int x, y, count;

    public Node(int x, int y, int count) {
        this.x = x;
        this.y = y;
        this.count = count;
    }
}

public class Main {
    static int n, m, sn, sm;
    static int[][] map;
    static int[][] drc = {{-1,0},{0,1},{1,0},{0,-1}};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 2) {
                    sn = i;
                    sm = j;
                }
            }
        }

        bfs(sn, sm);

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(!visited[i][j] && map[i][j] == 1) map[i][j] = -1;
            }
        }

        for(int i = 0; i < n; i++) {
            if(i != 0) bw.write("\n");
            for(int j = 0; j < m; j++) {
                if(j != 0) bw.write(" ");
                bw.write(Integer.toString(map[i][j]));
            }
        }

        br.close();
        bw.close();
    }

    private static void bfs(int sn, int sm) {
        Queue<Node> q = new LinkedList<>();
        q.add(new Node(sn, sm, 0));
        visited[sn][sm] = true;

        while(!q.isEmpty()) {
            Node node = q.poll();
            map[node.x][node.y] = node.count;

            for(int i = 0; i < 4; i++) {
                int nx = node.x + drc[i][0];
                int ny = node.y + drc[i][1];

                if(nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    if(!visited[nx][ny] && map[nx][ny] == 1) {
                        visited[nx][ny] = true;
                        q.add(new Node(nx, ny, node.count+1));
                    }
                }
            }
        }
    }
}