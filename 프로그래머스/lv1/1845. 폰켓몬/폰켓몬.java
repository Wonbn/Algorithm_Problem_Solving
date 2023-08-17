import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int solution(int[] nums) {
        Set<Integer> type = new HashSet<>();

        for (int num : nums) type.add(num);

        return Math.min(nums.length / 2, type.size());
    }
}
