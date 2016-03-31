package com.amichaelmarsh.droptest.resources;

/**
 * Created by superdullboy on 2/28/16.
 */

import com.amichaelmarsh.droptest.api.Prediction;
import com.amichaelmarsh.droptest.api.Saying;
import com.amichaelmarsh.droptest.core.Predictor;
import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;

@Path("/prediction")
@Produces(MediaType.APPLICATION_JSON)
public class PredictionResource {
    private final String template;
    private final String defaultName;
    private final AtomicLong counter;

    public PredictionResource(String template, String defaultName) {
        this.template = template;
        this.defaultName = defaultName;
        this.counter = new AtomicLong();
    }

    @GET
    @Timed
    public Prediction getPrediction(){
        return new Prediction(counter.incrementAndGet(), "outcome will be", Predictor.answerQuestion());
    }
}
