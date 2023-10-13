import java.util.*; //325

class Solution {
    public int solution(String str1, String str2) {
        Map<String, Integer> str1Map = makeMap(str1);
        Map<String, Integer> str2Map = makeMap(str2);
        System.out.println(str1Map);
        System.out.println(str2Map);
        
        double answer = J(str1Map, str2Map);
        
        return (int) (answer*65536);
    }
    
    private double J(Map<String, Integer> map1, Map<String, Integer> map2) {
        double union = 0.0;
        double inters = 0.0;
        
        if(map1.isEmpty() && map2.isEmpty()) return 1.0;
        
        for(String key : map1.keySet()) {
            if(map2.containsKey(key)) {
                union += Math.max(map1.get(key), map2.get(key));
                inters += Math.min(map1.get(key), map2.get(key));
            } else {
                union += map1.get(key);
            }
        }
        
        for(String key : map2.keySet()) {
            if(!map1.containsKey(key)) {
                union += map2.get(key);
            } 
        }
        
        System.out.println("union="+union);
        System.out.println("inters="+inters);
        
        return inters/union;
    }
    
    private Map<String, Integer> makeMap(String str) {
        Map<String, Integer> map = new HashMap<>();
        
        String nowStr = str.toUpperCase();
        for(int i = 0; i < str.length()-1; i++) {
            StringBuilder sb = new StringBuilder();
            if((nowStr.charAt(i) >= 'A' && nowStr.charAt(i) <= 'Z') && (nowStr.charAt(i+1) >= 'A' && nowStr.charAt(i+1) <= 'Z')) {
                sb.append(nowStr.charAt(i)).append(nowStr.charAt(i+1));
                if(map.containsKey(sb.toString())) {
                    map.put(sb.toString(), map.get(sb.toString())+1);
                } else {
                    map.put(sb.toString(), 1);
                }
            }
        }
        
        return map;
    }
}