package cn.array;

public class MoveZero {

    public static void main(String[] args) {
        Solution solution = new Solution();
        //int[] arr = {0,1,0,3,12};
        //int[] arr = {0,1,0,3,12};
        int[] arr = {0,1,0,3,0};
        solution.moveZeroes(arr);
        //System.out.println(arr);
        for (int i:arr
             ) {
            System.out.println(i);
        }

    }



}

class Solution {
    public void moveZeroes(int[] nums)  {
        int length;
        if (nums == null || (length = nums.length) == 0) {
            return;
        }
        int j = 0;
        for (int i = 0; i < length; i++) {
            //i进行后续探索，j进行延后的定位，始终指向下一个存储位置
            if (nums[i] != 0) {//非0，则进行交换
                if (i > j) {
                    nums[j] = nums[i];
                    nums[i] = 0;
                }
                j++;
            }
        }
    }
}
