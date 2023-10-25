package edu.hw3;

import java.util.ArrayList;
import java.util.Stack;

public class Task2 {

    final private static String TEXT_OF_EXCEPTION = "Unbalanced parentheses";

    private Task2() {
    }

    static ArrayList<String> clusterize(String string) {
        if (string == null) {
            throw new IllegalArgumentException();
        }
        ArrayList<String> result = new ArrayList<>();
        Stack<Character> stack = new Stack<>();
        StringBuilder currentCluster = new StringBuilder();
        for (char ch : string.toCharArray()) {
            if (ch != '(' && ch != ')') {
                throw new IllegalArgumentException();
            }
            currentCluster.append(ch);
            if (ch == '(') {
                stack.push(')');
            } else {
                if (stack.isEmpty()) {
                    throw new IllegalArgumentException(TEXT_OF_EXCEPTION);
                }
                stack.pop();
            }

            if (stack.isEmpty()) {
                result.add(currentCluster.toString());
                currentCluster.setLength(0);
            }
        }
        if (!stack.isEmpty()) {
            throw new IllegalArgumentException(TEXT_OF_EXCEPTION);
        }
        return result;
    }
}
