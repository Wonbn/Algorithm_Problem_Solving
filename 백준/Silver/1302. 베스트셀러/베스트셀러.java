import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] arr = new String[N];
        for(int i = 0; i < N; i++) arr[i] = br.readLine();
        Arrays.sort(arr);

        HashSet<String> tmp = new HashSet<>(Arrays.asList(arr));
        String[] name = tmp.toArray(new String[0]);
        Arrays.sort(name);
        int[] count = new int[name.length];

        int max = 0;
        int maxi = 0;
        for(int i = 0; i < name.length; i++) {
            for(int j = 0; j < N; j++) {
                if(name[i].equals(arr[j])) count[i]++;
            }
            if(max < count[i]) {
                max = count[i];
                maxi = i;
            }
        }

        System.out.println(name[maxi]);
    }
}