import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static int n;
    static int existence = 0;
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = stoi(st.nextToken());
        int m = stoi(st.nextToken());

        nodes = new Node[n];
        for(int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int idx1 = stoi(st.nextToken());
            int idx2 = stoi(st.nextToken());

            nodes[idx1].connections.add(idx2);
            nodes[idx2].connections.add(idx1);
        }

        for(int i = 0; i < n; i++) {
            if(existence == 0) {
                dfs(i, 0);
            }
        }

        System.out.println(existence);
    }

    private static void dfs(int idx, int count) {
        nodes[idx].visitCheck = true;

        if(count == 4) {
            existence = 1;
        }

        if(existence == 1) {
            return;
        }

        for(int nextIdx : nodes[idx].connections) {
            if(!nodes[nextIdx].visitCheck) {
                dfs(nextIdx, count+1);
            }
        }
        nodes[idx].visitCheck = false;
    }

    private static int stoi(String in) {
        return Integer.parseInt(in);
    }
}

class Node {
    public List<Integer> connections = new ArrayList<>();
    public boolean visitCheck = false;
}