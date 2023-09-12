import java.util.*;


// n : 진법 , t : 미리 구할 숫자의 갯수 , m : 게임에 참가하는 인원 , p : 튜브의 순서
class Solution {
    public String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();
        
        StringBuilder gameStr = new StringBuilder();
        for(int i = 0; i < t*m; i++) {
            gameStr.append(Integer.toString(i, n).toUpperCase());
        }
        
        int check = 0;
        for(int i = 0; i < gameStr.length(); i++) {
            if((i % m + 1) == p) {
                answer.append(gameStr.toString().charAt(i));
                check++;
            }
            if(check == t) {
                break;
            }
        }
        
        
        return answer.toString();
    }
}