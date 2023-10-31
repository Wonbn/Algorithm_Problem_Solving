import java.util.*;

class Solution {
    public int solution(String dirs) {
        int answer = 0;
        boolean[][][] m = new boolean[11][11][4];
        
        // 위아래오왼
        int[] dy = new int[] {-1, 1, 0, 0};
        int[] dx = new int[] {0, 0, 1, -1};
        Map<Character, Integer> map = new HashMap<>();
        map.put('U', 0); map.put('D', 1); map.put('R', 2); map.put('L', 3);
        
        int y = 5;
        int x = 5;
        for(char cmd : dirs.toCharArray()) {
            int ny = y + dy[map.get(cmd)];
            int nx = x + dx[map.get(cmd)];
            int rNum = ((map.get(cmd)%2)+1)%2+(map.get(cmd)/2)*2;
            if(ny < 0 || ny > 10 || nx < 0 || nx > 10) continue;                              
                 
            boolean check = true;
            if(!m[y][x][map.get(cmd)]) m[y][x][map.get(cmd)] = true;
            else check = false;
            y = ny;
            x = nx;
            
            if(check && !m[ny][nx][rNum]) {
                m[ny][nx][rNum] = true;
                answer++;
            }
        }
        
        
        return answer;
    }
}