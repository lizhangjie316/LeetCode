package cn.Practice;

import java.util.Scanner;

public class Rotate {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        Scanner sc = new Scanner(System.in);
        int k = Integer.parseInt(sc.nextLine());
        System.out.println(nums);
        while (true) {
            new Solution20().rotate(nums, k);
            //nums = new Solution20().rotate(nums);
            //System.out.println(nums);
            k = Integer.parseInt(sc.nextLine());
        }

    }
}

class Solution20 {
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (nums.length == 0 || nums == null) {
            return;
        }
        int tem = 0;
        for (int i = 0; i < k; i++) {
            //每轮向右移动一位
            nums = rotate(nums);
        }
    }

    public int[] rotate(int[] nums) {
        int tmp = 0;
        tmp = nums[nums.length-1];
        for (int i = nums.length-1; i > 0; i--) {
            nums[i] = nums[i-1];
        }
        nums[0] = tmp;
        return nums;
    }
}
