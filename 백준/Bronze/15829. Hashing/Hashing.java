import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        final long M = 1234567891;
        final long r = 31;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int l = Integer.parseInt(br.readLine());
        String str = br.readLine();

        long H = 0;
        for(int i = 0; i < l; i++) H += ((Math.pow(r, i) % M)*(str.charAt(i)-'a'+1)) % M;
        // 31^i 값과 H 값이 문자열 길이가 50이 되면 double 로도 감당이 안되기 때문에
        // 미리 M 값으로 나눈 나머지를 사용한다.

        System.out.println(H % M);
    }
}