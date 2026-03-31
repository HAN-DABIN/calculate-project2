package step3;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.Scanner;

// 제네릭 활용 - Number 클래스 (int, double, long ...) 만 들어올 수 있음
public class ArithmeticCalculator<T extends Number> {
    private List<Double> resultList = new ArrayList<>(); // 속성
    Scanner scanner = new Scanner(System.in);

    // enum 선언
    OperatorType plus = OperatorType.PLUS;
    OperatorType minus = OperatorType.MINUS;
    OperatorType multipy = OperatorType.MULTIPLY;
    OperatorType divide = OperatorType.DIVIDE;

    // 입력받은 num1, num2, ope로 계산하는 메서드
    public double calculate(T num1, T num2, char ope) {
        // 실수 입력 가능
        double firstNum = num1.doubleValue();
        double secondNum = num2.doubleValue();
        double result = 0;

        // 계산 결과 메서드 - enum 클래스 활용
        switch (ope) {
            case ('+'):
                result = plus.cal(firstNum, secondNum);
                System.out.println("::: 계산결과: " + num1 + " + " + num2 + " = " + result);
                break;
            case ('-'):
                result = minus.cal(firstNum, secondNum);
                System.out.println("::: 계산결과: " + num1 + " - " + num2 + " = " + result);
                break;
            case ('*'):
                result = multipy.cal(firstNum, secondNum);
                System.out.println("::: 계산결과: " + num1 + " * " + num2 + " = " + result);
                break;
            case ('/'):
                result = divide.cal(firstNum, secondNum);
                System.out.println("::: 계산결과: " + num1 + " / " + num2 + " = " + result);
                break;
        }
        resultList.add(result);
        return result;
    }

    // getter
    public ArrayList<Double> getResultList() {
        // 얕은 복사
        return new ArrayList<>(resultList);
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

    // 큰 값 구하기
    public void bigger(double value) {
        // 스트림 활용
        List<Double> biggerValue = resultList.stream()
                // 람다 활용
                .filter(num -> num > value)
                .collect(Collectors.toList());

        if (!biggerValue.isEmpty()) {
            System.out.println("입력한 숫자보다 큰 값: " + biggerValue);
        } else {
            System.out.println("※ 입력한 숫자보다 더 큰 값이 없습니다.");
        }
    }
}
