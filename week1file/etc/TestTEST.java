package testPack;
import java.util.*;

public class TestTEST {
	public static void main(String[] args) {
		System.out.print("숫자를 입력하세요 : ");
		Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); // 1부터 100까지의 소수 출력
        System.out.println("1부터 " + n + "까지의 소수:");
        

        for (int i = 2; i <= n; i++) {
            if (cal(i)) {
                System.out.print(i + " ");
            }
        }
        scanner.close();
    }

    // 소수 판별 메서드
    public static boolean cal(int num) {
        if (num < 2) {
        	return false; // 1 이하 숫자는 소수가 아님
        }

        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
            	return false; // 나누어 떨어지면 소수가 아님
            }
        }
        return true;
    }

}
