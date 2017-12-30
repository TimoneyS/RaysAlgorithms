package com.rays.algo.string;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import com.ray.common.utils.In;
import com.ray.common.utils.Out;

/**
 * ��λ�����ַ�������
 * @author rays1
 *
 */
public class Lsd {
    
    public void sort(String[] keys) {
        int N = keys.length;
        int w = keys[0].length();
        int R = 256;
        
        for (int i = w-1; i >= 0; i--) {
            int[] counts = new int[R+1];
            
            // Ƶ��ͳ��
            for (int j = 0; j < N; j ++) {
                counts[keys[j].charAt(i) + 1] += 1;
            }
            
            // Ƶ��ת��Ϊ����
            for (int j = 0; j < R; j++) {
                counts[j + 1]+= counts[j];
            }
            
            // ���ݷ���
            String[] aux = new String[N];
            for (int j = 0; j < N; j++) {
                aux[counts[keys[j].charAt(i)]++] = keys[j];
            }
            
            // ��д
            for (int j = 0; j < aux.length; j++) {
                keys[j] = aux[j];
            }
            
        }
        
    }
    
    public static void main(String[] args) {
        
        Scanner in = In.getClassPathScanner(Lsd.class, "lsd.txt");
        
        List<String> list = new LinkedList<String>();
        while (in.hasNext()) {
            list.add(in.next());
        }
        
        String[] keys = list.toArray(new String[0]);
Out.p(keys);        
        new Lsd().sort(keys);
        for (String s : keys)
            Out.p(s);
    }
    
}
