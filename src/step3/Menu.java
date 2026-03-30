package step3;

import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);

    // 메뉴 리스트 출력
    String menuList =
            "=== 계산기 메뉴 ===\n" +
            "1. 계산하기\n" +
            "2. 계산 기록 보기\n" +
            "3. 첫 번째 계산 기록 삭제하기\n" +
            "4. 입력 숫자보다 큰 숫자 확인하기\n" +
            "0. 계산기 종료\n" +
            "< 메뉴를 숫자로 입력해주세요. >";

    // 메뉴
    public String answer(Scanner scanner) {
        String ans;
        while (true) {
            System.out.println("- 다시 계산하시겠습니까? (yes: 다시계산 / menu: 메뉴로 돌아가기 / exit: 계산기 종료)");
            ans = scanner.nextLine();
            // 다른 문자 입력 시
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
            } break;
        } return ans;
    }
    public String goMenu(Scanner scanner) {
        String gM;
        // 메뉴 입력 반복문
        while (true) {
            // 메뉴로 돌아가는 입력 받기
            System.out.println("- 메뉴로 돌아가시겠습니까? (yes: 메뉴로 돌아가기 / exit: 계산기 종료)");
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
}
