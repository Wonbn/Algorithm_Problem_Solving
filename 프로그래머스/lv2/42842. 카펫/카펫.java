class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int area = yellow;
        int a = 0;
        int b = 0;
        for(int i = 1; i <= Math.sqrt(area); i++) {
            if(area % i == 0) {
                a = i; // 세로
                b = area/i; // 가로
            }
            if(2*(a+b)+4 == brown) {
                answer[0] = b + 2;
                answer[1] = a + 2;
            }
        }
        
        return answer;
    }
}