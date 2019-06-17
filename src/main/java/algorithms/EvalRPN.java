package algorithms;

import java.util.Stack;

/**
 * Created by nav on 5/29/15.
 */
public class EvalRPN {

    public static void main(String[] args) {
        EvalRPN evalRPN = new EvalRPN();
        System.out.println(evalRPN.postfixEvaluation(new String[] { "2", "5", "3", "-", "+" }));
        System.out.println(evalRPN.postfixEvaluation(new String[] { "2", "5", "3", "-", "-" }));
    }

    public int postfixEvaluation(String[] tokens) {
        Stack<Integer> stack = new Stack();
        Operator operator;
        for (String s : tokens) {
            if ((operator = this.getSymbol(s)) == null) {
                stack.push(Integer.valueOf(s));
            } else {
                stack.push(operator.exec(stack.pop(), stack.pop()));
            }
        }
        return stack.pop();
    }

    public Operator getSymbol(String in) {
        for (Operator op : Operator.values()) {
            if (in.equals(op.getOperator())) {
                return op;
            }
        }
        return null;
    }

    public enum Operator {
        add("+") {
            @Override
            public int exec(int a, int b) {
                return b + a;
            }
        },
        subtract("-") {
            @Override
            public int exec(int a, int b) {
                return b - a;
            }
        },
        divide("/") {
            @Override
            public int exec(int a, int b) {
                return b / a;
            }
        },
        multiply("*") {
            @Override
            public int exec(int a, int b) {
                return b * a;
            }
        };

        Operator(String operator) {
            this.operator = operator;
        }

        private String operator;

        public String getOperator() {
            return operator;
        }

        public abstract int exec(int a, int b);

    }
}
