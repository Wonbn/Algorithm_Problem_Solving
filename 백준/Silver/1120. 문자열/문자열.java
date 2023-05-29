import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] ab = br.readLine().split(" ");

        String a = ab[0];
        String b = ab[1];

        int max = 0;
        for(int i = 0; i <= b.length()-a.length(); i++) {
            int check = 0;
            for(int j = i; j < i + a.length(); j++) check += (b.charAt(j) == a.charAt(j-i))? 1:0;
            if(max < check) max = check;
        }
        System.out.println(a.length()-max);
    }
}