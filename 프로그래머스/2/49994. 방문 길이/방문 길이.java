import java.util.*; // 141

// 0 : U / 1 : D / 2 : R / 3 : L
class Solution {
    public int solution(String dirs) {
        int answer = 0;
        int[] dy = new int[] {-1, 1, 0, 0};
        int[] dx = new int[] {0, 0, 1, -1};
        boolean[][][] visited = new boolean[11][11][4];        
        
        int[] idx = new int[] {5, 5};
        for(char cmd : dirs.toCharArray()) {
            if(cmd == 'U') {
                if(idx[0] + dy[0] < 0) continue;
                int ny = idx[0] + dy[0];
                int nx = idx[1] + dx[0];
                if(!visited[ny][nx][1] && !visited[idx[0]][idx[1]][0]) {
                    answer++;
                    visited[idx[0]][idx[1]][0] = true;
                    visited[ny][nx][1] = true;
                }
                idx[0] = ny;
                idx[1] = nx;
            }
            if(cmd == 'D') {
                if(idx[0] + dy[1] >= 11) continue;
                int ny = idx[0] + dy[1];
                int nx = idx[1] + dx[1];
                if(!visited[ny][nx][0] && !visited[idx[0]][idx[1]][1]) {
                    answer++;
                    visited[idx[0]][idx[1]][1] = true;
                    visited[ny][nx][0] = true;
                }
                idx[0] = ny;
                idx[1] = nx;
            }
            if(cmd == 'R') {
                if(idx[1] + dx[2] >= 11) continue;
                int ny = idx[0] + dy[2];
                int nx = idx[1] + dx[2];
                if(!visited[ny][nx][3] && !visited[idx[0]][idx[1]][2]) {
                    answer++;
                    visited[idx[0]][idx[1]][2] = true;
                    visited[ny][nx][3] = true;
                }
                idx[0] = ny;
                idx[1] = nx;
            }
            if(cmd == 'L') {
                if(idx[1] + dx[3] < 0) continue;
                int ny = idx[0] + dy[3];
                int nx = idx[1] + dx[3];
                if(!visited[ny][nx][2] && !visited[idx[0]][idx[1]][3]) {
                    answer++;
                    visited[idx[0]][idx[1]][3] = true;
                    visited[ny][nx][2] = true;
                }
                idx[0] = ny;
                idx[1] = nx;
            }
        }
        
        return answer;
    }
}