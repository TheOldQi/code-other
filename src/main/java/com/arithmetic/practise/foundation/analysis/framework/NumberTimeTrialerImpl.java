package com.arithmetic.practise.foundation.analysis.framework;

import com.arithmetic.practise.foundation.analysis.framework.superclass.NumberAnalysis;
import com.arithmetic.practise.foundation.analysis.framework.superclass.NumberTimeTrialer;
import com.arithmetic.practise.utils.StopWatch;

public class NumberTimeTrialerImpl implements NumberTimeTrialer {

    @Override
    public double trial(int initSize, NumberAnalysis analysis) {
        StopWatch watch = new StopWatch();
        analysis.exec(initSize);
        return watch.elapsedTime();
    }

}
