class CalculatorConundrum {
    public String calculate(int operand1, int operand2, String operation) throws IllegalOperationException {
        int result;
        if (operation == "+") {
            result = operand1 + operand2;
        } else if (operation == "*") {
            result = operand1 * operand2;
        } else if (operation == "/") {
            try {
                result = operand1 / operand2;
            } catch (ArithmeticException e) {
                throw new IllegalOperationException("Division by zero is not allowed", e);
            } 
        } else {
            if (operation == null) {
                throw new IllegalArgumentException("Operation cannot be null");
            } else if (operation == "") {
                throw new IllegalArgumentException("Operation cannot be empty");
            }
            throw new IllegalOperationException(String.format("Operation '%s' does not exist", operation));
        }
        return String.format("%d %s %d = %d", operand1, operation, operand2, result);
    }
}
