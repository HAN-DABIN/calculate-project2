package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

// main에서 while문이 너무 많아져서 새로 만든 클래스입니다
public class InputNumber {

    Scanner scanner = new Scanner(System.in);

    public double getFirstNum() {
        while (true) {
            try {
                System.out.print("- 첫 번째 숫자를 입력해주세요.: ");
                double num1 = scanner.nextDouble();
                scanner.nextLine();
                return num1;
            } catch (InputMismatchException e) {
                System.out.println("※ 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }

    char ope;
    public char getOperator() {
        while (true) {
            System.out.print("- 연산자(+, -, *, /)를 입력해주세요.: ");
            ope = scanner.next().charAt(0);
           switch (ope) {
               case '+', '-', '*', '/':
                   return ope;
               default:
                   System.out.println("※ 사칙연산 중 하나를 입력해주세요.");
           }
        }
    }

    public double getSecondNum() {
        double num2;
        while (true) {
            try {
                System.out.print("- 두 번째 숫자를 입력해주세요.: ");
                num2 = scanner.nextDouble();
                scanner.nextLine();

                if (ope == '/' && num2 == 0) {
                    System.out.println("※ 0으로 나눌 수 없습니다. 다른 숫자를 입력해주세요.");
                    continue;
                }
                return num2;

            } catch (InputMismatchException e) {
                System.out.println("※ 숫자를 입력해주세요.");
                scanner.nextLine();
            }
        }
    }
}
