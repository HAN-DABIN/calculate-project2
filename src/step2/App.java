package step2;

import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 스캐너 선언
        Scanner scanner= new Scanner(System.in);
        Calculator calculator = new Calculator();

        System.out.println("=== 계산기 메뉴 ===");
        System.out.println("1. 계산하기");
        System.out.println("2. 계산 기록 보기");
        System.out.println("3. 계산 기록 삭제하기");
        System.out.println("0. 계산기 종료");

        int select = scanner.nextInt();

        if (select == 1) {
            System.out.println("=== 계산을 실행합니다 ===");
            // 계산하기 반복문
            while (true) {
                int num1 = calculator.firstNum(scanner, "- 첫 번째 숫자를 입력해주세요.: ");
                char ope = calculator.ope(scanner, "- 연산자(+, -, *, /)를 입력해주세요.: ");
                int num2 = calculator.secondNum(scanner, "- 두 번째 숫자를 입력해주세요.: ", ope);
                int result = calculator.cacaulate(num1, ope, num2);
            }
        }
    }
}
