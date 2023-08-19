import java.util.PriorityQueue;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> q = new PriorityQueue<>((o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        for (int num : numbers) q.add(String.valueOf(num));

        StringBuilder sb = new StringBuilder();
        while (!q.isEmpty()) sb.append(q.poll());

        // {0,0,0} 의 입력값이 들어왔을때, "000" 이런 결과값이 나오는 것을 방지한다.
        if(sb.toString().charAt(0) == '0') return "0";

        return sb.toString();
    }
}