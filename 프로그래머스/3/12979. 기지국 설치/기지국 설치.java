import java.util.*; //1243

class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int g5 = 2*w+1;
        int l = stations.length;
        int s = 0;
        int e = 0;
        for(int i = 0; i < l; i++) { 
            if(i != 0) s = stations[i-1]+w;
            e = stations[i]-w-1;
            
            int dis = e - s;
            
            if(dis > 0) answer += ((dis-1)/g5+1);
            
            if(i == l-1) {
                dis = n-stations[i]-w;
                if(dis > 0) answer += ((dis-1)/g5+1);
            }
        }
        

        return answer;
    }
}