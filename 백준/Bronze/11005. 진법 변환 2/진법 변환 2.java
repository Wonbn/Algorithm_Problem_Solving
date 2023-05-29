import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] tmp = br.readLine().split(" ");
        int n = Integer.parseInt(tmp[0]);
        int b = Integer.parseInt(tmp[1]);

        String result = "";
        while(n > 0) {
            if(n%b >= 10) {
                char t = (char)('A' + n%b - 10);
                result += Character.toString(t);
            }
            else result += Integer.toString(n%b);
            n /= b;
        }

        for(int i = result.length()-1; i >= 0; i--) {
            System.out.printf("%c",result.charAt(i));
        }
    }
}