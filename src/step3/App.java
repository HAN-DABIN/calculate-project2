package step3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        ArithmeticCalculator<Double> cal = new ArithmeticCalculator<>();
        Menu menu = new Menu();
        InputNumber input = new InputNumber();

        while (true) {
            System.out.println(menu.menuList);

            int select = 0;
            try {
                select = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
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
                    // 계산식 출력
                    cal.calculate(num1, num2, ope);
                    // getter 활용
                    String ans = menu.answer(scanner);
                    if (ans.equals("menu")) {
                        break;
                    }
                }
            }
        }
    }
}

