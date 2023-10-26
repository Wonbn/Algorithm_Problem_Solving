import java.util.*; // 510

class Solution {
    public String[] solution(String[] record) {
        int len = 0;
        for(String str : record) {
            if(str.charAt(0) == 'E' || str.charAt(0) == 'L') len++;
        }
        String[] answer = new String[len];
        List<String> result1 = new ArrayList<>(); // 아이디
        List<String> result2 = new ArrayList<>(); // 메세지
        Map<String, String> map = new HashMap<>(); // id, name
        for(String r : record) {
            String[] rs = r.split(" ");
            if(!map.containsKey(rs[1]) || rs[0].equals("Change")) {
                map.put(rs[1], rs[2]);
            }
            
            if(rs[0].equals("Enter")) {
                result1.add(rs[1]);
                result2.add("님이 들어왔습니다.");
                if(!map.get(rs[1]).equals(rs[2])) {
                    map.put(rs[1], rs[2]);
                }
            }
            if(rs[0].equals("Leave")) {
                result1.add(rs[1]);
                result2.add("님이 나갔습니다.");
            }
        }
        
        for(int i = 0; i < len; i++) {
            StringBuilder sb = new StringBuilder();
            answer[i] = sb.append(map.get(result1.get(i)))
                .append(result2.get(i))
                .toString();
        }
        
        
        return answer;
    }
}