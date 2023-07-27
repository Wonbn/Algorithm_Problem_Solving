import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int n, localBudgetSum;
    static int[] localBudget;
    static int nationalBudget;

    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        localBudgetSum = 0;
        localBudget = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            localBudget[i] = Integer.parseInt(st.nextToken());
            localBudgetSum += localBudget[i];
        }

        nationalBudget = Integer.parseInt(br.readLine());

        Arrays.sort(localBudget);
        System.out.println(findUpperLimit());
    }

    // 상한액을 찾아주는 메서드
    public static int findUpperLimit() {
        int upperLimit = localBudget[n-1], tmp;
        int budget = 3;


        if(nationalBudget >= localBudgetSum) return localBudget[n-1];
        else {
            if(nationalBudget/n <= localBudget[0]) upperLimit = nationalBudget/n;
            for(int i = localBudget[n-1]; i >= localBudget[0]; i--) {
                tmp = sum(i);
                if(tmp <= nationalBudget && tmp > budget) {
                    budget = tmp;
                    upperLimit = i;
                }
            }
        }

        return upperLimit;
    }

    // 상한액에 대한 예산 총합
    public static int sum(int upperLimit) {
        int sum = 0;

        for(int b : localBudget)
            sum += Math.min(b, upperLimit);

        return sum;
    }
}