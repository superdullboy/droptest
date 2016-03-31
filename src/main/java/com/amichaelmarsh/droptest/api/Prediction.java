package com.amichaelmarsh.droptest.api;

/**
 * Created by superdullboy on 2/28/16.
 */
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.Length;

public class Prediction {
    private long id;

    @Length(max = 3)
    private String content;
    private boolean prediction;

    public Prediction() {
        // Jackson deserialization
    }

    public Prediction(long id, String content, boolean prediction) {
        this.id = id;
        this.content = content;
        this.prediction = prediction;
    }

    @JsonProperty
    public long getId() {
        return id;
    }

    @JsonProperty
    public String getContent() {
        return content;
    }

    @JsonProperty
    public boolean isPrediction() {
        return prediction;
    }
}
