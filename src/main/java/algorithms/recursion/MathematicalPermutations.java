package algorithms.recursion;

import algorithms.EvalRPN;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Stack;

/**
 * Created by nav on 10/12/15.
 */
public class MathematicalPermutations {
    public List<Integer> result = new ArrayList<>();
    public List<String> operators = Arrays.asList("/", "*", "+", "-", "(", ")");
    private EvalRPN postfixEvaluator = new EvalRPN();

    public static void main(String[] args) {
        MathematicalPermutations mathematicalPermutations = new MathematicalPermutations();
        List<Integer> result = mathematicalPermutations.computePermutation(new int[] { 2, 5, 3, 4 });
        MathematicalPermutations.printUniques(result);
        //        String infix = "( 4 * 3 ) + 2 * 5 - 6 / 2";
        //        System.out.println(mathematicalPermutations.infixToPostive(infix));
    }

    private List<Integer> computePermutation(int[] in) {
        computePermutations(in, 0, "");
        return result;
    }

    private void computePermutations(int[] in, int pos, String expression) {
        expression += in[pos] + " ";

        if (pos == in.length - 1) {
            addResult(expression);
        } else {
            pos++;
            computePermutations(in, pos, expression + "+ ");
            computePermutations(in, pos, expression + "+ -");
            computePermutations(in, pos, expression + "* ");
        }
    }

    private void addResult(String expression) {
        String postfixExpression = infixToPostive(expression);
        int expressionResult = postfixEvaluator.postfixEvaluation(postfixExpression.split(" "));
        System.out.printf("%s (infix); %s (postfix); has a value of %d\n", expression, postfixExpression, expressionResult);
        result.add(expressionResult);
    }

    public static void printUniques(List<Integer> result) {
        for (Integer r : new HashSet<Integer>(result)) {
            System.out.println(r);
        }
    }

    private String infixToPostive(String inputExpression) {
        Stack<String> operatorStack = new Stack();
        StringBuilder postfix = new StringBuilder();

        for (String token : inputExpression.split(" ")) {
            if (isOperator(token)) {
                handleOperator(operatorStack, postfix, token);
            } else {
                // handle operand
                appendToken(postfix, token);
            }
        }
        while (!operatorStack.isEmpty()) {
            appendToken(postfix, operatorStack.pop());
        }
        return postfix.toString();
    }

    private boolean isOperator(String token) {
        return operators.contains(token);
    }

    private void appendToken(StringBuilder postfix, String token) {
        postfix.append(token).append(" ");
    }

    private void handleOperator(Stack<String> operatorStack, StringBuilder postfix, String token) {
        if (")".equals(token))
            handleParentheses(operatorStack, postfix);
        else if ("(".equals(token))
            operatorStack.add(token);
        else
            handleMathOperator(operatorStack, token, postfix);
    }

    private void handleParentheses(Stack<String> operatorStack, StringBuilder postfix) {
        while (!operatorStack.isEmpty()) {
            String operator = operatorStack.pop();
            if ("(".equals(operator))
                break;

            appendToken(postfix, operator);
        }
    }

    private void handleMathOperator(Stack<String> operatorStack, String token, StringBuilder postfix) {
        if (!operatorStack.isEmpty() && isLowerPrecedence(token, operatorStack.peek())) {
            while (!operatorStack.isEmpty()) {
                appendToken(postfix, operatorStack.pop());
            }
        }
        operatorStack.add(token);
    }

    private static boolean isLowerPrecedence(String op1, String op2) {
        if ("+".equals(op1) || "-".equals(op1) && ("*".equals(op2) || "/".equals(op2)))
            return true;
        else
            return false;
    }


}
