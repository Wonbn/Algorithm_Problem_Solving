import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String[] tmp = input.split("-|\\+");
        // 정규식에서 '.'과 '+'는 특별한 의미를 가지기 때문에 escape 문자열인 '\\'를 추가해주어야 한다.

        // 입력받은 식에 들어있는 숫자들의 배열 저장
        int[] numbers = new int[tmp.length];
        for (int i = 0; i < tmp.length; i++) numbers[i] = Integer.parseInt(tmp[i]);

        // - 가 처음으로 등장한 index 값을 idx에 저장
        int idx = -1; int j = 0;
        char[] signs = new char[tmp.length - 1];
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '+') j++;
            if (input.charAt(i) == '-') {
                idx = j;
                break;
            }
        }

        // - 가 처음으로 등장한 index 이후에 있는 모든 숫자를 뺀다.
        // 그렇게 되면 괄호를 쳐서 구할 수 있는 최소값이 된다.
        int sum = 0;
        if (idx == -1) {
            for (int i = 0; i < numbers.length; i++) sum += numbers[i];
        } else {
            for (int i = 0; i < idx + 1; i++) sum += numbers[i];
            for (int i = idx + 1; i < numbers.length; i++) sum -= numbers[i];
        }

        System.out.println(sum);
    }
}