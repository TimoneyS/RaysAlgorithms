package com.ray.LintCode;

import com.ray.io.Out;

/**
 * Description :
 *   Given a list of directory info including directory path, and all the files with contents in this directory, you need to find out all the groups of duplicate files in the file system in terms of their paths.

A group of duplicate files consists of at least **two** files that have exactly the same content.

A single directory info string in the **input** list has the following format:

`"root/d1/d2/.../dm f1.txt(f1_content) f2.txt(f2_content) ... fn.txt(fn_content)"`

It means there are **n** files (`f1.txt, f2.txt ... fn.txt` with content `f1_content, f2_content ... fn_content`, respectively) in directory `root/d1/d2/.../dm`. Note that n >= 1 and m >= 0. If m = 0, it means the directory is just the root directory.

The **output** is a list of group of duplicate file paths. For each group, it contains all the file paths of the files that have the same content. A file path is a string that has the following format:

`"directory_path/file_name.txt"`
 *
 * Example :
 *   **Example1**
```
Input:
["root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"]
Output:  
[["root/a/2.txt","root/c/d/4.txt","root/4.txt"],["root/a/1.txt","root/c/3.txt"]]
```

**Example2**
```
Input:
["root/a 1.txt(abcd) 2.txt(efgh)"]
Output:  
[]
```
 *
 * Challenge :
 *   1.Imagine you are given a real file system, how will you search files? DFS or BFS?
 *   2.If the file content is very large (GB level), how will you modify your solution?
 *   3.If you can only read the file by 1kb each time, how will you modify your solution?
 *   4.What is the time complexity of your modified solution? What is the most time-consuming part and memory consuming part of it? How to optimize?
 *   5.How to make sure the duplicated files you find are not false positive?
 *
 * @author rays1
 * @url    https://www.lintcode.cn/problem/find-duplicate-file-in-system/description
 * @date   2019-07-03 17:39:32
 */
public class L_1134_Find_Duplicate_File_in_System {

    static class Solution {
    
        
    
    }
    
    public static void main(String[] args) {
        
        Out.p(new Solution());
        
    }

}
