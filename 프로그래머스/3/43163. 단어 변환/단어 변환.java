import java.util.*; //343

class Solution {
    int answer = 51;
    boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];
        
        int l = words.length;
        for(int i = 0; i < l; i++) {
            if(target.equals(words[i])) break;
            if(i == l-1) return 0;
        }
        
        dfs(begin, target, words, 0);
        
        return answer;
    }
    
    private void dfs(String now, String t, String[] words, int c) {
        if(t.equals(now)) {
            answer = Math.min(answer, c);
            return;
        }
        
        for(int i = 0; i < words.length; i++) {
            if(!visited[i] && checkString(words[i], now)) {
                visited[i] = true;
                dfs(words[i], t, words, c+1);
                visited[i] = false;
            }
        }
    }
    
    private boolean checkString(String str1, String str2) {
        char[] ch1 = str1.toCharArray();
        char[] ch2 = str2.toCharArray();
        
        int count = 0;
        for(int i = 0; i < ch1.length; i++) {
            if(ch1[i] != ch2[i]) count++;
        }
        
        if(count == 1) return true;
        
        return false;
    }
}