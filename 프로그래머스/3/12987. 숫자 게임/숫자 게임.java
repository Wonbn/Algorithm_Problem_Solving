import java.util.*; //955

class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        int remain = 0;
        Arrays.sort(A);
        Arrays.sort(B);
        int l = A.length;
        
        int j = l-1;
        for(int i = l-1; i >= 0; i--) {
            int a = A[i];
            while(true) {
                if(j < 0 || B[j] <= a) break;
                remain++;
                j--;
            }
            
            if(remain > 0) {
                remain--;
                answer++;
            }
        }
        
        
        return answer;
    }
}