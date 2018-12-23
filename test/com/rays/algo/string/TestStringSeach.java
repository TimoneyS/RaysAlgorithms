package com.rays.algo.string;

import com.ray.io.Out;
import com.ray.util.StringUtil;
import com.ray.util.Timer;

public class TestStringSeach {

    public static void testKMPSreach(String txt, String pat) {
        KMP kmp = new KMP(pat);
        int rs = kmp.seach(txt);
        Out.pf("KMPSearch(txt, pat) = %s\n", rs);
    }
    
    public static void testBruteSreach(String txt, String pat) {
        int rs =BruteSearch.search(txt, pat);
        Out.pf("BruteSeach(txt, pat) = %s\n", rs);
    }
    
    
    public static void main(String[] args) {
        
        String pat = "aaaaaab";
        String txt = StringUtil.multiString(pat.substring(0, pat.length()-1), 10000000) + pat;
        
        Timer.CLICK();
        testBruteSreach(txt, pat);
        
        Timer.CLICK();
        testKMPSreach(txt, pat);
        
        Timer.CLICK();
        Out.p("Inner String = " + txt.indexOf(pat));
        
        Timer.STOP();
        
    }
    
}
