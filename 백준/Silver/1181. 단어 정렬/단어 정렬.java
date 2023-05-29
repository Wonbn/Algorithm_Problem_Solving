import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());

        String[] oarr = new String[N];
        for(int i = 0; i < N; i++) oarr[i] = br.readLine();
        br.close();

        HashSet<String> set = new HashSet<>(Arrays.asList(oarr));
        String[] arr = set.toArray(new String[0]);
        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(o1.length() > o2.length()) return 1;
                else if(o1.length() < o2.length()) return -1;
                else return o1.compareTo(o2);
            }
        });

        for(int i = 0; i < arr.length; i++) bw.write(arr[i]+"\n");
        bw.flush();
        bw.close();
    }
}