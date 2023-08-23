import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }

        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Comparator.reverseOrder());

        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            if(k <= 0) break;
            k -= list.get(i);
            answer++;
        }

        return answer;
    }
}