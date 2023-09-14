class Solution {
    public long solution(int k, int d) {
        long answer = 0;
        long dl = d;
        long kl = k;
        
        for(long a = 0; a <= dl/kl; a++) {
            long x = a*kl;
            long yConunt = (long) Math.sqrt(dl*dl-x*x)/kl + 1L;
            answer += yConunt;
        }
        
        return answer;
    }
}