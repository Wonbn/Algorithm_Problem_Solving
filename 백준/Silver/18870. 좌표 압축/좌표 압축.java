import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        String[] tmp = br.readLine().split(" ");
        br.close();
        Integer[] arr = new Integer[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(tmp[i]);

        HashSet<Integer> set = new HashSet<>(Arrays.asList(arr));
        Integer[] setarr = set.toArray(new Integer[0]);

        Arrays.sort(setarr);
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < setarr.length; i++) map.put(setarr[i], i);
        for(int i = 0; i < N; i++) {
            if(i == 0) bw.write(""+map.get(arr[i]));
            else bw.write(" "+map.get(arr[i]));
        }

        bw.flush();
        bw.close();
    }
}