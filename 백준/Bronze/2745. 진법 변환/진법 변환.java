import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] tmp = br.readLine().split(" ");
        String n = tmp[0];
        int b = Integer.parseInt(tmp[1]);

        int result = 0;
        double c = 0;
        for(int i = n.length()-1; i >= 0; i--) {
            if(n.charAt(i) >= 'A' && n.charAt(i) <= 'Z')
                result += ((n.charAt(i)-'A')+10)*((int)Math.pow((double)b,c));
            else
                result += (n.charAt(i)-'0')*((int)Math.pow((double)b,c));
            c++;
        }
        System.out.println(result);
    }
}