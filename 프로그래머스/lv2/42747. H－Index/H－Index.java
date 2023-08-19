import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int solution(int[] citations) {
        Integer[] tmp = Arrays.stream(citations).boxed().toArray(Integer[]::new);
        Arrays.sort(tmp, Comparator.reverseOrder());
        int[] thesis = new int[10001];
        int sum = 0;
        for(int c : tmp) {
            sum++;
            thesis[c] = sum;
        }

        int max = 0;
        for(int i = 0; i <= 10000; i++) {
            max = Math.max(Math.min(thesis[i], i), max);
        }

        return max;
    }
}