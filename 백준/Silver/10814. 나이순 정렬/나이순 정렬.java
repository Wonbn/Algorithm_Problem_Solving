import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String tmp;
        String[][] arr = new String[N][2];
        for(int i = 0; i < N; i++) arr[i] = br.readLine().split(" ");
        br.close();

        Arrays.sort(arr, new Comparator<String[]>() {
            @Override
            public int compare(String[] o1, String[] o2) {
                return Integer.compare(Integer.parseInt(o1[0]), Integer.parseInt(o2[0]));
            }
        });

        for(int i = 0; i < N; i++) bw.write(arr[i][0]+" "+arr[i][1]+"\n");
        bw.flush();
        bw.close();
    }
}
