import java.io.*;
import java.util.*;

class Node {
    public int size = 1;
    public List<Integer> childNode = new ArrayList<>();
    public List<Integer> connectNode = new ArrayList<>();
}

public class Main {
    static Node[] nodes;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = stoi(st.nextToken()); // 트리의 정점의 수
        int r = stoi(st.nextToken()); // 루트 정점의 번호 (최고 부모 정점)
        int q = stoi(st.nextToken()); // 쿼리의 수

        nodes = new Node[n+1];
        for(int i = 1; i <= n; i++) {
            nodes[i] = new Node();
        }

        for(int i = 0; i < n-1; i++) {
            st = new StringTokenizer(br.readLine());
            int num1 = stoi(st.nextToken());
            int num2 = stoi(st.nextToken());
            nodes[num1].connectNode.add(num2);
            nodes[num2].connectNode.add(num1);
        }

        makeTree(r, -1); // 루트 정점부터 탐색하면서 트리를 만든다.

        countSubtreeNodes(r); // 누적합을 이용한 각 정점마다 서브트리 갯수를 저장한다.

        // q만큼 주어지는 쿼리의 결과값을 출력한다.
        for(int i = 0; i < q; i++) {
            if(i != 0) bw.write("\n");
            bw.write(nodes[stoi(br.readLine())].size+"");
        }

        br.close();
        bw.close();
    }

    // 자신의 정점을 포함한 자신을 루트로 하는 서브트리의 정점의 갯수를 구한다.
    private static void countSubtreeNodes(int currentNode) {
        for(int node : nodes[currentNode].childNode) {
            countSubtreeNodes(node);
            nodes[currentNode].size += nodes[node].size;
        }
    }

    // 자신과 연결된 정점을 탐색하면서 자신의 부모와 자식을 구분하여 트리를 만든다.
    private static void makeTree(int currentNode, int parent) {
        for(int node : nodes[currentNode].connectNode) {
            if(node != parent) {
                nodes[currentNode].childNode.add(node);
                makeTree(node, currentNode);
            }
        }
    }

    private static int stoi(String in) {
        return Integer.parseInt(in);
    }
}