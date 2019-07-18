package com.ray.LintCode.temp;

import com.ray.io.Out;

/**
 * 描述：
 *      Implement a `Rectangle` class which include the following attributes and methods:
 *      
 *      1. Two public attributes width and height.
 *      1. A constructor which expects two parameters *width* and *height* of type int.
 *      2. A method `getArea` which would calculate the size of the rectangle and return.
 *
 * 用例：
 *      ```
 *      Example1:
 *      Java:
 *          Rectangle rec = new Rectangle(3, 4);
 *          rec.getArea(); // should get 12，3*4=12
 *      
 *      Python:
 *          rec = Rectangle(3, 4)
 *          rec.getArea()
 *      
 *      Example2:
 *      Java:
 *          Rectangle rec = new Rectangle(4, 4);
 *          rec.getArea(); // should get 16，4*4=16
 *      
 *      Python:
 *          rec = Rectangle(4, 4)
 *          rec.getArea()
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Native
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/rectangle-area/description
 * @date   2019-07-11 18:33:16
 */
public class L_0454_Rectangle_Area {

    static class Rectangle {
        /*
         * Define two public attributes width and height of type int.
         */
        // write your code here
        public int width;
        public int height;
        /*
         * Define a constructor which expects two parameters width and height here.
         */
        // write your code here
        public Rectangle(int w, int h) {
            width = w;
            height = h;
        }
        
        /*
         * Define a public method `getArea` which can calculate the area of the
         * rectangle and return.
         */
        // write your code here
        public int getArea(){
            return width*height;
        }

    }
    
    public static void main(String[] args) {
        
        Out.p(new Rectangle(1, 2));
        
    }

}
