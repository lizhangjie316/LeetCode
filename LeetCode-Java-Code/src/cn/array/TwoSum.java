package cn.array;


import javax.naming.PartialResultException;
import java.util.HashMap;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 11, 15};
        System.out.println(nums);
        int target = 9;
        System.out.println();
        for (int i:new Solution3().twoSum(nums,target)
             ) {
            System.out.println(i);
        }
    }

}

//class Solution3 {
//    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
//    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑使用HashMap数据结构
//        if (nums == null || nums.length == 0){
//            return null;
//        }
//
//        HashMap<Integer, Integer> map = new HashMap<>();
//        int tmp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            tmp = target-nums[i];
//            if (map.containsKey(tmp)){
//                return new int[]{i,map.get(tmp)};
//            }
//            map.put(nums[i],i);
//        }
//        return null;
//    }
//}

class Solution3 { //66ms 39.9M
    //数组中同一个元素不能使用两遍: 没有重复元素，且不能输出相同的下标。最终要返回两个下标
    public int[] twoSum(int[] nums, int target) {//对于返回下标的题可以考虑
        if (nums == null || nums.length == 0){
            return new int[0];
        }
        int[] arr = new int[2];
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i]+nums[j] == target){
                    arr[0] = i;
                    arr[1] = j;
                    return arr;
                }
            }
            
        }

        return new int[0];
    }
}
