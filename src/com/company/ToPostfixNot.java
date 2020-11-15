package com.company;

public class ToPostfixNot {
    private MyStack<Character> operatorsStack;
    private String input;
    private String output = "";

    public ToPostfixNot(String input) {
        this.input = input;
        operatorsStack = new MyStack<>();
    }

    public String transform() {
        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            switch (currentChar) {
                case ('+'):
                case ('-'):
                    gotOperator(currentChar, 1);
                    break;
                case ('*'):
                case ('/'):
                    gotOperator(currentChar, 2);
                    break;
                case ('^'):
                    gotOperator(currentChar, 3);
                    break;
                case ('('):
                    operatorsStack.push(currentChar);
                    break;
                case (')'):
                    gotClosingParenthesis();
                    break;
                default:
                    output += currentChar;
                    break;
            }
        }
        while (!operatorsStack.isEmpty()) {
            output += operatorsStack.pop();
        }
        return output;
    }

    private void gotOperator(char currentChar, int currentPriority) {
        while (!operatorsStack.isEmpty()) {
            char topChar = operatorsStack.pop();
            if (topChar == '(') {
                operatorsStack.push(topChar);
                break;
            } else {
                int topPriority;
                if (topChar == '+' || topChar == '-') {
                    topPriority = 1;
                } else if (topChar == '*' || topChar == '/') {
                    topPriority = 2;
                } else topPriority = 3;
                if (topPriority < currentPriority) {
                    operatorsStack.push(topChar);
                    break;
                } else output += topChar;
            }
        }
        operatorsStack.push(currentChar);
    }

    private void gotClosingParenthesis() {
        while (!operatorsStack.isEmpty()) {
            char ch = operatorsStack.pop();
            if (ch == '(') break;
            else output += ch;
        }
    }
}
