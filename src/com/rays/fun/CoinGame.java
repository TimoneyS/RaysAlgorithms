package com.rays.fun;

import java.util.Random;

import com.ray.io.Out;

/**
 * ������ A �� B Լ����ͬʱ�ӳ�һöӲ��
 * <p>
 * �����
 * <ul>
 *  <li> ��ö���������� B �� A 3 Ԫ
 *  <li> ��ö���Ƿ����� B �� A 1 Ԫ
 *  <li> ��öһ��һ���� A �� B 2 Ԫ
 * </ul>
 * ģ���������
 * @author rays1
 *
 */
public class CoinGame {
    
    private static int OBVERSE = 1; // Ӳ������
    private static int REVERSE = 0; // Ӳ�ҷ���
    private double riskA;           // A ������ĸ���
    private double riskB;           // B ������ĸ���
    private int moneyA = 1000;
    private int moneyB = 1000;
    private Random r = new Random(47);
    private int times;
    
    public CoinGame(int times, double riskA, double riskB) {
        
        this.riskA = riskA;
        this.riskB = riskB;
        this.times = times;
        for (int i = 0; i < times; i++) {
            game();
        }
        showResult();
    }
    
    private void showResult( ) {
        
        Out.pf("Game %s times result :\n", times);
        Out.pf("A money : %4d\n", moneyA);
        Out.pf("B money : %4d\n", moneyB);
        
    }
    
    private void game() {
        int a = throwCoin(riskA);
        int b = throwCoin(riskB);
        
        if (a == OBVERSE && b == OBVERSE) {
            moneyA += 3;
            moneyB -= 3;
        } else if (a == REVERSE && b == REVERSE) {
            moneyA += 1;
            moneyB -= 1;
        } else {
            moneyA -= 2;
            moneyB += 2;
        }
        
    }
    
    private int throwCoin(double risk) {
        double d = r.nextDouble();
        if (d < risk)
            return OBVERSE;
        else 
            return REVERSE;
    }
    
    public static void main(String[] args) {
        double ra = 0.4;
        double rb = 0.35;
        
        new CoinGame(5000, ra, rb);
        
    }
    
}
