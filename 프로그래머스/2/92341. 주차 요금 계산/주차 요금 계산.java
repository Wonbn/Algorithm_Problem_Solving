import java.util.*; //537

class Solution {
    public int[] solution(int[] fees, String[] records) {
        // 기록을 쪼개서 차량별 주차시간 구하는 메서드 (Map)
        Map<String, Integer> timeMap = makeTimeMap(records);
        List<String> keys = new ArrayList<>(timeMap.keySet());
        Collections.sort(keys);
        
        // 차량별 주차시간에 대한 주차요금 계산
        List<Integer> answer = makeResult(fees, timeMap, keys);
        
        return answer.stream().mapToInt(x->x).toArray();
    }
    
    private List<Integer> makeResult(int[] f, Map<String, Integer> t, List<String> k) {
        List<Integer> list = new ArrayList<>();
        int bTime = f[0];
        int bFee = f[1];
        int uTime = f[2];
        int uFee = f[3];
        
        for(String key : k) {
            int time = t.get(key);
            int fee = bFee;
            
            if(time > bTime) {
                time -= bTime;
                fee += time/uTime*uFee;
                if(time%uTime != 0) fee += uFee;
            }
            
            list.add(fee);
        }
        
        return list;
    }
    
    private Map<String, Integer> makeTimeMap(String[] r) {
        Map<String, Integer> map = new HashMap<>();
        
        String[][] splitR = new String[r.length][3]; 
        for(int i = 0; i < r.length; i++) splitR[i] = r[i].split(" ");
        
        // in -> 1439에서 뺀 값을 더해줌 / out -> 1439에서 뺀 값을 빼줌
        for(int i = 0; i < r.length; i++) {
            String[] now = splitR[i];
            String carNum = now[1];
            int time = Integer.parseInt(now[0].substring(0,2))*60+Integer.parseInt(now[0].substring(3,5));
            if(now[2].equals("IN")) {
                if(map.containsKey(carNum)) {
                    map.put(carNum, map.get(carNum)+1439-time);
                } else {
                    map.put(carNum, 1439-time);
                }
            }
            
            if(now[2].equals("OUT")) {
                map.put(carNum, map.get(carNum)-1439+time);
            }
        }
        
        return map;
    }
}