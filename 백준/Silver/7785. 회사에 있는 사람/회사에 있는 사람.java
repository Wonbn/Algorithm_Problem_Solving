import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, String> map = new HashMap<>();

        int n = Integer.parseInt(br.readLine());
        String[] key = new String[n];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            key[i] = input[0];
            if (map.containsKey(input[0])) map.remove(input[0]);
            else map.put(input[0], input[1]);
        }

        ArrayList<String> list = new ArrayList<String>(map.keySet());
        Collections.sort(list, Collections.reverseOrder());
        for(String l : list) System.out.println(l);
    }
}