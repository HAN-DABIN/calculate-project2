package step3;

public enum OperatorType {
    PLUS("+") {
        public double cal(double num1, double num2) {
            return num1 + num2;
        }
    },
    MINUS("-") {
        public double cal(double num1, double num2) {
            return num1 - num2;
        }
    },
    MULTIPLY("*") {
        public double cal(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE("/") {
        public double cal(double num1, double num2) {
            return num1 / num2;
        }
    };
    private final String operator;
    OperatorType(String opertaror) {
        this.operator = opertaror;
    }

    @Override
    public String toString() {
        return operator;
    }
    public abstract double cal(double x, double y);
}
