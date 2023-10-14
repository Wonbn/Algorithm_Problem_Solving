import java.util.*; //908

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        // n을 k진수로 변환
        String nk = Integer.toString(n, k);
        
        // 변환된 수 안에 소수 개수 찾기
        String[] nkList = nk.split("0+");

        for(String num : nkList) {
            boolean check = true;
            long nn = Long.parseLong(num);
            
            if(nn == 1) continue;
            
            for(int i = 2; i <= Math.sqrt(nn); i++) {
                if(nn % i == 0) {
                    check = false;
                    break;
                }
            }
            
            if(check) answer++;
        }
        
        return answer;
    }
}