import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 문제 난이도 설정 - 양끝 15% 극단적인 값들을 제외한 평균 난이도로 설정
        // 난이도와 제외 값들의 수는 모두 반올림

        int n = Integer.parseInt(br.readLine());
        int a = (int)Math.round((double)n*0.15);
        int m = a;

        double sum = 0;
        int[] tier = new int[31];
        for(int i = 0; i < n; i++) { // 입력받은 난이도 값을 넣어주고, 동시에 전체 총합을 구한다.
            int tmp = Integer.parseInt(br.readLine());
            tier[tmp]++;
            sum += tmp;
        }

        int k = a; int i = 1;
        while(true) { // 전체 총합 중 최소값 15% 삭제
            if(a != 0) {
                if(tier[i] != 0) {
                    tier[i]--;
                    a--;
                    sum -= i;
                } else i++;
            } else break;
        }

        i = 30;
        while(true) { // 전체 총합 중 최대값 15% 삭제
            if(k != 0) {
                if(tier[i] != 0) {
                    tier[i]--;
                    k--;
                    sum -= i;
                } else i--;
            } else break;
        }

        if(n != 0) System.out.println(Math.round(sum/(n-2*m)));
        else System.out.println(0);

    }
}