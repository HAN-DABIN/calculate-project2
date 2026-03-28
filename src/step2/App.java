package step2;

import java.util.ArrayList;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);
        Calculator calculator = new Calculator();

        while (true) {
            System.out.println("=== 계산기 메뉴 ===");
            System.out.println("1. 계산하기");
            System.out.println("2. 계산 기록 보기");
            System.out.println("3. 첫 번째 계산 기록 삭제하기");
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
                    String ans = calculator.answer(scanner, "- 다시 계산하시겠습니까? (yes: 다시계산 / menu: 메뉴로 돌아가기 / exit: 계산기 종료)");

                    if (ans.equals("menu")) {
                        break;
                    }
                }
            }
            if (select == 2) {
                System.out.println("=== 계산 결과를 조회합니다 ===");
                // getter 활용
                ArrayList<Integer> resultList = calculator.getResultList();
                System.out.println("계산 결과: " + resultList);
                String gM = calculator.goMenu(scanner, "- 메뉴로 돌아가시겠습니까? (yes: 메뉴로 돌아가기 / exit: 계산기 종료)");
            }

        }
    }
}
