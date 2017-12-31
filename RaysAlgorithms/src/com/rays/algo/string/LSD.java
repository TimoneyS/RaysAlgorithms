package com.rays.algo.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;

/**
 * 低位优先字符串排序<br>
 * 算法的核心在于键索引计数的排序是稳定的<br>
 * 即在排序过程中，键值相等的元素的相对位置是不变的。
 * @author rays1
 *
 */
public class LSD {
    
    public void sort(String[] keys) {
        
        int N = keys.length;
        int w = keys[0].length();
        int R = 256;
        
        // 从定位到高位共循环w轮，每轮按照指定的位对所有字符串排序。
        for (int i = w-1; i >= 0; i--) {
        
            int[] counts = new int[R+1];
            
            // 频率统计
            for (int j = 0; j < N; j ++) {
                counts[keys[j].charAt(i) + 1] += 1;
            }
            
            // 频率转换为索引
            for (int j = 0; j < R; j++) {
                counts[j + 1]+= counts[j];
            }
            
            // 数据分类
            String[] aux = new String[N];
            for (int j = 0; j < N; j++) {
                aux[counts[keys[j].charAt(i)]++] = keys[j];
            }
            
            // 回写
            for (int j = 0; j < aux.length; j++) {
                keys[j] = aux[j];
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        Scanner in = In.getClassPathScanner(LSD.class, "lsd.txt");
        
        List<String> list = new LinkedList<String>();
        while (in.hasNext()) {
            list.add(in.next());
        }
        
        String[] keys = list.toArray(new String[0]);
Out.p(keys);        
        new LSD().sort(keys);
        for (String s : keys) Out.p(s);
    }
    
}
