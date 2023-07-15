import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] num = new int[8001];

        double sum = 0;
        for(int i = 0; i < n; i++) {
            int tmp = Integer.parseInt(br.readLine());
            num[tmp+4000]++;
            sum += tmp;
        }
        System.out.println(Math.round(sum/n)); // 산술평균

        int mid = n/2+1; int mNum = 0;
        for(int i = 0; i < num.length; i++) { // 최대빈도수
            if(num[i] < mid) mid -= num[i];
            else {
                mNum = i - 4000;
                break;
            }
        }
        System.out.println(mNum); // 중앙값

        int fr = 0; int frNum = 0;
        for(int i = 0; i < num.length; i++) { // 최대빈도수
            if(fr < num[i]) fr = num[i];
        }
        int check = 0;
        for(int i = 0; i < num.length; i++) { // 최빈값
            if(fr == num[i]) {
                frNum = i - 4000;
                check++;
                if(check == 2) {
                    frNum = i - 4000;
                    break;
                }
            }
        }
        System.out.println(frNum); // 최빈값

        int max = 0, min = 0;
        for(int i = 0; i < num.length; i++) { // 최소값
            if(num[i] >= 1) {
                min = i - 4000;
                break;
            }
        }
        for(int i = 8000; i >= 0; i--) { // 최대값
            if(num[i] >= 1) {
                max = i - 4000;
                break;
            }
        }
        System.out.println(max-min); // 범위

    }
}