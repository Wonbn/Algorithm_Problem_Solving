import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static char[][] tiles;
    static Map<String, Integer> numbersOfCases = new HashMap<>();
    static int[][] drc = {{0,1},{1,1},{1,0},{1,-1},{0,-1},{-1,-1},{-1,0},{-1,1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        // 입력값 저장
        n = stoi(st.nextToken());
        m = stoi(st.nextToken());
        int k = stoi(st.nextToken());
        
        // 타일 정보 저장
        tiles = new char[n][m];
        for(int i = 0; i < n; i++) {
            tiles[i] = br.readLine().toCharArray();
        }
        
        // 신이 좋아하는 문자열 저장 -> numbersOfCases
        String[] godString = new String[k];
        for (int i = 0; i < k; i++) {
            godString[i] = br.readLine();
            numbersOfCases.put(godString[i], 0);
        }
        
        // bfs 알고리즘을 이용해서 나올 수 있는 모든 경우의 수를
        // 따져서 신이 좋아하는 문자열과 같다면 경우의 수를 늘려준다.
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                bfs(i, j);
            }
        }

        for(String key : godString) {
            System.out.println(numbersOfCases.get(key));
        }
    }

    private static void bfs(int x, int y) {
        Queue<Tile> q = new LinkedList<>();

        q.add(new Tile(x, y, tiles[x][y] + "")); // 먼저 시작인덱스에 해당하는 문자를 넣는다.

        while (!q.isEmpty()) {
            Tile tile = q.poll();

            if(numbersOfCases.containsKey(tile.str)) { // 신이 좋아하는 문자열이라면 Count++
                numbersOfCases.put(tile.str, numbersOfCases.get(tile.str)+1);
            }

            if(tile.str.length() >= 5) { // 길이가 5보다 크거나 같다면 탐색 X
                continue;
            }

            // 8개 방향에 있는 타일을 큐에 저장 -> 다시 위로 올라가서 불러오는 방식
            for(int i = 0; i < 8; i++) {
                int idxN = (tile.x + drc[i][0]) % n;
                int idxM = (tile.y + drc[i][1]) % m;

                if(idxN < 0) idxN += n;
                if(idxM < 0) idxM += m;

                q.add(new Tile(idxN, idxM, tile.str + tiles[idxN][idxM]));
            }
        }
    }

    private static int stoi(String in) {
        return Integer.parseInt(in);
    }
}

class Tile {
    int x,y;
    String str;

    public Tile(int x, int y, String str) {
        this.x = x;
        this.y = y;
        this.str = str;
    }
}