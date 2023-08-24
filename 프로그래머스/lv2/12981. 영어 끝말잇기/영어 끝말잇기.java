import java.util.*;

class Solution {
    static Set<String> set = new HashSet<>();

    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        int[][] now = new int[n][2];
        char ch = words[0].charAt(words[0].length()-1);
        int size = 0;
        set.add(words[0]);
        now[0][0]++;

        for(int i = 1; i < words.length; i++) {
            now[i%n][0]++;
            set.add(words[i]);

            if(size == set.size() || ch != words[i].charAt(0)) {
                answer[0] = i%n+1;
                answer[1] = now[i%n][0];
                return answer;
            } else {
                ch = words[i].charAt(words[i].length()-1);
                size = set.size();
            }
        }

        answer[0] = 0;
        answer[1] = 0;
        return answer;
    }
}