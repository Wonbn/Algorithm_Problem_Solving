import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        while (t-- != 0) {
            int n = Integer.parseInt(br.readLine());
            Map<String, Integer> map = new HashMap<>();
            List<String> key = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                String[] tmp = br.readLine().split(" ");
                if (!map.containsKey(tmp[1])) {
                    map.put(tmp[1], 1);
                    key.add(tmp[1]);
                }
                else map.put(tmp[1], map.get(tmp[1]) + 1);
            }

            int count = 1;
            for (String k : key) count *= (map.get(k)+1);

            System.out.println(count - 1);
        }
    }
}