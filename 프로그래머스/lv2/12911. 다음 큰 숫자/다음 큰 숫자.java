class Solution {
    public int solution(int n) {
        int answer = 0;
        String s = Integer.toBinaryString(n);
        char[] cList = s.toCharArray();
        for(int i = 0; i < cList.length; i++) {
            if(cList[i] == '1') answer++;
        }
        for(int i = n+1; i <= 10000000; i++) {
            s = Integer.toBinaryString(i);
            cList = s.toCharArray();
            int count = 0;
            for(int j = 0; j < cList.length; j++) {
                if(cList[j] == '1') count++;
            }
            if (count == answer) {
                return i;
            }
        }
        
        return 0;
    }
}