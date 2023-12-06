import java.util.*; // 617

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pqMax = new PriorityQueue<>(Comparator.reverseOrder());
        PriorityQueue<Integer> pqMin = new PriorityQueue<>();
        Map<Integer, Integer> count = new HashMap<>();
        int[] answer = new int[2];
        
        for(String cmd : operations) {
            if(cmd.charAt(0) == 'I') {
                int num = Integer.parseInt(cmd.split(" ")[1]);
                pqMax.add(num);
                pqMin.add(num);
                
                if(!count.containsKey(num)) count.put(num, 1);
                else count.put(num, count.get(num)+1);
            } else {
                if(cmd.charAt(2) == '-' && pqMin.isEmpty()) continue;
                if(cmd.charAt(2) == '1' && pqMax.isEmpty()) continue;
                
                int n = 0;
                while(true) {
                    if(cmd.charAt(2) == '-') {
                        if(!pqMin.isEmpty()) n = pqMin.poll();
                        else break;
                    }
                    if(cmd.charAt(2) == '1') {
                        if(!pqMax.isEmpty()) n = pqMax.poll();
                        else break;
                    }
                    
                    if(count.get(n) > 0) {
                        count.put(n, count.get(n)-1);
                        break;
                    }
                }
            }
        }
        
        System.out.println(pqMax);
        System.out.println(pqMin);
        System.out.println(count);
        
        while(true) {
            if(pqMax.isEmpty()) break;
            
            if(count.get(pqMax.peek()) <= 0) pqMax.poll();
            else {
                answer[0] = pqMax.peek();
                break;
            }
        }
        
        while(true) {
            if(pqMin.isEmpty()) break;
            
            if(count.get(pqMin.peek()) <= 0) pqMin.poll();
            else {
                answer[1] = pqMin.peek();
                break;
            }
        }
        
        return answer;
    }
}