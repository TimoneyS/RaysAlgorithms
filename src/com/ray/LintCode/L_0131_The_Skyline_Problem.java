package com.ray.LintCode;

import com.ray.io.Out;

/**
 * 描述：
 *      Given *N* buildings in a x-axis，each building is a rectangle and can be represented by a triple (start, end, height)，where start is the start position on x-axis, end is the end position on x-axis and height is the height of the building. Buildings may overlap if you see them from far away，find the outline of them。
 *      
 *      An outline can be represented by a triple, (start, end, height), where start is the start position on x-axis of the outline, end is the end position on x-axis and height is the height of the outline.
 *      
 *      ![Building Outline](https://lintcode-media.s3.amazonaws.com/problem/jiuzhang3.jpg "Building Outline")
 *
 * 用例：
 *      **Example 1**
 *      
 *      ```plain
 *      Input:
 *      [
 *          [1, 3, 3],
 *          [2, 4, 4],
 *          [5, 6, 1]
 *      ]
 *      Output:
 *      [
 *          [1, 2, 3],
 *          [2, 4, 4],
 *          [5, 6, 1]
 *      ]
 *      Explanation:
 *      The buildings are look like this in the picture. The yellow part is buildings.
 *      ```
 *      
 *      ![图片](https://media-cdn.jiuzhang.com/markdown/images/6/20/18bd686e-934d-11e9-a170-0242ac110002.jpg)
 *      
 *      **Example 2**
 *      
 *      ```plain
 *      Input:
 *      [
 *          [1, 4, 3],
 *          [6, 9, 5]
 *      ]
 *      Output:
 *      [
 *          [1, 4, 3],
 *          [6, 9, 5]
 *      ]
 *      Explanation:
 *      The buildings are look like this in the picture. The yellow part is buildings.
 *      ```
 *      
 *      ![图片](https://media-cdn.jiuzhang.com/markdown/images/6/20/58c5f08e-934d-11e9-a170-0242ac110002.jpg)
 *
 * 挑战：
 *      
 *
 * 难度： Super
 *   
 * @author rays1
 * @url    https://www.lintcode.cn/problem/the-skyline-problem/description
 * @date   2019-07-11 18:30:57
 */
public class L_0131_The_Skyline_Problem {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
