import java.util.*;

// 수열(2~11개)(1~100) 사이에 연산자를 끼워넣어서 식의 결과값 중 max, min을 출력
// 숫자를 계산할 때는 연산자 순위 무시
// 연산자의 갯수는 주어짐 (+, -, x, /)
public class Main {
    static Scanner scan = new Scanner(System.in);

    // 입력 함수
    static void input() {
        N = scan.nextInt();
        nums = new int[N + 1]; // N+1로 배열 갯수를 두고 index를 1부터 시작한다.
        operators = new int[5]; // 각 연산자의 사용가능 횟수
        for (int i = 1; i <= N; i++) nums[i] = scan.nextInt(); // index는 1부터
        for (int i = 1; i <= 4; i++) operators[i] = scan.nextInt();

        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
    }

    static int N, max, min;
    static int[] nums, operators;

    // 피연산자 2개와 연산자가 주어졌을 때 계산해주는 함수
    static int calculator(int operand1, int operator, int operand2){
        // value, order[i], num[i+1]
        if (operator == 1) // +
            return operand1 + operand2;
        else if (operator == 2) // -
            return operand1 - operand2;
        else if (operator == 3) // *
            return operand1 * operand2;
        else // /
            return operand1 / operand2;
    }


    static void rec_func(int k, int value) {
        if (k == N) {
            // 완성된 식에 맞게 계산을 해서 정답에 갱신하는 작업
            max = Math.max(max, value);
            min = Math.min(min, value);
        } else {
            // k 번째 연산자는 무엇을 선택할 것인가?
            for (int cand = 1; cand <= 4; cand++){
                if (operators[cand] >= 1){
                    operators[cand]--;
                    rec_func(k + 1, calculator(value, cand, nums[k + 1]));
                    operators[cand]++;
                }
            }
        }
    }

    public static void main(String[] args) {
        input();
        // 1 번째 원소부터 M 번째 원소를 조건에 맞게 고르는 모든 방법을 탐색해줘
        rec_func(1, nums[1]);
        System.out.println(max);
        System.out.println(min);
    }
}
