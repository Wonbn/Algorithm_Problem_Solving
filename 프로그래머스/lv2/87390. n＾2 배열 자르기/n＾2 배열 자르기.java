class Solution {
    public int[] solution(int n, long left, long right) {
        long nLong = n;
        int[] answer = new int[(int)(right - left) + 1];
        
        int idx = 0;
        for(long i = left; i <= right; i++) {
            int num = (int)(i % nLong) + 1;
            int plus = (int)(i / nLong) + 1;
            if(num < plus) {
                num = plus;
            }
            answer[idx++] = num;
        }
        
        return answer;
    }
}