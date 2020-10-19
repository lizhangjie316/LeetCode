package cn.recursion;

public class ReverseString {

    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        reverseString(s);
        System.out.println(s);
    }

    public static void reverseString(char[] s) {
        helper(s,0,s.length-1);
    }

    private static void helper(char[] s, int left, int right) {
        if (left >= right) return;
        char tmp = s[right];
        s[right--] = s[left];
        s[left++] = tmp;
        helper(s,left,right);
    }
}
