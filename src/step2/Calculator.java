package step2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    // 연산 결과 저장 컬렉션 - 캡슐화
    private ArrayList<Integer> resultList = new ArrayList<>(); // 속성

    // 첫 번째 숫자 입력 메서드 (기능)
    public int firstNum(Scanner scanner, String first) {
        int num1;
        while (true) {
            // first에 담긴 문장 출력
            System.out.print(first);
            try {
                // num1에 입력 값 저장
                num1 = scanner.nextInt(); // num1 입력 받기
                scanner.nextLine(); // 개행문자 제거
                if (num1 <= 0) { // 입력한 숫자가 음의 정수일 때 문장 출력
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

    // 연산자 입력 메서드 (기능)
    public char ope (Scanner scanner, String operator) {
        char ope2;
        while (true) {
            System.out.print(operator);
            ope2 = scanner.next().charAt(0); // ope 입력받기
            // 사칙연산 외 다른문자 입력 시 문구 출력
            switch (ope2) {
                case '+', '-', '*', '/':
                    break;
                default:
                    System.out.println("※ 사칙연산 중 하나를 입력해주세요.");
                    continue;
            }
            break; // 연산자 입력 반복문 종료
        } return ope2;
    }

    // 두 번째 숫자 입력 메서드 (기능)
    public int secondNum (Scanner scanner, String second, char ope) {
        int num2;
        while (true) {
            System.out.print(second);
            try {
                num2 = scanner.nextInt();
                scanner.nextLine(); // 개행문자 제거
                if (num2 <= 0) {
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

    // 계산 메서드 (기능)
    public int calculate(int num1, char ope, int num2) {
        int result = 0;
        switch (ope) {
            case '+':
                result = num1 + num2;
                System.out.println("* 계산 결과: " + num1 + " + " + num2 + " = " + result);
                break;
            case '-':
                result = num1 - num2;
                System.out.println("* 계산 결과: " + num1 + " - " + num2 + " = " + result);
                break;
            case '*':
                result = num1 * num2;
                System.out.println("* 계산 결과: " + num1 + " * " + num2 + " = " + result);
                break;
            case '/':
                result = num1 / num2;
                System.out.println("* 계산 결과: " + num1 + " / " + num2 + " = " + result);
                break;
        }
        resultList.add(result);
        return result;
    }
    // 계속 계산 입력 메서드 (기능)
    public String answer(Scanner scanner, String answer2) {
        String ans;
        while (true) {
            System.out.println(answer2);
            ans = scanner.nextLine(); // 입력받기
            // 다른문자 입력 시 문구 출력
            switch (ans) {
                case "yes":
                    System.out.println("< 계산을 다시 시작합니다. >");
                    break;
                case "menu":
                    System.out.println("< 메뉴로 돌아갑니다. >");
                    return "menu";
                case "exit":
                    System.out.println("< 프로그램을 종료합니다. >");
                    System.exit(0);
                default:
                    System.out.println("※ 잘못 입력하셨습니다.");
                    continue;
            } break; // 연산자 입력 반복문 종료
        } return ans;
    }
    // getter
    public ArrayList<Integer> getResultList() {
        // 얕은 복사
        return new ArrayList<>(resultList);
    }
    // 메뉴 복귀 메서드 (기능)
    public String goMenu(Scanner scanner, String goMenu2) {
        String gM;
        // 메뉴 입력 반복문
        while (true) {
            // 메뉴로 돌아가는 입력 받기
            System.out.println(goMenu2);
            scanner.nextLine(); // 개행문자 제거 => 전 입력이 String이었는데 왜 생겼을까? * 트러블슈팅
            gM = scanner.nextLine();
            switch (gM) {
                case "yes":
                    System.out.println("< 메뉴로 돌아갑니다. >");
                    break;
                case "exit":
                    System.out.println("< 프로그램을 종료합니다. >");
                    System.exit(0);
                default:
                    System.out.println("※ 잘못 입력하셨습니다.");
                    continue;
            } break;
        } return gM;
    }
    // 첫 번째 계산 기록 (0번째 인덱스) 삭제 메서드 (기능)
    public void removeResult() {
        if (!resultList.isEmpty()) {
            resultList.remove(0);
            System.out.println("변경 계산 기록: " + resultList);
        } else {
            System.out.println("※ 삭제할 결과가 없습니다.");
        }
    }
}

