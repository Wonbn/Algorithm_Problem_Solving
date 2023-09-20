class Solution {
    static int num;
    static int sum;
    static int[] answer;
    static int m = 0;
    
    public int[] solution(int n, int s) {
        num = n;
        sum = s;
        answer = new int[n];
        
        if(s < n) {
            return new int[] {-1};
        }
        
        // dfs(1, 0, new int[num]);
        
        for(int i = 0; i < n; i++) {
            answer[i] = s/(n-i);
            s -= answer[i];
        }
        
        return answer;
    }
    
    private void dfs(int max, int count, int[] nums) {
        int remain = sum;
        
        if(remain <= 0) {
            return;
        }
        
        if(count == num-1) {
            max *= remain;
            nums[count] = remain;
            if(m < max) {
                answer = nums;
                m = max;
            }
            
            return;
        }
        
        for(int i = 1; i <= remain/2; i++) {
            nums[count] = i;
            sum -= i;
            dfs(max*i, count+1, nums);
            sum += i;
        }
    }
}