package com.amichaelmarsh.droptest;
/**
 * Created by superdullboy on 2/28/16.
 */

import com.amichaelmarsh.droptest.resources.PredictionResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import com.amichaelmarsh.droptest.resources.HelloWorldResource;
import com.amichaelmarsh.droptest.health.TemplateHealthCheck;

public class HelloWorldApplication extends Application<DropTestConfiguration> {
    public static void main(String[] args) throws Exception {
        new HelloWorldApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<DropTestConfiguration> bootstrap) {
        // nothing to do yet
    }

    @Override
    public void run(DropTestConfiguration configuration,
                    Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final PredictionResource predictionResource = new PredictionResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);
        environment.jersey().register(resource);
        environment.jersey().register(predictionResource);

    }

}