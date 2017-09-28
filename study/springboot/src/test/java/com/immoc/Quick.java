package com.immoc;

import org.junit.Test;

/**
 * @author yugi
 * @apiNote
 * @since 2017-08-17
 */
public class Quick {

    private static int count = 0;

    private void quick_sort(int s[], int low, int high) {
        if (low < high) {
            count++;
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = low, j = high, x = s[low];
            while (i < j) {
                while (i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if (i < j) {
                    s[i++] = s[j];
                }
                while (i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if (i < j) {
                    s[j--] = s[i];
                }
            }
            s[i] = x;
            quick_sort(s, low, i - 1); // 递归调用
            quick_sort(s, i + 1, high);
        }
    }

    @Test
    public void testQuick() {
        int s[] = {8, 7, 6, 5, 4, 3, 2, 9};
        // int s[] = {9, 5, 1, 2, 6, 7, 3, 4, 8};
        this.quick_sort(s, 0, s.length - 1);
        for (int i : s) {
            System.out.print(i + ",");
        }
        System.out.println();
        System.out.println("执行了:" + Quick.count);
    }

}
