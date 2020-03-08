package com.ray.LintCode.done;

import com.ray.io.Out;

/**
 * 描述：
 *      给定一个字符数组，和一个偏移量，原地旋转字符数组（从左到右）。
 *
 * 用例：
 *      **用例 1:**
 *      输入: str="abcdefg", offset = 3
 *      输出: str = "efgabcd"
 *      
 * 挑战：
 *      Rotate in-place with O(1) extra memory.
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rotate-string/description
 * @date   2019-07-10 18:27:27
 */
public class L_0008_Rotate_String {

    /**
     * 封装数组区域交换的方法
     *      交换数组两个区域 = 交换等比区域 + 交换剩余区域
     */
    static class Solution {
    
        public void rotateString(char[] str, int offset) {
            if (str.length == 0) return;
            int size = str.length;
            offset %= size;
            if (offset == 0) return;
            swap(str, 0, size-offset-1, size-offset, size-1);
        }
        
        private void swap(char[] arr, int l1, int r1, int l2, int r2) {
            int diff = (r1 - l1) - (r2 - l2);
            if (diff > 0) {
                // 左边部分更大
                swap(arr, l1 + diff, r1, l2, r2);
                swap(arr, l1, l1 + diff - 1, l1 + diff, r1);
            } else if (diff < 0) {
                // 右边部分更大
                swap(arr, l1, r1, l2, r2 + diff);
                swap(arr, l2, r2 + diff, r2 + diff+1, r2);
            } else {
                for (int i = l1, j = l2; i <= r1 && j <= r2; i++, j++) {
                    char t = arr[i];
                    arr[i] = arr[j];
                    arr[j] = t;
                }
            }
        }
    
    }
    
    public static void main(String[] args) {
        
        char[] str = "abc".toCharArray();
        int offset = 3;
        
        new Solution().rotateString(str, offset);
        
        Out.p(new String(str));
        
    }

}
