package com.arithmetic.practise.foundation.analysis.arithmetics;

import com.arithmetic.practise.foundation.analysis.framework.superclass.NumberAnalysis;

public class P146A implements NumberAnalysis {

    @Override
    public void exec(int n) {
        String str = "";
        for (int i = n; i > 0; i >>>= 1)
            for (int j = 0; j < i; j++)
                str += "";
    }

}
