class Solution {
    public int solution(int[] arr) {
        int answer = 1;
        
        int num = 2;
        boolean check = true;
        while(check) {
            check = false;
            boolean same = false;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] % num == 0) {
                    arr[i] /= num;
                    same = true;
                }
                if(arr[i] > 1) {
                    check = true;
                }
            }
            if(same) answer *= num;
            else num++;
        }
        
        return answer;
    }
}