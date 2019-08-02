package com.arithmetic.practise.foundation.analysis.arithmetics;

import com.arithmetic.practise.foundation.analysis.framework.superclass.NumberAnalysis;

public class P146B implements NumberAnalysis {

    @Override
    public void exec(int n) {
        String str = "";
        for (int i = 1; i < n; i <<= 1)
            for (int j = 0; j < i; j++)
                str += "";
    }

}
