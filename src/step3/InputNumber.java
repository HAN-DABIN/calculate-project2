package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

// main에서 while문이 너무 많아져서 새로 만든 클래스입니다
public class InputNumber {

    Scanner scanner = new Scanner(System.in);

    // getter - 첫 번째 숫자 입력받기
    public double getFirstNum() {
        while (true) { // 첫 번째 숫자 입력 반복문
            try {
                System.out.print("- 첫 번째 숫자를 입력해주세요.: ");
                double num1 = scanner.nextDouble();
                scanner.nextLine();
                return num1; // 숫자 입력하면 반복문 종료
            } catch (InputMismatchException e) { // 문자 입력 예외 처리
                System.out.println("※ 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    // getter - 연산자 입력 받기
    char ope; // 나눗셈과 0을 예외처리 하기 위해 변수선언 while문 밖에서
    public char getOperator() {
        while (true) { // 연산자 입력 반복문
            System.out.print("- 연산자(+, -, *, /)를 입력해주세요.: ");
            ope = scanner.next().charAt(0);
           switch (ope) {
               case '+', '-', '*', '/':
                   return ope; // 저장된 연산자 입력하면 반복문 종료
               default:
                   System.out.println("※ 사칙연산 중 하나를 입력해주세요."); // 아니면 반복
           }
        }
    }

    // getter - 두 번째 숫자 입력받기
    public double getSecondNum() {
        double num2;
        while (true) { // 두 번째 숫자 입력 반복문
            try {
                System.out.print("- 두 번째 숫자를 입력해주세요.: ");
                num2 = scanner.nextDouble();
                scanner.nextLine();

                if (ope == '/' && num2 == 0) { // 0 나누기 처리
                    System.out.println("※ 0으로 나눌 수 없습니다. 다른 숫자를 입력해주세요.");
                    continue; // 반복문 계속
                }
                return num2; // 숫자 입력 시 반복문 종료

            } catch (InputMismatchException e) { // 문자 입력 예외 처리
                System.out.println("※ 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    // 큰 숫자 비교 입력 메서드
    public double getBiggerNumber() {
        double userValue;
        while (true) { // 숫자 입력 반복문
            try {
                System.out.println("- 비교할 숫자를 입력해주세요.");
                userValue = scanner.nextDouble();
                scanner.nextLine();
                return userValue;
            } catch (InputMismatchException e) {
                System.out.println("※ 숫자로 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}
