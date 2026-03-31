package step3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        // 객체화
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator<>();
        Menu menu = new Menu();
        InputNumber input = new InputNumber();

        while (true) {
            System.out.println(menu.menuList); // 메뉴리스트 출력
            int select;
            try {
                select = scanner.nextInt(); // 메뉴 숫자 입력받기
                scanner.nextLine();
            } catch (InputMismatchException e) { // 예외 처리
                System.out.println("※ 메뉴를 숫자로 입력해주세요.");
                scanner.nextLine();
                continue;
            }
            // 계산 반복문
            while (true) {
                if (select == 1) {
                    System.out.println("=== 계산을 실행합니다 ===");
                    // getter 활용
                    double num1 = input.getFirstNum();
                    char ope = input.getOperator();
                    double num2 = input.getSecondNum();
                    cal.calculate(num1, num2, ope); // 계산식 출력
                    String ans = menu.answer(scanner); // getter 활용
                    if (ans.equals("menu")) {
                        break; // "menu"입력 시 반복문 탈출
                    }
                }
            }
            if (select == 2) {
                System.out.println("=== 계산 결과를 조회합니다 ===");
                ArrayList<Double> resultList = cal.getResultList(); // getter 활용
                System.out.println("계산 결과: " + resultList);
                menu.goMenu(scanner); // 메뉴 입력받기
            }
            if (select == 3) {
                System.out.println("=== 첫 번째 계산 기록을 삭제합니다. ===");
                ArrayList<Double> resultList = cal.getResultList(); // getter 활용
                System.out.println("기존 계산 기록: " + resultList);
                cal.removeResult(); // removeResult 메서드 호출
                menu.goMenu(scanner); // 메뉴 입력받기
            }
            if (select == 4) {
                System.out.println("=== 입력하신 숫자보다 큰 숫자를 조회합니다. ===");
                double userValue = input.getBiggerNumber(); // getter 활용
                cal.bigger(userValue); // 매개변수 전달
                menu.goMenu(scanner); // 메뉴 입력받기
            }
        }
    }
}


