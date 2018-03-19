package com.ray.common.io;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class In {
    
    /**
     * �ӹ���Ŀ¼��ȡScanner
     * @param res
     * @return
     */
    public static Scanner getProjectScanner(String res) {
        Scanner in = null;
        try {
            in = new Scanner(new File(res));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
    
    /**
     * ����·����ȡ��Դ��Scanner
     * @param res
     * @return
     */
    public static Scanner getClassPathScanner(String res) {
        Scanner in = null;
        String path = In.class.getClassLoader().getResource(res).getFile();
        try {
            in = new Scanner(new File(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return in;
    }
    
    /**
     * ��·����ָ�������ڵİ��»�ȡ��Դ��Scanner
     * @param cl
     * @param res
     * @return
     */
    public static Scanner getClassPathScanner(Class<?> cl, String res) {
        String pkgName = cl.getPackage().getName().replaceAll("\\.", "/");
        return getClassPathScanner(pkgName + "/" + res) ;
    }
    
}
