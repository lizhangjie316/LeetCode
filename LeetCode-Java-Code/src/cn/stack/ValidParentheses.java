package cn.stack;

import sun.font.TrueTypeFont;

import java.util.*;

public class ValidParentheses {


    public static void main(String[] args) {
        String str = "()[]{}";
        System.out.println(isValid(str));
        String parse = isValid(str)==true?"是有效括号":"不是有效括号";
        System.out.println(str+parse);
    }


    public static boolean isValid(String s) {
        if (s.length()%2==1)    return false;

        Stack<Character> stack = new Stack();
        for (char c:s.toCharArray()) {
            if (c == '(') {
                stack.push(')');
            } else if (c == '[') {
                stack.push(']');
            } else if (c == '{') {
                stack.push('}');
            } else if (stack.isEmpty() || c != stack.pop()) {
                return false;
            }
        }

        return stack.isEmpty() ;
    }
}


