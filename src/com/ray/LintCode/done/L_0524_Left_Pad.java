package com.ray.LintCode.done;

/**
 * 描述：
 *      You know what, left pad is javascript package and referenced by React: 
 *      [Github link](https://github.com/azer/left-pad "Left pad")
 *      
 *      One day his author unpublished it, then a lot of javascript projects in the world broken.
 *      
 *      You can see from github it's only 11 lines.
 *      
 *      You job is to implement the left pad function. If you do not know what left pad does, see examples below and guess.
 *
 * 用例：
 *      Example 1:
 *      ```
 *      Input:
 *      leftpad("foo", 5)
 *      Output:
 *      "  foo"
 *      ```
 *      Example 2:
 *      ```
 *      Input:
 *      leftpad("foobar", 6)
 *      Output:
 *      "foobar"
 *      ```
 *      Example 3:
 *      ```
 *      Input:
 *      leftpad("1", 2, "0")
 *      Output:
 *      "01"
 *      ```
 *
 * 挑战：
 *      Use as little memory as possible
 *
 * 难度： Simple
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/left-pad/description
 * @date   2019-07-11 18:33:49
 */
public class L_0524_Left_Pad {

    static class StringUtils {
        /**
         * @param originalStr: the string we want to append to with spaces
         * @param size: the target length of the string
         * @return: A string
         */
        static public String leftPad(String originalStr, int size) {
            return String.format("%"+size+"s", originalStr);
        }

        /*
         * @param originalStr: the string we want to append to
         * @param size: the target length of the string
         * @param padChar: the character to pad to the left side of the string
         * @return: A string
         */
        public String leftPad(String originalStr, int size, char padChar) {
            size = size - originalStr.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < size; i++) {
                sb.append(padChar);
            }
            sb.append(originalStr);
            return sb.toString();
        }
    }
    
    public static void main(String[] args) {
        
        
    }

}
