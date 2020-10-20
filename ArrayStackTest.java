public class ArrayStackTest {
    public static void main(String[] args){
        int actualResult = 2*3/(4-2)+5*6;
        String infix = "2*3/(4-2)+5*6";
        String postfix = "23*42-/56*+";
        int result = evaluatePostfix(postfix);
        System.out.println("Infix form: " + infix);
        System.out.println("Postfix form: " + postfix);
        System.out.println("\nActual result: " + actualResult);
        System.out.println("Postfix result: " + result);
    }

    public static int evaluatePostfix(String postfix) {
        ResizeableArrayStack<Integer> valueStack = new ResizeableArrayStack<Integer>();
        int index = 0;
        while (index < postfix.length()) {  // keep looping as long as we have characters left in string
            char nextCharacter = postfix.charAt(index);
            int operandTwo;
            int operandOne;
            switch (nextCharacter) {
                case '+':
                    operandTwo = valueStack.pop();  // pop into operandTwo first because order matters
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne + operandTwo);
                    break;
                case '-':
                    operandTwo = valueStack.pop();  // pop into operandTwo first because order matters
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne - operandTwo);
                    break;
                case '*':
                    operandTwo = valueStack.pop();  // pop into operandTwo first because order matters
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne * operandTwo);
                    break;
                case '/':
                    operandTwo = valueStack.pop();  // pop into operandTwo first because order matters
                    operandOne = valueStack.pop();
                    valueStack.push(operandOne / operandTwo);
                    break;
                case '^':       // exponential case
                    operandTwo = valueStack.pop();  // pop into operandTwo first because order matters
                    operandOne = valueStack.pop();
                    valueStack.push((int) Math.pow(operandOne, operandTwo)); // uses power function but must cast double to int
                    break;
                case ' ':
                    break;
                default:
                    valueStack.push(Integer.parseInt(Character.toString(nextCharacter)));   // default case assumes number that must be parsed
                    break;                                                                  // so we can perform operations
            }
            index++; // go to new letter in postfix string
        }
        return valueStack.peek(); // return evaluated postfix int
    }
}
