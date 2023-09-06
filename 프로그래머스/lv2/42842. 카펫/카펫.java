class Solution {
    public int[] solution(int brown, int yellow) {
        int area = brown + yellow;
        int[] answer = new int[2];
        for(int i = 3; i <= (brown/2+2)/2; i++) {
            int hl = brown/2+2 - i;
            if(hl * i == area) {
                answer[0] = hl;
                answer[1] = i;
            }
        }
        
        return answer;
    }
}