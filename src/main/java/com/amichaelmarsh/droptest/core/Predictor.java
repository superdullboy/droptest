package com.amichaelmarsh.droptest.core;

import com.amichaelmarsh.droptest.api.Prediction;

/**
 * Created by superdullboy on 3/31/16.
 */
public class Predictor {

    public static boolean answerQuestion(){
        return Math.random() < 0.5;
    }
}
