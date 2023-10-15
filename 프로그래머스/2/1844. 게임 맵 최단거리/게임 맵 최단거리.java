import java.util.*;

class Solution {
    // 동서남북 방향 설정
    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};
    
    public int solution(int[][] maps) {
        int answer = 0;
        
        // 해당 노드의 거리 배열 초기화
        int[][] distance = new int[maps.length][maps[0].length];
        
        // BFS 알고리즘을 이용한 최단거리탐색
        bfs(maps, distance);
        
        // answer에 상대팀 진영을 가기 위한 거리 저장
        answer = distance[maps.length-1][maps[0].length-1];
        
        return answer == 0 ? -1 : answer;
    }
    
    public void bfs(int[][] maps, int[][] distance){
        int x = 0, y = 0;
        distance[x][y] = 1;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});
        
        while(!queue.isEmpty()){
            int[] current = queue.remove();
            int cX = current[0];
            int cY = current[1];
            
            for(int i = 0; i < 4; i++){
                int nX = cX + dx[i];
                int nY = cY + dy[i];
                
                // 게임 맵 크기를 벋어난 곳으로의 움직임을 제한한다.
                if(nX < 0 || nX > maps.length-1 || nY < 0 || nY > maps[0].length-1)
                    continue;
                
                // 해당 자리를 한번도 방문하지 않았고, 해당자리가 벽이 아닌 길이라면
                // 거리를 구해서 값을 넣어준다.
                if(distance[nX][nY] == 0 && maps[nX][nY] == 1){
                    distance[nX][nY] = distance[cX][cY] + 1;
                    
                    // 만약에 상대 진영에 도착했다면, 바로 종료해준다.
                    // if(nX == maps.length-1 && nY == maps[0].length-1) return;
                    queue.add(new int[]{nX, nY});
                }
            }
            
        }
        
        
    }
}