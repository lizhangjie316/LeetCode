package cn.Practice;

import java.util.Arrays;

public class MergeTwoArray {

    public static void main(String[] args) {
        int m = 3;
        //int[] num1 = new int[m];
        //int[] num1 = {1,2,3,0,0,0};
        //int[] num2 = {2,5,6};
        int[] num1 = {1};
        int[] num2 = null;
        merge3(num1,1,num2,0);
        for (int num:num1 ) {
            System.out.print(num+" ");
        }
    }

    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2,0,nums1,m,n);
        Arrays.sort(nums1);
    }

    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        //借助m个空间
        int[] arr = new int[m];
        System.arraycopy(nums1,0,arr,0,m);
        int i = 0; //arr
        int j = 0; //nums2
        int k = 0; //nums1
        while (i<m && j<n) {
            if (arr[i]<nums2[j]) {
                nums1[k++] = arr[i++];
            }else {
                nums1[k++] = nums2[j++];
            }
        }
        if (i<m) {
            //此时nums2已经完成
            System.arraycopy(arr,i,nums1,i+j,m+n-i-j);
        }
        if (j<n) {
            //此时arr已经完成
            System.arraycopy(nums2,j,nums1,i+j,m+n-i-j);
        }

    }

    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        //不借助空间，直接从nums1的后面插
        int p1 = m-1; //记录nums1的比较节点
        int p2 = n-1; //记录nums2的比较节点
        int p = nums1.length-1; //
        while (p1>=0 && p2>=0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p--] = nums1[p1--];
            }else {
                nums1[p--] = nums2[p2--];
            }
        }
        if (p1<0) {
            //将nums2剩下的补齐
            System.arraycopy(nums2,0,nums1,0,p2+1);
        }
        if (p2<0) {
            //p1不用管
        }
    }
}
