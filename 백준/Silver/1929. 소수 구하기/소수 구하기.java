import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출력양이 많기 때문에 버퍼를 사용해서 한번에 출력

        // 소수 출력하기
        
        int m = sc.nextInt();
        int n = sc.nextInt();

        // 2의 배수, 즉 짝수는 무조건 소수가 아니기 때문에 제외하고 소수를 찾는다.
        if(m <= 2 && n >= 2) bw.write(2+"\n");
        for(int i = (m/2)*2+1; i <= n; i+=2) {
            boolean check = false;
            // 숫자의 제곱근 값까지 자신의 약수가 나오지 않는다면 소수이다.
            for(int j = 3; j <= Math.sqrt(i); j+=2) {
                if(i % j == 0) {
                    check = true;
                    break;
                }
            }
            if(!check && i != 1) bw.write(i+"\n");
        }

        bw.flush();
        bw.close();
    }
}