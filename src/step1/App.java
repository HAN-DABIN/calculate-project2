package step1;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        // 스캐너 선언
        Scanner scanner = new Scanner(System.in);
        System.out.println("=== 계산기를 실행합니다. ===");

        // 계산기 전체 반복문
        while (true) {
            int num1; // 첫 번째 숫자 입력값 담을 변수 선언 -> 반복문 때문에 먼저 선언
            // 첫 번째 숫자 반복문
            while (true) {
                System.out.print("- 첫 번째 숫자를 입력해주세요.: ");
                try {
                    num1 = scanner.nextInt(); // num1 입력 받기
                    scanner.nextLine(); // 개행문자 제거
                    if (num1 < 0) { // 입력한 숫자가 음의 정수일 때 문장 출력
                        System.out.println("※ 양의 정수를 입력해주세요.");
                        continue; // 무한루프 방지
                    }
                } catch (InputMismatchException e) { // int(정수) 외 입력 시 예외처리
                    System.out.println("※ 정수를 입력해주세요.");
                    scanner.nextLine(); // 개행문자 제거
                    continue;
                }
                break; // 첫 번째 숫자 입력 반복문 종료
            }

            char ope; // 연산자 담을 변수 선언
            // 연산자 입력 반복문
            while (true) {
                System.out.print("- 연산자(+, -, *, /)를 입력해주세요.: ");
                ope = scanner.next().charAt(0); // ope 입력받기
                // 사칙연산 외 다른문자 입력 시 문구 출력
                switch (ope) {
                    case '+', '-', '*', '/':
                        break;
                    default:
                        System.out.println("※ 사칙연산 중 하나를 입력해주세요.");
                        continue;
                }
                break; // 연산자 입력 반복문 종료
            }

            int num2 = 0; // 두 번째 숫자 담을 변수 선언
            // 두 번째 숫자 입력 반복문
            while (true) {
                System.out.print("- 두 번째 숫자를 입력해주세요.: ");
                try {
                    num2 = scanner.nextInt();
                    scanner.nextLine(); // 개행문자 제거
                    if (num2 < 0) {
                        System.out.println("※ 양의 정수를 입력해주세요.");
                        continue; // 무한루프 방지
                    }
                } catch (InputMismatchException e) { // 예외 처리
                    System.out.println("※ 정수를 입력해주세요.");
                    scanner.nextLine(); // 개행문자 제거
                    continue;
                    // 연산자 '/' 입력 시 0 입력 방지
                }
                if (ope == '/' && num2 == 0) {
                    System.out.println("※ 0으로 나눌 수 없습니다. 다른 숫자를 입력해주세요.");
                    continue;
                }
                break; // 두 번째 숫자 입력 반복문 종료
            }

            System.out.println("=== 계산결과 ===");

            // ope 입력에 따른 계산 결과
            switch (ope) {
                case '+':
                    int result1 = num1 + num2;
                    System.out.println("::: " + num1 + " + " + num2 + " = " + result1);
                    break;
                case '-':
                    int result2 = num1 - num2;
                    System.out.println("::: " + num1 + " - " + num2 + " = " + result2);
                    break;
                case '*':
                    int result3 = num1 * num2;
                    System.out.println("::: " + num1 + " * " + num2 + " = " + result3);
                    break;
                case '/':
                    int result4 = num1 / num2;
                    System.out.println("::: " + num1 + " / " + num2 + " = " + result4);
                    break;
            }
            // 계속 계산 while문
            while (true) {
                System.out.print("- 계속 계산하시겠습니까? (yes: 계속계산 / exit: 종료): ");
                String answer = scanner.nextLine();
                switch (answer) {
                    case "yes":
                        System.out.println("=== 계산을 다시 시작합니다. ===");
                        break; // switch문 탈출
                    case "exit":
                        System.out.println("=== 계산을 종료합니다. ===");
                        System.exit(0); // 프로그램 종료
                    default:
                        System.out.println("※ yes 나 exit를 입력해주세요.");
                        continue; // 계속계산 문구 출력으로 돌아감
                } break; // 계속 계산 반복문 탈출
            }
        }
    }
}








