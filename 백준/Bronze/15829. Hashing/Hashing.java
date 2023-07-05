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
        for(int i = 0; i < l; i++) H += (long)Math.pow(r, i)*(str.charAt(i)-'a'+1);

        System.out.println(H%M);
    }
}