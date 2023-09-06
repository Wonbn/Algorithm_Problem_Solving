import java.util.*;
import java.util.stream.*;

class Solution {
    static List<int[]> results = new ArrayList<>();
    
    public int[][] solution(int n) {
        hanoi(n, 1, 2, 3);
        
        int[][] answer = results.stream().toArray(int[][]::new);
        return answer;
    }
    
    private void hanoi(int N, int start, int mid, int to) {
        // 이동할 원반의 수가 1개라면?
	    if (N == 1) {
		    results.add(new int[] {start, to});
		    return;
	    } 
 
	    // A -> C로 옮긴다고 가정할 떄,
	    // STEP 1 : N-1개를 A에서 B로 이동 (= start 지점의 N-1개의 원판을 mid 지점으로 옮긴다.)
	    hanoi(N - 1, start, to, mid);
    
	    // STEP 2 : 1개를 A에서 C로 이동 (= start 지점의 N번째 원판을 to지점으로 옮긴다.)
	    results.add(new int[] {start, to});
    
	    // STEP 3 : N-1개를 B에서 C로 이동 (= mid 지점의 N-1개의 원판을 to 지점으로 옮긴다.)
	    hanoi(N - 1, mid, start, to);
    }
}