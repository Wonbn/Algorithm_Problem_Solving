class Solution {
    public int solution(int n) {
        int nn = n+1;
        while(true) {
            if(Integer.bitCount(nn) == Integer.bitCount(n)) return nn;
            nn++;
        }
    }
}