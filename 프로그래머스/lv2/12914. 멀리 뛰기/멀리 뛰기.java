class Solution {
    public long solution(int n) {
        long[] f = new long[2001];
        f[1] = 1;
        f[2] = 2;
        int i = 3;
        while(i <= n) {
            f[i] = (f[i-1] + f[i-2])%1234567;
            i++;
        }
        return f[n];
    }
}