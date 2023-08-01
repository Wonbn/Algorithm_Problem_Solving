import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = sc.nextInt(); // 컴퓨터의 수
        int m = sc.nextInt(); // 컴퓨터 쌍의 수

        int[][] pair = new int[m][2];
        for(int i = 0; i < m; i++) {
            pair[i][0] = sc.nextInt();
            pair[i][1] = sc.nextInt();
        }

        Set<Integer> set = new HashSet<>();
        set.add(1);
        for(int i = 0; i < m; i++) {
            if(set.contains(pair[i][0]) || set.contains(pair[i][1])) {
                set.add(pair[i][0]);
                set.add(pair[i][1]);
            }
            for(int j = 0; j < m; j++) {
                if(set.contains(pair[j][0]) || set.contains(pair[j][1])) {
                    set.add(pair[j][0]);
                    set.add(pair[j][1]);
                }
            }
        }

        System.out.println(set.size() - 1);
    }
}