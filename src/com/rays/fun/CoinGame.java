package com.rays.fun;

import java.util.Random;

import com.ray.io.Out;

/**
 * 参与者 A 和 B 约定，同时扔出一枚硬币
 * <p>
 * 如果：
 * <ul>
 *  <li> 两枚都是正面则 B 给 A 3 元
 *  <li> 两枚都是反面则 B 给 A 1 元
 *  <li> 两枚一正一反则 A 给 B 2 元
 * </ul>
 * 模拟二者收益
 * @author rays1
 *
 */
public class CoinGame {
    
    private static int OBVERSE = 1; // 硬币正面
    private static int REVERSE = 0; // 硬币反面
    private double riskA;           // A 出正面的概率
    private double riskB;           // B 出正面的概率
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
