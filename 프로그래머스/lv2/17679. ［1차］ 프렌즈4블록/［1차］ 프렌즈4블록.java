import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        char[][] map = new char[m][n];
        int[] dm = new int[] {0, 1, 1};
        int[] dn = new int[] {1, 1, 0};

        for(int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }

        while(true) {
            // 블록이 4개 뭉쳐있는 확인
            boolean[][] check = new boolean[m][n];
            boolean checkOut = true;
            for(int i = 0; i < m-1; i++) {
                for(int j = 0; j < n-1; j++) {
                    if(map[i][j] == '.') continue;
                    boolean checkFour = true;
                    for(int k = 0; k < 3; k++) {
                        int um = i + dm[k];
                        int un = j + dn[k];
                        if(map[i][j] != map[um][un]) {
                            checkFour = false;
                        }
                    }
                    if(checkFour) { // 4개 뭉쳐있다면 표시
                        check[i][j] = true;
                        checkOut = false;
                        for(int k = 0; k < 3; k++) {
                            int um = i + dm[k];
                            int un = j + dn[k];
                            check[um][un] = true;
                        }
                    }
                }
            }

            if(checkOut) break;

            // 4개로 뭉쳐있다고 표시된 블록을 없앤다.
            for(int i = 0; i < m; i++) {
                for(int j = 0; j < n; j++) {
                    if(check[i][j]) {
                        answer++;
                        map[i][j] = '.';
                    }
                }
            }

            // 블록들이 내려온다.
            for(int i = 0; i < n; i++) {
                StringBuilder sb = new StringBuilder();
                boolean checkX = false;
                int mj = 0;
                for(int j = m-1; j >= 0; j--) {
                    if(checkX && map[j][i] != '.') {
                        sb.append(map[j][i]);
                        map[j][i] = '.';
                    }

                    if(!checkX && map[j][i] == '.') {
                        checkX = true;
                        mj = j;
                    }
                }
                int l = sb.toString().length();
                if(l != 0) {
                    for(int j = 0; j < l; j++) {
                        map[mj--][i] = sb.toString().charAt(j);
                    }
                }
            }
        }
        return answer;
    }
}