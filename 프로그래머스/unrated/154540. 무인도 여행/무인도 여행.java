import java.util.*;

class Solution {
    static int xl, yl;
    static boolean[][] visited;
    static int[][] drc = new int[][]{{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    static int[] answer;

    public int[] solution(String[] maps) {
        List<Integer> list = new ArrayList<>();
        xl = maps.length; yl = maps[0].length();
        visited = new boolean[xl][yl];

        for(int i = 0; i < xl; i++) {
            for(int j = 0; j < yl; j++) {
                if(maps[i].charAt(j) == 'X') visited[i][j] = true;
            }
        }

        for(int i = 0; i < xl; i++) {
            for(int j = 0; j < yl; j++) {
                if(!visited[i][j]) {
                    int[] idx = new int[] {i, j};
                    int sum = bfs(maps, idx);
                    list.add(sum);
                }
            }
        }

        if(list.size() == 0) {
            answer = new int[] {-1};
        } else {
            answer = new int[list.size()];
            for(int i = 0; i < list.size(); i++) {
                answer[i] = list.get(i);
            }
            Arrays.sort(answer);
        }

        return answer;
    }

    private int bfs(String[] maps, int[] idx) {
        Queue<int[]> q = new LinkedList<>();
        int sum = 0;
        q.add(idx);
        visited[idx[0]][idx[1]] = true;
        sum += (maps[idx[0]].charAt(idx[1]) -'0');

        while(!q.isEmpty()) {
            int[] cur = q.poll();

            for(int i = 0; i < 4; i++) {
                int di = cur[0] + drc[i][0];
                int dj = cur[1] + drc[i][1];
                if((di >= 0 && di < xl) && (dj >= 0 && dj < yl)) {
                    if(!visited[di][dj]) {
                        q.add(new int[] {di, dj});
                        sum += (maps[di].charAt(dj) -'0');
                        visited[di][dj] = true;
                    }
                }
            }

        }

        return sum;
    }
}