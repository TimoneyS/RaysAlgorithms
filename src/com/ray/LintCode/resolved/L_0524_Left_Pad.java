package com.ray.LintCode.resolved;

import com.ray.io.Out;

/**
 *
 * 左填充 ？
 *
 * @author rays1
 *
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
        
        String originalStr = "1";
        int size = 2;
        char padChar = '0';
        
        Out.p(new StringUtils().leftPad(originalStr, size, padChar));
        
    }

}
