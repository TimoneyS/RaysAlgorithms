package com.ray.LintCode.temp;

/**
 * 描述：
 *      Factory is a design pattern in common usage. Please implement a `ToyFactory` which can generate proper toy based on the given type.
 *
 * 用例：
 *      Example 1：
 *      ```
 *      Input：
 *      ToyFactory tf = ToyFactory();
 *      Toy toy = tf.getToy('Dog');
 *      toy.talk(); 
 *      Output:
 *      Wow
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      ToyFactory tf = ToyFactory();
 *      toy = tf.getToy('Cat');
 *      toy.talk();
 *      Output：
 *      Meow
 *      
 *      ```
 *
 * 挑战：
 *      
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/toy-factory/description
 * @date   2019-07-11 18:33:32
 */
public class L_0496_Toy_Factory {

    interface Toy {
        void talk();
    }

    class Dog implements Toy {
         public void talk(){System.out.println("Wow");}
    }

    class Cat implements Toy {
       public void talk(){System.out.println("Meow");}
    }

    public class ToyFactory {
        /**
         * @param type a string
         * @return Get object of the type
         */
        public Toy getToy(String type) {
            Toy t = null;
            try {
                t = (Toy)Class.forName(type).newInstance();
            } catch (Exception e) {
            }
            return t;
        }
    } 
    
    public static void main(String[] args) {
        
        
    }

}
