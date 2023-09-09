class Solution {
    public int solution(int n) {
        int[] f = new int[100001];
        f[0] = 0;
        f[1] = 1;
        
        int i = 2;
        while(i <= n) {
            f[i] = (f[i-1] + f[i-2])%1234567;
            i++;
        }
        
        return f[n];
    }
}