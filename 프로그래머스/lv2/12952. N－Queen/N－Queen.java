class Solution {
    int[] board; // 2차원 배열 문제를 1차원으로 압축
    int count = 0;

    public int solution(int n) {
        board = new int[n];
        backTracking(n, 0); // 백트래킹을 이용해서 탐색

        return count;
    }

    public void backTracking(int n, int row) {
        if (row == n) { // 모든 퀸을 놓았다면 카운트
            count++;
            return;
        }

        // board의 row는 세로줄이고, i는 가로줄이다.
        // 말하자면 (row, i) 에 퀸이 존재한다는 의미이다.
        for (int i = 0; i < n; i++) {
            board[row] = i;
            if (possible(row)) {
                backTracking(n, row + 1);
            }
        }

    }

    // 결국 체스판에서 가로든 세로든 대각선이든 하나의 퀸만 존재해야하기 때문에
    // possible 메서드를 이용해서 가능한지 체크하면 된다.
    public boolean possible(int row) {
        for (int i = 0; i < row; i++) {
            // 세로가 같을때
            // 예를 들어 board = {3,3,0,1} 이렇게 있다면
            // 첫번째 줄과 두번째 줄에 있는 퀸이 세로로 겹치는 것을 의미한다.
            if (board[i] == board[row]) {
                return false;
            }
            // 대각선이 같을때
            // 가로위치와 세로위치의 차이가 같다면 대각선으로 판단할 수 있다.
            if (Math.abs(row - i) == Math.abs(board[row] - board[i])) {
                return false;
            }
        }
        return true;
    }
}