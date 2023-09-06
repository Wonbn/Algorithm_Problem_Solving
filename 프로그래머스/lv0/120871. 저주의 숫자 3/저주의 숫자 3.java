class Solution {
    public int solution(int n) {
        int num = 1;
        int[] threeX = new int[101];
        for(int i = 1; i <= 100; i++) {
            while(true) {
                if(num%3 != 0 && notThree(num)) {
                    System.out.println(num);
                    threeX[i] = num++;
                    break;
                }
                num++;
            }
        }
        return threeX[n];
    }
    
    private boolean notThree(int num) {
        while(num != 0) {
            int n = num % 10;
            if(n == 3) {
                return false;
            }
            num /= 10;
        }
        return true;
    }
}