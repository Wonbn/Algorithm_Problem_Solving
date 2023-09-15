import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "";
        int l = 0;
        
        for(String musicInfo : musicinfos) {
            String[] music = musicInfo.split(","); // 0시작시간, 1종료시간, 2음악제목, 3악보정보
            
            int hh = Integer.parseInt(music[1].split(":")[0]) - Integer.parseInt(music[0].split(":")[0]);
            int mm = Integer.parseInt(music[1].split(":")[1]) - Integer.parseInt(music[0].split(":")[1]);
            int time = hh*60 + mm;// 전체 재생시간
            
            String ms = music[3];
            
            m = m.replaceAll("C#", "c"); m = m.replaceAll("D#", "d"); m = m.replaceAll("F#", "f");
            m = m.replaceAll("A#", "a"); m = m.replaceAll("G#", "g");
            
            ms = ms.replaceAll("C#", "c"); ms = ms.replaceAll("D#", "d"); ms = ms.replaceAll("F#", "f");
            ms = ms.replaceAll("A#", "a"); ms = ms.replaceAll("G#", "g");
            
            StringBuilder sb = new StringBuilder(); // 실제 실행된 음악 전체 악보 만들기 (반복 포함)
            for(int i = 0; i < time; i++) {
                int idx = i%ms.length();
                sb.append(ms.charAt(idx));
            }
    
            String ma = sb.toString(); // 실제 실행된 음악 전체 악보
            // System.out.println(ma);
            int idx = -1;
            for(int i = 0; i <= ma.length()-m.length(); i++) {
                if(ma.substring(i,i+m.length()).equals(m)) {
                    if(l < time) {
                        answer = music[2];
                        l = time;
                    }
                    break;
                }
            }
        }
        
        if(answer == "") return "(None)";
        return answer;
    }
}