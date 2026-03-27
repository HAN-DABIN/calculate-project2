package step2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    // 연산 결과 저장 컬렉션 - 캡슐화
    private ArrayList<Integer> resultList = new ArrayList<>();

    // 첫 번째 숫자 입력 메서드
    public int firstNum(Scanner scanner, String first) {
        int num1;
        while (true) {
            // first에 담긴 문장 출력
            System.out.println(first);
            try {
                // num1에 입력 값 저장
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
        } return num1;
    }

    public char ope (Scanner scanner, String operator) {
        char ope;
        while (true) {
            System.out.println(operator);
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
        } return ope;
    }

    public int secondNum (Scanner scanner, String second, char ope) {
        int num2;
        while (true) {
            System.out.println(second);
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
        } return num2;
    }

    public int cacaulate(int num1, char ope, int num2) {
        int result = 0;
        switch (ope) {
            case '+':
                result = num1 + num2;
                System.out.println("::: " + num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("::: " + num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("::: " + num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                result = num1 / num2;
                System.out.println("::: " + num1 + " / " + num2 + " = " + result);
                break;
        }
        resultList.add(result);
        return result;
    }
}

