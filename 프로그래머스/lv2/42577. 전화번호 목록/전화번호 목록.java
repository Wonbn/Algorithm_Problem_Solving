import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean solution(String[] phone_book) {
        Set<String> prefix = new HashSet<>();

        // 가장 긴 전화번호부터 차례대로 정렬한다.
        Arrays.sort(phone_book, Comparator.reverseOrder());

        // 접두어가 될 수 있는 모든 String을 Set에 넣어둔다.
        // 전화부를 돌면서 접두어에 해당하는지 체크한다.
        for (String str : phone_book) {
            for (int i = 1; i < str.length(); i++) {
                prefix.add(str.substring(0, i));
            }
            if(prefix.contains(str)) return false;
        }

        return true;
    }
}