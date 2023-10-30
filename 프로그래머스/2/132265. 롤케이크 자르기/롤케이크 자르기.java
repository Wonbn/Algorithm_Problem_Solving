import java.util.*; // 857
import java.util.stream.*;

class Solution {
    public int solution(int[] topping) {
        int answer = 0;
        int[] num = new int[10001];
        
        List<Integer> tmpList = new ArrayList<>();
        for(int n : topping) {
            num[n]++;
            tmpList.add(new Integer(n));
        }
        Set<Integer> tmpSet = new HashSet<>(tmpList);
        int baseCnt = tmpSet.size();
        
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < topping.length; i++) {
            num[topping[i]]--;
            if(num[topping[i]] == 0) baseCnt--;
            set.add(topping[i]);
            if(set.size() == baseCnt) answer++;
        }
        
        return answer;
    }
}