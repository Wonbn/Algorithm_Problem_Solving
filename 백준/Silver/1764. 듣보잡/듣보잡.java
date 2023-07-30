import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        Set<String> nameN = new HashSet<>();
        for(int i = 0; i < n; i++) nameN.add(br.readLine());

        // Set을 이용해서 입력받은 값 중 Set에 포함되어있는지 판단하는 메서드
        List<String> result = new ArrayList<>();
        int nameCount = 0;
        for(int i = 0; i < m; i++) {
            int len = nameN.size();
            String name = br.readLine();

            // 만약에 입력된 이름을 Set에 추가했을때, Set의 크기가 똑같다면 Set에 포함되어 있는 것이기 때문에
            // 그 이름을 결과 배열에 추가한다.
            nameN.add(name);
            if(len == nameN.size()) {
                nameCount++;
                result.add(name);
            }
        }
        Collections.sort(result); // 배열을 사전 순으로 정렬

        System.out.println(nameCount);
        for(int i = 0; i < result.size(); i++) {
            if(i != 0) bw.write("\n");
            bw.write(result.get(i));
        }
        bw.flush();
        br.close();
        bw.close();

    }
}