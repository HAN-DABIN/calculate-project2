package step3;

import java.util.ArrayList;

// 제네릭 활용 - Number 클래스 (int, double, long ...) 만 들어올 수 있음
public class ArithmeticCalculator<T extends Number> {
    private ArrayList<Double> resultList = new ArrayList<>(); // 속성

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
}

