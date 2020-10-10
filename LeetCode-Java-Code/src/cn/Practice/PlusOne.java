package cn.Practice;

import java.util.Arrays;

public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {1,2,3};
        System.out.println(Arrays.toString(digits));
    }

    public static int[] plusOne(int[] digits) {
        for (int i = digits.length-1; i >= 0; i--) {
            digits[i]++;
            digits[i] = digits[i]%10;
            //什么时候需要进位？
            if (digits[i]!=0) return digits;
        }
        digits = new int[digits.length+1];
        digits[0] = 1;
        return digits;
    }
}
