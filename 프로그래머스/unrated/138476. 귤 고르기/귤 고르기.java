import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> map = new HashMap<>();
				
				// 귤의 크기(key)와 갯수(value)를 Map 형태로 저장 
        for (int i = 0; i < tangerine.length; i++) {
            if (map.containsKey(tangerine[i])) {
                map.put(tangerine[i], map.get(tangerine[i]) + 1);
            } else {
                map.put(tangerine[i], 1);
            }
        }

				// 갯수를 list 형태로 가져와서 내림차순으로 정렬
        List<Integer> list = new ArrayList<>(map.values());
        Collections.sort(list, Comparator.reverseOrder());

				// 입력받은 k개의 귤을 선택할때, 크기가 달라지면 그때마다 answer을 증가시켜준다.
        int answer = 0;
        for(int i = 0; i < list.size(); i++) {
            if(k <= 0) break;
            k -= list.get(i);
            answer++;
        }

        return answer;
    }
}