package cn.array;

public class ContainerMostWater {

    public static void main(String[] args) {
        //int[] height = {1,8,6,2,5,4,8,3,7};
        int[] height = {2,3,4,5,18,17,6};
        System.out.println(new Solution2().maxArea(height));
    }
}

class Solution2 {
    public int maxArea(int[] height) {
        //最大水容量，双指针
        if (height == null || height.length==0) {
            return 0;
        }
        int max_area = 0;
        int area = 0;
        int j = height.length-1;
        for (int i = 0; i < j; i++) {//可以考虑使用while循环
            //i指头，j指尾
            area = (j-i) * Math.min(height[i],height[j]);
            //前边的大，则后边指针j前移
            if (height[i]>=height[j]) {
                i--; //保证i指针不后移
                j--; //确保j指针向前移
            }
            max_area = Math.max(max_area, area);

        }

        return max_area;
    }
}
