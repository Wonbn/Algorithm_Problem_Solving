import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        // 출력해야하는 값이 많기 때문에 버퍼를 사용한다.

        for(int i = 1; i <= 10000; i++) {
            int count  = 0;
            for(int j = 1; j < i; j++) {
                int tmp = j;
                int jj = j;
                while(jj > 0) {
                    tmp += jj%10;
                    jj /= 10;
                }
                if(tmp == i) {
                    count++;
                    break;
                }
            }
            if(count == 0) bw.write(i+"\n");
        }
        bw.flush();
        bw.close();
    }
}